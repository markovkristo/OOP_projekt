import java.util.ArrayList;

public class Arvuti extends TripsTrapsTrull {
    static ArrayList<Integer> arvutiKäigud = new ArrayList<Integer>();
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
}
