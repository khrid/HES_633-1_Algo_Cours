public class HuitDames {

    int[] dames;

    public HuitDames() {
        dames = new int[9];
    }

    public void placeDame() {
        placeDame(1);
    }

    private void placeDame(int colonne) {
        if (colonne == 9) {
            display();
            return;
        }

        for (int ligne = 1; ligne < 9; ligne++) {
            if(possibleMettreDame(colonne, ligne)) {
                dames[colonne] = ligne;
                placeDame(colonne+1);
            }
        }
    }

    private boolean possibleMettreDame(int colonne, int ligne) {

        // Est-ce que le
        for (int i = 0; i < colonne; i++) {
            if(dames[i] == ligne) {
                return false;
            }

            if(colonne - i == Math.abs(ligne-dames[i])) {
                return false;
            }
        }
        return true;
    }

    private void display() {
        for (int i = 0; i < dames.length; i++) {
            System.out.print(dames[i] + " ");
        }
        System.out.println();
    }
}
