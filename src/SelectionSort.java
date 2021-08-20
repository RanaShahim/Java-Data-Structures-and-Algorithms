public class SelectionSort {
    public static void main(String[] args) {
        int []myArr = {34,11,6,65,4,12,38,5};
        displayArray(selectionArr(myArr));
    }
    //The concept is to find the minimum element in the array and putting it at the beginning.
    public static int [] selectionArr(int[]arr){

        int counter = 0;

        while (counter<arr.length-1){
            int min = counter;
            for(int i = counter+1;i<=arr.length-1;i++){
                if(arr[i]<arr[min]) {
                    min = i;
                }
               int temp = arr[min];
                arr[min] = arr[counter];
                arr[counter] = temp;

            }
            counter++;
        }
        return arr;
    }
    public static void displayArray(int []arr){
        for(int val:arr){
            System.out.print(val + " ");
        }
    }
}
