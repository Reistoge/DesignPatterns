package StructuralPatterns.Adapter.Context;
// New third-party library that you need to integrate (you can't modify this class)
public class WeatherServiceB {
    public double getTempFahrenheit(String location) {
        // Simulates an external API that only returns Fahrenheit
        return 77.0;
    }
}