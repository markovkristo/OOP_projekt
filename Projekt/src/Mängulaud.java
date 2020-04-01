import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mängulaud extends TripsTrapsTrull {
    private char[][] laud;

    public Mängulaud(char[][] laud) {
        this.laud = laud;
    }

    public static void moodustaMängulaud(char[][] laud) {

        for (char[] rida : laud) {
            for (char tähis : rida) {
                System.out.print(tähis);
            }
            System.out.println();
        }
    }
    public static String kesVõitis() {
        // Võiduvõimalused
        List ülemineRida = Arrays.asList(1, 2, 3);
        List keskmineRida = Arrays.asList(4, 5, 6);
        List alumineRida = Arrays.asList(7, 8, 9);
        List vasakVeerg = Arrays.asList(1, 4, 7);
        List keskmineVeerg = Arrays.asList(2, 5, 8);
        List paremVeerg = Arrays.asList(3, 6, 9);
        List diagonaal1 = Arrays.asList(1, 5, 9);
        List diagonaal2 = Arrays.asList(3, 5, 7);
        // Lisan kõik võiduvõmalused ühte list-i
        List<List> võiduvõimalused = new ArrayList<List>();
        võiduvõimalused.add(ülemineRida);
        võiduvõimalused.add(keskmineRida);
        võiduvõimalused.add(alumineRida);
        võiduvõimalused.add(vasakVeerg);
        võiduvõimalused.add(keskmineVeerg);
        võiduvõimalused.add(paremVeerg);
        võiduvõimalused.add(diagonaal1);
        võiduvõimalused.add(diagonaal2);
        // Käin Võiduvõimaluste list-i läbi ning vaatan, et kas kasutaja või arvuti käikude seas on võiduvõimalus,
        // kui pole ning arvuti ja kasutaja käikude listi suurus on liites üheksa siis on viik.
        for (List järjend : võiduvõimalused) {
            if (Kasutaja.kasutajaKäigud.containsAll(järjend))
                return "Sina võitsid";
            else if (Arvuti.arvutiKäigud.containsAll(järjend))
                return "Arvuti võitis";
            else if (Kasutaja.kasutajaKäigud.size()+Arvuti.arvutiKäigud.size() == 9)
                return "Viik";
        }
        return "";
    }
}
