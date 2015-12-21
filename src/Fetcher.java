import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Fetcher {
	String fetch(String rawInput){
		// String =>String array

	    // split on new lines
	    String[] lines = rawInput.split("\\r?\\n"); 
	    
	    for(String line: lines){
	    	System.out.println(line);
	    	System.out.println(fetchHTML(line));
	    }
		// Filter 
		
		
		// grab lines, one by one, send to html fetcher

		
		// send return to output
		
		return null;
	}
	
	String fetchHTML(String lookup){
		lookup = lookup.replaceAll("\\s","+");
		System.out.println(lookup);
	    String content = null;
	    URLConnection connection = null;
	    try {
	      connection =  new URL("https://www.youtube.com/results?search_query="+lookup).openConnection();
	      Scanner scanner = new Scanner(connection.getInputStream());
	      scanner.useDelimiter("\\Z");
	      content = scanner.next();
	    }catch ( Exception ex ) {
	        ex.printStackTrace();
	    }
		return content;
	}
}
