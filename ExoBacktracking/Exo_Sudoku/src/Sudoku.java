public class Sudoku {

    private int[][] grid;

    public Sudoku() {
    }

    public void solve(int[][] grid) {
        this.grid = grid;
        placeChiffre(0,0);
    }

    private void placeChiffre(int ligne, int colonne) {
        //System.out.println(ligne);
        if (ligne == 9) {
            display();
            System.out.println("---------------------------------");
            return;
        }

        for (int chiffre = 1; chiffre <= 9; chiffre++) {
            if (possiblePlacerChiffre(ligne, colonne, chiffre)) {
                //System.out.println("Chiffre "+chiffre+" posé en "+ligne+","+colonne);
                grid[ligne][colonne] = chiffre;
                int[] nextPos = findNextPos(ligne, colonne);
                //System.out.println("Prochaine case libre "+ nextPos[0]+","+nextPos[1]);
                placeChiffre(nextPos[0], nextPos[1]);
                //System.out.println("Chiffre "+chiffre+" posé en "+ligne+","+colonne);
                grid[ligne][colonne] = 0;
            }
        }
    }

    private int[] findNextPos(int x, int y) {
        y = y+1;
        //System.out.println(x+" - "+y);
        if (y >= 9) {
            x += 1;
            y = 0;
        }
        //System.out.println(x+" "+y);
        if(x == 9) {
            return new int[]{x, y};
        }
        while (grid[x][y] != 0) {
            y=y+1;
            if (y >= 9) {
                x += 1;
                y = 0;
            }
        }
        //System.out.println(x+"-"+y);
        return new int[]{x, y};
    }

    private boolean possiblePlacerChiffre(int x, int y, int chiffre) {

        // si le chiffre est présent dans la ligne
        for (int i = 0; i < grid.length; i++) {
            if(chiffre == grid[x][i])
                return false;
        }

        // si le chiffre est présent dans la colonne
        for (int i = 0; i < grid.length; i++) {
            if(chiffre == grid[i][y])
                return false;
        }

        // si le chiffre est présent dans le carré
        int xmin = 0;
        int ymin = 0;
        if(x < 3) {
            xmin = 0;
        } else if (x < 6) {
            xmin = 3;
        } else {
            xmin = 6;
        }
        if(y < 3) {
            ymin = 0;
        } else if (y < 6) {
            ymin = 3;
        } else {
            ymin = 6;
        }
        for (int i = xmin; i <= xmin+2; i++) {
            for (int j = ymin; j <= ymin+2; j++) {
                if(grid[i][j] == chiffre)
                    return false;
            }
        }
        return true;
    }

    private void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
