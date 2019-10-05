public class Vector {
    int[] v;

    public Vector() {

    }

    public Vector(int size) {
        this.v = new int[size];
    }

    public int[] fillRandom() {
        for (int i = 0; i < v.length; i++) {
            int rand = (int) (Math.random() * 100) + 1;
            v[i] = rand;
        }
        return v;
    }

    public int[] fillSpecific(int[] values) {
        this.v = values;
        return v;
    }
}
