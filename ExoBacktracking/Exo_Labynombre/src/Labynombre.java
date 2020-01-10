public class Labynombre {
    private int[][] labyrinthe;
    private int[][] solution = new int[20][20];

    static final int[] DELTAL = {-1, 0, 1, 0};
    static final int[] DELTAC = {0, 1, 0, -1};
    static final int[] VALEUR = {-5, 2, 3, -4};


    public Labynombre(int[][] labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    public void solve() {
        solve(0, 6, 1);
    }

    private void solve(int x, int y, int numero) {
        // clause de finitude
        if (isAtTheEnd(x, y)) {
            affiche(solution);
            return;
        }

        // 4 mouvements
        for (int i = 0; i < 4; i++) {

            int ligneTest = x + DELTAL[i];
            int colTest = y + DELTAC[i];
            int sommeTest = labyrinthe[x][y] + VALEUR[i];


            if (possibleAvancer(ligneTest, colTest, sommeTest)) {
                solution[ligneTest][colTest] = numero;
                solve(ligneTest, colTest, numero + 1);
                solution[ligneTest][colTest] = 0;
            }
        }

    }

    private boolean possibleAvancer(int ligne, int colonne, int somme) {
        if(ligne < 0 || ligne > 20) {
            return false;
        }
        if(colonne < 0 || colonne > 20) {
            return false;
        }
        return labyrinthe[ligne][colonne] == somme;
    }

    private boolean isAtTheEnd(int x, int y) {
        if (x == 13 && y == 0)
            return true;

        if (x == 19 && y == 8)
            return true;

        if (x == 13 && y == 19)
            return true;

        return false;
    }



    private void affiche(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if(matrice[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(matrice[i][j] + "\t");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
