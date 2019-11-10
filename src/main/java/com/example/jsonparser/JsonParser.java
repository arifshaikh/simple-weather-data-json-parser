package com.example.jsonparser;

import com.example.jsonparser.model.WeatherList;
import com.example.jsonparser.model.WeatherMap;
import com.example.jsonparser.service.RestService;
import com.example.jsonparser.service.RestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class JsonParser {

    private static final Logger logger = LogManager.getLogger(JsonParser.class.getName());
    public static void main(String[] args) {
        logger.debug("Starting application");

        try {
            // Load application.properties file
            InputStream propertiesStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("application.properties");
            Properties appProperties = new Properties();
            if (propertiesStream == null ) {
                throw new IOException("Could not load application.properties file");
            }
            appProperties.load(propertiesStream);

            // Create RestServiceImpl concrete class instance using RestService as supertype
            RestService restService = new RestServiceImpl();
            // Get Weather data using rest service instance
            WeatherMap weatherData = restService.getWeatherData(appProperties.getProperty("weatherdata.api.url"));
            List<WeatherList> weatherList = weatherData.getList();
            // Filter names of cities starting with letter T and collect it in a list
            List<WeatherList> filteredNames = weatherList
                    .stream()
                    .filter(o -> o.getName().startsWith("T"))
                    .collect(Collectors.toList());
            logger.info("Cities starting with letter T: " + filteredNames);
            logger.info("Number of cities with name starting with T: " + filteredNames.size());

        } catch (IOException e) {
            logger.error("Error getting application.properties file");
        }
    }
}
