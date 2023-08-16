/*
 4. User ID Generation: Joseph's team has assigned the task of creating user-ids for all participants of an online gaming competition. Joseph has designed a process for generating the user-id using the participant's First_name, Last_name, PIN code and a number N. The process defined by joseph is as below-

Step1- Compare the length of First_name and Last_name of the participant. The one that is shorter will be called "Smaller Name" and the one that is longer will be called the "Longer Name". If both First_name and Last_name are of equal length, then the name that appears earlier in alphabetical order will be called "Smaller Name" and the name that appears later in the alphabetical order will be called the "Longer Name".

Step2- The User-id should be generated as below-
First letter of the smaller name + Entire word of the longer name + Digit at position N in the PIN when traversing the PIN from left to right + Digit at position N in the PIN when traversing the PIN from right to left.

Step3- Toggle the alphabets of the user-id generated in step-2. I.e. upper-case alphabets should become lower-case and lower-case alphabets should become upper-case.

Let us see a few examples.

Example-1 - If th participant's details are as below-
First_Name = Rajiv
Last_Name = Roy
PIN = 560037
N = 6
Step1- Length of the Last_Name is less than the length of First_Name. so the smaller name is "ROY" and the longer name is "Rajiv"
Step2- The user-id will be = First Letter of the longer name + Entire word of the smaller name + Digit at position N in the PIN When traversing from RIGHT to LEFT + Digit at position N in the PIN when traversing from LEFT to RIGHT.
=First letter of "Rajiv" + Entire word of "Roy" + 6th Digit of PIN from left + 6tg Digit of PIN from right
=R+Roy+7+5
Therefore, user-id = RRoy75
Step3- Toggle the alphabets in the user-id. So, user-id=rrOY75

Example-2 -If the participants details are as below-
First_Name = Manoj
Last_Name = Kumar
PIN = 561327
N =2
Step1- Length of the First_Name is equal to the Length of the Last_Name. Alphabettically, 'Kumar' appears earlier than 'Manoj' (by comparing alphabetic positions of 'K' and 'M') so the smaller name is "Kumar" and the Longer name as "Manoj"
Step2- The User-id will be = First Letter of the longer name +  Entire word of the smaller name + Digit at position N in the PIN when traversing the PIN from right to left
=First Letter of "Manoj" + Entire word of "Kumar" + 2nd Digit of PIN from left + 2nd Digit of PIN from right.
=M+kumar+6+2
Therefore, user-id=MKumar62
Step3- Toggle the alphabets in the user-id. So, user-id=mKUMAR62

Example3- If the participants details are as below-
First_Name=Kumud
Last_Name=Kumar
PIN=561327
N=2

Step1- Length of the First_Name is equal to the Length of the Last_Name.
Alphabetically, "Kumar" appears earlier than "Kumud" (by comparing alphabetical position of Kuma and Kumu) so the smaller name is "Kumar" and the longer name is "Kumud"

Step2- The user-id will be = First Letter of the longer name + Entire word of the smaller name + Digit at position N  in the PIN when traversing the PIN from left to right + digit at position N in the PIN when traversing the PIN from right  to left.
=First Letter of "Kumud' + Entire word in "Kumar" + 2nd Digit of PIN from left and 2nd digit of PIN from right.
=K+Kumar+6+2
Therefore, user-id=KKumar62
Step3- Toggle the alphabets in the user-id. So, user-id = kkUMAR62

You are part of Joseph's team and he has asked you to write a program(method to generate the participants user-id using the above rules.

The name of the function is useridGeneration and it takes four input parameters.
where, 
input1 is the First_Name
input2 is the Last_Name
input3 is the PIN
input4 is the number N

The function should do the processing as per the rules explained above and  should return the generated user-id.

Assumptions- For convenience of this assessment questions. Let us assume that the value of N(input4) will always be less than or equal to the number of digits in the PIN.

=======================================================================================================================================================================
 */

import java.util.Scanner;

public class Question4 {
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
            if(input1.length()>input2.length())res+=input1.charAt(0)+input2;
            else res+=input2.charAt(0)+input1;
        }
        else{
            if(input1.compareTo(input2)<=0)res+=input2.charAt(0)+input1;
            else res+=input1.charAt(0)+input2;
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