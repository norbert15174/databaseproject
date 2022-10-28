package com.example.postgressqldb.core.abstracts;

import java.util.Set;

public interface IReadCSV<T> {

    Set <T> readCSVAndSave();

}
