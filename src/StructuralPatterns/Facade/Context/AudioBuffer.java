package StructuralPatterns.Facade.Context;

public class AudioBuffer {
    public void loadBuffer(String filePath) {
        System.out.println("Buffering audio file: " + filePath);
    }
}