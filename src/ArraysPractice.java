import java.util.ArrayList;
import java.util.Locale;

public class ArraysPractice {
    public static void main(String[] args) {
        int [] arr = {23,44,1,4,5,4};
        displayArr(reverseArr(arr));

    }
    public static /*ArrayList<Integer>*/ int [] reverseArr(int [] arr){
//        ArrayList<Integer> rev = new ArrayList<Integer>();
//        for(int i = arr.length-1;i>=0;i--){
//            rev.add(arr[i]);
//        }
//        return rev;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    public static void displayArr(int []arr){
        for(int el:arr){
            System.out.print(el + " ");
        }
    }

}
