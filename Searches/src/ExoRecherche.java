public class ExoRecherche {
    public static void main(String[] args) {
        Recherche r = new Recherche(30);
        System.out.print("Vector : ");
        r.display();
        System.out.println("-----------------------------------");
        System.out.println(r.linear(10));

        System.out.println("-----------------------------------");
        int number = 25;
        int res = r.dichotomic(number);
        System.out.println("Dichotomic search for " + number + " : Found at "+ res +" in xxx iterations.");
    }
}
