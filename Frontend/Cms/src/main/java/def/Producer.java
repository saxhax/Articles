package def;

/**
 * Created by Akif on 27.1.2015.
 */
public class Producer {

    private static int i = 0;
    private Data data;

    public  Producer(Data data) {
        this.data = data;
    }

    public void add() throws InterruptedException {
        data.add("random" + (++i));
    }
}
