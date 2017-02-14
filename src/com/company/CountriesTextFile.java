package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

    public static void writeTextToFile(String fileName, String country) {

        Path filePath = Paths.get(fileName);
        File productsFile = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(
                    productsFile, true));


            out.println(country);

            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static void readText(String fileName) {
        Path filePath = Paths.get(fileName);
        File countryFile = filePath.toFile();
        StringBuilder sb = new StringBuilder();


        try {
            FileReader r = new FileReader(countryFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);
                sb.append(line).append("\n");
                line = reader.readLine();
            }

            reader.close();
            System.out.print(sb);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isDuplicate(String fileName, String country) {
        Path filePath = Paths.get(fileName);
        File countryFile = filePath.toFile();
        boolean isDuplicate = false;

        try {
            FileReader r = new FileReader(countryFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {
                if (line.equalsIgnoreCase(country)) {
                    isDuplicate = true;
                }
                line = reader.readLine();
            }
            reader.close();
            r.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return isDuplicate;
    }

    public static void deleteText(String fileName, String country) {
        ArrayList<String> array = new ArrayList<String>();
        Path filePath = Paths.get(fileName);
        File countryFile = filePath.toFile();

        /*Creates new ArrayList.
          Reads .txt file line by line
          Adds all lines in the file that do not EqualIgnoreCase the user entered country.

         */
        try {
            FileReader r = new FileReader(countryFile);
            BufferedReader reader = new BufferedReader(r);
            String line = reader.readLine();

            while (line != null) {
                if(!line.equalsIgnoreCase(country)) {
                    array.add(line);
                }
                line = reader.readLine();
            }

            reader.close();

            /*opens file, but with append set to false in order to rewrite on top of the file.
              iterates through the ArrayList printing a new line for each string gathered in the previous loop.
             */

            PrintWriter out = new PrintWriter(new FileOutputStream(
                    countryFile, false));

            for (String string: array){
                out.println(string);
            }

            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

