import java.util.Scanner;

public class ConsoleGame extends GuessGame {
	private Scanner scanner;

	ConsoleGame() {
		welcome = "歡迎";
		prompt = "輸入";
		correct = "猜中了";
		bigger = "你猜的比較大";
		smaller = "你猜的比較小";
		scanner = new Scanner(System.in);
	}

	protected void message(String msg) {
		System.out.println(msg);
	}

	protected int guess() {
		return scanner.nextInt();
	}
}
