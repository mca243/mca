import java.util.Stack;

public class ParenthesisBalancing {
    // Function to check if parentheses are balanced
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for (char ch : expr.toCharArray()) {
            // Push open brackets onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Check for closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                // If stack is empty, it's unbalanced
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element and check if it matches
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        // If the stack is not empty, it's unbalanced
        return stack.isEmpty();
    }

    // Helper function to check if two brackets are matching pairs
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    // Main method to test the function
    public static void main(String[] args) {
        String expr = "{[()]}";
        if (isBalanced(expr)) {
            System.out.println("The expression is balanced.");
        } else {
            System.out.println("The expression is not balanced.");
        }
    }
}

/*
Balancing Parentheses Using a Stack
Balancing parentheses is a common problem where we check 
whether the given string containing different types of brackets ({}, [], ()) 
is properly nested and balanced. A stack is an ideal data structure for solving 
this problem because of its LIFO (Last In, First Out) nature.

Steps to Check Parentheses Balance
1.	Traverse the Expression: 
o	Read each character of the string one at a time.
2.	Push Open Brackets: 
o	If the character is an opening bracket ((, [, {), push it onto the stack.
3.	Match Closing Brackets: 
o	If the character is a closing bracket (), ], }): 
	Check if the stack is empty (indicating an unmatched closing bracket).
	Pop the top of the stack and check if it matches the closing bracket.
4.	Final Check: 
o	After traversing the string, the stack should be empty. If not, 
it indicates unmatched opening brackets.

Algorithm
1.	Create an empty stack.
2.	Traverse each character of the string: 
o	If it is an opening bracket, push it onto the stack.
o	If it is a closing bracket, check: 
	If the stack is empty, the string is unbalanced.
	Pop the stack and check if the popped element matches the closing bracket. 
If not, the string is unbalanced.
3.	After traversing the string, check if the stack is empty. If not, the string is unbalanced.


Example Execution
Input: {[()]}
1.	Read {: Push onto stack → Stack: [{.
2.	Read [: Push onto stack → Stack: [{[.
3.	Read (: Push onto stack → Stack: [{[(.
4.	Read ): Pop and match with ( → Stack: [{[.
5.	Read ]: Pop and match with [ → Stack: [{.
6.	Read }: Pop and match with { → Stack: [].
7.	Final Check: Stack is empty → Balanced.
Output: The expression is balanced.

Time and Space Complexity
1.	Time Complexity:
o	Traversing the string takes O(n)O(n), where nn is the length of the string.
o	Each stack operation (push and pop) takes O(1)O(1).
o	Overall: O(n)O(n).
2.	Space Complexity:
o	The stack can hold at most n/2n/2 elements (if all are opening brackets).
o	Space complexity: O(n)O(n).

Applications
1.	Compiler Design: 
o	Used to validate syntax (matching parentheses, brackets, etc.).
2.	Expression Parsing: 
o	Ensures proper nesting in mathematical and logical expressions.
3.	Code Editors: 
o	Real-time checking for balanced parentheses in IDEs or text editors.
4.	XML/HTML Validation: 
o	Verifies proper nesting and closure of tags.

*/
