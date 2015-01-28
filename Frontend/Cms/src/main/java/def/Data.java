package def;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akif on 27.1.2015.
 */
public class Data {
    public static final int MAX = 5;
    private List<String> list = new ArrayList<String>();

    public synchronized void add(String value) throws InterruptedException {
        if (list.size() == MAX) {
            wait();
        }
        this.list.add(value);
        System.out.println("add" + value);
        notify();
    }

    public synchronized void removeFirst() throws InterruptedException {
        if (list.size() == 0) {
            wait();
        }
        list.remove(0);
        System.out.println("removeFirst");
        notify();
    }
}
