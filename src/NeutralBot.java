import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Parker Straight
 * @version Nov 2018
 */
public class NeutralBot
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	public static void chatLoop() {
		Scanner x= new Scanner(System.in);
		System.out.println(getGreeting());
		System.out.println((getName()));
	}


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	private static String getGreeting()
	{
		return "Hi I'm NeutralBot. How are you feeling?";
	}
	private static String getName() {return "What's your name?";}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */


	public String getResponse(String statement)
	{

			String response = "";

			if (statement.length() == 1)
			{
				response = "Respond, a bot can get lonely, too.";
			}

			else if (findKeyword(statement, "feel sad") >= 0)
			{
				response = "Why are you sad?";
				emotion--;
			}
			else if(findKeyword(statement, "feel upset") >=0 )
			{
				response = "what happened?";
				emotion--;
			}
			else if(findKeyword(statement, "feel depressed")>=0 )
			{
				response= "I will try to make you feel better.";
				emotion--;
			}
			else if(findKeyword(statement, "feel horrible")>=0 )
			{
				response= "You can talk to me";
				emotion--;
			}
			else if(findKeyword(statement, "feel good")>=0 )
			{
				response= "Nice, I feel the same!";
				emotion++;
			}
			if(emotion <= -3)
			{
				response = "Hey, check this out! https://suicidepreventionlifeline.org/";
			}
			// Response transforming I want to statement
			else if (findKeyword(statement, "I want",0) >= 0)
			{
				response = transformIWantStatement(statement);
			}
			else if(findKeyword(statement, "I should", 0) >= 0)
			{
				response = transformIShouldStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}

	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";

	}
// if one of the elements in SadEmotion exists in the user's string, the following code goes



	/**
	 * Take a statement with "I feel <something>." and transform it into
	 * "Why do you feel <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIFeelStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I feel", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Why do you feel " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "I should <something>." and transform it
	 * into "Why do you feel like you should <something>?."
	 * @param statement the user statement, that contains "I should"
	 * @return the transformed statement
	 */
	private String transformIShouldStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I should", 0);
		String restOfStatement = statement.substring(psn + 8).trim();
		return "Why do you feel like you should " + restOfStatement + "?";
	}




	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */

	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more", "Hmmm.", "Oh", "You don't say.", "It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};


	private String [] randomHappyResponses = {"Good for you", "Nice", "Cool", "Okay", };
	private String [] randomAngryResponses = {"I don't know how you feel.", "OOF", "Darn", "That's tough", "I'm sure you're not alone", "Good luck with that"};

}
