package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SearchEngineLogger {
    //Doing the Stretch goal
    private static final String LogFile = "log.txt";
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final int DateLength = 10;
    private static final int ActionStart = 20;
    private static final String SearchMarker = "search : ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logAction("launch");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1- Search for a term");
            System.out.println("2- Show today's searches");
            System.out.println("3- Exit");
            System.out.print("Enter command: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> search(scanner);

            }
        }



        while (true) {
            System.out.print("Enter a search term (X or x to exit): ");
            String term = scanner.nextLine().trim();

            if (term.equalsIgnoreCase("x")) {
                logAction("exit");
                break;
            }

            if (term.isEmpty()) {
                continue;
            }

            logAction("search : " + term);
            System.out.println("Searching for: " + term);
        }

        System.out.println("Goodbye!");
    }

    private  static void logAction(String action) {
        String entry = LocalDateTime.now().format(TIMESTAMP) + " " + action;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LogFile, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error: Could not write to " + LogFile + ": " + e.getMessage());
        }
    }
}


//  EXERCISE 3
//      Create a Java application named search-engine-logger.
//      Create a method to log the actions of the user. Write each user action to a file named
//  logs.txt
//      Actions include:
//          a. Launching the application
//          b. Searching for a term
//          c. Exiting the application
//      In the main() method prompt the user for a search term that they wish to search.
//          Example
//              Enter a search term (X or x to exit):
//              Entries in the logs.txt file should follow this format:
//                  2026-04-22 12:42:20 launch
//                  2026-04-22 12:42:45 search : How to use ChatGPT
//                  2026-04-22 12:43:51 search : How to forge a camp knife
//                  2026-04-22 12:45:32 exit
