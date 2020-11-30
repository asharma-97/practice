package codes.java;

public class Maximum69Num {
    public static void main(String[] args) {

    }
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        String s1 = s.replaceFirst("6", "9");
        return new Integer(s1);
    }
}
