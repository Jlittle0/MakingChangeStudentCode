import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Josh Little
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        // Sorts the array of coins from least to greatest
        Arrays.sort(coins);
        // Creates a map to store the number of coins required for combinations of target
        // length and using only a subset of coins.
        long[][] map = new long[target + 1][coins.length];
        // Go through all the combinations that can make 0 cents and set them equal to 1.
        for (int i = 0; i < coins.length; i++)
            map[0][i] = 1;
        // Memoization
        return countWays(target, map, coins, coins.length - 1);
    }

    public static long countWays(int target, long[][] map, int[] coins, int index) {
        if (index < 0)
            return 0;
        if (target < 0)
            return 0;
        // If there's a value stored for a specific combination, return it.
        if (map[target][index] != 0)
            return map[target][index];
        // Set the value of a target + subset of coins pair using index as max by using recursion
        map[target][index] = countWays(target - coins[index], map, coins, index) + countWays(target, map, coins, index - 1);
        // return the value above for the recursive call.
        return map[target][index];
    }

}
