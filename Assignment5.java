/**   Name: Assignment5.java
 * 	  Purpose: This class contains a main method to run the dictionary application.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 4/14/2017
 *	  Data fields:  none
 *    Methods:  main - provides a menu to run a dictionary application
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment5 {
	
	public static void main(String[] args){
		
		Scanner input;
		int option;
		
		Dictionary dictionary = new Dictionary();
		
		while(true){
			option = 0;
			input = new Scanner(System.in);
			do{
				System.out.println("\nEnter 1 to clear dictionary,"
								  +"\n2 to add text from keyboard,"
								  +"\n3 to add text from a file,"
								  +"\n4 to search for a word count,"
								  +"\n5 to display number of words,"
								  +"\n6 to quit ");
			
				if(input.hasNextInt())
					option = input.nextInt();
				else {
					input.next();
					System.out.println("Invalid input");
				}
			
			}while (option < 1 || option > 6);
		
		
			switch(option){
			case 1:
				dictionary.clearDictionary(input);
				break;
			case 2:
				dictionary.addFromKeyboard(input);
				break;
			case 3:
				String file;
				System.out.println("\nEnter name of file to process: ");
				file = input.next();
				try{
					input = new Scanner(new File(file));
				} catch (NullPointerException ex){
					System.out.println("Error opening file. Ensure the filename is correct.");
					break;
				} catch (FileNotFoundException ex){
					System.out.println("Error opening file. Ensure the file exists.");
					break;
				}
				dictionary.addFromFile(input);
				break;
			case 4:
				dictionary.searchWord(input);
				break;
			case 5:
				dictionary.numWords();
				break;
			case 6:
				input.close();
				return;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}
