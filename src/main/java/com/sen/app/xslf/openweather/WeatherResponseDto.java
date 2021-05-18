package com.sen.app.xslf.openweather;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponseDto {
	List<Map<String, Object>> weather;
	Map<String, Object> main;
	Map<String, Object> wind;
	Map<String, Object> sys;
	String name;
}
