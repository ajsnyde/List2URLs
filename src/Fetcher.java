import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fetcher {	// REGEX FOR FIRST VIDEO: /<a aria-hidden="true" href="/watch/
	static long totalTrials = 0;
	static long regexTime = 0;
	static long htmlGrabTime = 0;
	static long totalTime = 0;

	String fetch(String rawInput){
		// String =>String array
		// mostly redundent code for failures mid-test
		htmlGrabTime = 0;
		totalTime = 0;
		regexTime = 0;
		totalTrials = 0;
		// end redundencies
		
		long start = System.nanoTime();
	    // split on new lines
	    String[] lines = rawInput.split("\\r?\\n");
	    totalTrials = lines.length;
	    String list = "";
	    String html;
	    for(String line: lines){
	    	System.out.println(line);
	    	html = fetchHTML(line);
	    	String URL = fetchURL(html);
	    	System.out.println(URL);
	    	list += (URL+'\n');
	    }
	    totalTime = System.nanoTime()-start;
		return list;
	}
	
	String fetchHTML(String lookup){
		long start = System.nanoTime();
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
	    htmlGrabTime += System.nanoTime()-start;
		return content;
	}
	
	String fetchURL(String html){
		long start = System.nanoTime();
		Pattern pattern = Pattern.compile("(href=\"/watch[^\"]*\")");
		Matcher matcher = pattern.matcher(html);
		
		
		if (matcher.find())
		{
		    System.out.println(matcher.group(0));
		    System.out.println(matcher.group(0).substring(6, matcher.group(0).length()-1));
		    regexTime += System.nanoTime()-start;
		    return "https://www.youtube.com"+matcher.group(0).substring(6, matcher.group(0).length()-1);
		}
		else {
			regexTime += System.nanoTime()-start;
			return "NOT FOUND";
		}
	}
}
