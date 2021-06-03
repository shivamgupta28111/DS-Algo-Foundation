import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String path;

        public Pair(int i, int j, String path){
            this.i = i;
            this.j = j;
            this.path = path;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here

        
         printTargetSumSubsets( arr,   tar);
        
        

    }

  
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

        
        
        ArrayDeque<Pair> q=new ArrayDeque<>();              // Path is shown using BFS
        q.add(new Pair(arr.length,tar,""));
        
        while(q.size() !=0){
            
            Pair rem= q.removeFirst();
            
            if(rem.i==0 && rem.j==0){
                System.out.println(rem.path);
                
            }
            
            else{
            
               int excludeContribution = dp[rem.i-1][rem.j];

               if(excludeContribution ==1){
                     q.add(new Pair(rem.i-1,rem.j,rem.path));
               }

              
              if(rem.j>=arr[rem.i-1]){

                 int includeContribution = dp[rem.i-1][rem.j-arr[rem.i-1]];

                 if(includeContribution==1){

                        q.add(new Pair(rem.i-1,rem.j-arr[rem.i-1],(rem.i-1)+" "+rem.path));
                 }


              }
           }
            
        }
        
        
        
    }

}





                        


                        
