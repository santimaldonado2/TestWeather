package controller;

import entities.CityWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Maldo on 25/9/2017.
 */

@Controller
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/weather")
    public String greeting(@RequestParam(value="city_name",defaultValue = "London") String cityName, Model model) {
        CityWeather city = callWeatherApi(cityName);
        model.addAttribute("city", city);
        return "weather";
    }

    public CityWeather callWeatherApi(String city){
        String key = "ca147896cad69f2c6e786ee7177c9882";
        String url = "http://api.openweathermap.org/data/2.5/weather";
        StringBuilder callUrl= new StringBuilder();
        callUrl.append(url);
        callUrl.append("?q=");
        callUrl.append(city);
        callUrl.append("&appid=");
        callUrl.append(key);

        RestTemplate restTemplate = new RestTemplate();
        entities.CityWeather cityWeather = restTemplate.getForObject(callUrl.toString(), entities.CityWeather.class);
        cityWeather.setCityName(city);
        return cityWeather;

    }
}
