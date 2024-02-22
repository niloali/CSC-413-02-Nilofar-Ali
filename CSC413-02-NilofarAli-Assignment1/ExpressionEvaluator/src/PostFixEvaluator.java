//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 2

import java.util.Stack;

class PostfixEvaluator {
    public static int evaluatePostfix(String str, int[] values) {
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(values[c - 'a']);
            } else if (isOperator(c)) { // Check if it's an operator
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(applyOperator(operand1, operand2, c));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'; // Added support for ^
    }

    private static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand1, operand2); // Exponentiation
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
