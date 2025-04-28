package StructuralPatterns.Facade.Solution;

import StructuralPatterns.Facade.Context.AudioBuffer;
import StructuralPatterns.Facade.Context.AudioDecoder;
import StructuralPatterns.Facade.Context.AudioDriver;

public class FacadeMediaPlayer {
    String song;
    AudioDecoder decoder;
    AudioBuffer buffer ;
    AudioDriver driver;

    public FacadeMediaPlayer(String song) {
        // we initialize each instance needed.
        this.decoder = new AudioDecoder();
        this.buffer = new AudioBuffer();
        this.driver = new AudioDriver();
        this.song = song;
    }
    public void turnOnMediaPlayer() {
        // refactor the main logic from the MediaPlayer,
        // we encapsulate each component logic.
        decodeSong();
        loadBuffer();
        playSong();
    }
    public void setSong(String song) {
        // we can set a new song to play.
        this.song = song;
    }
    public void  playSong(){
        driver.playSound();

    }
    public void loadBuffer(){
        buffer.loadBuffer(song);
    }
    public void decodeSong(){
        decoder.decode(song);
    }




}
