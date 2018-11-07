import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */

	public static void main(String[] args)
	{

		{
			String[] SadEmotions;
			SadEmotions=new String[8];
			SadEmotions[0]="Sad";
			SadEmotions[1]="Bad";
			SadEmotions[2]="Not good";
			SadEmotions[3]="Wack";
			SadEmotions[4]="Depressed";
			SadEmotions[5]="Trash";
			SadEmotions[6]="Stressed";
			SadEmotions[7]="Awful";

		}
		{
			String[] HappyEmotions;
			HappyEmotions=new String[6];
			HappyEmotions[0]="Happy";
			HappyEmotions[1]="Good";
			HappyEmotions[2]="Great";
			HappyEmotions[3]="Awesome";
			HappyEmotions[4]="Fantastic";
			HappyEmotions[5]="Well";
		}
		{
			String[] MediumEmotions;
			MediumEmotions=new String[7];
			MediumEmotions[0]="Ok";
			MediumEmotions[1]="Okay";
			MediumEmotions[2]="Not bad";
			MediumEmotions[3]="Eh";
			MediumEmotions[4]="So-so";
			MediumEmotions[5]="Mediocre";
			MediumEmotions[6]="Not great";

		}
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();


		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the chatbot, nice to meet you.");
		System.out.println("How are you?");
		String statement = in.nextLine();


		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1



			chatbot1.chatLoop(statement);


			statement = in.nextLine();


		}
	}



}

