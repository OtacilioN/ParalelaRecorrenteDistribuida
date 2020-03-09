package school.cesar.sd.bowl;

public class ParqueSantana {
    public static void main(String args[]) {
        Bowl bowl = new Bowl();
        Torre torre = new Torre(bowl);
        CasaForte casaForte = new CasaForte(bowl);
        Thread threadTorre = new Thread(torre);
        Thread threadCasaForte = new Thread(casaForte);
        threadTorre.start();
        threadCasaForte.start();
    }
}
