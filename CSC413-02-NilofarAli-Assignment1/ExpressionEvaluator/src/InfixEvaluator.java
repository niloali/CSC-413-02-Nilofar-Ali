//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 2

import java.util.Stack;

class InfixEvaluator {
    public static int evaluateInfix(String str, int[] values) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                valueStack.push(values[c - 'a']);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    char operator = operatorStack.pop();
                    int operand2 = valueStack.pop();
                    int operand1 = valueStack.pop();
                    valueStack.push(applyOperator(operand1, operand2, operator));
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    char operator = operatorStack.pop();
                    int operand2 = valueStack.pop();
                    int operand1 = valueStack.pop();
                    valueStack.push(applyOperator(operand1, operand2, operator));
                }
                operatorStack.pop(); // Discard '('
            }
        }

        while (!operatorStack.isEmpty()) {
            char operator = operatorStack.pop();
            int operand2 = valueStack.pop();
            int operand1 = valueStack.pop();
            valueStack.push(applyOperator(operand1, operand2, operator));
        }

        return valueStack.pop();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
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
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
