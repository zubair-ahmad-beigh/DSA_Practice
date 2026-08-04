package Revision.Array;

import java.util.HashMap;

public class OnesTwice {
    public static int OnesTw(int[]arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }
        return -1;
    }
    public static int SingleNumber(int []arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:arr){
            if(map.get(num)==1){
                return num;
            }
        }
        return -1;
    }
    public static int SingleXor(int[]arr){
        int xor=0;
        for(int num:arr){
            xor^=num;

        }
        return xor;
    }

    static void main(String[] args) {
        int []arr={1,1,2,3,2};
        System.out.println(OnesTw(arr));
        System.out.println(SingleNumber(arr));
        System.out.println(SingleXor(arr));
    }
}
