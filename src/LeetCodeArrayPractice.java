import java.util.*;

public class LeetCodeArrayPractice {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoonblloon"));
        int[] arr1 = {2, 3, 7, 6, 10, 8, 4};
        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int []arr3 = {9,9,9,9};
        displayArr(plusOne(arr3));
        System.out.println(Arrays.toString(twoSum(arr1, 7)));
        calcDays(200);
        System.out.println(removeDupsFromSortedArray(arr2));

        String st = "a-bC-dEf-ghIj";
        System.out.println(revLettersOnly(st));


    }

    public static void displayArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    /*

    1- Trick is to get the frequency of all letters and get the minimum of the traversed array.

     */
    public static int maxNumberOfBalloons(String text) {
        if (text.length() < 7) return 0;

        int[] textFreq = new int[26];

        for (char ch : text.toCharArray()) {
            textFreq[ch - 'a']++;
        }
        int min = textFreq[1]; //b
        min = Math.min(min, textFreq[0]);//a
        min = Math.min(min, textFreq[11] / 2); //l
        min = Math.min(min, textFreq[14] / 2); //o
        min = Math.min(min, textFreq[13]); //n

        return min;


    }

    public static int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> visitedNums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int delta = target - arr[i];
            if (visitedNums.containsKey(delta)) {
                return new int[]{visitedNums.get(delta), i};
            }
            visitedNums.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void calcDays(int daysToConvert) {
        int year, month, week, day;
        if (daysToConvert < 365) {
            year = 0;
        } else {
            year = daysToConvert / 365;
            daysToConvert -= 365;
        }
        month = daysToConvert / 30;
        daysToConvert -= month * 30;
        week = daysToConvert / 7;
        daysToConvert -= week * 7;
        day = daysToConvert;

        System.out.println(year + " years " + month + " months " + week + " weeks " + day + " days ");
    }

    /*

    1- You cant make a new array so we can update the original array by update the values using a new variable.

     */


    public static int removeDupsFromSortedArray(int[] arr) {

        int index = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[index] = arr[i + 1];
                index++;
            }
        }
        return index;
    }

    /*

    1- Simple idea, swap the elements starting from pos 1 and ending at pos .lenght();
    2- Ignore other letters

     */

    public static String revLettersOnly(String str) {
        int i = 0;
        int j = str.length() - 1;
        char ch[] = str.toCharArray();
        while (i < j) {
           while(i<j && !Character.isLetter(str.charAt(i))){
               i++;
           }
           while(j>i&&!Character.isLetter(str.charAt(j))){
               j--;
           }
           char temp = ch[i];
           ch[i] = ch[j];
           ch[j] = temp;
           i++;
           j--;
        }
        return new String(ch);
    }

    /*

    1- The only edge case here is if the last number is 9, we gotta increase the size of array and

     */


    public static int [] plusOne(int []arr){
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]<9){
                arr[i]++;
                //Immidietly returning the array here instead of looping through it all.
                return arr;
            }
            //Here's the main trick, if number is greater than equal to 9, make it 0 else increment one and return the array.
            arr[i] = 0;
        }
        int []newNum = new int[arr.length+1];
        newNum[0] = 1;
        return newNum;
    }
}
