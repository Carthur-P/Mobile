package pongp1.bit;

public class ArtistData {
    protected String name;
    protected int listener;

    public ArtistData(String name, int listener){
        this.name = name;
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

    public int getListener() {
        return listener;
    }
}
