public class SquareOfSortedArr {
    public static void main(String[] args) {
        int []arr = {-4,-1,0,3,10};
        displayArray(squaredSortedArr(arr));
    }
    public static int[] squaredSortedArr(int []arr){
        int []results = new int[arr.length];
        int counter = arr.length-1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            if(arr[start]*arr[start]>=arr[end]*arr[end]){
                results[counter] = arr[start]*arr[start];
                start++;
            }else if(arr[start]*arr[start]<=arr[end]*arr[end]){
                results[counter] = arr[end]*arr[end];
                end--;
            }
            counter--;
        }
        return results;
    }
    public static void displayArray(int []arr){
        for(int val:arr){
            System.out.print(val + " ");
        }
    }

}
/*

1- How to solve it?

    - Follow the two pointer approach.
    - Put one pointer at the start and one at the end.
    - Compare elements at both pointers and if element starting at the 0th pointer is greater than the element at the arr.length's pointer, insert it at that spot.
    - Make a counter to then insert elements in the results array. The reason we would want to set it to array.length is because we want to keep the bigger number at the very end.
    - Start filling the array in a reverse order rather than filling it from the beginning.
    - Time complexity is 0^n where n is the length of array. It's the most optimal approach.
 */
