package codes;

public class RemoveOuterParentheses {
    public static void main(String[] args) {

    }

    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && counter++ > 0) str.append(c);
            else if (c == ')' && counter-- > 1) str.append(c);
        }
        return str.toString();
    }
}
