import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public static int coinChange(int[] coins, int amount){

        int[] coinCombination = new int[amount+1];
        Arrays.fill(coinCombination,amount+1);
        coinCombination[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(coin <= i){
                    coinCombination[i] = Math.min(coinCombination[i],coinCombination[i-coin]+1);
                }
            }
        }

        return coinCombination[amount] > amount ? -1 : coinCombination[amount];



    }
    public static void main(String[] args){
        int[] coins = {1,3,5};
        System.out.println(coinChange(coins,11));

    }
}
