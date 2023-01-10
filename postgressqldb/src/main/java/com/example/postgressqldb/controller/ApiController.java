package com.example.postgressqldb.controller;

import com.example.postgressqldb.core.abstracts.IDatabaseTestService;
import com.example.postgressqldb.model.LapTimeId;
import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final IDatabaseTestService databaseTestService;

    @GetMapping("/persist")
    public String testDBPersist(@RequestParam Long amount) {
        databaseTestService.testPersist(amount);
        return "persist executed";
    }

    @GetMapping("/read")
    public LapTimeId testDBRead() {
        databaseTestService.testReadById();
        databaseTestService.testSingleUpdate();
        return databaseTestService.testRead();
    }

    @GetMapping("/delete")
    public String testDBDelete() {
        databaseTestService.testDelete();
        return "delete executed";
    }

}
