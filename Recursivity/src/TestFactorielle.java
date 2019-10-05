public class TestFactorielle {
    public static void main(String[] args) {
        System.out.println("" + factorielle(10));
    }

    private static long factorielle(long n) {
        // Clause de finitude
        if (n == 0) {
            return 1;
        }

        // Pas récursif
        return n * factorielle(n - 1);
    }
}
