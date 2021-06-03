// ZOHO Interview Question

class Solution
{
    ArrayList<Long> alternateSort(long arr[] ,int N)
    {
        
        // Your code goes here
        
       ArrayList<Long> result=new ArrayList<Long>();
        Arrays.sort(arr);
        j=N-1
        for(int i=0;i<=j;i++)
        {
           
           result.add(arr[j]);
           result.add(arr[i]);
          j--;
        }
        return result;
        
    }
}
