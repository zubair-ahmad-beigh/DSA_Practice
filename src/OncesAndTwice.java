public class OncesAndTwice {
    static void main(String[] args) {
        int xor=0;
        int arr[]={1,1,0,2,2};
        int n=arr.length;
        for(int i=0;i<n;i++){
            xor=xor^arr[i];
            System.out.println(xor+" ");

        }
    }
}
