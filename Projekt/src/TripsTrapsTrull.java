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
        Mängulaud.moodustaMängulaud(laud);
        // Kasutame while tsüklit, et kõik kestab nii kaua kuni kõik on tõene.
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Käigu tegemiseks sisestage number vahemikus 1-9: ");
            int käik = scan.nextInt();
            System.out.println();


            while (Kasutaja.kasutajaKäigud.contains(käik) || Arvuti.arvutiKäigud.contains(käik) || käik < 1 || käik >9) {
                System.out.println("See koht on juba võetud või ei kuulu antud vahemikku 1-9. Sisestage uus number kuhu tahate käia.");
                käik = scan.nextInt();
            }
            Kasutaja.kasutajaKäiguTegemine(laud, käik);
            String tulemus = Mängulaud.kesVõitis();
            if (tulemus.length() > 0) {
                System.out.println(tulemus);
                break;
            }
            int arvutiKäik = (int) (Math.random() * 9) + 1;
            while (Kasutaja.kasutajaKäigud.contains(arvutiKäik) || Arvuti.arvutiKäigud.contains(arvutiKäik)) {
                arvutiKäik = (int) (Math.random() * 9) + 1;
            }
            Arvuti.arvutiKäiguTegemine(laud, arvutiKäik);
            tulemus = Mängulaud.kesVõitis();
            if (tulemus.length() > 0) {
                System.out.println(tulemus);
                break;
            }
            Mängulaud.moodustaMängulaud(laud);
            System.out.println(tulemus);
        }
        Mängulaud.moodustaMängulaud(laud);
    }
}
