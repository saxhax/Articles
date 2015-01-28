package def;

/**
 * Created by Akif on 27.1.2015.
 */
public class Thread2  extends Thread {

    private Consumer consumer;

    public Thread2 (Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run(){
        while(true) {
            try {
                consumer.removeFirst();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
