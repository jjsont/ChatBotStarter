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
		HappyBot chatbot1 = new HappyBot();
		SadBot chatbot2 = new SadBot();
		NeutralBot chatbot3 = new NeutralBot();

		Scanner in = new Scanner(System.in);
		System.out.println("Hey, which bot would you want? Happy/Sad/Neutral Bot?");


		boolean botChoice = false;
		boolean pick1 = false;
		boolean pick2 = false;
		boolean pick3 = false;
		String botSe = "";
		String botch1 = "";
		String botch2 = "";
		String botch3 = "";
		String statement = "";
		while (botChoice == false) {
			botSe = in.nextLine();
			botSe = botSe.toLowerCase();
			if (botSe.indexOf("Happy") >= 0 || botSe.indexOf("HappyBot") >= 0 || botSe.indexOf("happy bot") >= 0 || botSe.indexOf("happy") >= 0) {

				System.out.println("Hey, I'm HappyBot. Coded by Jason, designed to mimic happiness.");
				statement = in.nextLine();
				chatbot1.chatLoop(statement);
				botChoice = true;
				pick1 = true;
				pick2 = false;
				pick3 = false;
			} else if (botSe.indexOf("Sad") >= 0 || botSe.indexOf("SadBot") >= 0 || botSe.indexOf("sad bot") >= 0 || botSe.indexOf("sad") >= 0) {

				System.out.println("Hey, I'm SadBot. Get ready to be sadder.");
				statement = in.nextLine();
				chatbot2.chatLoop(statement);
				botChoice = true;
				pick1 = false;
				pick2 = true;
				pick3 = false;
			} else if (botSe.indexOf("neutral") >= 0 || botSe.indexOf("NeutralBot") >= 0 || botSe.indexOf("neutral bot") >= 0 || botSe.indexOf("Neutral") >= 0 || botSe.indexOf("neut") >= 0) {

				System.out.println("I'm NeutralBot. Hey.");
				statement = in.nextLine();
				chatbot3.chatLoop(statement);
				botChoice = true;
				pick1 = false;
				pick2 = false;
				pick3 = true;
			} else {
				System.out.println("Choose a bot!");
			}
		}
		while (botChoice == true)
		{
			botch1 = "";
			botch2 = "";
			botch3 = "";
			while (pick1 == true) {
				botch1.equals(chatbot1.getResponse(statement).toLowerCase());
				if (botch1.equals("SadBot") || botch1.equals("NeutralBot")) {
					break;
				}
			}
			while (pick2 == true) {
				botch2.equals(chatbot2.getResponse(statement).toLowerCase());
				if (botch2.equals("HappyBot") || botch2.equals("NeutralBot")) {
					break;
				}

			}
			while (pick3 == true) {
				botch3.equals(chatbot3.getResponse(statement).toLowerCase());
				if (botch1.equals("HappyBot") || botch1.equals("SadBot")) {
					break;
				}
			}
			if (botch2.equals("HappyBot") || botch3.equals("HappyBot")) {
				System.out.println("Thanks for choosing me.");
				statement = in.nextLine();
				chatbot1.chatLoop(statement);
				botChoice = true;
				pick1 = true;
				pick2 = false;
				pick3 = false;
			} else if (botch1.equals("SadBot") || botch3.equals("SadBot")) {
				System.out.println("Wow, thanks for choosing me :/.");
				statement = in.nextLine();
				chatbot1.chatLoop(statement);
				botChoice = true;
				pick1 = false;
				pick2 = true;
				pick3 = false;
			} else if (botch1.equals("NeutralBot") || botch2.equals("NeutralBot")) {
				System.out.println("You chose me.");
				statement = in.nextLine();
				chatbot1.chatLoop(statement);
				botChoice = true;
				pick1 = false;
				pick2 = false;
				pick3 = true;
			}
		}
	}
}