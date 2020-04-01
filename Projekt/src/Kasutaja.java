import java.util.ArrayList;

public class Kasutaja extends TripsTrapsTrull {
    static ArrayList<Integer> kasutajaKäigud = new ArrayList<Integer>();
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
}
