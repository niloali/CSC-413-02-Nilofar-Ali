//Nilofar M. Ali
//ID#: 920311584
//CSC 413-02 Spring 2024
//Assignment 1 part 2

import java.util.Scanner;

public class ExpressionEvaluator {
    public static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    public static final String POSTFIX_EXPRESSION = "ac-b^d+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionDriver expressionDriver = new ExpressionDriver();

        while (true) {
            System.out.println("Do you want to compute the expressions? (yes/no)");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("no")) {
                System.out.println("Program ended.");
                break;
            } else if (input.equals("yes")) {
                expressionDriver.evaluateExpressions(scanner);
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
