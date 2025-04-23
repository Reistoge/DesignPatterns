package StructuralPatterns.Facade.InitialCode;


public class MediaPlayer {

    public void turnOnMediaPlayer() {
        String song = "song.mp3";

        AudioDecoder decoder = new AudioDecoder();
        decoder.decode(song);

        AudioBuffer buffer = new AudioBuffer();
        buffer.loadBuffer(song);

        AudioDriver driver = new AudioDriver();
        driver.playSound();
    }
}