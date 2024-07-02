import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    public boolean addSong(String songTitle, double songDuration) {
        return songList.add(new Song(songTitle, songDuration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (songList.findSong(index) != null) {
            return playlist.add(songList.findSong(index));
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        if (songList.findSong(songTitle) != null) {
            return playlist.add(songList.findSong(songTitle));
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return (ArrayList<Song>) songList.songs;
    }

    private class SongList {
        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                System.out.println("Song " + song.getTitle() + " is already added\n");
                return false;
            }
            else {
                songs.add(song);
                System.out.println("Song " + song.getTitle() + " has been added to album: "+ name + "\n");
                return true;
            }
        }

        private Song findSong(String songTitle) {
            for (Song song : songs) {
                if (song.getTitle().equals(songTitle))
                    return song;
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            if (trackNumber < 0 || trackNumber > songs.size()) {
                System.out.println("No song with such track number found in " + name + "\n");
                return null;
            }
            else {
                return songs.get(trackNumber);
            }
        }
    }
}
