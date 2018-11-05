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
            SadEmotions=new String[9];
            SadEmotions[0]="Sad";
            SadEmotions[1]="Bad";
            SadEmotions[2]="Not good";
            SadEmotions[3]="Awful";
            SadEmotions[4]="Not great";
            SadEmotions[5]="Wack";
            SadEmotions[6]="Depressed";
            SadEmotions[7]="Trash";
            SadEmotions[8]="Stressed";

        }
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		

		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the chatbot, nice to meet you.");
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

