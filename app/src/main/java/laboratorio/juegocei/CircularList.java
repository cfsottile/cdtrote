package laboratorio.juegocei;

import java.util.ArrayList;
import java.util.List;

public class CircularList {
    private List<Integer> list;
    private int i;
    private final int size = 20;

    public CircularList() {
        list = new ArrayList<Integer>(size);
        i = 0;
    }

    public void add(Integer b) {
        list.add(b);
    }

    public Integer getNext() {
        return list.get(i++ % size);
    }
}
