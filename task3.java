import java.util.Scanner;

public class SimpleChatbot {

    public static String getResponse(String input) {

        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you today?";
        }
        else if (input.contains("your name")) {
            return "I am a Java AI Chatbot.";
        }
        else if (input.contains("stock")) {
            return "You can buy or sell stocks in the trading platform.";
        }
        else if (input.contains("bye")) {
            return "Goodbye! Have a nice day!";
        }
        else {
            return "Sorry, I don't understand that.";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("AI Chatbot Started (type 'bye' to exit)");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine();

            String response = getResponse(input);
            System.out.println("Bot: " + response);

            if (input.equalsIgnoreCase("bye")) {
                break;
            }
        }

        sc.close();
    }
}