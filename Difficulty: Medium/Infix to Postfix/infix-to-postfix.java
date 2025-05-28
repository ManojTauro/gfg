//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static String infixToPostfix(String str) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> s = new Stack<>();
        
        for (char c: str.toCharArray()) {
            if (Character.isLetter(c) ||
                Character.isDigit(c)) ans.append(c);
                
            else if (c == '(') s.push(c);
            else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    ans.append(s.pop());
                }
                s.pop();
            }
            else {
                while (!s.isEmpty() && priority(c) <=  priority(s.peek())) {
                    ans.append(s.pop());
                }
                s.push(c);
            }
        }
        
        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        
        return ans.toString();
    }
    
    private static int priority(char c) {
        if (c == '^') return 3;
        
        else if (c == '/' || c == '*') return 2;
        
        else if (c == '+' || c == '-') return 1;
        
        return -1;
    }
}