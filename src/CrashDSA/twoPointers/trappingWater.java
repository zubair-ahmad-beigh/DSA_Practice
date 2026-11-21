package CrashDSA.twoPointers;

public class trappingWater {
    public static int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int water = Math.min(
                    leftMax,
                    rightMax
            ) - height[i];
            totalWater += water;
        }
        return totalWater;
    }
    public static int trapBetter(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(
                    leftMax[i - 1],
                    height[i]
            );
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(
                    rightMax[i + 1],
                    height[i]
            );
        }
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(
                    leftMax[i],
                    rightMax[i]
            ) - height[i];
            totalWater += water;
        }
        return totalWater;
    }
    public static int trapOptimal(int []height){
        int left=0;
        int right= height.length-1;
        int leftMax=0;
        int rightMax=0;
        int totalWater=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    totalWater+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    totalWater+=rightMax-height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    static void main(String[] args) {
        int []height={4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
        System.out.println(trapBetter(height));
        System.out.println(trapOptimal(height));

    }
}
