import java.util.ArrayList;

public class Kasutaja extends TripsTrapsTrull {
    // Teen globaalsed listi kasutajale, kuhu ta salvestab arvuti tehtud käigud.
    static ArrayList<Integer> kasutajaKäigud = new ArrayList<Integer>();

    // Kasutame palju erinevaid if-tingimuslauseid, mis kontrollib kuhu kasutaja käigu tegi ning asendab mängulaual oleva numbri tähega "x".
    // Kui kasutaja sisestab numbri, mis ei kuulu antud mängulauale (ehk number, mis on väiksem kui 1 ja suurem kui 9), siis väljastab programm, et sisestati valenumber.
    public static void kasutajaKäiguTegemine(char[][] mängulaud, int käik) {
        kasutajaKäigud.add(käik);
        if (käik == 1)
            mängulaud[0][0] = 'x';  // Esimene indeks näitab mängulaua rida ning teine indeks näitab veergu kuhu tahetakse oma käik teha.
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
        else
            System.out.println("Sisestasite vale numbri!");
    }
}
