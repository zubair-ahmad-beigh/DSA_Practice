package BinarySearch;

import java.util.PriorityQueue;

public class Minimise_max_Distance {
    public static double minimiseMaxDistance(int []stations,int k){
        int n=stations.length;
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int  i=0;i<n-1;i++){
            double gap=stations[i+1]-stations[i];
            pq.offer(new double[]{gap,1});
        }
        for(int i=0;i<k;i++){
            double []current=pq.poll();
            double gap=current[0];
            double parts=current[1];
            parts++;
            double newGap=(stations[0]+0.0);
        }
        return pq.peek()[0];
    }
    public static boolean canPlace(int []stations,int k,double distance){
        int required=0;
        for(int i=0; i<stations.length-1;i++){
            double gap=stations[i+1]-stations[i];
            required+=(int)Math.ceil(gap/distance)-1;
            if(required>k){
                return false;
            }
        }
        return true;
    }
    public static double miniMaxDistance(int []stations,int k){
        double low=0;
        double high=0;
        for(int i=0;i<stations.length-1;i++){
            high=Math.max(high,stations[i+1]-stations[i]);
        }
        while(high-low>1e-6){
            double mid=low+(high-low)/2;
            if(canPlace(stations,k,mid)){
                high=mid;
            }else{
                low=mid;
            }
        }
        return high;
    }

    static void main(String[] args) {
        int []stations={1,7,15,20};
        int k=3;
        double answer=miniMaxDistance(stations,k);
        System.out.printf("%.6f",answer);
    }

}
