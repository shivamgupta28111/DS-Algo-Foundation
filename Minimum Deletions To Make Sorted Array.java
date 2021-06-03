import java.util.Scanner;

public class Main{
    public static int longestIncreasingSubsequence(int []arr){
        int []dp = new int[arr.length];
        dp[0] = 1;

        int LISans = 0;
        for(int i = 1 ; i < arr.length;i++){
            int tmp = 0;
            for(int j = i-1 ; j>=0 ;j--){
                if(arr[j] < arr[i]){
                    tmp = Math.max(tmp,dp[j]);
                }
            }
            dp[i] = tmp + 1;
            if(dp[i] > LISans) LISans = dp[i];
        }

        return LISans;
    }
    public static int longestDecreasingSubsequence(int []arr){
        int []dp = new int[arr.length];
        dp[0] = 1;

        int LDSans = 0;
        for(int i = 1 ; i < arr.length;i++){
            int tmp = 0;
            for(int j = i-1 ; j>=0 ;j--){
                if(arr[j] > arr[i]){
                    tmp = Math.max(tmp,dp[j]);
                }
            }
            dp[i] = tmp + 1;
            if(dp[i] > LDSans) LDSans = dp[i];
        }

        return LDSans;
    }
    public static int minimumDeletionsToSorted(int []arr){
        // 1. LIS
        int sizeLIS = longestIncreasingSubsequence(arr);
        // 2. LDS
        int sizeLDS = longestDecreasingSubsequence(arr);

        // 2. calc minimum deletions
        return arr.length - Math.max(sizeLIS,sizeLDS);
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i = 0 ;i < n;i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(minimumDeletionsToSorted(arr));
    }
}
