

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;


public class Main{

	public static void main(String[] args){
		
		Parser parser = new Parser();
		String file;
		ArrayList<String> sentences = new ArrayList<String>();
		for (int i = 1; i < 5; i++){
		file = "C://"+i+".train2";
		parser.parse(file,i);
		}
		HashMap<Integer, ArrayList<String>> messages = parser.getMessages();
		Dictionary dict = new Dictionary();
		for (int i = 1; i < 5; i++){
			
			// All the messages related to the i'th forum
			sentences = messages.get(i);
			
			// Bag of words for every message (j) from the i'th forum
			for (int j = 0; j < sentences.size(); j++){
				BagOfWords bag = new BagOfWords();
				bag.createBagFromMessage(sentences.get(j).toString());
				// Update the dictionary for the current message ( bag of words)
				dict.updateDictionary(bag);
			}
		}
		for (int i: messages.keySet()){
			for (int j = 0;j < messages.get(i).size(); j++){
				messages.get(i).get(j).toLowerCase();
			}
		}
		Matrix m = new Matrix();
		int pointer = 0;// Index of the current array list in m
		for (int i: messages.keySet()){
			for (int j = 0;j < messages.get(i).size(); j++){
				String[] curr = messages.get(i).get(j).toString().split(" +|,|'|!|$|>|<|>|\" |:|\\.|\\?|-|\\(|\\)");
				//LinkedHashSet<Integer> temp = m.getSet(pointer);
				// For every word in the message find the corresponding entry in the dictionary 
				for (int k=0; k < curr.length; k++){
					int index = dict.getDictionary().indexOf(curr[k]); // Index of the corresponding entry in the dictionary 
					// for the current word
					m.insert(pointer, index);
				}
				pointer++;
			}
		}
	}


}