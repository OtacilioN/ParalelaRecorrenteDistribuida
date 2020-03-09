package school.cesar.sd.bowl;

import java.util.Random;

public class Torre implements Runnable {
    private Bowl bowl;
    private Random random;

    public Torre(Bowl bowl) {
        this.bowl = bowl;
        this.random = new Random();
    }

    protected boolean isPrecisaManutencao() {
        return random.nextInt(100) > 70;
    }

    protected boolean usarBowl() {
        System.out.println("Usando o Bowl");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
        }
        return isPrecisaManutencao();
    }

    public void run() {
        while (true) {
            if (bowl.manutencao) {
                synchronized (bowl) {
                    try {
                        bowl.wait();
                    } catch (InterruptedException e) {

                    }
                }
            } else {
                boolean necessitaManutencao = usarBowl();
                if (necessitaManutencao) {
                    bowl.manutencao = necessitaManutencao;
                    synchronized (bowl) {
                        bowl.notify();
                    }
                }
            }
        }
    }
}