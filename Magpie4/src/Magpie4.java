public class Magpie4 {
	
	//Get a default greeting and return a greeting
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/*
	 * 1) Copy and paste the code you wrote in Magpie 3 into the getResponse method. There is new code within the method 
	 * but below where you will paste your code.  Figure out what it does.
	 * 
	 * 2) Copy and paste Part 3's getRandomResponse() code into the method below.
	 * 
	 * 3) Alter the class as described in the handout.
	 * 
	 */
	
	/**
	 * Gives a response to a user statement
	 * takes in user statement
	 * response based on the rules given
	 */
	public String getResponse(String statement) {
		statement = statement.trim();
		String response = "";
		if (statement.length() == 0) {
			response = "Say something, please.";
		} else if (findKeyword(statement, "no") >= 0) {
			response = "Don't be so negative. Cheer up!";
		} else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0) {
			response = "You have a really nice family.";
		} else if (findKeyword(statement, "dog") >= 0 
				|| findKeyword(statement, "cat") >= 0) {
			response = "Pets can be your best friend!";
		} else if (findKeyword(statement, "Mr.") >= 0) {
			response = "He sounds like a nice teacher.";
		} else if (findKeyword(statement, "Mrs.") >= 0) {
			response = "She sounds like a nice teacher.";

		// Responses which require transformations
		} else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
			
		} else if (findKeyword(statement, "I want", 0) >= 0) {
			response = transformIWantStatement(statement);
			
		} else if (findKeyword(statement, "I", 0) >= 0 && findKeyword(statement, "you", findKeyword(statement, "I", 0)) >= 0){
			// Look for a two word (I <something> you)
			// pattern
			response = transformIYouStatement(statement);	
			
		} else {
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0); 
			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				response = transformYouMeStatement(statement);
		} else {
			response = getRandomResponse();
			}
		}
	return response; 
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I want <something>." and transform it into
	 * "Would you really be happy if you had <something>?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I want "
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I <something> you." and transform it into
	 * "Why do you <something> me?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I <something> you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psnOfI = findKeyword(statement, "I", 0);
		int psnOfYou = findKeyword(statement, "you", psnOfI + 1);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou)
				.trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
	/**
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 * 
	 * parameter: statement
	 *            the string to search
	 * parameter: goal
	 *            the string to search for
	 * parameter: startPos
	 *            the character of the string to begin the search at
	 * return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0) {
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(),
						psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've found the word
			if (before.equals(" ") && after.equals(" ")) {
				return psn;
			}
			// The last position didn't work, so let's find the next, if there
			// is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * takes in the string to search
	 * takes in the string to search for
	 * returns the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
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
