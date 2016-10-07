package de.umidi.reflowcontrol.recycler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles retrieval of temperature profiles from CSV files. Each line consists
 * of two integers: duration, temperature. The duration is given in seconds, the
 * temperature in celsius.
 */
public class TemperatureProfile {

    /**
     * An array list that contains one value per second. Thus, the index
     * represents the time in seconds. Yes, this is not efficient.
     */
    private ArrayList<Integer> profile;

    /**
     * @return the profile
     */
    public ArrayList<Integer> getSetpointList() {
        return profile;
    }

    /**
     * Load a given csv file containing a temperature profile
     * 
     * @param path
     */
    public void loadFile(String path) {

        // Empty current profile
        profile = new ArrayList<Integer>();

        // Load file
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(path));
            String line;

            // Read file line by line
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
                    // Fill into profile array list
                    for (int i = 0; i < duration; i++) {
                        profile.add(new Integer(temperature));
                    }
                } else {
                    System.err.println("Ignoring illegal line: " + line);
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
    }

    /**
     * Get the temperature setpoint at a given time
     * 
     * @param second
     *            time in seconds. Starts at 0.
     * @return temperature setpoint in celsius
     */
    public int getSetpoint(int second) {
        if (profile.size() >= second) {
            return profile.get(second);
        } else {
            return profile.get(profile.size() - 1);
        }
    }
}