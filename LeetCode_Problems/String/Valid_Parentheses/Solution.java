package Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
// Given a string s containing just the characters 
// '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true


// Example 2:

// Input: s = "()[]{}"
// Output: true


// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

    static boolean solution(String s){

       Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '['){
                switch (c) {
                    case '{':
                        stack.push('}');
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case '(':
                        stack.push(')');
                        break;
                }
            }
            else{
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    } 
    public static void main(String[] args) {
        String s = "(){[{}]}";
        String s1= "(){[{]}}";
        System.out.println(solution(s));
        System.out.println(solution(s1));
    } 
}
