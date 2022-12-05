//package com.example.mongodb.csv.maper;
//
//import com.example.casandra.model.LapTime;
//import com.google.common.collect.Sets;
//
//import java.util.List;
//import java.util.Set;
//import java.util.UUID;
//
//public class LapTimeMapper {
//
//    public static Set <LapTime> getByCSV(List <String> lines) {
//        Set <LapTime> lapTimes = Sets.newHashSet();
//        for (int i = 1; i < lines.size(); i++) {
//            String line = lines.get(i);
//            var readValue = line.split(",");
//            lapTimes.add(build(readValue));
//        }
//        return lapTimes;
//    }
//
//    private static LapTime build(String[] readValue) {
//        var lapTime = new LapTime();
//        lapTime.setId(UUID.randomUUID());
//        lapTime.setLap(Long.valueOf(readValue[2]));
//        lapTime.setDriverId(Long.valueOf(readValue[2]));
//        lapTime.setRaceId(Long.valueOf(readValue[2]));
//        lapTime.setPosition(Long.valueOf(readValue[3]));
//        lapTime.setTime(readValue[4]);
//        lapTime.setMilliseconds(Long.valueOf(readValue[5]));
//        return lapTime;
//    }
//
//}
