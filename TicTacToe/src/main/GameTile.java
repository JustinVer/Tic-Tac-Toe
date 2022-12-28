/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: GameTile
 * Description: Tile object
 */
package main;

/**
 * Class for Tic-Tac-Toe tile
 * 
 * @author Justin Verhoog
 */

public class GameTile {
	/**
	 * Stores a String representing the owner "X" or "O" of a GameTile
	 */
	protected String owner;

	/**
	 * Constructs a GameTile, sets owner to null by default
	 */
	public GameTile() {
		owner = " ";
	}

	/**
	 * This will return who owns this particular GameTile
	 * 
	 * @return String "X" if player 1 owns tile, "Y" if player 2 owns tile, empty
	 *         string if unowned
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * This will assign a new owner to the game tile
	 * 
	 * @param player A String indicating which player will own the tile ("X" or "O")
	 */
	public void setOwner(String player) {
		owner = player;
	}

	/**
	 * This will determine whether any player owns a particular tile
	 * 
	 * @return boolean true if a player owns the tile, false otherwise
	 */
	public boolean owned() {
		boolean owned = false;
		if (owner == "X" || owner == "O") {
			owned = true;
		} else {
			owned = false;
		}
		return owned;
	}
}
