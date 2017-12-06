package laboratorio.juegocei;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by cristian on 5/12/17.
 */

public class Track {
    private List<SubTrack> subTracks;

    public Track(List<SubTrack> subTracks) {
        this.subTracks = subTracks;
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
}
