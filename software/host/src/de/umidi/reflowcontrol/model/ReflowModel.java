package de.umidi.reflowcontrol.model;

public final class ReflowModel {

    // TODO:
    // - Reflow profile
    // - Communicator
    // - Duty cylce calculation

    private TemperatureProfile temperatureProfile;
    private Communicator communicator;

    public ReflowModel() {

        // Load default temperature profile
        temperatureProfile = new TemperatureProfile();

        // Init communicator
        communicator = new Communicator();
    }
}
