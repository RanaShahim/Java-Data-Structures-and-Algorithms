import java.util.ArrayList;
import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
       // int [][]arr = new int[4][4];
        int [][]wavePrintArr = {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
        System.out.println(findPrimes(10,20));

       // displayArr(userInput(arr));
        wavePrint(wavePrintArr);
        System.out.println("--------------------------------------");
        //Defining an ArrayList:

        ArrayList<Integer> arrList = new ArrayList<>();

        //To add an element :
        //arrList.add(10);
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
    public static ArrayList<Integer> findPrimes(int start, int end) {

        ArrayList<Integer> primes = new ArrayList<Integer>();

        for(int n = start; n < end; n++) {
            boolean prime = true;

            int i = 2;
            while(i <= n/2) {
                if(n % i == 0) {
                    prime = false;
                    break;
                }
                i++;
            }

            if(prime) {
                primes.add(n);
            }
        }

        return primes;
    }

}
