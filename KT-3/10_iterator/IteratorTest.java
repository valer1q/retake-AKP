interface Iterator {
    boolean hasNext();

    String next();
}

class Playlist {
    private String[] songs = new String[10];
    private int count = 0;

    public void add(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public String getSong(int index) {
        return songs[index];
    }

    public Iterator getIterator() {
        return new PlaylistIterator(this);
    }
}

class PlaylistIterator implements Iterator {
    private Playlist playlist;
    private int index = 0;

    public PlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    public boolean hasNext() {
        return index < playlist.getCount();
    }

    public String next() {
        String song = playlist.getSong(index);
        index++;
        return song;
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");

        Iterator iterator = playlist.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Now playing: " + iterator.next());
        }
    }
}
