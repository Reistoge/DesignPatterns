package StructuralPatterns.Adapter.Solution;
import StructuralPatterns.Adapter.InitialCode.WeatherServiceA;
import StructuralPatterns.Adapter.InitialCode.WeatherServiceB;

public class WeatherServiceBAdapter implements WeatherServiceA {
    // The adapter has to implement the interface of the
    // service we want to adapt to basically work and return the same method
    // and encapsulate the adaptee and adapter logic to adapt
    // the WeatherServiceB to WeatherServiceA.

     WeatherServiceB  weatherServiceB; // we need a reference of the adaptee to work with them

     public WeatherServiceBAdapter() {
            // the constructor of the adapter has to be equal to the adaptee.
            this.weatherServiceB = new WeatherServiceB();
     }
    public WeatherServiceBAdapter(WeatherServiceB adaptee) {
        // the constructor of the adapter has to be equal to the adaptee.
        this.weatherServiceB = adaptee;
    }
     @Override
     public String getTemperatureInCelsius(String city) {
         System.out.println("adapting WeatherService B through WeatherServiceBAdapter... ");
         return ((weatherServiceB.getTempFahrenheit(city) - 32) * 5 / 9) + " Celsius";


     }

}
