public class Tris {
    private int size;
    private int v[];

    public static final int SORT_SELECTION_MIN = 0;
    public static final int SORT_SELECTION_MINMAX = 1;
    public static final int SORT_BUBBLE = 2;
    public static final int SORT_COCKTAIL = 3;
    public static final int SORT_INSERTION = 4;
    public static final int SORT_DENOMBREMENT = 5;

    public Tris() {

    }

    public int[] sort(int[] array, int type) {
        int ret[] = new int[0];
        switch (type) {
            case SORT_SELECTION_MIN:
                ret = sortSelectionMin(array);
                break;
            case SORT_SELECTION_MINMAX:
                ret = sortSelectionMinMax(array);
                break;
            case SORT_BUBBLE:
                break;
            case SORT_COCKTAIL:
                ret = sortCocktail(array);
                break;
            case SORT_INSERTION:
                break;
            case SORT_DENOMBREMENT:
                ret = sortDenombrement(array);
                break;
        }
        return ret;
    }



    private int[] sortSelectionMin(int[] array) {
        int tmp[] = array;
        int left = 0;
        int iterations = 0;
        while(left < array.length-1) {
            iterations++;
            int min = 0;
            int temp = 0;
            int minPos = left;
            for (int i = left; i < array.length; i++) {
                if (i == left) {
                    min = array[i];
                } else {
                    if (array[i] < min) {
                        min = array[i];
                        minPos = i;
                    }
                }
            }
            //System.out.println("left "+ left+" [" + minPos + "]" + min);
            temp = array[left];
            array[left] = array[minPos];
            array[minPos] = temp;
            left++;
            //this.display();
        }
        System.out.println("selection min iterations : "+ iterations);
        return array;
    }

    private int[] sortSelectionMinMax(int[] array) {
        int left = 0;
        int right = array.length-1;
        int iterations = 0;
        while(left < right) {
            iterations++;
            int min = 0, max = 0, temp = 0, minPos = left, maxPos = right;
            for (int i = left; i < array.length-left; i++) {
                if (i == left) {
                    min = array[i];
                    max = array[i];
                } else {
                    if (array[i] < min) {
                        min = array[i];
                        minPos = i;
                    } else if (array[i] > max) {
                        max = array[i];
                        maxPos = i;
                    }
                }
            }
            //System.out.println("left : "+ left+" [" + minPos + "]" + min);
            //System.out.println("right : "+ right+" [" + maxPos + "]" + max);
            temp = array[left];
            array[left] = array[minPos];
            array[minPos] = temp;
            left++;

            //System.out.println("right : "+ right+" [" + maxPos + "]" + max);
            temp = array[right];
            array[right] = array[maxPos];
            array[maxPos] = temp;
            right--;
            //this.display();
        }
        System.out.println("selection minMax iterations : "+ iterations);
        return array;
    }

    private int[] sortCocktail(int[] array) {
        int tmp = 0;
        int changes = 1;
        boolean switched = true;
        int right = array.length-1;
        while (switched) {
            switched = false;
            for (int i = 0; i < right; i++) {
                if(array[i] > array[i+1]) {
                    tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    switched = true;
                }
            }

            for (int i = right-1; i > 0; i--) {
                if(array[i] > array[i+1]) {
                    tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    switched = true;
                }
            }
            //display();
            right--;
        }
        return array;
    }

    private void sortInsertion() {

    }

    private int[] sortDenombrement(int[] v) {
        int max = 0;
        for (int i = 0; i < v.length; i++) {
            if(v[i] > max) max = v[i];
        }

        int[] frequencies = new int[max+1];
        int[] sorted = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            frequencies[v[i]]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                sorted[sortedIndex] = i;
                sortedIndex++;
            }
        }
        return sorted;
    }
}
