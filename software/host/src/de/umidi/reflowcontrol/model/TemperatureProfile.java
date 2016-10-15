package de.umidi.reflowcontrol.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.jfree.data.xy.XYSeries;

public class TemperatureProfile {
    private static final Logger LOGGER = Logger.getLogger(TemperatureProfile.class.getName());

    private String csvFilePath;
    private int valueCount;
    private XYSeries profile;

    public TemperatureProfile(String csvFilePath) {
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

        // Strip whitespace and split line
        String strippedLine = line.replaceAll("\\s+", "");
        String[] split = strippedLine.split(",");

        // There should be two elements; Else return
        if (split.length != 2) {
            if (!strippedLine.isEmpty()) {
                // Warn if a non-empty line does not contain two elements
                LOGGER.warning("Ignoring illegal line: " + line);
            }
            return;
        }
        String durationString = split[0];
        String temperaturesString = split[1];

        int duration = Integer.parseInt(durationString);

        // Test whether temperature contains ".."
        if (temperaturesString.contains("..")) {
            // Expect two integers separated by two dots
            // TODO

        } else {
            // No dots -> Constant temperature
            int temperature = Integer.parseInt(temperaturesString);

            // Insert into profile XYSeries second-by-second
            for (int i = 0; i < duration; i++) {
                profile.add(this.valueCount++, new Integer(temperature));
            }
        }

    }
}