import java.util.Scanner;

public class TripsTrapsTrull {

    public static void main(String[] args) {
        char[][] laud = {{'1', '|', '2', '|', '3'},
                {'-', '+', '-', '+', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'}};
        Mängulaud mängulaud = new Mängulaud(laud);
        while (true) {
            Mängulaud.moodustaMängulaud(laud);
            Scanner scan = new Scanner(System.in);
            System.out.print("Sisestage kuhu soovite käigu teha: ");
            int käik = scan.nextInt();
            while (Kasutaja.kasutajaKäigud.contains(käik) || Arvuti.arvutiKäigud.contains(käik)) {
                System.out.println("See koht on juba võetud. Sisestage uus number kuhu tahate käia.");
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
            System.out.println(tulemus);
        }
    }
}
