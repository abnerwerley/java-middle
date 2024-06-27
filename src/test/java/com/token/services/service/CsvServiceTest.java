package com.token.services.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class CsvServiceTest {

    private CsvService utils;

    @BeforeEach
    void setup() {
        this.utils = new CsvService();
    }

    @Test
    void shouldReturnCsvValues() throws IOException {
        ArrayList<String> response = utils.convertCsvToString(getFile());
        assertEquals("name", response.get(0));
        assertEquals("city", response.get(1));
        assertEquals("email", response.get(2));
        assertEquals("someone", response.get(3));
        assertEquals("sao paulo", response.get(4));
        assertEquals("someone@domain.com", response.get(5));
    }


    private BufferedReader getFile() throws IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + "/src/test/resources/teste.csv";
        File file = new File(filePath);

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("name, city, email");
        bw.newLine();
        bw.write("someone,sao paulo, someone@domain.com");
        bw.flush();
        bw.close();

        FileReader fr = new FileReader(file);

        return new BufferedReader(fr);
    }
}
