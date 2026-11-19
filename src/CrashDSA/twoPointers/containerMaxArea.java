package CrashDSA.twoPointers;

public class containerMaxArea {
    public static int maxArea(int[] height){
        int maxWater=0;
        for(int i=0;i< height.length;i++){
            for(int j=i+1;j< height.length;j++){
                int width=j-i;
                int h=Math.min(height[i],height[j]);
                int area=width*h;
                maxWater=Math.max(maxWater,area);
            }
        }
        return maxWater;
    }
    public static int maxAreaOptimal(int []height){
        int left=0;
        int right=height.length-1;
        int maxWater=0;
        while(left<right){
            int width=right-left;
            int h=Math.min(height[left],height[right]);
            int area=width*h;
            maxWater=Math.max(maxWater,area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }

    static void main(String[] args) {
        int []height={1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaOptimal(height));

    }
}
