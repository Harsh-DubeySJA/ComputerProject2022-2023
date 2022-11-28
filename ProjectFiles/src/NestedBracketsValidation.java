import java.util.Scanner;

public class NestedBracketsValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack characterStack = new LinkedStack();
        System.out.print("Enter the Expression: ");
        String expression = sc.nextLine();
        boolean isPrecedenceCorrect = true;
        String brackets = "{[(}])";
        for (int i = 0, indexPosition; i < expression.length(); i++) {
            indexPosition = brackets.indexOf(expression.charAt(i));

            if (indexPosition != -1) {
                if (indexPosition < 3) characterStack.push(expression.charAt(i));
                else if (characterStack.isEmpty() || characterStack.pop() != brackets.charAt(indexPosition-3)) {
                    isPrecedenceCorrect = false;
                    break;
                }
            }

        }

        if (!isPrecedenceCorrect || !characterStack.isEmpty())
            System.out.println(expression + " is invalid");
        else
            System.out.println(expression + " is valid");
        sc.close();
    }
}
