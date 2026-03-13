public class RearrangeBySign {
    static int[] rearrange(int[] arr){
        int n= arr.length;
        int[] result=new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int num:arr){
            if(num>0){
                result[posIndex]=num;
                posIndex+=2;
            }else{
                result[negIndex]=num;
                negIndex+=2;
            }
        }
        return result;
    }

    static void main(String[] args) {
        int []arr={3,1,-2,-5,2,-4};
        int []result=rearrange(arr);
        for(int num:result){
            System.out.println(num+" ");
        }
    }
}
