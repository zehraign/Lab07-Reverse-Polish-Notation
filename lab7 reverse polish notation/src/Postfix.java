

import java.util.ArrayDeque;
import java.util.Deque;

public class Postfix {
   
    public double evaluate(String postfix) 
    {
        Deque<Double> stack = new ArrayDeque<>();
        
        for (char c : postfix.toCharArray()) 
        {
            if (Character.isDigit(c)) 
            {
                stack.push((double) (c - '0'));
                
            } else if (isOperator(c)) 
            {
               if (stack.size() < 2) 
               {
                  throw new IllegalArgumentException("Invalid expression" );
               }
                double b = stack.pop();
                double a = stack.pop();
                
                double result = performOperation(a, b, c);
                stack.push(result);
                
                
            } else {
                throw new IllegalArgumentException("Invalid character expression: " + c);
            }
        }
        
        
        
        return stack.pop();
    }
    
    
    
    
    
    
    
    private static boolean isOperator(char c) 
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private static double performOperation(double a, double b, char operator) {
        switch (operator)
        {
            case '+': 
            	return a + b;
            case '-': 
            	return a - b;
            case '*':
            	return a * b;
            case '/':
            	return a / b;
            default: 
            	throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
