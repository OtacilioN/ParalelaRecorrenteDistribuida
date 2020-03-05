package school.cesar;

import java.util.concurrent.CountDownLatch;

public class Exec {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int count = 10;
        int iter = 1000000;
        Conc conc = new Conc();
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            IncRun incRun = new IncRun(conc, iter, latch);
            Thread t = new Thread(incRun);
            t.start();
        }
        latch.await();

        System.out.println("elapsed " + (System.currentTimeMillis() - start));
        System.out.println("Expected: " + (iter * count) + " result: " + conc.i + " Diff: " + (iter * count - conc.i));
    }
}
