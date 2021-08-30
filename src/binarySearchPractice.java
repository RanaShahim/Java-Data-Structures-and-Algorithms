public class binarySearchPractice {
    public static void main(String[] args) {
        int []arr = {8,15,23,66,752,81};
        int []arr1 = {-17,-15,-6,-3,-1,0,5,7,9,11,14};
        int []arr2 = {2,3,5,9,14,16,18,24,26,29};
        int []arr3 = {5,7,7,7,8,7,10};
        displayArray(firstAndLastPosition(arr3, 7));
        char []ch = {'c', 'f', 'j'};

        System.out.println(ceilingOfANumber(arr2, 4));
        System.out.println(ceilingOfaChar(ch,'a'));
        displayArray(firstAndLastPosition(arr3, 7));
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



    /*

    Find the ceiling of a number in an array
    Ceiling is the smallest element in the array >= target.

    How to solve it? :

    check when exactly the loop condition breaks?
    Its when start>=end !!
    so if the scenario is like:

     end    mid    start

    and the while loop has ended so obviously the the answer would either be mid(In case we found our target)
    or start(In case we didn't find what we wanted) because start is now at ((mid + 1));

    The trick lies behind loop immidietly when loop is violated.
     */


    public static int ceilingOfANumber(int []arr, int target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;

        //Edge Case, In case target number is the larget number.
        if(target>arr[arr.length-1]){
            return -1;
        }
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]<target){
                start = mid+1;
            }else if(arr[mid]>target){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return arr[start];
    }

    /*

    Q : Return smallest character that is largest than the target
        1- Same logic as Binary Search.
        2- The arr[start%arr.length] thing gives us the
     */
    public static char ceilingOfaChar(char []arr, char target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;

        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return arr[start%arr.length];
    }






    /*

     1- Apply binary search and get the potentiol answer.
     2- Once we've the potential answer, apply binary search again and check on the left/whether first occurence is needed(do start = mid+1 for that)
     3- For last occurence do (end = mid-1) since we're checking on the right.

     */



    public static int[] firstAndLastPosition(int[]arr, int target){

        int [] answersArr = {-1,-1};
        int firstEl = search(arr, target, true);
        int secondEl = search(arr,target,false);
        answersArr[0] = firstEl;
        answersArr[1] = secondEl;

        return answersArr;
    }
    static int search(int []arr, int target, boolean isFirstOccurence){
        int result = 0;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target>arr[mid]){
                start = mid+1;
            }else if(target<arr[mid]){
                end = mid-1;
            }else{
                result = mid;
                if(isFirstOccurence){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return result;
    }

    /*

    Question : Get Position of an element in an infinite sortedArray!

    Sol : 1- Try to move in chunks since we don't know the length of the array
          2- Check chunk by chunk in your array until you find the answer


     */

//    public static int infiniteSortedArray(int []arr){
//
//        int start = 0
//    }

    public static void displayArray(int []arr){
        for(int val:arr){
            System.out.print(val + " ");
        }
    }


}
