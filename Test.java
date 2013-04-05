import java.util.*;
public class Test {
    public static void main(String args[]) {
        Random generator = new Random(1);
        for (int d = 0; d < 1000; d++) {
            System.out.println(generator.nextInt(100) + 1);
        }
    }
}