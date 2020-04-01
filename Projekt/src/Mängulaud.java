public class Mängulaud {
    private char[][] laud;

    public Mängulaud(char[][] laud) {
        this.laud = laud;
    }

    public static void moodustaMängulaud(char[][] laud) {

        for (char[] rida : laud) {
            for (char tähis : rida) {
                System.out.print(tähis);
            }
            System.out.println();
        }
    }
}
