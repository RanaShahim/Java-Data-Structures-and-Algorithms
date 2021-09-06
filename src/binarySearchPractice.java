public class binarySearchPractice {
    public static void main(String[] args) {
        int []arr = {8,15,23,66,752,21};
        int []arr1 = {-17,-15,-6,-3,-1,0,5,7,9,11,14};
        int []arr2 = {2,3,5,9,14,16,23,13,10,0,3};
        int []arr3 = {5,7,7,7,8,7,10};
        int []arr4 = {1,2,3,2,1};
        displayArray(firstAndLastPosition(arr3, 7));
        char []ch = {'c', 'f', 'j'};

        System.out.println(ceilingOfANumber(arr2, 4));
        System.out.println(ceilingOfaChar(ch,'a'));
        displayArray(firstAndLastPosition(arr3, 7));
       // System.out.println(binarySearch(arr, 23));
       // displayArray(squaredSortedArray(arr1));
        System.out.println(" ");
        //System.out.println(infiniteSortedArray(arr2, 5));
        System.out.println(peakOfTheMountain(arr4));
        System.out.println(" ");
        System.out.println(findMax(arr2));
    }
    public static int binarySearch(int []arr, int target, int start, int end){

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
          3- Start with a box and size two and keep increasing it exponentionally.
          4- Apply simple binary search

     */

    public static int infiniteSortedArray(int []arr, int target, int start, int end){


        int result = 0;
        while(start<=end){

            int mid = (start + end) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else{
                result = mid;
                break;
            }
        }
        return result;
    }
    static int findingRangeForInfiniteArr(int []arr, int target){
        int start = 0;
        int end = 1;
        while(target>arr[end]){
            int newStart = end+1;
            end += (end-start+1)*2;
            start = newStart;
        }
        return infiniteSortedArray(arr,target,start,end);
    }

    /*

    Q : Peak Index In a mountain array:

    1- A mountain array is one which first increases and then decreases.
    2- The most optimised approach is being implemented here

     */

    public static int peakOfTheMountain(int []arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid]<arr[mid+1]){
                //This condition states that the array is in decreasing order, since the element at mid index < mid+1
                //This may be the answer but look at the left thats why end != mid-1
                start = mid+1;;
            }else{
                //This conditon states that array is in increasing order
                 // We know mid+1 element is greater than
                end = mid;
            }
        }
        return start; //or end since they're equal and we will
    }

    /*

    1- Find the peak element
    2- Search in the first half and if now found, search in the second half.

     */
    public static int smallestIndexInMountainArray(int []arr){

        //This code will find the peak.
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = (start+end)/2;

            if(arr[mid]<arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int solToAboveQuestion(int []arr, int target){
        boolean isFound = false;
        int peak = smallestIndexInMountainArray(arr);
        //Instead of applying simple binary search here, order agnostic binary search should've been implemented.
        int element = binarySearch(arr,target,0,peak);
        if(element != -1){
            return element;
        }else{
            return binarySearch(arr,target,peak+1,arr.length-1);
        }
    }
    /*

    Question : Search in a rotated array:

        1- Find the pivot in the array.
        2- The property of a pivot is that it has a sorted array on its left and tight side. e.g : [2,6,8,10,3,4,6]=> 10 is the pivot
        3- Pivot is the maximum number in the array around which the array is distributed.
        4- Once pivot is found, check the left side of the array and if element is not found, check the right side.

        Finding the pivot with binary search

        1- Incase our mid value is lesser than the start value, it means that we dont have to look into the right side of the pivot
        2- Otherwise if start is lesser than pivot, we have to look into the left side of the pivot.

     */
        public static int searchInRotatedArray(int []arr, int target){
            int max = findMax(arr);
            int element = binarySearch(arr,target,0,max);
            if(element != -1){
                return element;
            }else{
                return binarySearch(arr, target,max+1,arr.length-1);
            }
        }


    public static int findMax(int []arr){
        int max = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        return max ;
    }

    public static void displayArray(int []arr){
        for(int val:arr){
            System.out.print(val + " ");
        }
    }


}
