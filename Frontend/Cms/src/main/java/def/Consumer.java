package def;
/**
 * Created by Akif on 27.1.2015.
 */
public class Consumer {

    private Data data;

    public  Consumer(Data data) {
        this.data = data;
    }

    public void removeFirst() throws InterruptedException {
        data.removeFirst();
    }
}
