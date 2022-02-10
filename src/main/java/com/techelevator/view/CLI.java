package com.techelevator.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class CLI {


    public CLI() throws IOException {

            String delimiter = "|";
            Map<String, String> map = new TreeMap<>();

            try (Stream<String> lines = Files.lines(Paths.get("vendingmachine.csv"))){
                lines.filter(line -> line.contains(delimiter)).forEach(
                        line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
                );
            }



            System.out.println(map);
        }
    }


