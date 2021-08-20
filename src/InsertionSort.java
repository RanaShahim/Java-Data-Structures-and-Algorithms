public class InsertionSort {
    public static void main(String[] args) {
        int []myArr = {34,11,6,65,4,12,38,5};
        displayArray(insertionSort(myArr));
    }
    public static int [] insertionSort(int []arr){
        int counter = 1;
        while(counter<arr.length-1){
            int val = arr[counter];
            int j = counter-1;
            while(j>=0 && arr[j]>val){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
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
