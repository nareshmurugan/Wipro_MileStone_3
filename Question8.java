/*
 
8. User ID Generation: Joseph's team has assigned the task of creating user-ids for all participants of an online gaming competition. Joseph has designed a process for generating the user-id using the participant's First_name, Last_name, PIN code and a number N. The process defined by joseph is as below-

Example-1 - If th participant's details are as below-
First_Name = Rajiv
Last_Name = Roy
PIN = 560037
N = 6
Step1- Length of the Last_Name is less than the length of First_Name. so the smaller name is "ROY" and the longer name is "Rajiv"
Step2- The user-id will be = First Letter of the smaller name + Entire word in the longer name + Digit at position N in the PIN when traversing the PIN from left to right + Digit at position N in the PIN when traversing the PIN from right to left
=First letter of "Roy" + Entire word of "Rajiv" + 6th Digit of PIN from left + 6tg Digit of PIN from right
=R+Rajiv+7+5
Therefore, user-id = RRajiv75
Step3- Toggle the alphabets in the user-id. So, user-id=rrAJIV75

Example-2 -If the participants details are as below-
First_Name = Manoj
Last_Name = Kumar
PIN = 561327
N =2
Step1- Length of the First_Name is equal to the Length of the Last_Name. Alphabettically, 'Kumar' appears earlier than 'Manoj' (by comparing alphabetic positions of 'K' and 'M') so the smaller name is "Kumar" and the Longer name as "Manoj"
Step2- The User-id will be = First Letter of the smaller name +  Entire word in the longer name + Digit ar position N in the PIN when traversing the PIN from left to right + Digit at position N in the PIN when traversing the PIN from right to left

Therefore, user-id=KManoj62
Step3- Toggle the alphabets in the user-id. So, user-id=kmANOJ62.

You are part of Joseph's team and he has asked you to write a program(method to generate the participants user-id using the above rules.

The name of the function is useridGeneration and it takes four input parameters.
where, 
input1 is the First_Name
input2 is the Last_Name
input3 is the PIN
input4 is the number N

The function should do the processing as per the rules explained above and  should return the generated user-id.

Assumptions- For convenience of this assessment questions. Let us assume that the value of N(input4) will always be less than or equal to the number of digits in the PIN.

====================================================================================================================================================================


 */

import java.util.Scanner;

public class Question8 {
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
            if(input1.length()>input2.length())res+=input2.charAt(0)+input1;
            else res+=input1.charAt(0)+input2;
        }
        else{
            if(input1.compareTo(input2)<=0)res+=input1.charAt(0)+input2;
            else res+=input2.charAt(0)+input1;
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
