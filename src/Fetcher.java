import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Fetcher {	// REGEX FOR FIRST VIDEO: /<a aria-hidden="true" href="/watch/
	String fetch(String rawInput){
		// String =>String array

	    // split on new lines
	    String[] lines = rawInput.split("\\r?\\n"); 
	    String list = "";
	    String html;
	    for(String line: lines){
	    	System.out.println(line);
	    	html = fetchHTML(line);
	    	String URL = fetchURL(html);
	    	System.out.println(URL);
	    	list += (URL+'\n');
	    }
		return list;
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
	
	String fetchURL(String html){
		Pattern pattern = Pattern.compile("(href=\"/watch[^\"]*\")");
		Matcher matcher = pattern.matcher(html);
		
		
		if (matcher.find())
		{
		    System.out.println(matcher.group(0));
		    System.out.println(matcher.group(0).substring(6, matcher.group(0).length()-1));
		    return "https://www.youtube.com"+matcher.group(0).substring(6, matcher.group(0).length()-1);
		}
		else
			return "NOT FOUND";
	}
}
