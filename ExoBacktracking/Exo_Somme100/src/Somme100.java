public class Somme100 {

    private int[][] carre = new int[9][9];
    private char[] solution = new char[100];
    int solutions = 0;

    private void generer() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                carre[i][j] = i + 1;
            }
        }
    }

    public void deplace() {
        generer();
        affiche(carre);
        deplace(0, 0, 1, 0);
        System.out.println(solutions);
    }


    private void deplace(int x, int y, int somme, int indice) {
        // clause de finitude
        if (x == 8 && y == 8 && somme == 100) {
            ++solutions;
            System.out.print("" + somme + " :\t");
            affiche(solution);
            System.out.println("");
            return;
        }

        if (somme >= 100)
            return;

        // pas récursif
        if (possibleDeplacer(x, y, somme)) {
            if (y < 8) {
                solution[indice] = 'B';
                deplace(x, y + 1, somme += carre[x][y], indice + 1);
            }
            if (x < 8) {
                solution[indice] = 'D';
                deplace(x + 1, y, somme += carre[x][y], indice + 1);
            }
        }
    }

    private boolean possibleDeplacer(int x, int y, int somme) {

        return carre[x][y] + somme <= 100;

    }

    private void affiche(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private void affiche(char[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != ' ')
                System.out.print(tab[i] + "\t");
        }
    }
}
