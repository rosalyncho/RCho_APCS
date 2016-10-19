
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		statement = statement.trim();
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Don't be so negative. Cheer up!";
		} else if (statement.length() == 0) {
			response = "Say something, please.";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "You have a really nice family.";
		} else if (statement.indexOf("dog") >= 0 
				|| statement.indexOf("cat") >= 0) {
			response = "Pets can be your best friend!";
		} else if (statement.indexOf("Mr.") >= 0) {
			response = "He sounds like a nice teacher.";
		} else if (statement.indexOf("Mrs.") >= 0) {
			response = "She sounds like a nice teacher.";
		} else {
			response = getRandomResponse();
		}
		return response;
	}
	

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Oh. Really?";
		} else if (whichResponse == 5) {
			response = "Woah. Sounds good!";
		}

		return response;
	}
}
