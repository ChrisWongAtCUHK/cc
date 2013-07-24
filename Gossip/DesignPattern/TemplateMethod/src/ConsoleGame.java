import java.util.Scanner;

public class ConsoleGame extends GuessGame {
	private Scanner scanner;

	ConsoleGame() {
		welcome = "�w��";
		prompt = "��J";
		correct = "�q���F";
		bigger = "�A�q������j";
		smaller = "�A�q������p";
		scanner = new Scanner(System.in);
	}

	protected void message(String msg) {
		System.out.println(msg);
	}

	protected int guess() {
		return scanner.nextInt();
	}
}
