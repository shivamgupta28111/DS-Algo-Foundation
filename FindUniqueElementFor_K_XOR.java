// [8 7 9 8 9 7 1 2 8 7 2 9] ----> 1 is unique for k=3times each no. other than 1 all no.s are repeating 


import java.util.Scanner;
public class FindUniqueForK
{

public static void main(String[] args)
{

  int[] arr={5,2,8,7,14,10,7,5,8,10,7,2,10,8,2,5};
  uniqueForK(arr,3);



}


public static void uniqueForK(int[] arr,int k){
    int[] bits=new int[32];

    for(int ele:arr){ // for each loop

         for(int i=0;i<32;i++){
             int mask=(1<<i);
             if((ele&mask)!=0){
                bits[i]+=1;
             }
         }
    }
    
    // for(int ele: bits){
    //   System.out.print(ele + " ");
    

    int ans=0;
    for(int i=0;i<32;i++){
      if(bits[i] % k != 0){
        ans |= (1<<i);
      }
    }

    System.out.println(ans);

}




}
