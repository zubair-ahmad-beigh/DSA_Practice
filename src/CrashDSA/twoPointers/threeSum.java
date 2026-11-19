package CrashDSA.twoPointers;

import java.util.*;

public class threeSum {
    public static List<List<Integer>>threeSum(int []arr){
        Set<List<Integer>>set=new HashSet<>();
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer>temp= Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static List<List<Integer>>threeSumBetter(int []arr){
        Set<List<Integer>>answer=new HashSet<>();
        for(int i=0;i< arr.length;i++){
            Set<Integer>seen=new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                int required=-(arr[i]+arr[j]);
                if(seen.contains(required)){
                    List<Integer>temp=Arrays.asList(arr[i],arr[j],required);
                    Collections.sort(temp);
                    answer.add(temp);
                }
                seen.add(arr[j]);
            }
        }
        return new ArrayList<>(answer);
    }
    public static List<List<Integer>> threeSumOptimal(int []arr){
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(arr);
        int n= arr.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0){
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[left]==arr[left-1]){
                        left++;
                    }
                    while(left < right && arr[right] == arr[right + 1]){
                        right--;

                 
                    }
                } else if (sum<0) {
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }

    static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
        System.out.println(threeSumBetter(arr));
        System.out.println(threeSumOptimal(arr));
    }
}
