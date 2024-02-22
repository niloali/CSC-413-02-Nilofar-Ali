//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 2

import java.util.Scanner;

class ExpressionDriver {
    public void evaluateExpressions(Scanner scanner) {
        System.out.println("Enter values for identifiers (a, b, c, d):");
        int[] values = new int[4];
        for (int i = 0; i < 4; i++) {
            char identifier = (char) ('a' + i);
            System.out.print("Enter value for " + identifier + ": ");
            values[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume newline

        int infixResult = InfixEvaluator.evaluateInfix(ExpressionEvaluator.INFIX_EXPRESSION, values);
        int postfixResult = PostfixEvaluator.evaluatePostfix(ExpressionEvaluator.POSTFIX_EXPRESSION, values);

        System.out.println("Value of infix string " + ExpressionEvaluator.INFIX_EXPRESSION +
                " with a = " + values[0] + ", b = " + values[1] +
                ", c = " + values[2] + ", d = " + values[3] + " is " + infixResult);

        System.out.println("Value of postfix string " + ExpressionEvaluator.POSTFIX_EXPRESSION +
                " with a = " + values[0] + ", b = " + values[1] +
                ", c = " + values[2] + ", d = " + values[3] + " is " + postfixResult);
    }
}
