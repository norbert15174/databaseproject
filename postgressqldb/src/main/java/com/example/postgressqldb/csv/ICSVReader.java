package com.example.postgressqldb.csv;

import java.util.List;

public interface ICSVReader {
    List <String> readCSV(String CSVName);
}
