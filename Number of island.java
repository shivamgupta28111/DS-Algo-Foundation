//                               Using DFS and Backtracking Recusrion like flood fill

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // code Logic for Number of island
      
      boolean[][] vis = new boolean[m][n];
      int count =0;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              
              if(arr[i][j]==0 && vis[i][j] != true){
                  dfs(arr,i,j,vis);
                   count +=1;
              }
              
          }
          
        
      }
       System.out.println(count); 
   }
   
   public static void dfs(int[][] arr, int i,int j,boolean[][] vis){
       
       if(i<0|| i==arr.length|| j<0||j==arr[0].length||arr[i][j]!=0||vis[i][j]==true){
           return;
       }
       
       vis[i][j]=true;
       
       dfs(arr,i-1,j,vis);
       dfs(arr,i+1,j,vis);
       dfs(arr,i,j-1,vis);
       dfs(arr,i,j+1,vis);
       
       
   }

}
