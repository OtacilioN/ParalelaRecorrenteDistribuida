package school.cesar;

import java.util.concurrent.CountDownLatch;

public class IncRun implements Runnable {
    private final Conc conc;
    private final int iter;
    private final CountDownLatch latch;

    public void run() {
        for (int c = 0; c < this.iter; c++) {
            // To fix the concurrency problem add a:
            // synchronized (conc) {
            // conc.i++;
            // }
            conc.i++;
        }
        latch.countDown();
    }

    public IncRun(Conc conc, int iter, CountDownLatch latch) {
        this.conc = conc;
        this.iter = iter;
        this.latch = latch;
    }
}