package com.pluralsight;

import java.time.format.DateTimeFormatter;

public class SearchEngineLogger {
    private static final String LogFile = "log.txt";
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args){

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