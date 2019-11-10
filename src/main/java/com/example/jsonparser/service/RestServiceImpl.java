package com.example.jsonparser.service;

import com.example.jsonparser.model.WeatherMap;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestServiceImpl implements RestService {

    private static final Logger logger = LogManager.getLogger(RestServiceImpl.class.getName());

    /**
     * Implements getWeatherData of RestService interface
     * @param url url to fetch data from
     * @return WeatherMap instance
     */
    @Override
    public WeatherMap getWeatherData(String url) {
        StringBuilder response = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        // Don't fail in deserialization on unknown properties
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WeatherMap weatherMap;
        try {
            logger.debug("Opening connection to REST API URL: " + url);
            URL restUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) restUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                // Throw RuntimeException if API returns response code other than 200
                String message = "Failed to get 200 response code from API";
                logger.error(message);
                throw new RuntimeException(message);
            }
            // Successfully received the response from API
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                // Read API response and add it to response variable
                response.append(output);
            }
            // disconnect the connection to the URL
            conn.disconnect();
            logger.debug("Received response from API, deserializing it");
            weatherMap = objectMapper.readValue(response.toString(), WeatherMap.class);
        } catch (MalformedURLException e) {
            String message = "Received MalformedURLException, check URL";
            logger.error(message);
            throw new RuntimeException(message);
        } catch (IOException e) {
            String message = "Error opening connection to url";
            logger.error(message);
            throw new RuntimeException(message);
        }
        return weatherMap;
    }
}
