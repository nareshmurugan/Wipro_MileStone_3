/*
 
3. Place the Alphabets

Given an integer array input1 with N non-repeating elements, generate and return a character array as per the requirement:
1. Size of the character array should be same as that of input1,
2. In the character array,
	alphabet 'a' will be placed in the position of smallest element of input1.
	alphabet 'b' will be placed in the position of second smallest element of input1
	alphabet 'c' will be placed in the position of third smallest element of input1 and so on..
Example-1

input1={10,5,70,1}
output={c,b,d,a}

Explanation:
	1 is the smallest element in the input1, it is in index 3, hence 'a' is placed in index position 3
	5 is the second smallest element in the input1, it is in index 1, hence 'b' is placed in index position 1
	10 is the third smallest element in the input1, it is in index 0, hence 'c' is placed in index position 0
	70 is the fourth smallest element in the input1, it in index 2, hence 'd' is placed in index position 2

Example - 2

input1={4,5,-2,8,99,67}
output={b,c,a,d,f,e}

Explanation:
	-2 is the smallest element in input1, it is in index2, hence 'a' is placed in index position 2
	4 is the second smallest element in input1, it is in index 0, hence 'b' is placed in index position 0
	5 is the third smallest element in input1, it is in index 1, hence 'c' is placed in index position 1
	8 is the fourth smallest element in input1, it is in index 3, hence 'd' is placed in index position 3
	67 is the fifth smallest element in input1, it is in index 5, hence 'e' is placed in index position 5
	99 is the sixth smallest element in input1, it is in index 4, hence 'f' is placed in index position 4.


=======================================================================================================================================================================

 */
import java.util.Arrays;
public class Question3 {
    public static void main(String[] args) {
        int[]i={4,5,-2,8,99,67};
        char[]c=alp(i);
        for(char ch:c)System.out.println(ch);
    }

    public static char[] alp(int[]input1) {
        int[]a=input1.clone();
        char ch='a';
        char[]res=new char[input1.length];
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i]==input1[j]){
                    res[j]=ch;
                    ch++;
                    if(ch=='{')ch='a';
                    break;
                }
            }
        }
        return res;
    }
}