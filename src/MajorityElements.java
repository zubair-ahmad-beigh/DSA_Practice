public class MajorityElements {
    static int findMajority(int[] arr){
        int candidate=0;
        int count=0;
        for(int num:arr){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }

    static void main(String[] args) {
        int[]arr={2,2,1,1,2,2,2};
        int result=findMajority(arr);
        System.out.println("Majority Elements: "+result);
    }
}
