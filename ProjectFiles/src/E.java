import java.util.Scanner;

interface StackFloat {
    void push(float data);
    float pop();
    boolean isEmpty();
}

class StackLinked implements StackFloat {

    static class Node {
        float data;
        Node next;

        public Node(float data) {
            this.data = data;
        }
    }

    Node start;
    public StackLinked() {
        start = null;
    }
    public void push(float data) {
        try {
            Node newNode = new Node(data);
            newNode.next = start;
            start = newNode;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Overflow");
        }
    }

    public float pop() {
        float data;
        if (!isEmpty()) {
            data = start.data;
            start = start.next;
        } else {
            throw new RuntimeException("Underflow");
        }
        return data;
    }

    public boolean isEmpty() {
        return start == null;
    }
}

class PostfixEvaluation {
    private final String expr;
    private float ans;

    public PostfixEvaluation(String expr) {
        this.expr = expr;
        evaluatePostFixExpression();
    }

    public boolean isOperator(String part) {
        if (part.length() == 1) {
            char ch=part.charAt(0);
            return ch == '+' || ch == '-' || ch == '/' || ch == '*';
        }
        return false;
    }

    public void evaluatePostFixExpression() {
        String[] part = expr.split(" ");
        float result = 0;
        float op1, op2;
        StackFloat stkOpr = new StackLinked();
        for (String operator : part) {
            System.out.println(operator);
            if (isOperator(operator)) {
                op2 = stkOpr.pop();
                op1 = stkOpr.pop();
                if (operator.charAt(0) == '+') {
                    result = op1 + op2;
                } else if (operator.charAt(0) == '-') {
                    result = op1 - op2;
                } else if (operator.charAt(0) == '/') {
                    result = op1 / op2;
                } else if (operator.charAt(0) == '*') {
                    result = op1 * op2;
                }
                stkOpr.push(result);
            } else {
                stkOpr.push(Float.parseFloat(operator));
            }
        }
        ans = stkOpr.pop();
        if (!stkOpr.isEmpty()) throw new IllegalArgumentException();
    }


    public String toString() {
        return "Evaluation of Postfix : " + ans;
    }
}

class Expression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix Expression : ");
        String expr = sc.nextLine();
        PostfixEvaluation postfixEvaluation = new PostfixEvaluation(expr);
        System.out.println(postfixEvaluation);
        sc.close();
    }
}