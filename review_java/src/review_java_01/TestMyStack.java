package review_java_01;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-02
 * Time: 9:00
 */
public class TestMyStack {

    /*public boolean IsPopOrder(int [] pushA,int [] popA) {
        int j = 0;
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            int puch = pushA[i];
            integerStack.push(puch);
            int m = i - j;
            for (int k = 0; k <= m; k++) {
                if (integerStack.peek() == popA[j]){
                    integerStack.pop();
                    j++;
                }
            }
        }
        if (j == popA.length)
            return true;
        return false;
    }*/
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]){
                j++;
                stack.pop();
            }
        }
        if (stack.isEmpty() && j == popA.length) return true;
        return false;
    }


    public static boolean judgeParenthesesMatching(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{'){
                stack.push(ch);
            }else {
                if (stack.isEmpty()) return false;
                switch (ch){
                    case ')':
                        if (stack.pop() != '(')
                            return false;
                        break;
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    public static boolean isOperations(String s){
        if (s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/"))
            return true;
        return false;
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperations(tokens[i])){
                stack.push(tokens[i]);
            }else {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                switch (tokens[i]){
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }


    public static void main(String[] args) {

    /*MyStack<Integer> integerMyStack = new MyStack<>();
    integerMyStack.push(10);
    integerMyStack.push(11);
    integerMyStack.push(12);
    integerMyStack.push(13);
    System.out.println(integerMyStack.peek());*/


    int[] puchA = {1,2,3,4,5};
    int[] popA = {4,5,3,2,1};
    System.out.println(IsPopOrder(puchA, popA));

    String str = "({(())()}[])";
    System.out.println(judgeParenthesesMatching(str));


    String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    System.out.println(evalRPN(tokens));


    }
}
