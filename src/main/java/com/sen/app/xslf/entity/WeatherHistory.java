package com.sen.app.xslf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "WeatherHistories")
@Getter
@Setter
public class WeatherHistory{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Weather", length = 100, nullable = false )
	private String weather;
	
	@Column(name = "WeatherDescription", length = 500, nullable = true )
	private String weatherDescription;
	
	@Column(name = "Temperature", nullable = false )
	private Integer temperature;
	
	@Column(name = "WindSpeed", nullable = false  )
	private Integer windSpeed;
	
	@Column(name = "Country", length = 100, nullable = false )
	private String country;
	
	@Column(name = "City", length = 50, nullable = false )
	private String city;
	
	@Column(name = "HistoryDate", nullable = false )
	private Date historyDate;
}
