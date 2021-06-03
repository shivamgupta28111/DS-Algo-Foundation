//   Basic BFS on Graph nodes 

//Input
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2

// Sample Output
// 2@2
// 1@21
// 3@23
// 0@210
// 4@234
// 5@2345
// 6@2346

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      ArrayDeque<Pair> queue =new ArrayDeque<>();
      queue.add(new pair(src,src+""));
      boolean[] visited = new boolean[vtces];
      
      while(queue.size()!=0)
      {
          Pair rem = queue.remove();   //rem
          
          
           System.out.println(rem.v + "@" + rem.psf); //print
              
              
             visited[rem.vertex]=true;                
          
          
          for(Edge e:graph[src])    // graph nbrs loop put in queue
          {
              if(visited[e.nbr]!=true){
                  queue.add(new Pair(e.nbr,rem.psf+e.nbr));
              }
          }
      }
      
      
      
   }
   
   static class Pair{
       int vertex;
       String psf;
       
       Pair(vertex,psf){
           this.vertex=vertex;
           
           this.psf=psf;
       }
       
   }
}
