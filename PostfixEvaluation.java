import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Traverse the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert character to integer
            }
            // If the character is an operator, pop two elements, apply the operator, and push the result
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            System.out.println("Error: Division by zero.");
                            return 0;
                        }
                        stack.push(operand1 / operand2);
                        break;
                }
            } else {
                System.out.println("Invalid character in the expression.");
                return 0;
            }
        }

        // The result is the only element left in the stack
        if (stack.size() != 1) {
            System.out.println("Invalid postfix expression.");
            return 0;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (e.g., 2354+): ");
        String expression = scanner.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println("The result of the postfix expression is: " + result);
        scanner.close();
    }
}

/*
Postfix expressions do not require parentheses because the order of operations is unambiguous. 
The steps for evaluating a postfix expression using a stack are:

1. Traverse the expression from left to right.
2. Push operands onto the stack.
3. When an operator is encountered:
   - Pop two elements from the stack.
   - Apply the operator.
   - Push the result back onto the stack.
4. At the end, the stack will contain one element: the result.

How the Program Works

1. Input:  
   The program takes a postfix expression as input (e.g., `2354+`).
2. Stack Operations:  
   - If a character is a digit, it is pushed onto the stack.  
   - If a character is an operator, two operands are popped from the stack, and the operation is applied. The result is then pushed back onto the stack.
3. Result:  
   At the end of the expression, the stack contains only one element, which is the result.

 Example Execution

# Input:
2354+
# Step-by-Step Execution:

| Character | Stack After Execution     | Operation         |
|-----------|----------------------------|-------------------|
| 2         | [2]                        | Push 2            |
| 3         | [2, 3]                     | Push 3            |
|          | [6]                        | Pop 2, 3; Push 6  |
| 5         | [6, 5]                     | Push 5            |
| 4         | [6, 5, 4]                  | Push 4            |
|          | [6, 20]                    | Pop 5, 4; Push 20 |
| +         | [26]                       | Pop 6, 20; Push 26|

 Output:
The result of the postfix expression is: 26
Key Points:
1. Time Complexity:
   - Traversal of Expression: (O(n)), where (n) is the length of the expression.
   - Stack operations (push pop) are (O(1)).

2. Space Complexity:
   - Depends on the stack size, which in the worst case is proportional 
to the number of operands (O(n)).

*/