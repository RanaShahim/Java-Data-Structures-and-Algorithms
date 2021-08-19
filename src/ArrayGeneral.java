import java.io.*;
import java.util.Scanner;

public class ArrayGeneral {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //Specifying an arr

        int []arr = null;

        //Allocating the space

        arr = new int[6];
        System.out.println(arr);
        arr[1] = 10;
        arr[2] = 20;
        arr[3] = 30;
        arr[4] = 40;
        arr[5] = 50;

//        int i = 2;
//        int j = 3;

        //get the values

        System.out.println(arr[0]);//Returns 0 since array initially have a value of 0 set

        //Enhanced For loop
        //Using this loop, you cant making any changes in the existing array. Its read only
        for(int val:arr){
            System.out.println(val);
        }

//        System.out.println(arr[i] + ", " + arr[j]);
//        swap(arr, i, j);

        //Taking input from the user

        int [] usersArr = new int [5];

        for(int i = 0;i<usersArr.length;i++){
            usersArr[i] = kb.nextInt();
        }
        for(int val:usersArr){
            System.out.println(val);
        }
        //Find the maximum number in arr:
        findMaxInArr(usersArr);
    }






    public static void swap(int []arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
        System.out.println(arr[n1] + ", " + arr[n2]);
    }
    public static void findMaxInArr(int []arr){
        int max = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max) max = arr[i];
        }
        System.out.println("Maximum number is " + max);
    }


}
