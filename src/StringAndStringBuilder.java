import java.util.ArrayList;
import java.util.Locale;

public class StringAndStringBuilder {
    public static void main(String[] args) {
        String ex = "hello world india is shit";
        String nuni = "paruparu";
        allSubs(nuni);
        wordMan(ex);
        System.out.println();


        //String builder

        StringBuilder str = new StringBuilder("Hello this is a String Builder");
        System.out.println(str);
        //To find the length:
        str.length();

        //To get a char
        str.charAt(1);
        //To set a character
        str.setCharAt(2, 'W');
        //To insert
        str.insert(3, "abc");
        //To insert character at the end:
        str.append("asdsad");
        //To delete a char
        str.deleteCharAt(2);
        //To convert to string
        String de = str.toString();

    }
    public static void wordMan(String str){
        String []spl = str.split(" ");
        String s = "";
        for(int i = 0;i<spl.length;i++){
           String [] splLetters = spl[i].split("");
            for(int j = 0;j<splLetters.length;j++){
                if(j%2==0){
                    s = splLetters[j].toUpperCase();
                }
                if(j%2==1){
                    s = splLetters[j].toLowerCase();
                }
                System.out.print(s);
            }
            System.out.print(" ");

            //System.out.print(spl[i].substring(0,1).toUpperCase(Locale.ROOT) + spl[i].substring(1) + " ");

        }
    }
    public static void allSubs(String str){
        for(int i = 0;i<=str.length();i++){
            System.out.println(str.substring(0, i));
        }
    }
}
