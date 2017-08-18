/**   Name: DictionaryEntry.java
 * 	  Purpose: This class models a dictionary.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 4/14/2017
 *	  Data fields:  word: String - holds a word in the dictionary
 *					count: int - the number of times that word occurs
 *    Methods:  default constructor - initilizes the fields
 *    			overloaded constructor - sets the 
 *				getCount(): int - returns the number of times the word occurs
 *				getWord(): String - returns the word
 *				incrementCount(): void - increments the number of times the word occurs
 */
public class DictionaryEntry {
	private String word;
	private int count = 0;
	
	public DictionaryEntry(){
		word = null;
		count = 0;
	}
	
	public DictionaryEntry(String word, int count){
		this.word = word;
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
	public String getWord(){
		return word;
	}
	
	public void incrementCount(){
		count++;
	}

}
