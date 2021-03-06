import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Mängulaua klass. Võtab argumendiks kahekordse järjendi (3x3), millest valmistab mängulaua. Lisaks kontrollib võiduvõimalused üle ning mängu lõpus väljastab, kes võitis.
//Klass on vajalik, kuna mängul peab olema mängulaud ning ka viis määrata võitja.
public class Mängulaud extends TripsTrapsTrull {
    private static char[][] laud;

    // Mängulaua konstruktor
    public Mängulaud(char[][] laud) {
        this.laud = laud;
    }

    // Mängulaua moodustamiseks vajalik meetod, kus on kasutatud topelt for-tsüklit.
    // Esimene for-tsükkel võtab mängulaua rea ning teine for-tsükkel teeb sellele vastava veeru.
    // Parameetriks võtab laua maatriksi, mis on defineeritud peameetodis.
    public static void moodustaMängulaud(char[][] laud) {

        for (char[] rida : laud) {
            for (char tähis : rida) {
                System.out.print(tähis);
            }
            System.out.println();
        }
    }

    //Meetod, mis otsustab, kes mängu võitis.
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
        // Käime võiduvõimaluste list-i läbi ning vaatame, kas kasutajakäikude list-is või arvutikäikude list-is on võiduvõimalus,
        // kui pole ning arvuti ja kasutaja käikude listi suurus on kokku liites üheksa siis on viik.
        for (List järjend : võiduvõimalused) {

            if (MängijaX .mängija_x_Käigud.containsAll(järjend)){
                Mängulaud.moodustaMängulaud(laud);
                return "Mängija X võitis. ";}
            else if (MängijaO.mängija_o_Käigud.containsAll(järjend)){
                Mängulaud.moodustaMängulaud(laud);
                return "Mängija O võitis. ";}
            else if (MängijaX .mängija_x_Käigud.size() + MängijaO.mängija_o_Käigud.size() == 9){
                Mängulaud.moodustaMängulaud(laud);
                return "Mäng jäi viiki.";}
        }
        return "";
    }

}
