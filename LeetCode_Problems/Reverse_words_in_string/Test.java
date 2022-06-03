// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
class Test{
    
    /**
     
        take input string and split it at space
        ('', 0) will split it at space and remove trailing zeros
        itterate the array backwards and add words that are not empty then a space
        remove trailing space, last char 

        string fin = ""
        string[] temp = string split("",0)
        for(i = arr length; i > 0; i--)
            if(i == 1)
                fin += temp[i]
            else if(temp[i] != '')
            fin += temp[i]
            fin += ''

     */
    static String solution(String input){
        String fin = "";
        String[] temp = input.split(" ", 0);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]+"|"); 
        }
        for(int i = temp.length-1; i >= 0; i--){
            if(fin.length()!=0 && temp[i] != "" && temp[i] != " "){
                fin += " ";
            }
            if(temp[i] != "" && temp[i] != " "){
                fin += temp[i];
            }
            
        }
        return fin;
    }
    public static void main(String[] args) {
        String input = "  hello world  ";
        System.out.println("|"+solution(input)+"|"); 
    }
}