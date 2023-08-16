/*
 
10. Example-1 - If th participant's details are as below-
First_Name = Rajiv
Last_Name = Roy
PIN = 560037
N = 6
Step1- Length of the Last_Name is less than the length of First_Name. so the smaller name is "ROY" and the longer name is "Rajiv"
Step2- The user-id will be = Last Letter of the longer name + Entire word of the smaller name + Digit at position N in the PIN when traversing from LEFT to RIGHT + Digit at position N in the PIN When traversing from RIGHT to LEFT.
=Last letter of "Rajiv" + Entire word of "Roy" + 6th Digit of PIN from left + 6tg Digit of PIN from right
=v+Roy+7+5
Therefore, user-id = vRoy75
Step3- Toggle the alphabets in the user-id. So, user-id=VrOY75.

====================================================================================================================================================================
 */
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String Fname=sc.nextLine(),Lname=sc.nextLine();
        int pin=sc.nextInt(),pos=sc.nextInt();
        System.out.println(userId(Fname,Lname,pin,pos));
        sc.close();
    }

    public static String userId(String input1, String input2, int input3, int input4) {
        String res="";
        if(input1.length()!=input2.length()){
            if(input1.length()>input2.length())res+=input1.charAt(input1.length()-1)+input2;
            else res+=input2.charAt(input2.length()-1)+input1;
        }
        else{
            if(input1.compareTo(input2)<=0)res+=input2.charAt(input2.length()-1)+input1;
            else res+=input1.charAt(input1.length()-1)+input2;
        }
        String r=""+input3;
        res+=r.charAt(input4-1);
        res+=r.charAt(r.length()-input4);
        // res+= (""+input3.charAt(input4-1))+(""+input3.charAt(""+input3.length()-input4));
        return toggle(res);
    }



    public static String toggle(String a){

        String r="";

        for(char c:a.toCharArray()){
            if(Character.isLowerCase(c))r+=Character.toUpperCase(c);
            else if(Character.isUpperCase(c))r+=Character.toLowerCase(c);
            else r+=c;
        }

        return r;
    }
}
