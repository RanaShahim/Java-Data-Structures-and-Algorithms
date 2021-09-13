import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeArrayPractice {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoonblloon"));
        int []arr1 = {3,8,2,5,6,9,1,6};
       // System.out.println(Arrays.toString(twoSum(arr1, 7)));
        Arrays.sort(arr1);
        displayArr(arr1);
    }
    public static void displayArr(int[]arr){
        for(int a:arr){
            System.out.print(a);
        }
    }
    /*

    1- Trick is to get the frequency of all letters and get the minimum of the traversed array.

     */
    public static int maxNumberOfBalloons(String text) {
        if(text.length()<7) return 0;

        int [] textFreq = new int[26];

        for(char ch:text.toCharArray()){
            textFreq[ch - 'a']++;
        }
        int min = textFreq[1]; //b
        min = Math.min(min,textFreq[0]);//a
        min = Math.min(min,textFreq[11]/2); //l
        min = Math.min(min,textFreq[14]/2); //o
        min = Math.min(min,textFreq[13]); //n

        return min;



    }
//    public static int [] twoSum(int []arr, int target){
//        int left = 0;
//        int right = arr.length-1;
//        ArrayList<Integer>results = new ArrayList<>();
//        Arrays.sort(arr);
//        int counter = 0;
//
//        while(left<right){
//            if(arr[left]+arr[right]>target){
//                right--;
//            }else if(arr[left]+arr[right]<target){
//                left++;
//            }else{
//                results.add(left,right);
//                left++;
//                right--;
//            }
//        }
//        //int []ans = results.toArray(new int[results.size()]);
//
//    }
}
