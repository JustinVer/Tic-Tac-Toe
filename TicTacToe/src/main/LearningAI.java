/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: LearningAI
 * Description: Play's tik tac toe while learning what to do better the next time it plays
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningAI {
	//Declare variable that are used in multiple methods
	static String[] BoardState = new String[9];
	static int[] Index = new int[9];
	static int Turn = -1;

	public static void wright(String[] boardOwned, String player, int index, boolean win) {
		Turn++;
		//Declare variables
		StringBuffer board = new StringBuffer();
		//Replaces all of the blank tiles with an S for easier writing
		for (int i = 0; i < boardOwned.length; i++) {
			if (boardOwned[i] == " ") {
				boardOwned[i] = "S";
			}
		}
		//Turns the array into a single string by appending and a string buffer
		for (int i = 0; i < boardOwned.length; i++) {
			board.append(boardOwned[i]);
		}
		//Converts string buffer into a string
		String Board = board.toString();
		//Saves the board state and the index to be used when writing to the file at the end of the game
		BoardState[Turn] = Board;
		Index[Turn] = index;
	}

	public static void record(Boolean winX) { 
		//Declares variables
		String file = "";
		//Changes all of the blanks to S
			for (int i = 0; i < BoardState.length; i++) {
				if (BoardState[i] == null) {
					BoardState[i] = "S";
				}
			}
			//Sets the correct location depending on if the computer won or lost
			if (winX == false) {
				file = "losingCombinations.txt";
			}
			if (winX == true) {
				file = "WiningCombinations.txt";
			}
			//Declares the file writer. Has to be in a try catch
			try {
				File outFile = new File(file);
				BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
				//Writes all of the stuff to the file using the method arrays BoardState and Index
				for (int i = 0; i < 9; i++) {
					if (BoardState[i] != "S") {
						writer.newLine();
						writer.write(BoardState[i]);
						writer.newLine();
						writer.write(Integer.toString(Index[i]));

					}
				}
				//Closes the writer
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static int move(String[] boardOwned) {
		//Declare variables
		File inFile = new File("WiningCombinations.txt");
		StringBuffer board = new StringBuffer();
		int index = 2;
		//Changes blank spaces to S
		for (int i = 0; i < boardOwned.length; i++) {
			if (boardOwned[i] == " ") {
				boardOwned[i] = "S";
			}
		}
		//Starts scanner, has to be in a try catch
		try {
			Scanner freader = new Scanner(inFile);
			//Takes all of the elements of board Owned and appends them into board
			for (int i = 0; i < boardOwned.length; i++) {
				board.append(boardOwned[i]);
			}
			//Converts board to a string
			String Board = board.toString();
			//Reads through all of the lines to try and find a good move
			for (int i = 0; i < (((inFile.length() + 2) / 14)); i++) {
				String b;
				//Reads in a line
				b = freader.nextLine();
				boolean GN = false;
				//Checks to see if the line that was read is equal to the board state if it is it reads in the next line at sets index equal to that line
				if (b.equals(Board)) {
					index = Integer.parseInt(freader.nextLine());
					return index;
				} 
				//If the hole file has been read through and no move has been found get a random number that dose not contradict with the loses file
				else if (i >= (((inFile.length() + 2) / 14) - 1)) {
					freader.nextLine();
					//Declare variables
					int count8 = 0;
					File inFile2 = new File("losingCombinations.txt");
					//Checks the random number against the loses file until the number is either good or the file has check so many times that there is no good option so it just makes a random number
					while (GN == false && count8 < (inFile2.length() * 2) ) {
						count8++;
						//Gets a random number
						index = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
						//Declares scanner
						Scanner freader2 = new Scanner(inFile2);
						//Checks the number against the lose file
						for (int j = 0; j < (((inFile2.length() + 2) / 14)); j++) {
							//Reads in one line
							String d = freader2.nextLine();
							//Takes in a second line converting it to an integer
							int d2 = Integer.parseInt(freader2.nextLine());
							//If the first line equals the board state and the index equals the second line break the loop which gets a new random number
							if (d.equals(b) && d2 == index) {
								break;
							} 
							//If the whole file gets read then set GN equal to true so that the while loop ends which then returns index
							else if (j >= (((inFile2.length() + 2) / 14) - 1)) {
								GN = true;
							}
						}
						freader2.close();
					}
					//If the while loop ends because it tried to many times it just picks a random number
					if (GN == false) {
						index = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
					}
				}
			}
			// Closes the reader
			freader.close();
		} catch (FileNotFoundException e) {
		}
		//Returns index
		return index;
	}
}
