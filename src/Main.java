
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;




public class Main{

	public static void main(String[] args){
		Parser parser = new Parser();
		String file;
		for (int i = 1; i < 5; i++){
		file = "C:\\"+i+".train";
		parser.parse(file,i);
		}
		
		HashMap<String, ArrayList<String>> messages = parser.getMessage();
		Dictionary dict = new Dictionary();
		for (int i = 1; i < 5; i++){
			String strI = Integer.toString(i);
			// All the messages related to the i'th forum
			ArrayList<String> sentences = messages.get(strI);
			
			
			// Bag of words for every message (j) from the i'th forum
			for (int j = 0; j < sentences.size(); j++){
				BagOfWords bag = new BagOfWords();
				bag.createBagFromMessage(sentences.get(j).toString());
				// Update the dictionary for the current message ( bag of words)
				dict.updateDictionary(bag);
			}
			String temp = sentences.get(7).toString();
		}
		dict.print();
		
		
		Message msg = new Message();
		// Comparing the i'th message (i = 4) to the j'th message(j = 7), creating the
		// corresponding vector
		//msg.makeMessage(temp, dict);
		//msg.printVector();	
	}


}