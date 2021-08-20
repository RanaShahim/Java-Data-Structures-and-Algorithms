public class BubbleSort {
    public static void main(String[] args) {
        int []myArr = {23,44,11,7,19,59,43};
        displayArray(bubbleSort(myArr));
    }
    //In bubble sort, we gotta make sure that the maximum number stays at the very end in each iteration.

    public static int[] bubbleSort(int []arr){
        int counter = 0;
        int temp = 0;
        while(counter<arr.length-1){
            for(int i = 0;i<arr.length-1-counter;i++){
                if(arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
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
