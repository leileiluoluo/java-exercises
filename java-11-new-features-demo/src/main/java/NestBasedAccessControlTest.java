public class NestBasedAccessControlTest {

    private int number = 10;

    private void printOuter() {
        new Inner().printInner();
    }

    private class Inner {
        private void printInner() {
            number += 10;
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new NestBasedAccessControlTest().printOuter();
    }

}
