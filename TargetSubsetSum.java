import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n= scn.nextInt();
        int arr[]= new int[n];
        
        for(int i=0;i< arr.length;i++){
            arr[i]= scn.nextInt();
        }
        
        int tar=scn.nextInt();
        
         printTargetSumSubsets( arr,   tar);
        
        

    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr,  int tar) {
        
        int dp[][]=new int[arr.length+1][tar+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                
                if(i==0 && j==0){
                    dp[i][j]=1;
                    
                }
                
                else if(i==0){
                   
                    dp[i][j]=0;  
                }
                
              
                else  if(j==0){
                    dp[i][j]=1;
                }
                
                else {
                    
                    if(dp[i-1][j]==1){     // not contributed
                        
                        dp[i][j]=1;
                    }
                    
                    else{                  // contributes
                       
                        
                        if(j>=arr[i-1]){
                            
                            if(dp[i-1][j-arr[i-1]]==1){
                                
                                dp[i][j]=1;
                            }
                        }
                        
                    }
                }
                
                
            }
        }
        
        System.out.println(dp[arr.length][tar]);
        
    }

}
