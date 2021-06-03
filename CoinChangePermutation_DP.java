import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();
        
        int[] coins=new int[n];
        
        for(int i=0;i<coins.length;i++){
            
            coins[i]=scn.nextInt();
        }

        
        int tar = scn.nextInt();
        
        int[] dp=new int[tar+1];
        dp[0]=1;
        
        for(int amount=1; amount<=tar; amount++){
            for(int coin:coins){
               
                if(coin<=amount){
                    
                    if(coin<=amount){
                        
                        int remainingAmt=amount-coin;
                        
                        dp[amount] +=dp[remainingAmt];
                    }
                    
                }
            } 
            
            
        }
        
        System.out.println(dp[tar]);
        
    }
}
