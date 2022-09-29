/**
 * This class creates a new song which is used in a Music Player GUI to do various tasks through buttons
 * like play, pause, rewind, fast forward, and stop.
 * 
 * @author Alex Tedesco
 */

package musicplayer;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {

    String mediaPath;
    String description;
    String imagePath;
    MediaPlayer songPlayer;

    /**
     * Creates a new Song object
     * @param mediaPath The path to the song mp3 file
     * @param description Description of the song name and artist
     * @param imagePath The path to the image of the album cover/artist
     * @param songPlayer MediaPlayer field created in the constructor
     */

    public Song (String mediaPath, String description, String imagePath) {
        this.mediaPath = mediaPath;
        this.description = description;
        this.imagePath = imagePath;
        String songUri = new File(mediaPath).toURI().toString();
        Media songMedia = new Media(songUri);
        MediaPlayer songPlayer = new MediaPlayer(songMedia);
        this.songPlayer = songPlayer;
    }

    /**
     * @return Returns the description of the song
     */

    public String getDescription() {
        return description;
    }

    /**
     * @return Returns the image or album cover of the song
     */

    public Image getImage() {
        return new Image(imagePath);
    }

    /**
     * Plays the song
     */

    public void playSong () {
        songPlayer.play();
    }

    /**
     * Pauses the song
     */

    public void pauseSong () {
        songPlayer.pause();
    }

    /**
     * Rewinds the song by 10 seconds/10000 milliseconds
     */

    public void rewindSong () {
        javafx.util.Duration rewind = new javafx.util.Duration(10000);
        songPlayer.seek(songPlayer.getCurrentTime().subtract(rewind));
    }

    /**
     * Fast forwards the song by 10 seconds/10000 milliseconds
     */

    public void fastForwardSong () {
        javafx.util.Duration fastForward = new javafx.util.Duration(10000);
        songPlayer.seek(songPlayer.getCurrentTime().add(fastForward));
    }

    /**
     * Stops the song 
     */

    public void stopSong () {
        songPlayer.stop();
    }

    /**
     * Helper method that changes the song by modifying the mediaPath, description, and imagePath fields
     * @param newSong - The Song object that becomes the new current song
     */

    public void changeSong (Song newSong) {
        mediaPath = newSong.mediaPath;
        description = newSong.description;
        imagePath = newSong.imagePath;
        String songUri = new File(mediaPath).toURI().toString();
        Media songMedia = new Media(songUri);
        this.songPlayer = new MediaPlayer(songMedia);
    }
}
