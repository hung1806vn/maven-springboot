package com.sen.app.xslf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sen.app.xslf.constant.APIResource;
import com.sen.app.xslf.entity.WeatherHistory;
import com.sen.app.xslf.openweather.OpenWeatherClient;
import com.sen.app.xslf.service.WeatherHistoryService;

@RestController
@RequestMapping(APIResource.WEATHER_API)
public class WeatherController {

	@Autowired
	private WeatherHistoryService service;

	@Autowired
	private OpenWeatherClient clientService;

	@GetMapping(value = "/history")
	public ResponseEntity<Object> getWeatherHistories() {

		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/city/{city}")
	public ResponseEntity<Object> getWeatherByCity(@PathVariable("city") String city) {
		WeatherHistory en = clientService.getWeatherByCity(city);
		if (en != null) {
			return ResponseEntity.ok(service.save(en));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(String.format("Cannot check weather of this %s", city));
		}

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateHistoryById(@PathVariable("id") Long id, @RequestBody WeatherHistory en) {
		en.setId(id);
		return ResponseEntity.ok(service.save(en));

	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteHistoryById(@PathVariable("id") Long id) {
		service.deleteById(id);

	}

}