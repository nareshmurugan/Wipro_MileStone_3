/*
 5. Toggle the String

Anju and Aman are close friends. There are playing a game on toggling of strings. Anju has given certain instructions to Aman to toggle a String. Help Aman to find the correct output.

Given a String input1, based on input2 return the output as follows:

Case1: If input2 is 0, extract and toggle the character at even indexes and return the concatenated output.

Case2: If input2 is 1, extract and toggle the character at odd indexes and return the concatenate output.

Case3: If input2 is 2, reverse the String and return the toggled output.

Example1:
input1: Wipro
input2: 0
output:wPO
Explanation: W, p and o are at even indexes. After toggling, the values are w,P and O. Hence, the concatenated output is wPO.

Example2:
input1:TechnolOgY
input2:1
output:EHOoy
Explanation: e,h,o,O and Y are at odd indexes. After toggling, the values are E, H, O, o and y. Hence, the concatenated output is EHOoy

Example3: 
input1: CHEnnAi
input2:2
output: laNNehc
Explanation: Input String is reversed and all the characters are toggled.

Note: Input String will be a single word containing only alphabets

=======================================================================================================================================================================
 */

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input1=sc.nextLine();
        int input2=sc.nextInt();
        System.out.println(toggle(input1,input2));
        sc.close();
    }

    public static String toggle(String input1, int input2) {
        
        String r="";
        for(char c:input1.toCharArray()){
            if(Character.isLowerCase(c))r+=Character.toUpperCase(c);
            else if(Character.isUpperCase(c))r+=Character.toLowerCase(c);
            else r+=c;
        }

        input1="";

        if(input2==0)for (int i = 0; i < r.length(); i+=2)input1+=r.charAt(i);
        else if(input2==1)for (int i = 1; i < r.length(); i+=2)input1+=r.charAt(i);
        else for (int i = r.length()-1; i>=0; i--)input1+=r.charAt(i);
        
        return input1;
    }
}