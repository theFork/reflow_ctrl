# Reflow Controller
A simple-as-possible reflow oven controller. It uses the [uMIDI](https://github.com/theFork/uMIDI) board and library as microcontroller and for USB host communication.

* 3.3V and 5V sourced from the controller board (uMIDI)
* Solid state relais Finder 77.11..9.8251 (15A) to power an oven from a low current 5V signal
* AD converter (MAX6675), connected to type-K thermocoupler
* Graphical host software written in Java
