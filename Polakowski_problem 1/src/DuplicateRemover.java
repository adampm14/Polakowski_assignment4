import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class DuplicateRemover {
Set<String> uniqueWords;
	public void remove(String dataFile) {
		try {
			uniqueWords = new LinkedHashSet<>(); 
			Scanner original = new Scanner(new File(dataFile));
				while(original.hasNextLine()){
					String line=original.nextLine();
					String[] words = line.split(" ");
					for(int fileWords=0;fileWords<words.length;fileWords++) {
						String print = words[fileWords].replaceAll("[^\\w\\s\\ ]", " ").toLowerCase();
						uniqueWords.add(print);
	                }
				}
				original.close();
		}
		catch(Exception problem){
			System.out.println("There is a problem opening the file: "+dataFile);
		}
}
public void write(String outputFile) {
    try {
    	FileWriter output = new FileWriter(outputFile);
        for(String uW:uniqueWords)
            output.write(uW+" ");
        output.close();
    }
    catch(Exception problem)
    {
        System.out.println("There is a problem opening the file: "+outputFile);
	}
  }
}
