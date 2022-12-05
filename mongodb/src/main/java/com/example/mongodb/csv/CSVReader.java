package com.example.mongodb.csv;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Service
class CSVReader implements ICSVReader {

    private final String PATH = "src/main/resources/csv/%s";

    @Override
    public List <String> readCSV(String CSVName) {
        var path = String.format(PATH , CSVName);
        try {
            var data = Files.lines(Paths.get(path) , StandardCharsets.UTF_8);
            var csvLines = data.toList();
            data.close();
            return csvLines;
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }

}
