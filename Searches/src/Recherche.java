import java.util.Arrays;

public class Recherche {
    int size;
    int v[];

    public Recherche(int size) {
        this.size = size;
        this.createVector();
    }

    public void createVector() {
        this.v = new int[size];
        for (int i = 0; i < v.length; i++) {
            int rand = (int) (Math.random() * 200) + 1;
            v[i] = rand;
        }
        Arrays.sort(this.v);
    }

    public void display() {
        for (int i = 0; i < this.v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public void displayTab(int tab[]) {
        for (int i = 0; i <= tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public void displayPortion(int debut, int fin) {
        for (int i = 0; i < this.v.length - 1; i++) {
            if (i >= debut && i <= fin) {
                System.out.print(this.v[i] + "\t");
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    public int linear(int number) {
        System.out.print("Linear search for " + number + " : ");
        int tries = 0;
        for (int i = 0; i < this.v.length; i++) {
            tries++;
            //System.out.println(number + " - " + v[i]);
            if (v[i] == number) {
                System.out.println("Found in " + tries + " iteration");
                return i;
            }
        }
        return -1;
    }

    public int dichotomic(int number) {
        boolean search = true;
        int debut = 0;
        int fin = this.v.length - 1;
        int tries = 0;
        while (debut <= fin) {
            tries++;
            int milieu = (debut + fin) / 2;
            displayPortion(debut, fin);
            if (this.v[milieu] == number) {
                return milieu;
            } else if (this.v[milieu] < number) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return -1;
    }
}
