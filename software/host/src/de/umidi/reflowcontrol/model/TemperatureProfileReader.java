package de.umidi.reflowcontrol.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.jfree.data.xy.XYSeries;

/**
 * Handles retrieval of temperature profiles from CSV files. Each line consists
 * of two integers: duration, temperature. The duration is given in seconds, the
 * temperature in celsius.
 */
public class TemperatureProfileReader {
    private static final Logger LOGGER = Logger.getLogger(TemperatureProfileReader.class.getName());

    /**
     * Load a given csv file containing a temperature profile
     * 
     * @param path
     */
    public static XYSeries loadFile(String path) {
        int valuesAdded = 0;
        XYSeries profile = new XYSeries("");

        // Load file
        BufferedReader fileReader = null;
        try {
            // Read file line by line
            fileReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = fileReader.readLine()) != null) {

                // Ignore lines starting with #
                if (line.startsWith("#")) {
                    continue;
                }

                // Extract duration and temperature
                String strippedLine = line.replaceAll("\\s+", "");
                String[] split = strippedLine.split(",");
                if (split.length == 2) {
                    int duration = Integer.parseInt(split[0]);
                    int temperature = Integer.parseInt(split[1]);

                    // Fill into profile XYSeries
                    for (int i = 0; i < duration; i++) {
                        profile.add(valuesAdded++, new Integer(temperature));
                    }
                } else {
                    if (!strippedLine.isEmpty()) {
                        LOGGER.warning("Ignoring illegal line: " + line);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close file
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return profile;
    }
}