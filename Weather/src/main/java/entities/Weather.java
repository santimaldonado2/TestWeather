package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Maldo on 25/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private float temp;

    public Weather(float temp) {
        this.temp = temp;
    }

    public Weather(){

    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "entities.Weather{" +
                "temp=" + temp +
                '}';
    }
}
