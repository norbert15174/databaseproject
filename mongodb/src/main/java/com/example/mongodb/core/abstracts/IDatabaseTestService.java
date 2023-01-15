package com.example.mongodb.core.abstracts;

import java.util.UUID;

public interface IDatabaseTestService {

    void testPersist(Long number);

    UUID testRead();

    void testReadById();

    void testSingleUpdate();

    void testDelete();
}
