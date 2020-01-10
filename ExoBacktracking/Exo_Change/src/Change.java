public class Change {

    static final int[] PIECES_DISPO = new int[]{50,20,10,5};
    int[] portemonnaie = new int[20];
    int solutions = 0;

    public Change() {

    }

    public int change() {
        change(0, 0, 0);
        return solutions;
    }

    private void change(int somme, int indicePiece, int position) {
        // clause de finitude
        if(somme == 100) {
            solutions++;
            affiche(portemonnaie);
            return;
        }

        // pas récursif
        for (int i = indicePiece; i < PIECES_DISPO.length; i++) {
            if(possiblePlacerPiece(PIECES_DISPO[i], somme)) {
                portemonnaie[position] = PIECES_DISPO[i];
                change(somme+PIECES_DISPO[i], i, position+1);
                portemonnaie[position] = 0;
            }
        }
    }

    private boolean possiblePlacerPiece(int piece, int somme) {
        return (somme + piece) <= 100;
    }

    private void affiche(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] != 0)
                System.out.print(tab[i] + "\t");
        }
        System.out.println("");
    }
}