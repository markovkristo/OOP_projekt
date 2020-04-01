import java.util.Scanner;

public class TripsTrapsTrull {

    public static void main(String[] args) {

        char[][] laud = {{'1', '|', '2', '|', '3'},
                {'-', '+', '-', '+', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'}};

        // Mängulaua loomine
        Mängulaud mängulaud = new Mängulaud(laud);

        // Kasutame while tsüklit, et kõik kestab nii kaua kuni kõik on tõene.
        while (true) {


            // Scanner selleks, et kasutaja saaks sisestada enda käigu kuhu soovib käia

            Mängulaud.moodustaMängulaud(laud);

            Scanner scan = new Scanner(System.in);
            System.out.print("Käigu tegemiseks sisestage number vahemikus 1-9: ");
            int käik = scan.nextInt();
            System.out.println();

            // While-tsükkel, millega kontrollitakse, et sisestatud käiku poleks juba tehtud ning, et käik kuuluks ikka 1-9-ni.
            while (Kasutaja.kasutajaKäigud.contains(käik) || Arvuti.arvutiKäigud.contains(käik) || käik < 1 || käik > 9) {
                System.out.println("See koht on juba võetud või ei kuulu antud vahemikku 1-9. Sisestage uus number kuhu tahate käia.");
                käik = scan.nextInt();
            }

            // Tehtud käigu panek mängulauale.
            // Peale igat käigu tegemist, kontrollib kas kasutaja on võitnud või ei ole.
            Kasutaja.kasutajaKäiguTegemine(laud, käik);
            String tulemus = Mängulaud.kesVõitis();
            if (tulemus.length() > 0) {
                System.out.println(tulemus);
                break;
            }

            // Arvuti käigu genereerimine randomi abil.
            int arvutiKäik = (int) (Math.random() * 9) + 1;

            // Kontrollib, kas arvuti poolt tehtav käik on juba tehtud või ei ole, kui on juba tehtud siis genereerib uue arvu random-iga.
            while (Kasutaja.kasutajaKäigud.contains(arvutiKäik) || Arvuti.arvutiKäigud.contains(arvutiKäik)) {
                arvutiKäik = (int) (Math.random() * 9) + 1;
            }

            // Arvuti poolt tehtava käigu lisamine mängulauale ning peale seda tehakse jälle kontroll, kas arvutil poolt
            //tehtud käigud on mängu võitnud või ei.
            Arvuti.arvutiKäiguTegemine(laud, arvutiKäik);
            tulemus = Mängulaud.kesVõitis();
            if (tulemus.length() > 0) {
                System.out.println(tulemus);
                break;
            }
            System.out.println(tulemus);
        }
        Mängulaud.moodustaMängulaud(laud);
    }
}
