/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: GameBoard
 * Description: Game Board object
 */
package main;

/**
 * Class for Tic Tac Toe gameboard
 * 
 * @author Put Name Here
 */
public class GameBoard {
	/**
	 * An array of 9 GameTiles representing the TicTacToe gameboard
	 */
	GameTile[] board;
	//Declare variable for storing values for the learning AI
	String[] gameBoardThisTurn = new String[9];

	/**
	 * Constructs an empty gameboard of 9 GameTiles and fills it with unowned tiles
	 */
	public GameBoard() {
		board = new GameTile[9];
		for (int i = 0; i < 9; i++)
			board[i] = new GameTile();
	}

	/**
	 * This will allow a player to claim a GameTile on the TicTacToe board
	 * 
	 * @return A boolean true if the player successfully played on a tile, false if
	 *         that tile is already owned or the index is out of bounds
	 * @param player A String indicating which player is to own the tile ("X" or
	 *               "O")
	 * @param tile   An integer representing the tile the player wishes to claim
	 */
	//Plays Player vs. player
	public boolean play(String player, int tile) {
		tile = tile - 1;
		boolean owned = board[tile].owned();
		if (owned == false) {
			//Gets all of the owners and puts into an array and saves it for later use in the LearningAI method in the variable gameBoardThisTurn
			String[] boardOwned = { board[0].getOwner(), board[1].getOwner(), board[2].getOwner(), board[3].getOwner(),
					board[4].getOwner(), board[5].getOwner(), board[6].getOwner(), board[7].getOwner(),
					board[8].getOwner() };
			gameBoardThisTurn = boardOwned;
			board[tile].setOwner(player);
		}
		if (owned == false) {
			owned = true;
		} else {
			owned = false;
		}
		return owned;
	}

	//Plays hard AI
	public int playAIHard() {
		//Gets the board state in proper form in order to give to the move method in hard AI
		String[] boardOwned = { board[0].getOwner(), board[1].getOwner(), board[2].getOwner(), board[3].getOwner(),
				board[4].getOwner(), board[5].getOwner(), board[6].getOwner(), board[7].getOwner(),
				board[8].getOwner() };
		for (int i = 0; i < boardOwned.length; i++) {
			if (boardOwned[i] == null) {
				boardOwned[i] = "S";

			}
		}
		//Gets the move from Hard AI then returns it
		int index = (HardAI.move(boardOwned));
		return index;

	}

	public int playAILearn() {
		//Gets the current board state into an array
		String[] boardOwned = { board[0].getOwner(), board[1].getOwner(), board[2].getOwner(), board[3].getOwner(),
				board[4].getOwner(), board[5].getOwner(), board[6].getOwner(), board[7].getOwner(),
				board[8].getOwner() };
		//Sets index equal to the move method in the learning AI
		int index = LearningAI.move(boardOwned);
		//Returns index
		return index;
	}

	/**
	 * This will check to see if there are three tiles in a row belonging to a
	 * player
	 * 
	 * @return A boolean true if the player has three tiles in a row, false
	 *         otherwise
	 * @param player A String indicating which player to check for a win ("X" or
	 *               "O")
	 */
	public boolean checkWin(String player) {
		boolean win = false;
		for (int i = 0; i < board.length; i += 3) {
			if (board[i].getOwner() == player && board[i + 1].getOwner() == player
					&& board[i + 2].getOwner() == player) {
				win = true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (board[i].getOwner() == player && board[i + 3].getOwner() == player
					&& board[i + 6].getOwner() == player) {
				win = true;
			}
		}
		if (board[0].getOwner() == player && board[4].getOwner() == player && board[8].getOwner() == player) {
			win = true;
		}
		if (board[2].getOwner() == player && board[4].getOwner() == player && board[6].getOwner() == player) {
			win = true;
		}
		return win;
	}

	/**
	 * This will draw the current gameboard on the screen
	 */
	public void drawBoard() {
		String[] boardOwned = { board[0].getOwner(), board[1].getOwner(), board[2].getOwner(), board[3].getOwner(),
				board[4].getOwner(), board[5].getOwner(), board[6].getOwner(), board[7].getOwner(),
				board[8].getOwner() };
		for (int i = 0; i < boardOwned.length; i++) {
			if (boardOwned[i] == " ") {
				boardOwned[i] = " ";
			}
		}
		System.out.println("_____________");
		System.out.println("| " + boardOwned[0] + " | " + boardOwned[1] + " | " + boardOwned[2] + " |");
		System.out.println("_____________");
		System.out.println("| " + boardOwned[3] + " | " + boardOwned[4] + " | " + boardOwned[5] + " |");
		System.out.println("_____________");
		System.out.println("| " + boardOwned[6] + " | " + boardOwned[7] + " | " + boardOwned[8] + " |");
		System.out.println("_____________");
	}

	public void write(int index, String player, boolean win) {
		//Calls the wright method in learning AI
		LearningAI.wright(gameBoardThisTurn, player, index, win);
	}
	public void record(Boolean winX) {
		//Calls the record method in learning AI
		LearningAI.record(winX);
	}
}// end class