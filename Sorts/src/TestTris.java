public class TestTris {
    public static void main(String[] args) {
        Tools tools = new Tools();

        // Création d'un tableau de 20 valeurs aléatoires
        int[] vrand = new Vector(20).fillRandom();
        int[] vspec = new Vector().fillSpecific(new int[]{4,6,2,4,3,3,2,6,1,0,4});

        // Utilitaires de tris
        Tris t = new Tris();

        // Affichage du tableau
        tools.displayVector(vspec);

        // Tri du tableau
        vspec = t.sort(vspec, Tris.SORT_DENOMBREMENT);

        // Affichage du tableau
        tools.displayVector(vspec);
    }
}
