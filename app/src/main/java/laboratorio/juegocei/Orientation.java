package laboratorio.juegocei;

public enum Orientation {
    N, S, E, W, NE, NW, SE, SW;

    public static Orientation from(float degrees) {
        if (-22.5 < degrees && degrees <= 22.5) {
            return N;
        } else if (-67.5 < degrees && degrees <= -22.5) {
            return NW;
        } else if (247.5 < degrees && degrees <= 292.5) {
            return W;
        } else if (202.5 < degrees && degrees <= 247.5) {
            return SW;
        } else if (157.5 < degrees && degrees <= 202.5) {
            return S;
        } else if (112.5 < degrees && degrees <= 157.5) {
            return SE;
        } else if (67.5 < degrees && degrees <= 112.5) {
            return E;
        } else if (22.5 < degrees && degrees <= 67.5) {
            return NE;
        } else if (-112.5 < degrees && degrees <= -67.5) {
            return NW;
        } else {
            return S;
        }
    }
}
