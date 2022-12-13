import java.util.Scanner;

class PostfixConversion {
    private final String expression;
    private final Stack stack;

    public PostfixConversion(String expression) {
        this.expression = expression;
        stack = new LinkedStack();
        convertToPostfix();
    }

    private void convertToPostfix() {
        String operator = "-+/*$()";
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (operator.indexOf(character) == -1) {
                System.out.print(character);
            } else {
                char popped;
                if (character == '(' || stack.isEmpty()) {
                    stack.push(character);
                } else if (checkHierarchy((popped = stack.pop()), character)) {
                    System.out.print(popped);
                    if (character == ')') {
                        int bracketFound = 0;
                        while (!stack.isEmpty() && bracketFound < 2) {
                            popped = stack.pop();
                            if (popped != '(')
                                System.out.print(popped);
                            else
                                bracketFound++;
                        }
                        continue;
                    }
                    stack.push(character);
                } else {
                    stack.push(popped);
                    stack.push(character);
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty())
                System.out.print(stack.pop());
        }
    }

    private boolean checkHierarchy(char popped, char current) {
        String[] operators = {"+-", "*/", "$", "("};
        int first = -1;
        int second = -1;
        for (int i = 0; i < 3; i++) {
            first = first == -1 && operators[i].indexOf(popped) != -1 ? i : first;
            second = second == -1 && operators[i].indexOf(current) != -1 ? i : second;
        }
        return first >= second;
    }
}

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Infix Expression : ");
        String expression = sc.next();
        PostfixConversion conversion = new PostfixConversion(expression);
        sc.close();
    }
}
