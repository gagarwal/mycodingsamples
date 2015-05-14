package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class reads a text file which is a key value pair separated by comma and sums up the values
 * for all keys and prints
 * </p>
 * 
 * @author BK
 */
public class FileRead
{

    /**
     * <p>
     * This class reads a text file which is a key value pair separated by comma and sums up the
     * values for all keys and prints
     * </p>
     * 
     * <p>
     * Assumptions:
     * </p>
     * <li>
     * If a key does not have a comma, ignores it and continues to read the next line. <li>If a key
     * does not have a value after comma, it ignores and continues to read the next line. <li>If a
     * value after comma is not a number, throws NumberFormatException and exists.</li>
     * 
     * @param filePath Path for the file to scan
     * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     * @throws NumberFormatException This exception is thrown if number after is not a valid number.
     */
    public static void printcount(final String filePath) throws IOException, FileNotFoundException, NumberFormatException
    {

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        Map<String, Long> nameCountMap = new HashMap<String, Long>();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null)

        {
            int commaIndex = line.indexOf(','); // get the index of ','

            int lineLength = line.length();

            // If line does not have comma and value after comma, continue processing the next
            // values
            if (commaIndex == -1 || lineLength <= commaIndex + 1)
            {
                continue;
            }

            String currentKey = line.substring(0, commaIndex);

            Long tempCount = Long.valueOf(line.substring(commaIndex + 1));

            if (nameCountMap.containsKey(currentKey))
            {
                // If map contains the key alreday, add the value to existing value
                tempCount = nameCountMap.get(currentKey) + tempCount;
            }
            nameCountMap.put(currentKey, tempCount);
        }

        for (Map.Entry entry : nameCountMap.entrySet())
        {
            System.out.println("Count for " + entry.getKey() + " is " + entry.getValue());
        }

        System.out.println();
        fileReader.close();
        bufferedReader.close();
    }
}