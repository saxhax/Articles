package def;

/**
 * Created by Akif on 27.1.2015.
 */
public class Thread1 extends Thread {

    private Producer producer;

    public Thread1(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run(){
        while (true) {
            try {
                producer.add();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
