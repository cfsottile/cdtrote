package laboratorio.juegocei.table;

import java.util.List;

public class Track {
    private List<SubTrack> subTracks;
    private SubTrack current;
    private int i;

    public Track(List<SubTrack> destinations, int start) {
        subTracks = destinations;
        i = start;
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
