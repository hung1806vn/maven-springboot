package com.sen.app.xslf.openweather;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sen.app.xslf.entity.WeatherHistory;
import com.sen.app.xslf.utils.AppUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenWeatherClient {
	@Value("${weather.apikey}")
	private String apikey;

	@Value("${weather.domain}")
	private String domain;

	private String REQUEST_URI = "%s/weather?q=%s&appid=%s";

	
	@Autowired
	private RestTemplate restTemplate;
	
	public WeatherHistory getWeatherByCity(String city) {
		String url = String.format(REQUEST_URI,domain,city,apikey);
		try {
			ResponseEntity<WeatherResponseDto> res = restTemplate.getForEntity(url, WeatherResponseDto.class);
			if(res.getStatusCode().equals(HttpStatus.OK)) {
				WeatherResponseDto dto = res.getBody();
				WeatherHistory en = new WeatherHistory();
				en.setCity(dto.getName());
				en.setCountry(MapUtils.getString(dto.getSys(), "country"));
				en.setWeather(MapUtils.getString(dto.getWeather().get(0), "main"));
				en.setWeatherDescription(MapUtils.getString(dto.getWeather().get(0), "description"));
				en.setCountry(MapUtils.getString(dto.getSys(), "country"));
				en.setTemperature(MapUtils.getInteger(dto.getMain(), "temp"));
				en.setWindSpeed(MapUtils.getInteger(dto.getWind(), "speed"));
				en.setHistoryDate(AppUtils.getCurrentDateTime());
				return en;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}
}
