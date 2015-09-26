// Create a new project and then drag and drop this code into the project
// The searchAndReplace code given below was what we did in Grade 11
// Modify this code to make it faster

/**
 * To write an efficient method for a search and replace method
 * 
 * @author Hannah Kim
 * @version September 2013
 */

public class SearchAndReplace
{
	/**
	 * Replaces every occurrence of the search String in the given String with
	 * the replace String
	 * 
	 * @param str The string you are searching in
	 * @param search The string you are searching for
	 * @param replace The string you want to replace search with
	 * @return The new string with all of the replacements made
	 */
	static String searchAndReplace(String str, String search, String replace)
	{
		StringBuilder string = new StringBuilder (str);
		//StringBuffer string = new StringBuffer (str);

		int findIndex = string.indexOf(search);
		
		while (findIndex >= 0)
		{
			string.replace (findIndex, findIndex + search.length(), replace);
			findIndex = str.indexOf (search, findIndex + replace.length());
		}
		return string.toString();
	}
	

	public static void main(String[] args)
	{
		System.out.println("Checking Search and Replace");

		// First test that the code works
		System.out.println("First test that the code works");
		String newStr = searchAndReplace("Simple simple simple" , "simple",
				"easy");
		System.out.println(newStr.equals("Simple easy easy"));
		newStr = searchAndReplace("cat cat cat", "cat", "a big cat");
		System.out.println(newStr.equals("a big cat a big cat a big cat"));
		newStr = searchAndReplace("nothing to replace", "something", "replace");
		System.out.println(newStr.equals("nothing to replace"));
		newStr = searchAndReplace("aaaaa", "a", "aaa");
		System.out.println(newStr.equals("aaaaaaaaaaaaaaa"));
		newStr = searchAndReplace("bbbbb", "bb", "b");
		System.out.println(newStr.equals("bbb"));

		// Now time how fast it is to do lots of search and replaces
		System.out.println("Then time how long it takes");

		String sentence = "This is a test: is is is is is complete";
		String newSentence = "";

		long startTime = System.nanoTime();
		for (int times = 1; times <= 100000; times++)
			newSentence = searchAndReplace(sentence, "is", "was");
		long endTime = System.nanoTime();

		System.out.println(newSentence);
		System.out.printf("Total Time: %.0f ms%n",
				(endTime - startTime) / 1000000.0);
		System.out.println("Program is Complete");
	} // main method
} // SearchAndReplace class

