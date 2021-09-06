import java.util.ArrayList;

public class SlidingWindowPattern {
    public static void main(String[] args) {
            int []arr = {2,-4,1,6,-3,-6,8,-5,2,5,0,-3,2,6};
           // System.out.println(firstNegInSubArr(arr, 3));
    }
    /*
    1- SubArray must be continuous
    2- Either window size will be given and you will be expected to get the maximum or minimum sum.
    3- Either maximum sum will be given and you will be expected to get the window size.
    4- If you see subarray/window/sum anywhere in questions, try sliding window.
    5- Fix window size questions are comparetively easier than variable window size questions.
     */

    /*

    Q--> Largest sum of a subarray with window size K
            1- Trick to start the both pointers at 0th index;
            2- Start moving j until we reach the size of window.
            3- Keep track of the sum and update it in every iteration.
            4- Important(Once everything is done, maintain the window.)
     */
    public static int maxSubArr(int[]arr, int ws){
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        while(j<arr.length){
            sum+=arr[j];
            if((j-i)+1<ws){
                j++;
            }else if((j-i)+1==ws){
                max = Integer.max(max, sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return max;

    }

    /*

    1- loop the array and check elements < 0 and store them in a list.
    2- once the j-i+1 hits the window size, check whether the array is empty or not.
    3- if empty add 0 else take the first element out.
    4- lastly, we have to slide the window and for that, we check whether arr[i] equals our resultsArray[0]. If true, we pop that element in our result and move the array.

     */
    public static ArrayList<Integer> firstNegInSubArr(int []arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> resultsList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(j<arr.length){
            if(arr[j]<0) {
                list.add(arr[j]);
            }
            if((j-i)+1<k){
                j++;
            }
            else if((j-i)+1==k){
                if(list.size()==0) list.add(0);
            }else{
                list.get(0);
            }
           if(arr[i]==list.get(0)){
               list.remove(0);
           }
           i++;
           j++;
        }
        return list;
    }

}
