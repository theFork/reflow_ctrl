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

    private String csvFilePath;
    private int valueCount;
    private XYSeries profile;

    public TemperatureProfileReader(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    /**
     * Load CSV file and create XYProfile containing setpoints
     */
    public XYSeries getSetpointSeries() {
        this.valueCount = 0;
        this.profile = new XYSeries("");

        // Load file
        BufferedReader fileReader = null;
        try {
            // Read file line by line
            fileReader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = fileReader.readLine()) != null) {
                parseLine(line);
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

    private void parseLine(String line) {
        // Ignore lines starting with #
        if (line.startsWith("#")) {
            return;
        }

        // Extract duration and temperature
        String strippedLine = line.replaceAll("\\s+", "");
        String[] split = strippedLine.split(",");

        if (split.length == 2) {
            int duration = Integer.parseInt(split[0]);
            int temperature = Integer.parseInt(split[1]);

            // Fill into profile XYSeries second-by-second
            for (int i = 0; i < duration; i++) {
                profile.add(this.valueCount++, new Integer(temperature));
            }
        } else if (!strippedLine.isEmpty()) {
            LOGGER.warning("Ignoring illegal line: " + line);
        }

    }
}