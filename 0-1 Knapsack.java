import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
           
        int n= scn.nextInt();

        
        int[] vals = new int[n];
        int[] wts=new int[n];
        
        for(int i=0;i<n;i++){
            vals[i]=scn.nextInt();
        }
        
         for(int i=0;i<n;i++){
            wts[i]=scn.nextInt();
        }
     
         int cap =scn.nextInt();
         
         int[][] dp = new int[n+1][cap+1];
         
         
         for(int i=1;i<dp.length;i++){               //i represents  vals and wts
             for(int j=1;j<dp[0].length;j++){        // j represents counting from 1 till capacity
                 

                  // when player contributes 
                 if(j>=wts[i-1])  {              //wts[i-1] coincides with dp[i] that is why i-1 is used for comparison with j
               
                     if(dp[i-1][j-wts[i-1]] > dp[i-1][j]){
                         
                         dp[i][j]=dp[i-1][j-wts[i-1]]+vals[i-1];
                     }
                 }
                 
                
                else                 // when player doesn't contributes 
                  dp[i][j] = dp[i-1][j];         
             }
         }
         
         
         System.out.println(dp[n][cap]);
     
    }
}
