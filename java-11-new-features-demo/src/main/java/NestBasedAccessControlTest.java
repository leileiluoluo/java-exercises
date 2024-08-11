public class NestBasedAccessControlTest {

    private final int number = 10;

    private void printOuter() {
        new Inner().printInner();
    }

    private class Inner {
        private void printInner() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new NestBasedAccessControlTest().printOuter();
    }

}
