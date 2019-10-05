public class TestHanoi {
    private static int step = 0;

    public static void main(String[] args) {
        hanoi(5, "A", "B", "C");
    }

    private static void hanoi(int n, String start, String temp, String end) {
        step++;
        // Clause de finiitude
        if (n == 1) {
            System.out.println(step + " / " + start + " -> " + end);
            return;
        }
        // Pas récursif
        hanoi(n - 1, start, end, temp);
        System.out.println(step + " / " + start + " -> " + end);
        hanoi(n - 1, temp, start, end);
    }
}
