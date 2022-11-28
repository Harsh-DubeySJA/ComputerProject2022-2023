import java.util.Scanner;

class InfixToPostfix {
    private String infixExpression;
    private String postfixExpression;

    public InfixToPostfix(String infixExpression) {
        this.infixExpression = infixExpression;
        postfixConversion();
    }

    private void postfixConversion() {
        Stack operatorStack = new LinkedStack();
        String operators = "()$*/+-";
        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            int index = operators.indexOf(ch);
            if (index != -1) {
                if (ch == '(') continue;
                if (ch == ')') while (!operatorStack.isEmpty()) postfixExpression+=operatorStack.pop();
                else if (!operatorStack.isEmpty()) {
                    char pop = operatorStack.pop();
                    int newIndex = operators.indexOf(pop);
                    if (checkHierarchy(newIndex, index)) {
                        operatorStack.push(ch);
                        postfixExpression+=pop;
                    } else {
                        operatorStack.push(pop);
                        operatorStack.push(ch);
                    }
                } else
                    operatorStack.push(ch);
            } else postfixExpression+=ch;
        }
    }

    private boolean checkHierarchy(int newIndex, int index) {
        // Checks for higher order of precedence
        // In the operator String higher precedence operators are placed first
        return (newIndex < index+2);
    }

    public String toString() {
        return "InfixToPostfix\n" +
                "infixExpression=" + infixExpression +
                "\npostfixExpression='" + postfixExpression;
    }
}

public class InfixToPostfixConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Infix Equation : ");
        String infixEquation = sc.next();
        InfixToPostfix infixToPostfix = new InfixToPostfix(infixEquation);
        System.out.println(infixToPostfix);
        sc.close();
    }
}
