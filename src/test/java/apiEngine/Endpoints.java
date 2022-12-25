package apiEngine;


public class Endpoints {

    public String getBaseUri() {
        return System.getProperty("baseWeatherURL");
    }

    public String getWeatherEndpoint() {
        return System.getProperty("weatherDataEndpoint");
    }
}
