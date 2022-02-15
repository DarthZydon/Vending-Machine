package com.techelevator;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    public void time() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.format(formatter));
    }
}