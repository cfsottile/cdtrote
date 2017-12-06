package laboratorio.juegocei;

import android.annotation.TargetApi;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Created by cristian on 5/12/17.
 */

public class Track {
    private List<SubTrack> subTracks;
    private SubTrack current;
    private int i;

    @TargetApi(24)
    public Track(List<List<Destination>> dss) {
        subTracks = dss.stream().map(SubTrack::new).collect(Collectors.toList());
        i = 0;
        current = subTracks.get(i);
    }

    public List<SubTrack> getSubTracks() {
        return subTracks;
    }

    public void setSubTracks(List<SubTrack> subTracks) {
        this.subTracks = subTracks;
    }

    public void run() {
//        * situará al caballo en el medio
//        * runSubTrack (head track)
    }

    public SubTrack get(int i) {
        return subTracks.get(i);
    }

    public SubTrack next() {
        return subTracks.get(i++);
    }

//    public SubTrack current() {
//        return subTracks.get(i-1)
//    }

    public boolean hasNext() {
        return subTracks.size() > i + 1;
    }

    public SubTrack current() {
        if (current.finished() && hasNext()) {
            i += 1;
            current = subTracks.get(i);
        }
        return current;
    }
}
