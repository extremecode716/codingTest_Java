package codingTest.TestCode_BackJoon.Basic.Star;

public class Main {

    public static void main(String[] args) {
        printStar(3);
    }

    static void printStar(int end) {
        for (int i = 0; i < end; ++i) {
            for (int j = 0; j < (end - i - 1) * 2; ++j) {
                System.out.printf(" ");
            }
            for (int c = 0; c < i * 2 + 1; ++c) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
