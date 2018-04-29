package laboratorio.juegocei.table;

import java.util.ArrayList;
import java.util.List;

import laboratorio.juegocei.Destination;

public class Track {
    private List<SubTrack> subTracks;
    private SubTrack current;
    private int i;

    public Track(List<SubTrack> destinations, int start) {
        subTracks = destinations;
        i = start;
        current = subTracks.get(i);
    }

    public Track(List<List<Destination>> dss) {
        subTracks = new ArrayList<>(dss.size());
        for (List<Destination> ds : dss) {
            subTracks.add(new SubTrack(ds));
        }
        i = 0;
        current = subTracks.get(i);
    }

    public boolean hasNext() {
        return subTracks.size() > i + 1;
    }

    public void prepare() {
        current.setUpPaints();
    }

    public SubTrack current() {
        if (current.finished() && hasNext()) {
            i += 1;
            current = subTracks.get(i);
            current.setUpPaints();
        }
        return current;
    }
}
