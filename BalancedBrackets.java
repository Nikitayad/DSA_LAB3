import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                else if((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([[{ }]])";
        if(isBalanced(s)) {
            System.out.println("The entered String has Balanced Brackets");
        }
        else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}

