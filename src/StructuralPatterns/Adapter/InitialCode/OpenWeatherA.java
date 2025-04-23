package StructuralPatterns.Adapter.InitialCode;
// Current implementation you're using
public class OpenWeatherA implements WeatherServiceA{
    @Override
    public String getTemperatureInCelsius(String city) {
        return "25ºc in " + city;
    }
}
