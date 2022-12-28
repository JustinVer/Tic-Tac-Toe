/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: playTicTacToe
 * Description: Play tik tac toe
 */
package main;

/**This main program will create a GameBoard object and allow a round of TicTacToe to be played
	*@author Mr. Aldworth
	*/
import java.io.*;

public class playTicTacToe {
	public static void main(String args[]) throws Exception {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
		GameBoard game = new GameBoard();// makes a blank gameboard
		String player1;
		String player2 = "";
		int turn = 0;
		int index = 0;
		int gameN;
		boolean errorFlag;
		boolean gameOver = false;
		System.out.print("Please Enter Player 1's Name: ");
		player1 = keyboard.readLine();
		//Asks the user for the game mode they want to play
		System.out.println(
				"Press 1 for a 2 player game press 2 for a easy opponent press 3 for a hard opponent and press 4 for an opponent that learns");
		gameN = Integer.parseInt(keyboard.readLine());
		//Only asks for a second player if there is need for a second player
		if (gameN == 1) {
			System.out.println(player1 + " you are X's");
			System.out.print("Please Enter Player 2's Name: ");
			player2 = keyboard.readLine();
			System.out.println(player2 + " you are O's");
		}else {
			System.out.println(player1 + " you are O's");
		}
		System.out.println("Press ENTER to continue");
		keyboard.readLine();
		System.out.println();
		System.out.println();
		game.drawBoard();
		System.out.println();
		System.out.println();
		while (gameOver == false) {
			errorFlag = false;
			if (turn % 2 == 0) {// if it is player 1's turn
				do {
					//Depending on the game mode gets the starting players move in the correct way
					if (gameN == 1) {
						System.out.print(player1 + " enter your choice (1-9): ");
						index = Integer.parseInt(keyboard.readLine());// Assumes a valid number is entered
					}
					if (gameN == 2) {
						index = randomAI.move();
					}
						if (gameN == 3) {
							index = game.playAIHard();
						}
					if (gameN == 4) {
						index = game.playAILearn();
					}
					errorFlag = game.play("X", index);
					if (errorFlag == false)
						System.out.println("That square is already taken or invalid.  Try again");
				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				game.drawBoard();
				game.write(index, "X", game.checkWin("X"));
				System.out.println();
				System.out.println();
				if (game.checkWin("X")) {
					//if it is 2 humans playing print that player 1 has won if not print that the computer has won
					if (gameN == 1) {
						System.out.println(player1 + ", YOU WIN!!");
					}else if(gameN == 2||gameN == 3||gameN == 4) {
						System.out.println("The Computer Won");
					}
					gameOver = true;
				}
			} else {// player 2s turn

				do {
					System.out.print(player2 + " enter your choice (1-9): ");
					index = Integer.parseInt(keyboard.readLine());// Assumes an integer is entered
					errorFlag = game.play("O", index);
					if (errorFlag == false)
						System.out.println("That square is already taken or invalid.  Try again");
				} while (errorFlag == false);// makes sure player enters a square not yet used
				System.out.println();
				System.out.println();
				game.drawBoard();
				System.out.println();
				System.out.println();
				if (game.checkWin("O")) {
					//if it is 2 humans playing it prints that player 2 has won if not then player 1 has won
					if (gameN == 1) {
						System.out.println(player2 + ", YOU WIN!!");
					} else {
						System.out.println(player1 + ", YOU WIN!!");
					}
					gameOver = true;
				}

			}
			turn++;
			if (turn == 9 && gameOver == false) {
				gameOver = true;
				System.out.println("DRAW");
			}
		} // end while
		game.record(game.checkWin("X"));
	}// end main
}// end class