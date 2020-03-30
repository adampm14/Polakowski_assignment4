import java.util.*; 
import java.io.*; 
public class DuplicateCounter {
	HashMap<String, Integer> wordCounter = new HashMap<>();
	String words;
	public void count(String dataFile) {
	try {
		Scanner scanner = new Scanner(new File(dataFile));	
		while(scanner.hasNext()) {
			words = scanner.next();
			words = words.replaceAll("[^\\w\\s\\ ]", "").toLowerCase();
			if (wordCounter.containsKey(words)) {		
				wordCounter.put(words, wordCounter.get(words) + 1);
			}
				else {
					wordCounter.put(words, 1);
				 }
			
		}
		scanner.close();
			
}
	catch(Exception problem) {
	System.out.println("There was a problem finding the file: " +dataFile);	
	}
	
}
	public void write(String outputFile) {
		FileWriter output = null;;
		try {
			output = new FileWriter(outputFile);
			for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
		    	   output.write(entry.getKey() + " exists : " + entry.getValue()+ " times");
		    	   output.write("\n");
		       }
		 	}
		    catch(IOException problem) {    
		    	System.out.println("There was a problem finding the file: "+outputFile);
		    }
		    	finally {
		    	
		    	try {
		    		output.close();	
		    		}catch(Exception problem) {
		    		System.out.println("There was a problem with the file: "+outputFile);
		    		}
		 }
	}
}

		    	
		    	
		    

