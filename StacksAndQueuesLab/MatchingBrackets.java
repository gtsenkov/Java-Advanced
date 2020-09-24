package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();

        ArrayDeque<Integer> subExpressionStack = new ArrayDeque<>();
        for (int index = 0; index <expression.length() ; index++) {
            char symbol = expression.charAt(index);
            if (symbol == '(') {
                subExpressionStack.push(index);
            } else if (symbol == ')') {
                int startIndex = subExpressionStack.pop();
                String subExpression = expression.substring(startIndex, index + 1);
                System.out.println(subExpression);
            }
        }
    }
}
