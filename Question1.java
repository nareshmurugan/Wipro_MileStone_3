/*
 1. Encoding Three Strings: Anand was assigned the task of coming up with an encoding mechanism for any given three strings. He has come up with the below plan

STEP ONE: Given any three strings, break each string into 3 parts each,
For Example- If three strings are as below -
input1="John"
input2="Johny"
input3="Janardhan"

"John" should be split into "J","oh","n" as the FRONT, MIDDLE and END parts respectively.
"Johny" should be split into "Jo","h","ny" as the FRONT, MIDDLE and END parts respectively.
"Janardhan" should be split into "Jan","ard","han" as the FRONT, MIDDLE and END parts respectively.
i.e. if the no of characters in the string are in the multiples of 3, then each split part will contain equal no of characters. as seen in the example of "Janardhan".
If the no. of characters in the string are NOT in multiples of 3, then the middle part will get the extra character, as seen in the example of "John".
If the no. of characters in the string are NOT in multiples of 3, and if there are two characters more than multiple of 3, then the FRONT and END parts will get one extra character each, as seen in the example of "Johny"

STEP TWO: Concatenate(join) the FRONT, MIDDLE and END parts of the strings as per the below specified concatenation-rule to form three output strings.
Output1=FRONT part of input1+MIDDLE part of input2+END part of input3
Output2=MIDDLE part of input1+END part of input2+FRONT part of input3
Output3=END part of input1+FRONT part of input2+MIDDLE part of input3
For Example, for the above specified example input strings,
Output1="J"+"h"+"han"="Jhhan"
Output2="oh"+"ny"+"Jan"="ohnyJan"
Output3="n"+"Jo"+"ard"="nJoard"

STEP THREE: Process the resulting output strings based on the output Processing rule.
After the above two steps, we will now have three output strings. Further processing is required only for the third output string as per below rule-"Toggle the case of each character in the string", i.e. in the third output string, all lower-case characters should be made upper-case and vice versa.
For Example, for the above example strings, Output3 is "nJoard", so after applying the toggle rule, Output3 should become "NjOARD".

Final result- The three output strings after applying the above three steps is the final result. i.e. for the above example.
Output1="Jhhan"
Output2="ohnyJan"
Output3="NjOARD"

Anand approaches you to help him write a program that would do the above mentioned processing on any given three strings and generate the resulting three output strings.
The given functions three parameters, input1,input2,input3 represent the three given input strings and return a "Result" object/struct with the three output strings.
=======================================================================================================================================================================
 */

import java.util.Scanner;

class Result{
    public String o1;
    public String o2;
    public String o3;
    Result(String ou1,String ou2,String ou3){
        o1=ou1;
        o2=ou2;
        o3=ou3;
    }
}

public class Question1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine(),b=sc.nextLine(),c=sc.nextLine();
        sc.close();
        Result s=q1(a,b,c);
        System.out.println(s.o1);
        System.out.println(s.o2);
        System.out.println(s.o3);
    }
    

    public static Result q1(String input1, String input2, String input3){

        String[]a=splt(input1);
        String[]b=splt(input2);
        String[]c=splt(input3);

        String[]res={a[0]+b[1]+c[2],a[1]+b[2]+c[0],a[2]+b[0]+c[1]};

        res[2]=toggle(res[2]);
        Result result=new Result(res[0],res[1],res[2]);
        return result;
    }

    public static String[] splt(String a){

        int n=a.length()/3;

        switch(a.length()%3){
            case 0:
                return new String[]{a.substring(0, n),a.substring(n,n+n),a.substring(n+n)};
            case 1:
                return new String[]{a.substring(0, n),a.substring(n,n+n+1),a.substring(n+n+1)};
            default:
                return new String[]{a.substring(0, n+1),a.substring(n+1,n+n+1),a.substring(n+n+1)};
        }
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