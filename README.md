# Reflow Controller
A simple-as-possible reflow oven controller. It uses the [uMIDI](https://github.com/theFork/uMIDI) board and library as microcontroller and for USB host communication. The board will be single sided, and should only use handsolderable components to avoid running into a chicken-egg-problem ;)

## General
* Mains solder terminals
* No onboard controls such as switches or LEDs
* Connect to a controller board via ribbon cable
* 3.3V power supply sourced by the controller board

## Power Switch
* Capable of switching 10A/230V AC
* Low switching frequency (1 Hz or smaller)
* Use 40A triac BTA41/600B
* Triac (BTA41/600B) driven by optotriac with zero cross detection (MOC3063)

## Temperature Sensing
* Use thermocouple (type K) for measuring the device under manufacturing on-board temperature
* Use integrated AD-converter and cold-junction compensator (MAX66745)
* Host interfaces AD-converter via SPI interface (which will be bit-banged)
