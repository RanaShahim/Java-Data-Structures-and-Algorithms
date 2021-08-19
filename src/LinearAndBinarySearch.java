public class LinearAndBinarySearch {
    public static void main(String[] args) {
        int []arr = {20,54,55,66,77,89,90,101,116,119,220,229,271,281,290};
        System.out.println(linearSearch(arr, 23));
        System.out.println(binarySearch(arr, 220));
    }
    public static int linearSearch(int []arr, int target){
        for(int i = 0;i<arr.length;i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    //To implement a binary search, all the elements are supposed to be sorted. (Increasing or decreasing)

    /*

    - Why is Binary Search better than linear search:

    1- Linear search has 0n time complexity since it checks every single element of the array while Binary Search only checks half of the array depending on the target.
    2- Binary Search has a time complexity of logN;

     */

    public static int binarySearch(int []arr, int target) {
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        while (lowerBound <= upperBound) {
            int midOfTheArr = (lowerBound + upperBound) / 2;
            if (arr[midOfTheArr] < target) {
                lowerBound = midOfTheArr + 1;
            } else if (arr[midOfTheArr] > target) {
                upperBound = midOfTheArr - 1;
            } else {
                return midOfTheArr;
            }
        }
        return -1;
    }
}
