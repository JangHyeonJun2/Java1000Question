package chapter09;

public class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = new String("ab");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
    }
}
