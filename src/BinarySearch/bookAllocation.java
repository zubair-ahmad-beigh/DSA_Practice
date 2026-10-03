package BinarySearch;

public class bookAllocation {
    public static int allocateBooksBruteForce(int[] pages,int students){
        if(pages==null || pages.length==0|| students>pages.length){
            return -1;
        }
        int low=0;
        int high=0;
        for(int pagesCount:pages){
            low=Math.max(low,pagesCount);
            high+=pagesCount;
        }
        for(int limit=low;limit<=high;limit++){
            if(canAllocate(pages,students,limit)){
                return limit;
            }
        }
        return -1;
    }
    private static boolean canAllocate(int[]pages,int students,int limit){
        int studentsNeeded=1;
        int currentPages=0;
        for(int pagesCount:pages){
            if(currentPages+pagesCount>limit){
                studentsNeeded++;
                currentPages=pagesCount;
                if(studentsNeeded>students){
                    return false;
                }
            }else{
                currentPages+=pagesCount;
            }
        }
        return true;

    }
    public static int allocateBooksBinarySearch(int[] pages,int students){
        if(pages==null||pages.length==0||students> pages.length){
            return -1;
        }
        int low=0;
        int high=0;
        for(int pageCount:pages){
            low=Math.max(low,pageCount);
            high+=pageCount;
        }
        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAllocate(pages,students,mid)){
                answer=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return answer;
    }
    private static boolean canAllocatee(int []pages,int students,int limit){
        int studentsNeeded=1;
        int currentPages=0;
        for(int pageCount:pages ){
            if(currentPages+pageCount>limit){
                studentsNeeded++;
                currentPages=pageCount;
                if(studentsNeeded>students){
                    return false;
                }
            }else{
                currentPages+=pageCount;
            }
        } 
        return true;
    }

    static void main(String[] args) {
        int []pages={12,34,67,90};
        int students=2;
        System.out.println(allocateBooksBruteForce(pages,students));
        System.out.println(allocateBooksBinarySearch(pages,students));
    }
}
