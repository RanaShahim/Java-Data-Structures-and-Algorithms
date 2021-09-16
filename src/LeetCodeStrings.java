import java.util.ArrayList;
import java.util.List;

public class LeetCodeStrings {
    public static void main(String[] args) {

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        //  System.out.println(shortestDistance(words, "coding", "practice"));

        displayArr(findWords(words));
    }

    public static void displayArr(String[] arr) {
        for (String a : arr) {
            System.out.print(a + " ");
        }
    }

    /*

    1- Trick here to keep the track of the minimum distance in the current itteration.
    2- set first and second as -1 cause if the word is not found, the index will always return -1;

     */

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int first = -1, second = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) first = i;
            if (wordsDict[i].equals(word2)) second = i;

            if (first != -1 && second != -1) {
                min = Math.min(min, Math.abs(first - second));
            }
        }
        return min;

    }

    public static String[] findWords(String[] words) {

        {
            List<String> list = new ArrayList<>();

            String row1 = "qwertyuiop";
            String row2 = "asdfghjkl";
            String row3 = "zxcvbnm";

            for (String s : words)   // ek ek string ko uthao aur loop k andar ghusao
            {
                int len = s.length();
                char chr[] = s.toLowerCase().toCharArray();

                boolean flag = true;

                for (int i = 0; i < len - 1; i++) {
                    //agar har ek char aur uske agle wala char koi bhi same row se belong nahi karta, toh phir ye if aandar ghusega aur flag ko false karte huye break karke inner for loop se bahar ajayega....
                    if (
                            !(
                               (row1.contains(chr[i] + "") && row1.contains(chr[i + 1] + "")) ||
                               (row2.contains(chr[i] + "") && row2.contains(chr[i + 1] + "")) ||
                                (row3.contains(chr[i] + "") && row3.contains(chr[i + 1] + ""))
                            )) {
                        flag = false;
                        break;
                    }
                }

                if (flag)    //inner for loop khatam hone k baad bhi agar flag mera true hain toh list me wo current string ko add karo...
                    list.add(s);
            }
            String arr[] = new String[list.size()];
            return list.toArray(arr);
        }
    }
}

