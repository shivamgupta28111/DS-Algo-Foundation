import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n= scn.nextInt();
        
        int coins[]= new int[n];
        
        for(int i =0;i<coins.length;i++){
            
            coins[i]=scn.nextInt();
        }
        
        int tar= scn.nextInt();
        
        int dp[] = new int[tar+1];
        dp[0]=0;
        
        for(int coin:coins){     // Coin ka loop pehle ayega combination ke liye
            for(int amt=1;amt<=tar;amt++){   // baad mein target amount 0..1....2......tar
                
                if(coin<=amt){
                    
                       int remainingAmt=amt-coin;
                        
                        dp[amt] +=dp[remainingAmt];
                    
                    
                }
            }
        }
        
        System.out.println(dp[tar]);

    }
}
