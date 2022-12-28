/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: HardAI
 * Description: Play's tik tac toe while always making the best possible move
 */
package main;

public class HardAI {
	public static int move(String[] boardOwned) {
		int index = -1;
		StringBuffer board = new StringBuffer();
		for(int i = 0; i<boardOwned.length; i++) {
		if (boardOwned[i] == null||boardOwned[i] == " ") {
			boardOwned[i] = "S";
		}
		}
		// Turns the array into a single string by appending and a string buffer
		for (int i = 0; i < boardOwned.length; i++) {
			board.append(boardOwned[i]);
		}
		// Converts string buffer into a string
		String Board = board.toString();
		//Turn one move is always 1
		if (Board.equals("SSSSSSSSS")) {
			index = 1;
		}
		//Returns if a move was made
		if (index != -1) {
			return index;
		}
		//Turn 2 moves
		if(Board.equals("XOSSSSSSS") || Board.equals("XSSOSSSSS") || Board.equals("XSSSSOSSS") || Board.equals("XSSSSSSOS")) {
			index = 5;
		}
		if(Board.equals("XSSSOSSSS")) {
			index = 9;
		}
		if(Board.equals("XSSSSSOSS")) {
			index = 3;
		}
		if(Board.equals("XSSSSSSSO") || Board.equals("XSOSSSSSS")) {
			index = 7;
		}
		//Turn 3 moves for anything other than if they went middle on there first turn
		if(Board.equals("XOSSXSSSO")||Board.equals("XSSSXSSOO")) {
			index = 7;
		}
		if(Board.equals("XSSOXSOSO") || Board.equals("XSSSXOSSO") || Board.equals("XSSOSSXSO")) {
			index = 3;
		}
		if(Board.equals("XOXSSSOSS") || Board.equals("XSOOSSXSS")) {
			index = 9;
		}
		//Turn 3 moves if they went middle turn 1 (all of the other possible moves for O to make will end in a draw if both sides play perfect so the checking for a win and blocking moves will handle it)
		if(Board.equals("XSOSOSSSX")) {
			index = 7;
		}
		if(Board.equals("XSSSOSOSX")) {
			index = 3;
		}
		//Returns if a move was made
		if (index != -1) {
			return index;
		}
		// Checks to see if there is a possible winning move
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "S" && boardOwned[i + 1] == "X" && boardOwned[i + 2] == "X") {
				index = i;
				return index + 1;
			}
		}
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "X" && boardOwned[i + 1] == "S" && boardOwned[i + 2] == "X") {
				index = i + 1;
				return index + 1;
			}
		}
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "X" && boardOwned[i + 1] == "X" && boardOwned[i + 2] == "S") {
				index = i + 2;
				return index + 1;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "S" && boardOwned[i + 3] == "X" && boardOwned[i + 6] == "X") {
				index = i;
				return index + 1;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "X" && boardOwned[i + 3] == "S" && boardOwned[i + 6] == "X") {
				index = i + 3;
				return index + 1;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "X" && boardOwned[i + 3] == "X" && boardOwned[i + 6] == "S") {
				index = i + 6;
				return index + 1;
			}
		}
		if (boardOwned[0] == "S" && boardOwned[4] == "X" && boardOwned[8] == "X") {
			index = 0;
			return index + 1;
		}
		if (boardOwned[0] == "X" && boardOwned[4] == "S" && boardOwned[8] == "X") {
			index = 4;
			return index + 1;
		}
		if (boardOwned[0] == "X" && boardOwned[4] == "X" && boardOwned[8] == "S") {
			index = 8;
			return index + 1;
		}
		if (boardOwned[2] == "S" && boardOwned[4] == "X" && boardOwned[6] == "X") {
			index = 2;
			return index + 1;
		}
		if (boardOwned[2] == "X" && boardOwned[4] == "S" && boardOwned[6] == "X") {
			index = 4;
			return index + 1;
		}
		if (boardOwned[2] == "X" && boardOwned[4] == "X" && boardOwned[6] == "S") {
			index = 6;
			return index + 1;
		}
		//Finally if no other options check for a block
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "S" && boardOwned[i + 1] == "O" && boardOwned[i + 2] == "O") {
				index = i;
			}
		}
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "O" && boardOwned[i + 1] == "S" && boardOwned[i + 2] == "O") {
				index = i + 1;
			}
		}
		for (int i = 0; i < 3; i += 3) {
			if (boardOwned[i] == "O" && boardOwned[i + 1] == "O" && boardOwned[i + 2] == "S") {
				index = i + 2;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "S" && boardOwned[i + 3] == "O" && boardOwned[i + 6] == "O") {
				index = i;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "O" && boardOwned[i + 3] == "S" && boardOwned[i + 6] == "O") {
				index = i + 3;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (boardOwned[i] == "O" && boardOwned[i + 3] == "O" && boardOwned[i + 6] == "S") {
				index = i + 6;
			}
		}
		if (boardOwned[0] == "S" && boardOwned[4] == "O" && boardOwned[8] == "O") {
			index = 0;
		}
		if (boardOwned[0] == "O" && boardOwned[4] == "S" && boardOwned[8] == "O") {
			index = 4;
		}
		if (boardOwned[0] == "O" && boardOwned[4] == "O" && boardOwned[8] == "S") {
			index = 8;
		}
		if (boardOwned[2] == "S" && boardOwned[4] == "O" && boardOwned[6] == "O") {
			index = 2;
		}
		if (boardOwned[2] == "O" && boardOwned[4] == "S" && boardOwned[6] == "O") {
			index = 4;
		}
		if (boardOwned[2] == "O" && boardOwned[4] == "O" && boardOwned[6] == "S") {
			index = 6;
		}
		if (index != -1) {
			return index + 1;
		}else{
			//If there is no blocks and no wins the game will end in a draw so it doesn't matter what move gets made
			return (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
		}
	}
}
