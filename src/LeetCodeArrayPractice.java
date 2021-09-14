import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeArrayPractice {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoonblloon"));
        int []arr1 = {2,3,7,6,10,8,4};
       System.out.println(Arrays.toString(twoSum(arr1, 7)));
        calcDays(200);
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
    public static int [] twoSum(int []arr, int target){

        HashMap<Integer, Integer> visitedNums = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int delta = target - arr[i];
            if(visitedNums.containsKey(delta)){
                return new int[]{visitedNums.get(delta),i};
            }
            visitedNums.put(arr[i], i);
        }
        return new int []{-1,-1};
    }
    public static void calcDays(int daysToConvert){
        int year,month,week,day;
        if(daysToConvert<365){
          year = 0;
        }else{
          year = daysToConvert/365;
          daysToConvert-=365;
        }
        month = daysToConvert/30;
        daysToConvert -= month*30;
        week = daysToConvert/7;
        daysToConvert-=week*7;
        day = daysToConvert;

        System.out.println(year + " years " + month + " months " + week + " weeks " + day + " days ");
    }
}
