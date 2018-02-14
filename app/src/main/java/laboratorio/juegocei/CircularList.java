package laboratorio.juegocei;

import java.util.ArrayList;
import java.util.List;

public class CircularList {
    private List<Integer> list;
    private int i;
    private int size;

    public CircularList() {
        list = new ArrayList<Integer>();
        i = 0;
        size = 0;
    }

    public void add(Integer b) {
        size++;
        list.add(b);
    }

    public Integer getNext() {
        return list.get(i++ % size);
    }
}
