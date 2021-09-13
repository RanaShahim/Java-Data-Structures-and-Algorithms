import java.util.ArrayList;
import java.util.List;

public class SlidingWindowPattern {
    public static void main(String[] args) {
            int []arr = {2,-4,1,6,-3,-6,8,-5,2,5,0,-3,2,6};
           // System.out.println(firstNegInSubArr(arr, 3));
           String str1 = "aabaabaa";
           String str2 = "aabae";

           int [] charArr = new int[26];
           for(char c : str2.toCharArray()){
               charArr[c-'a']++;
           }
           displayArr(charArr);
    }
    public static void displayArr(int[]arr){
        for(int a:arr){
            System.out.println(a);
        }
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

    /*

    1- Use an array to get the frequency of smaller string!
    2- increment j to the size of the window which will be the length of the array
    3- decrement the count variable which is also the length of the second string. If that length = 0, means that we have found our anagram.

     */
    public static ArrayList<Integer> isAnnagram(String str1, String str2){
        ArrayList<Integer> result = new ArrayList<>();
        int []freqCount = new int[26];
        int windowSize = str2.length();
        for(char c:str2.toCharArray()){
            freqCount[c-'a']++;
        }
        int i = 0;
        int j = 0;
        int count = str2.length();

        while(j<str1.length()){
            //Here we check whether str1's character is = to str2 or not.
            if(freqCount[str1.charAt(j)-'a']>1){
                count--;
            }
            //Once we have checked our specific character from the charList, we will decrement it and move the j forwards
            freqCount[str1.charAt(j)-'a']--;
            j++;
            if(count==0) result.add(i); //Here we add the first character of our anagram which is still at i when the count is at 0.

            //This is the now sliding case of the window. Once our count is 0, we've to increment back the characters in our freqArray that were decremented in the first phase.
            //


            if(j==windowSize){
                if(freqCount[str1.charAt(i)-'a']>1){
                    count++;
                }
                freqCount[str1.charAt(i)-'a']++;
                i++;
            }

        }

        return result;

    }

}
