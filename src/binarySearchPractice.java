public class binarySearchPractice {
    public static void main(String[] args) {
        int []arr = {8,15,23,66,752,81};
        int []arr1 = {-17,-15,-6,-3,-1,0,5,7,9,11,14};
       // System.out.println(binarySearch(arr, 23));
       // displayArray(squaredSortedArray(arr1));
    }
    public static int binarySearch(int []arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void displayArray(int []arr){
        for(int val:arr){
            System.out.print(val + " ");
        }
    }


}
