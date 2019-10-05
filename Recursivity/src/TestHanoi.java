public class TestHanoi {
    private static int step = 0;

    public static void main(String[] args) {
        hanoi(33, "A", "B", "C");
    }

    private static void hanoi(int n, String start, String temp, String end) {
        // Clause de finiitude
        if (n == 0) {
            return;
        }
        // Pas récursif
        hanoi(n - 1, start, end, temp);
        step++;
        System.out.println(step + " \t " + start + " -> " + end);
        hanoi(n - 1, temp, start, end);
    }
}
