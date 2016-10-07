package de.umidi.reflowcontrol.model;

import org.jfree.data.xy.XYSeries;

public final class ReflowModel {

    // TODO:
    // - Reflow profile
    // - Communicator
    // - Duty cylce calculation

    private final String DEFAULT_PROFILE_PATH = "profiles/test.csv";

    private Communicator communicator;

    /**
     * Series containing temperature setpoints
     */
    private XYSeries setpointSeries;

    /**
     * Series containing measured temperatures.
     */
    private XYSeries temperatureSeries;

    public ReflowModel() {

        // Init communicator
        this.communicator = new Communicator();

        // Read profile into XYSeries
        setpointSeries = TemperatureProfileReader.loadFile(DEFAULT_PROFILE_PATH);

    }
}
