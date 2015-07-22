
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class Main{

	public static void main(String[] args){
		
		Parser parser = new Parser();
		String file;
		int[] counters = new int[4];
		ArrayList<String> sentences = new ArrayList<String>();
		for (int i = 1; i < 5; i++){
		file = "/Users/Lorin/Downloads/projectdata/20newsgroups/"+i+".train";
		parser.parse(file,i);
		}
		
		
		HashMap<String, ArrayList<String>> messages = parser.getMessage();
		Dictionary dict = new Dictionary();
		for (int i = 1; i < 5; i++){
			String strI = Integer.toString(i);
			// All the messages related to the i'th forum
			sentences = messages.get(strI);
			counters[i-1] = sentences.size();
			
			// Bag of words for every message (j) from the i'th forum
			for (int j = 0; j < sentences.size(); j++){
				BagOfWords bag = new BagOfWords();
			
				bag.createBagFromMessage(sentences.get(j).toString());

//			Print words of message
//				if ( j < 2 ) {
//				System.out.println("Message number " + j);
//				System.out.println(sentences.get(j).toString());
//				System.out.println();
//				bag.print();
//
//				}
				
				// Update the dictionary for the current message ( bag of words)
				dict.updateDictionary(bag);
			}
		}
		
		// who is the most 
		int max = 0;
		int idOfGroup = 0 ;
		
		for  (int i = 0; i < counters.length; i++) {
			if (counters[i]>max)
			{
				max = counters[i];
				idOfGroup = i;
			}
		}
		System.out.println("THE FORUM IS " + ++idOfGroup);
		String temp = sentences.get(1).toString();

		//dict.print();
		
		
		Message msg = new Message();
		// Comparing the i'th message (i = 4) to the j'th message(j = 7), creating the
		// corresponding vector
		msg.makeMessage(temp, dict);
		//msg.printVector();
		//msg.printVector();	
	}


}