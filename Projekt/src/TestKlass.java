import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class TestKlass {

    public static void moodustaMängulaud(char[][] mängulaud) {

        for (char[] rida : mängulaud) {
            for (char tähis : rida) {
                System.out.print(tähis);
            }
            System.out.println();
        }
    }

    public static void kasutajaKäiguTegemine(char[][] mängulaud, int käik) {
        kasutajaKäigud.add(käik);
        if (käik == 1)
            mängulaud[0][0] = 'x';
        else if (käik == 2)
            mängulaud[0][2] = 'x';
        else if (käik == 3)
            mängulaud[0][4] = 'x';
        else if (käik == 4)
            mängulaud[2][0] = 'x';
        else if (käik == 5)
            mängulaud[2][2] = 'x';
        else if (käik == 6)
            mängulaud[2][4] = 'x';
        else if (käik == 7)
            mängulaud[4][0] = 'x';
        else if (käik == 8)
            mängulaud[4][2] = 'x';
        else if (käik == 9)
            mängulaud[4][4] = 'x';
    }

    public static void arvutiKäiguTegemine(char[][] mängulaud, int käik) {
        arvutiKäigud.add(käik);
        if (käik == 1)
            mängulaud[0][0] = 'o';
        else if (käik == 2)
            mängulaud[0][2] = 'o';
        else if (käik == 3)
            mängulaud[0][4] = 'o';
        else if (käik == 4)
            mängulaud[2][0] = 'o';
        else if (käik == 5)
            mängulaud[2][2] = 'o';
        else if (käik == 6)
            mängulaud[2][4] = 'o';
        else if (käik == 7)
            mängulaud[4][0] = 'o';
        else if (käik == 8)
            mängulaud[4][2] = 'o';
        else if (käik == 9)
            mängulaud[4][4] = 'o';
        else
            System.out.println("Sisestasite vale numbri!");
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
        // Käin Võiduvõimaluste list-i läbi ning vaatan, et kas kasutaja või arvuti käikude seas on võiduvõimalus,
        // kui pole ning arvuti ja kasutaja käikude listi suurus on liites üheksa siis on viik.
        for (List järjend : võiduvõimalused) {
            if (kasutajaKäigud.containsAll(järjend))
                return "Sina võitsid";
            else if (arvutiKäigud.containsAll(järjend))
                return "Arvuti võitis";
            else if (kasutajaKäigud.size()+arvutiKäigud.size() == 9)
                return "Viik";
        }
        return "";
    }
    // Teen globaalsed list-id, kasutajale ja arvutile, et kõik meeetodid saaksid neid kasutada.
    static ArrayList<Integer> kasutajaKäigud = new ArrayList<Integer>();
    static ArrayList<Integer> arvutiKäigud = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] mängulaud = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Sisestage kuhu soovite käigu teha: ");
            int käik = scan.nextInt();
            while(kasutajaKäigud.contains(käik) || arvutiKäigud.contains(käik))
                System.out.println("See koht on juba võetud ");
                käik = scan.nextInt();
            kasutajaKäiguTegemine(mängulaud, käik);
            String tulemus = kesVõitis();
            if(tulemus.length() > 0){
                System.out.println(tulemus);
                break;
            }
            int arvutiKäik = (int) (Math.random() * 9) + 1;
            while(kasutajaKäigud.contains(arvutiKäik) || arvutiKäigud.contains(arvutiKäik))
                arvutiKäik = (int) (Math.random() * 9) + 1;
            arvutiKäiguTegemine(mängulaud, arvutiKäik);
            tulemus = kesVõitis();
            if(tulemus.length() > 0){
                System.out.println(tulemus);
                break;
            }
            moodustaMängulaud(mängulaud);
            System.out.println(tulemus);
        }
    }
}
