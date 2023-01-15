package com.example.mongodb.controller;

import com.example.mongodb.core.abstracts.IDatabaseTestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
    public UUID testDBRead() {
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
