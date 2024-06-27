package com.token.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Slf4j
public class CsvService {

    public ArrayList<String> convertCsvToString(BufferedReader br) throws IOException {
        String line = "";
        ArrayList<String> values = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] valueArray = line.split(",");
            log.info("Csv line values before converted to string: {}", line);
            for (String value : valueArray) {
                values.add(value.trim());
            }
        }
        br.close();
        log.info("Csv values in a String Array: {}", values);
        return values;
    }
}
