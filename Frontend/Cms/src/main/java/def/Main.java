package def;

/**
 * Created by Akif on 27.1.2015.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        Thread1 thread1 = new Thread1(producer);
        Thread2 thread2 = new Thread2(consumer);
        thread1.start();
        thread2.start();
    }
}
