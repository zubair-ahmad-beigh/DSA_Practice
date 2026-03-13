import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    static List<Integer>majorityElement(int []arr){
        int count1=0,count2=0;
        int candidate1=0,candidate2=0;
        for(int num:arr){
            if(num==candidate1){
                count1++;
            }
            else if(num==candidate2){
                count2++;
            } else if (count1==0) {
                candidate1=num;
                count1=1;
            } else if (count2==0) {
                candidate2=num;
                count2=1;
                
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:arr){
            if(num==candidate1)count1++;
            else if (num==candidate2)count2++;
            }
        List<Integer>result=new ArrayList<>();
        if(count1> arr.length/3)
            result.add(candidate1);
        if (count2> arr.length/3)
            result.add(candidate2);
        return result;
        }

    static void main(String[] args) {
        int []arr={1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(arr));

    }
}

