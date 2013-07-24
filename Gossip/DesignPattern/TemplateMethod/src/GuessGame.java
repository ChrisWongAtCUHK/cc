public abstract class GuessGame {
	protected String welcome;
	protected String prompt;
	protected String correct;
	protected String bigger;
	protected String smaller;

	void go() {
		message(welcome);

		int number = (int) (Math.random() * 10);
		int guess = 0;
		do {
			message(prompt);
			guess = guess();
			if (guess > number) {
				message(bigger);
			} else if (guess < number) {
				message(smaller);
			}
		} while (guess != number);

		message(correct);
	}

	protected abstract void message(String message);

	protected abstract int guess();
}
