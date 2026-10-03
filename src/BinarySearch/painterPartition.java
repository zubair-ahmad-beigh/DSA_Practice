package BinarySearch;

public class painterPartition {
    public static boolean canPaint(int[] boards,int k,int maxWork){
        int painters=1;
        int currentWork=0;
        for(int board:boards) {
            if (currentWork + board <= maxWork) {
                currentWork += board;
            } else {
                painters++;
                currentWork = board;
            }
            if (painters > k) {
                return false;
            }
        }
        return true;
    }
    public static int painterPartitionOptimal(int []boards,int k){
        int low=0;
        int high=0;
        for(int board:boards){
            low=Math.max(low,board);
            high+=board;
        }
        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPaint(boards,k,mid)){
                answer=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return answer;
    }

    static void main(String[] args) {
        int []boards={10,20,30,40};
        int k=2;
        System.out.println("Optimal: "+painterPartitionOptimal(boards,k));
    }
}
