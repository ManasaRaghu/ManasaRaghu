package com.spring.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication

public class SpringSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulingApplication.class, args);
	}
	
	@FunctionalInterface
	interface TemperatureMeasurementCallback {
	    public void temperatureMeasured(int temperature);
	}
	interface Thermometer {
	    public int measure();
	}

	@Configuration
	@Import({FakeThermometer.class, WeatherForecastService.class})
	@EnableScheduling
	class Config {
	  
	    @Bean
	    public TemperatureMeasurementCallback callback() {
	        return (temperature) -> System.out.println(temperature);
	    }
		
		
	}

	@Component
	@Scope("prototype")
	class FakeThermometer implements Thermometer {

	    private int currentTemperature = 21;
	    
	    @Override
	    public int measure() { return currentTemperature++; }
	}

	@Service
	public class WeatherForecastService {

	    @Autowired
	    private Thermometer thermometer;
	    @Autowired
	    private TemperatureMeasurementCallback callback;

		@Scheduled(fixedDelay = 50)
	    public void takeTemperatureMeasurement() {
	        int temperature = thermometer.measure();
	        callback.temperatureMeasured(temperature);
	    }   
	}	

}
