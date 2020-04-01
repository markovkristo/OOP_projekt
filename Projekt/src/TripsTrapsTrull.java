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

        // Kasutajalt küsimine, et kuidas ta soovib mängida.
        Scanner scanVariant = new Scanner(System.in);
        System.out.println("Sisestage, kas soovite mängida arvuti vastu või sõbraga koos. Arvuti vastu mängimiseks kirjutage 'Arvuti'.");
        System.out.print("Sõbra vastu mängimiseks kirjutage 'Sõber': ");

        String variant = scanVariant.nextLine();
        while (!"Arvuti".equals(variant) && !"Sõber".equals(variant)) {
            System.out.print("Sisestasite valesti. Peate sisestama sõnasõnalt ning suure tähega (ilma ülakomadeta) 'Arvuti' või 'Sõber': ");
            variant = scanVariant.nextLine();
        }
        System.out.println("Valisite variandi: " + variant);
        System.out.println();
        System.out.println("Mängulaud on meil selline: ");
        Mängulaud.moodustaMängulaud(laud);
        // Kasutame while tsüklit, et kõik kestab nii kaua kuni kõik on tõene.
        while (true) {

            // Scanner selleks, et kasutaja saaks sisestada enda käigu kuhu soovib käia
            Scanner scan = new Scanner(System.in);
            System.out.print("Mängija x. Käigu tegemiseks sisestage number vahemikus 1-9: ");
            int käikX = scan.nextInt();
            System.out.println();

            // While-tsükkel, millega kontrollitakse, et sisestatud käiku poleks juba tehtud ning, et käik kuuluks ikka 1-9-ni.
            while (MängijaX.mängija_x_Käigud.contains(käikX) || MängijaO.mängija_o_Käigud.contains(käikX) || käikX < 1 || käikX > 9) {
                System.out.print("See koht on juba võetud või ei kuulu antud vahemikku 1-9. Sisestage uus number kuhu tahate käia: ");
                käikX = scan.nextInt();
            }

            // Tehtud käigu panemine mängulauale.
            // Peale iga käigu tegemist, kontrollib kas kasutaja on võitnud või ei ole.
            MängijaX.mängija_x_KäiguTegemine(laud, käikX);
            String tulemus = Mängulaud.kesVõitis();
            if (tulemus.length() > 0) {
                System.out.println(tulemus);

                break;
            }

            // Kasutame if tingimuslauset, et vaadata, kuidas soovitakse mängida.
            if ("Arvuti".equals(variant)) {
                // Arvuti käigu genereerimine randomi abil.
                int arvutiKäik = (int) (Math.random() * 9) + 1;

                // Kontrollib, kas arvuti poolt tehtav käik on juba tehtud või ei ole, kui on juba tehtud siis genereerib uue arvu random-iga.
                while (MängijaX.mängija_x_Käigud.contains(arvutiKäik) || MängijaO.mängija_o_Käigud.contains(arvutiKäik)) {
                    arvutiKäik = (int) (Math.random() * 9) + 1;
                }

                //Arvuti poolt tehtava käigu lisamine mängulauale ning peale seda tehakse kontroll, kas arvuti poolt
                //tehtud käigud on mängu võitnud või ei.
                MängijaO.mängija_o_KäiguTegemine(laud, arvutiKäik);
                tulemus = Mängulaud.kesVõitis();
                if (tulemus.length() > 0) {
                    System.out.println(tulemus);
                    break;
                }
                System.out.println(tulemus);

            }
            Mängulaud.moodustaMängulaud(laud);
             if ("Sõber".equals(variant)) {
                Mängulaud.moodustaMängulaud(laud);
                Scanner scan2 = new Scanner(System.in);
                System.out.print("Mängija o. Käigu tegemiseks sisestage number vahemikus 1-9: ");
                int käikO = scan.nextInt();
                while (MängijaX.mängija_x_Käigud.contains(käikO) || MängijaO.mängija_o_Käigud.contains(käikO) || käikO < 1 || käikO > 9) {
                    System.out.print("See koht on juba võetud või ei kuulu antud vahemikku 1-9. Sisestage uus number kuhu tahate käia: ");
                    käikO = scan.nextInt();
                }
                MängijaO.mängija_o_KäiguTegemine(laud, käikO);
                Mängulaud.moodustaMängulaud(laud);
                tulemus = Mängulaud.kesVõitis();
                if (tulemus.length() > 0) {
                    System.out.println(tulemus);
                    break;
                }
                System.out.println(tulemus);
            }
        }

    }
}
