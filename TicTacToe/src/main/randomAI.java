/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: RandomAI
 * Description: Play's tik tac toe by making a random move
 */
package main;

public class randomAI {
public static int move() {
	//Returns a random integer between 1 and 9
	int M = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
	return M;
}
}
