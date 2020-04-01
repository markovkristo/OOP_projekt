import java.util.ArrayList;

public class MängijaX extends TripsTrapsTrull {
    // Teen globaalsed listi kasutajale, kuhu ta salvestab arvuti tehtud käigud.
    static ArrayList<Integer> mängija_x_Käigud = new ArrayList<Integer>();

    // Kasutame palju erinevaid if-tingimuslauseid, mis kontrollib kuhu kasutaja käigu tegi ning asendab mängulaual oleva numbri tähega "x".
    public static void mängija_x_KäiguTegemine(char[][] mängulaud, int käik) {
        mängija_x_Käigud.add(käik);
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
    }
}
