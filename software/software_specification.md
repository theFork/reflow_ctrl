# System Overview
The system consists of a
* host system (linux-capable computer), a
* uMIDI board, the
* reflow controller board, a
* type K thermocouple as well as a
* a pizza oven.

------------------------------------------------------------------------------

# MCU firmware

## Reflow Board Interface
The reflow board IS connected to uMIDI header GPIO1 as follows:

2: PWR
5: SCK
7: CS_n
9: SO

The reflow board IS equipped with a MAX6675 cold junction compensator and
AD-conversion chip.

## Host Interface
The uMIDI board is attached to the host system via USB and acts as a TTY device.

### Oven Shot
Activates the oven for a given duration in milliseconds:
``` 
shot <T>
```

The uMIDI board activates the oven for the given duration.
After activation it acknoledges by echoeing the shot command
with the given duration.

### Measure Temperature
Using the temp command

```
temp
```

the host requests the current temperature. The uMIDI replies in celius.

------------------------------------------------------------------------------

# Host Software
* Implemented in Python (3 or greater)
* Command line interface
* Create a temperature plot
* Implement temperature control to apply a given temperature profile

## Temperature profile
A profile consists of the following parameters, wheras upper case T stands for
a temperature whereas a lower case t represents a duration.
* T_preheat
* t_preheat
* T_reflow
* t_reflow
* T_max

The controller should not exceed T_max for more than 5s.

The profile MAY also define a maximum ramp down rate.

## Temperature plot
* A time curve of the temperature
* MUST be updated automaticaly
* SHOULD include a live view of the current temperature

SHOULKD be implemented using a python plot library (pyplot or mathplotlib), MAY also be
implemented using Gnuplot.
