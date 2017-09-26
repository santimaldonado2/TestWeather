package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Maldo on 23/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityWeather {
    @JsonProperty("coord")private Coord coord;
    @JsonProperty("main") private Weather weather;
    private String cityName;

    public CityWeather () {

    }

    public CityWeather(Coord coord, Weather weather) {
        this.coord = coord;
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "entities.CityWeather{" +
                "coord=" + coord +
                ", weather=" + weather +
                '}';
    }
}
