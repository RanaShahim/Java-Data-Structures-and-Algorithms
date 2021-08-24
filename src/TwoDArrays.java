import java.util.ArrayList;
import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
       // int [][]arr = new int[4][4];
        int [][]wavePrintArr = {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};

       // displayArr(userInput(arr));
        wavePrint(wavePrintArr);
        System.out.println("--------------------------------------");
        //Defining an ArrayList:

        ArrayList<Integer> arrList = new ArrayList<>();

        //To add an element :
        arrList.add(10);
        //To check the size;
        arrList.size();

        String abc = "Shahim";
        System.out.println(revStr(abc));
    }
    public static void displayArr(int [][]arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static int [][] userInput(int [][]arr){
        Scanner kb = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j]= kb.nextInt();
            }
        }
        return arr;
    }
    public static void wavePrint(int [][]arr){
        for(int i = 0;i<arr.length;i++){
            if(i%2==0){
                for(int j = 0;j<arr[i].length;j++){
                    System.out.print(arr[i][j] + " ");
                }
            }
            if(i%2==1){
                for(int j = arr[i].length-1;j>=0;j--){
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println(" ");
        }

    }
    public static String revStr(String str){
        String s = "";
        for(int i = str.length()-1;i>=0;i--){
            s+=str.charAt(i);
        }
        return s;
    }

}
