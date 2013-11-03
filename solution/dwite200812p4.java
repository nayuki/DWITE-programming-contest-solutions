/* 
 * DWITE - December 2008 - Problem 4: Time for change
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200812p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA4.txt", "OUT4.txt", new dwite200812p4());
	}
	
	
	protected void runOnce() {
		int amount = io.readIntLine();
		int[] minCoins = new int[amount + 1];
		Arrays.fill(minCoins, Integer.MAX_VALUE - 1);
		minCoins[0] = 0;
		
		int coins = io.readIntLine();
		for (int i = 0; i < coins; i++) {
			int coin = io.readIntLine();
			for (int j = coin; j <= amount; j++)
				minCoins[j] = Math.min(minCoins[j - coin] + 1, minCoins[j]);
		}
		io.println(minCoins[amount]);
	}
	
}
