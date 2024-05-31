// Infix.java


public class Infix {
	
    public String toPostfix(String infix) throws Underflow {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new LinkedListStack<>();

        char[] infixChars = infix.toCharArray();
        for (char c : infixChars) {

           
            if (Character.isDigit(c)) {
                postfix.append(c);
            } 
           
            else if (c == '(') {
                stack.push(c);
            } 
          
            else if (c == ')') {
               
                while (!stack.isEmpty() && stack.top() != '(') {
                  
                    postfix.append(stack.pop());
                }
       
                stack.pop(); 
            } 
            
            else {
                
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
                  
                    postfix.append(stack.pop());
                }
               
                stack.push(c);
            }
        }

      
        while (!stack.isEmpty()) {
           
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int precedence(char operator) {
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
}
