import java.util.ArrayList;
//Mängija O klass. Sõltuvalt mängualgsest otsusest, kas mängitakse arvuti vastu või sõbra vastu, väljastab klass, kas teise mängija sisestuse või siis arvuti poolt valitud sisestuse.
//Klass on vajalik, et saada teise mängija sisestused või lasta arvutil valida oma siestuse, et esimesel mängijal oleks ka vastanae.
public class MängijaO extends TripsTrapsTrull {
    // Teen globaalsed list-i arvutile, kuhu ta salvestab arvuti tehtud käigud.
    static ArrayList<Integer> mängija_o_Käigud = new ArrayList<Integer>();

    // Kasutame palju erinevaid if-tingimuslauseid, mis kontrollib kuhu arvuti käigu tegi ning asendab mängulaual oleva numbri tähega "o".
    public static void mängija_o_KäiguTegemine(char[][] mängulaud, int käik) {
        mängija_o_Käigud.add(käik);
        if (käik == 1)
            mängulaud[0][0] = 'o';  // Esimene indeks näitab mängulaua rida ning teine indeks näitab veergu kuhu arvuti tahab oma käiku teha.
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
    }
}
