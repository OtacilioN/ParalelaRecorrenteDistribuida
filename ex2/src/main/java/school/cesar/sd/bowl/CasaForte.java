package school.cesar.sd.bowl;

public class CasaForte implements Runnable {
    private Bowl bowl;

    public CasaForte(Bowl bowl) {
        this.bowl = bowl;
    }

    protected void efetuarManutencao() {
        System.out.println("Efetuando manutenção");
        try {
            Thread.currentThread().sleep(13000);
        } catch (InterruptedException e) {
        }
        bowl.manutencao = false;
        synchronized (bowl) {
            bowl.notify();
        }
    }

    public void run() {
        while (true) {
            if (bowl.manutencao) {
                efetuarManutencao();
            } else {
                synchronized (bowl) {
                    try {
                        bowl.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

}