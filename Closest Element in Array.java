/*Find closest Element in an array Using Binary Search , For Binary search approach array should always be sorted */

import java.io.*;
public static int BinarySearchClosestElemeny(int [] arr,int data)   //closest element  
{ 
  int li=0;
  int ri=arr.length-1;

  if(arr[ri]<data) 
  return ri;

  if(data<arr[li]) //to check if the no is  in range 
  return li;

 
  while(li<=ri)
  {
      int mid = (li+ri)/2;

      if(arr[mid]==data)
      return mid;

      else if(arr[mid]<data)
      li=mid+1;
      
      else ri=mid-1;
   }

   return (data-arr[ri]<=arr[li]-data?arr[ri]:arr[li]);   // it is returning closest elements index 


}
}
