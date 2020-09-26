package StacksaAndQueuesExercises;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        String inputBrackets = scan.nextLine();
        for (int i = 0; i < inputBrackets.length(); i++) {
            char currentBracket = inputBrackets.charAt(i);
            boolean isBalanced = false;
            switch (currentBracket) {
                case ']':
                    if (!brackets.isEmpty()) {
                        if (brackets.peek() == '[') {
                            brackets.pop();
                            isBalanced = true;
                        }
                        break;
                    }
                    System.out.println("NO");
                    return;
                case '}':
                    if (!brackets.isEmpty()) {
                        if (brackets.peek() == '{') {
                            brackets.pop();
                            isBalanced = true;
                        }
                        break;
                    }
                    System.out.println("NO");
                    return;
                case ')':
                    if (!brackets.isEmpty()) {
                        if (brackets.peek() == '(') {
                            brackets.pop();
                            isBalanced = true;
                        }
                        break;
                    }
                    System.out.println("NO");
                    return;
                default:
                    brackets.push(currentBracket);
            }
        }
        if (brackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
