package com.example.postgressqldb.core.abstracts;

import com.example.postgressqldb.model.LapTimeId;

public interface IDatabaseTestService {

    void testPersist(Long number);

    LapTimeId testRead();

    void testReadById();

    void testSingleUpdate();

    void testDelete();
}
