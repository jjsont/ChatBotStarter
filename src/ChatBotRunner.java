import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Jason Tan, Harpreet Kaur, Parker Straight
 * @version Nov 2018
 */
public class ChatBotRunner {
	/**
	 * /**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		String botChoice = "";
		System.out.println("Choose the bot you want to meet");
		String input = "";

		while (botChoice.equals("")) {
			System.out.println("Do you want to improve your mood? Y or N?");
			input = x.nextLine();
			if (input.equals("Y")) {
				botChoice = "HappyBot";
				break;
			}
			System.out.println(("Do you want to be sadder? Y or N?"));
			input = x.nextLine();
			if (input.equals("Y")) {
				botChoice = "SadBot";
				break;
			}
			System.out.println(("Do you want to feel as you are? Y or N?"));
			input = x.nextLine();
			if (input.equals("Y")) {
				botChoice = "NeutralBot";
				break;

			}
			loop(botChoice);
		}
	}

	private static void loop(String botChoice) {
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		Scanner x = new Scanner(System.in);
		String statement = "";
		if (botChoice == "HappyBot") {
			ChatBot1.chatLoop();
		}
		if (botChoice == "SadBot") {
			ChatBot2.chatLoop();
		}
		if (botChoice == "NeutralBot") {
			ChatBot3.chatLoop();
		}

	}
}




