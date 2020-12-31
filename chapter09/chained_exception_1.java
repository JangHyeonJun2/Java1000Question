package chapter09;

import java.io.IOException;

public class chained_exception_1 {
    public static void main(String[] args) {
//        try {
//              throw new ArithmeticException("Top Level Exception.").initCause(new IOException("IO cause"));
//        } catch(ArithmeticException ae) {
//            System.out.println("Caught : " + ae);
//            System.out.println("Actual cause: "+ ae.getCause());
//        }
        try{
            throw new ArithmeticException("Top Level Exception").initCause(new IOException("IO cause"));
        }catch (ArithmeticException ae){
            System.out.println("Caught : " + ae);
            System.out.println("Actual cause: "+ ae.getCause());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
