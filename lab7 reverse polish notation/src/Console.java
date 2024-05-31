


import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter an arithmetic expression:");

            String inputExpression = scanner.nextLine();

            Infix infixConverter = new Infix();
            Postfix postfixEvaluator = new Postfix();

            try {
                String postfixExpression = infixConverter.toPostfix(inputExpression);
                System.out.println("Postfix expression: " + postfixExpression);

                double result = postfixEvaluator.evaluate(postfixExpression);
                System.out.println("result: " + result);
            } catch (Underflow | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage()); 
            }
        }
    }
}
