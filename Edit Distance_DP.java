import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str1, String str2) {
		//write your code here
		
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i =0 ;i< dp.length;i++){
		    for(int j=0;j<dp[0].length;j++){
		        
		        if(i==0)
		          dp[i][j]=j;   
		          
		        if(j==0)
		         dp[i][j]=i;
		         
		         else{
		             
		             if(str1.charAt(i-1)==str2.charAt(j-1)){
		                 
		                 dp[i][j]=dp[i-1][j-1];
		                 
		                 
		             }
		             
		             else{
		                 
		                 int f1=1+dp[i-1][j-1];   //insert
		                 int f2=1+dp[i-1][j];    // replace
		                 int f3=1+dp[i][j-1];    // delete
		                 
		                 dp[i][j] = Math.max(f1,Math.max(f2,f3));
		                 
		                 
		             }
		             
		           
		             
		         }
		         
		         return dp[dp.length-1][dp[0].length-1];
		        
		        
		    }
		}
		

		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
