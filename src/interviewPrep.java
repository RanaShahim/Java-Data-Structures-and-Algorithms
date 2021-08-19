public class interviewPrep {
    public static void main(String[]args){
        System.out.println(isPrime(24));
        System.out.println("-------------------");
        fibonnaci(6);
        gcd(60,36);
        reverseNumber(12345);
        printPattern1(6, 6);
        convertDecimalToBinary(53);
        convertBinaryToDecimal(100000);
        convertDecimalToOctal(37);
        AnyNumberToDecimal(1423, 5);
        DecimalToAnyBase(238, 5);

    }
    public static boolean isPrime(int n){
        int counter = 2;
        if(n==1||n==2) return true;
        while(counter<n/2){
            if(n%counter==0){
                return false;
            }
            counter++;
        }
        return true;
    }
    public static void fibonnaci(int n){
        int a = 0;
        int b = 1;
        int sum = 0;
        int counter = 1;
        while(counter<n+1){
            sum = a+b;
            System.out.println("fib" + counter + "--> " + a);
            a = b;
            b = sum;
            counter++;

        }
        System.out.println("-------------------");
    }
    public static void gcd(int divident, int divisor){

        while(divident%divisor!=0){
           int remainder = divident%divisor;
            divident = divisor;
            divisor = remainder;
            if(remainder==0)break;
        }
        System.out.println("GCD --> " + divisor);
    }
    public static void reverseNumber(int n){
        while(n!=0){
            int nCheck = n%10;
            n = n/10;
            System.out.print(nCheck);

        }
        System.out.println();
    }
    public static void printPattern1(int rows, int cols){
        for(int i = 0;i<=rows-1;i++) {
            System.out.print(" ");
            for(int j = 0;j<cols-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void convertDecimalToBinary(int n){

        /*The logic goes like that:
        1- Divide the n(Decimal value) by 2(Binary Value).
        2- keep track of the remainder since we wanna multiply that with 10^0,1,2,3 etc.
        3- add the values.
         */

        int counter = 0;
        int sum = 0;
        while(n!=0){
            int remainder = n%2;
            n = n/2;
            remainder = remainder*(int)(Math.pow(10,counter));
            sum+=remainder;
            counter++;
        }
        System.out.println(sum);
    }

    public static void convertBinaryToDecimal(int n){

        /*
        Same logic but the opposite
        The logic goes like that:
        1- Divide the n(Decimal value) by 2(Binary Value).
        2- keep track of the remainder since we wanna multiply that with 10^0,1,2,3 etc.
        3- add the values.
         */

        int counter = 0;
        int sum = 0;
        while(n!=0){
            int remainder = n%10;
            n = n/10;
            remainder = remainder*(int)(Math.pow(2,counter));
            sum+=remainder;
            counter++;
        }
        System.out.println(sum);
    }
    public static void convertDecimalToOctal(int n){

        /*
        Same logic but the opposite
        The logic goes like that:
        1- Divide the n(Decimal value) by 2(Binary Value).
        2- keep track of the remainder since we wanna multiply that with 10^0,1,2,3 etc.
        3- add the values.
         */

        int counter = 0;
        int sum = 0;
        while(n!=0){
            int remainder = n%8;
            n = n/8;
            remainder = remainder*(int)(Math.pow(10,counter));
            sum+=remainder;
            counter++;
        }
        System.out.println(sum);
    }
    public static void AnyNumberToDecimal(int sourceNumber, int sourceDestination ){

        /*
        Same logic but the opposite
        The logic goes like that:
        1- Divide the n(Decimal value) by 2(Binary Value).
        2- keep track of the remainder since we wanna multiply that with 10^0,1,2,3 etc.
        3- add the values.
         */

        int counter = 0;
        int sum = 0;
        while(sourceNumber!=0){
            int remainder = sourceNumber%10;
            sourceNumber = sourceNumber/10;
            remainder = remainder*(int)(Math.pow(sourceDestination,counter));
            sum+=remainder;
            counter++;
        }
        System.out.println("Source Number in terms of Base 10 equals to " + sum);
    }
    public static void DecimalToAnyBase(int sourceNumber, int sourceDestination ){

        /*
        Same logic but the opposite
        The logic goes like that:
        1- Divide the n(Decimal value) by 2(Binary Value).
        2- keep track of the remainder since we wanna multiply that with 10^0,1,2,3 etc.
        3- add the values.
         */

        int counter = 0;
        int sum = 0;
        while(sourceNumber!=0){
            int remainder = sourceNumber%sourceDestination;
            sourceNumber = sourceNumber/sourceDestination;
            remainder = remainder*(int)(Math.pow(10,counter));
            sum+=remainder;
            counter++;
        }
        System.out.println(sum);
    }
}
