package org.example;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class DequeBracketBalanceCheck {
    static boolean checkBracketsBalanced(String expr)
    {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            char check;
            try {
                switch (x) {
                    case ')' -> {
                        check = stack.pop();
                        if (check == '{' || check == '[')
                            return false;
                    }
                    case '}' -> {
                        check = stack.pop();
                        if (check == '(' || check == '[')
                            return false;
                    }
                    case ']' -> {
                        check = stack.pop();
                        if (check == '(' || check == '{')
                            return false;
                    }
                }
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // Driver code
    public static void main(String[] args) {
        /*
         Используйте ArrayDeque для проверки синтаксиса математического выражения (относительно (){}[]).
         Пример: {(1+2+3)(5-2)*3}-5 верно, а {1+2+3)(5-2)*3}-5 неверно. Ваша программа должна уметь
         вычислять математическое выражение и давать окончательный результат. Учтите, что все числа
         являются целыми числами, и возможные операции над ними: вычитание (-), сложение (+) и умножение
         (*).
         */

        String expr = "{1+2+3)(5-2)*3}-5";

        // Function call
        if (checkBracketsBalanced(expr)) {
            System.out.println("Скобки сбалансированы ");
            Expression expression = new ExpressionBuilder(expr).build();
            System.out.println("Result: " + expression.evaluate());

        } else {
            System.out.println("Скобки не сбалансированы");
        }
    }
}
