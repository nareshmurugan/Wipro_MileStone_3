/*

2. TRANSFORM CODE

Given an integer array input1[], function transformCodes returns a String array by following the below steps:
Step A) For each number in the array, do the following and produce a string equivalent:
Let "answer" be an empty string.
Let 'n' be the current element from the array.

Step A1) Check whether the length of n is 6. if so, concatnate "C" to answer, Else concatenate "W" to answer.
Step A2) Check whether n satifies any of the following four conditions:
if n is 0, then concatenate alphabets "Z" to answer,
if n is 1, then concatenate alphabets "O" to answer, 
if n is a Prime number, concatenate alphabet "P" to answer, 
if n is not a Prime number, concatenate alphabet "N" to answer.
Step A3) Find the sum of all the individual digits in "n", till the sum becomes a "single digit"
Concatenate that single digit sum to the answer.
Step A4) If n is "even number, find (n/2) and concat it to the answer.
Else find (n-1)/2 and concat it to the answer.
Step B) Now we need to accumulate all the answers from step 4 in one String Array and return the same.
Assumptions:
1) All the numbers in the input1 array will be >=2.
2) input1 array will have minimum one element in it.
3) Output array size should be equal to input array size.
4) input and output are case sensitive.

Note:
1) Prime number series is 2,3,5,7,11,13,etc.
2) 0 and 1 are neither prime nor composite.

Function Prototype: String[] transformCodes(int[] input1)
Sample Input/Output-1:
input1[]={12}
output[]={"WN36"}
Explanation: Lets consider the first number from the input1 array.
	Step A1: Initially answer="" and n=12. Length of n is not 6. So, answer="W",
	Step A2: 12 is not a prime number. So, concatenate "N" to the answer. Now answer="WN"
	Step A3: Lets find the sum of digits till it becomes a single digit.
	Step A4: n=12 is an even number. so n/2=6. Concatenate this value to answer.
		Now answer="WN36"
	Finally the resulting string array is ["WN36"]. We need to return this array.

Sample Input/Output-2: 
input1[]={123456,1234567}
output[]={"CN361728","WN1617288"}

Explanation: Lets consider the first number from the input1 array.

	Step A1: Initially answer="" and n=123456. Length of n is 6. So, answer="C",
	Step A2: n is not a prime number. So, concatenate "N" to the answer. Now answer="CN"
	Step A3: Lets find the sum of digits till it becomes a single digit.
		1+2+3+4+5+6=21 Which is a two digit number. So, let us find the sum of the digit in 21.
	Step A4: n=123456 is an even number. so n/2=61728. Concatenate this value to answer.
		Answer for the first number is "CN361728".
Lets consider the second number from the input1 array.

	Step A1: Initially answer="" and n=1234567. Length of n is 7. So, answer="W",
	Step A2: n is not a prime number. So, concatenate "N" to the answer. Now answer="WN"
	Step A3: Lets find the sum of digits till it becomes a single digit.
		1+2+3+4+5+6+7=28 Which is a two digit number. So, let us find the sum of the digit in 28.
	Step A4: n=1234567 is an odd number. so (n-1)/2=617283. Concatenate this value to answer.
		Answer for the second number is "WN1617283".
Finally, We need to accumulate result for each of the input number. Hence, the resulting string array is {"CN361728","WN1617283"}. We need to return this array.

=======================================================================================================================================================================

 */
public class Question2 {
    public static void main(String[] args) {
        int[]i={123456,1234567};
        String[]s=Transfrorm(i);
        for(String ss:s)System.out.println(ss);
    }

    public static String[] Transfrorm(int []input1){
        String[] res=new String[input1.length];
        for(int i=0;i<input1.length;i++){
            res[i]=res(input1[i]);
        }
        return res;
    }

    public static String res(int i){
        
        String res="";

        if((""+i).length()==6)res+="C";
        else res+="W";

        if(i==0)res+="Z";
        else if(i==1)res+="O";
        else if(isPrime(i))res+="P";
        else res+="N";

        res+=sum(i);
        if(i%2==0)res+=i/2;
        else res+=(i-1)/2;

        return res;
    }

    public static int sum(int i) {
        int sum=0;
        do{
            sum=0;
            while(i!=0){
                int t=i%10;
                i/=10;
                sum+=t;                
            }
            i=sum;
        }while(sum>9);
        return sum;
    }

    public static boolean isPrime(int a) {
        if(a<2)return false;
        for(int i=2;i<=a/2;i++)if(a%i==0)return false;
        return true;
    } 
}