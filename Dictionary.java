/**   Name: Dictionary.java
 * 	  Purpose: This class models a dictionary.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 4/14/2017
 *	  Data fields:  dictionary: ArrayList<DictionaryEntry> - stores the words made by the user or imported from a file
 *					size: int - the current size of the ArrayList
 *					numWords: int - the number of words added to the dictionary
 *    Methods:  default constructor - initilizes the dictionary TreeMap object 
 *				clearDictionary(): void - clears the TreeMap 
 *				addFromKeyboard(Scanner): void - calls a method to add a word to the TreeMap from keyboard
 *				addFromFile(Scanner): void - calls a method to add words to the TreeMap from a file
 *				addWord(String): void - adds a word to to the ArrayList
 *				searchWord(Scanner): void - searches for number of instances of a single word
 *				numWords(): void - displays the number of words in the Dictionary
 *				stripWord(String): String - converts word to all lowercase letters and strips all characters except for a-z
 *				hash(String): int - calculates the index in the array based on the sum of all characters in the string argument
 *				fillArrayWithNulls(): void - fills the array with null values
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	private ArrayList<DictionaryEntry> dictionary;
	
	private int size = 1000;
	
	private int numWords = 0;
	
	public Dictionary(){
		dictionary = new ArrayList<DictionaryEntry>(size);
		fillArrayWithNull();
	}
	
	public void clearDictionary(Scanner in){
		int newSize = 0;
		do{
			System.out.print("Enter new size for the dictionary: ");
			if(in.hasNextInt()){
				newSize = in.nextInt();
			} else {
				in.next();
				System.out.println("Invalid Input");
			}
		} while(newSize <= 0);
		size = newSize;
		dictionary = new ArrayList<DictionaryEntry>(newSize);
		fillArrayWithNull();
		numWords = 0;
		System.out.println("Dictionary cleared");
	}
	
	public void addFromKeyboard(Scanner in){
		System.out.println("Enter word to add: ");
		addWord(in.next());
	}
	
	public void addFromFile(Scanner in){
		while(in.hasNext()){
			addWord(in.next());
		}
	}
	
	public void addWord(String word){
		word = stripWord(word);
		int index = hash(word);
		DictionaryEntry dictWord = dictionary.get(index);
		if(dictWord == null){
			dictionary.set(index, new DictionaryEntry(word, 1));
			++numWords;
		} else {
			if(dictWord.getWord().equals(word))
				dictWord.incrementCount();
			else{
				System.out.println("Word cannot be added.");
			}
		}
	}
	
	public void searchWord(Scanner in){
		System.out.println("Enter word to search for:");
		String word = stripWord(in.next());
		DictionaryEntry dictWord = dictionary.get(hash(word));
		if(dictWord != null && dictWord.getWord().equals(stripWord(word)))
			System.out.println(word + " occurs " + dictWord.getCount() + " times");
		else{
			System.out.println("Word does not exist in dictionary.");
		}
	}
	
	public void numWords(){
		System.out.println("There are " + numWords + " words");
	}
	
	private String stripWord(String word){
		return word.toLowerCase().replaceAll("[^a-z]","");
	}
	
	private int hash(String word){
		int numChars = 0;
		for(int i = 0; i < word.length(); i++)
			numChars += (int)word.charAt(i);
		return numChars % size;
	}
	
	private void fillArrayWithNull(){
		for(int i = 0; i < size; i++){
			dictionary.add(null);
		}
	}
}
