package com.example.postgressqldb.csv.maper;

import com.example.postgressqldb.model.Circuit;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CircuitMapper {

    public static Set <Circuit> getByCSV(List <String> lines) {
        Set <Circuit> circuits = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            circuits.add(build(readValue));
        }
        return circuits;
    }

    private static Circuit build(String[] line) {
        var circuit = new Circuit();
        circuit.setId(Long.valueOf(line[0]));
        circuit.setName(line[2].replace("\"" , ""));
        circuit.setLocation(line[3].replace("\"" , ""));
        circuit.setCountry(line[4].replace("\"" , ""));
        circuit.setUrl(line[8].replace("\"" , ""));
        return circuit;
    }

}
