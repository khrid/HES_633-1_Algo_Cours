public class TestFibonacci {
    public static void main(String[] args) {
        System.out.println(fibonnaci(8));
    }

    static int fibonnaci(int n) {
        // clause de finitude
        if(n <= 1) {
            return n;
        }
        // pas récursif
        return fibonnaci(n-1) + fibonnaci(n-2);
    }
}
