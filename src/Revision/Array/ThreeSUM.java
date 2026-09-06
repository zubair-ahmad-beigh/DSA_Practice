package Revision.Array;

import java.util.*;

public class ThreeSUM {
    static List<List<Integer>> SumThree(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {

                        List<Integer> triplet = Arrays.asList(
                                arr[i], arr[j], arr[k]
                        );

                        Collections.sort(triplet);

                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        return result;
    }
    static List<List<Integer>>TThreeSum(int []arr){
        Set<List<Integer>>result=new HashSet<>();
        int n= arr.length;
        for (int i=0;i<n;i++){
            HashSet<Integer>set=new HashSet<>();
            for (int j = i+1; j <n ; j++) {
                int required=-(arr[i]+arr[j]);
                if(set.contains(required)){
                    List<Integer>triplet=Arrays.asList(arr[i],arr[j],required);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                set.add(arr[j]);

            }
        }
        return new ArrayList<>(result);
    }
    static List<List<Integer>>threeSSUM(int []arr){
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
                    while(left<right && arr[right]==arr[right+1]){
                        right--;
                    }
                } else if (sum<0) {
                    left++;
                    
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    static void main(String[] args) {
        int []arr={-1, 0, 1, 2, -1, -4};
        System.out.println(SumThree(arr));
        System.out.println(TThreeSum(arr));
        System.out.println(threeSSUM(arr));

    }
}
