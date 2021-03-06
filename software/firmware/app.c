/// \file
/// \brief      Implementation of an application specific module
/// \see        app.h

/*
 * Copyright 2015 Sebastian Neuser
 *
 * This file is part of the uMIDI firmware.
 *
 * The uMIDI firmware is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The uMIDI firmware is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the uMIDI firmware.  If not, see <http://www.gnu.org/licenses/>.
 */

#include <stdlib.h>
#include <string.h>

#include "lib/leds.h"
#include "lib/usb.h"

#include "config.h"
#include "app.h"


////////////////////////////////////////////////////////////////
//                     V A R I A B L E S                      //
////////////////////////////////////////////////////////////////

static uint16_t heater_timeout = 0;

static int16_t temp_offset = 0;
static uint16_t temp_offset_eemem EEMEM;


////////////////////////////////////////////////////////////////
//      F U N C T I O N S   A N D   P R O C E D U R E S       //
////////////////////////////////////////////////////////////////

/// \brief      Handler for the `led` command
bool exec_led(const char* command)
{
    // Abort if the command is malformed
    if (strlen(command) != 7 || command[3] != ' ' || command[5] != ' ') {
        usb_puts("Malformed command" USB_NEWLINE);
        return false;
    }

    // Parse LED(s) to manipulate
    struct led* led;
    switch (command[4]) {
    case 'g':
        led = led_green;
        break;

    case 'r':
        led = led_red;
        break;

    default:
        usb_puts("No such LED" USB_NEWLINE);
        return false;
    }

    // Parse and execute action
    switch (command[6]) {
    case 'b':
        blink_led(led, F_TASK_SLOW);
        break;

    case 'f':
        flash_led(led);
        break;

    case 't':
        toggle_led(led);
        break;

    default:
        usb_puts("No such action" USB_NEWLINE);
        return false;
    }

    return true;
}

bool exec_shot(const char * const command)
{
    if (strlen(command) < 6 || command[4] != ' ') {
        usb_puts("Malformed command" USB_NEWLINE);
        return false;
    }

    uint16_t length = strtol(command+5, NULL, 10);
    usb_printf("Enabling heater for %u ms" USB_NEWLINE, length*10);

    // update (i.e. overwrite) countdown
    heater_timeout = length;

    return true;
}

bool exec_offs(const char* command)
{
    if (strlen(command) < 6 || command[4] != ' ') {
        usb_puts("Malformed command" USB_NEWLINE);
        return false;
    }

    temp_offset = strtol(command+5, NULL, 10);
    eeprom_write_word(&temp_offset_eemem, temp_offset);
    return true;
}

bool exec_temp(const char * const command)
{
    if (strlen(command) != 4) {
        usb_puts("Malformed command" USB_NEWLINE);
        return false;
    }

    // "Send" dummy value to recieve data
    spi_select(true);
    uint16_t input_word = spi_transceive(0);
    spi_select(false);

    // Abort if no thermo couple is connected
    if (input_word & 0x4) {
        usb_puts("Error: No thermo couple connected!" USB_NEWLINE ":-(");
        return true;
    }

    // Parse and print temperature
    uint16_t temperature = input_word >> 3;
    temperature += temp_offset;

    const char* fractional = "00";
    switch (temperature % 4) {
        case 3:
            fractional = "75";
            break;
        case 2:
            fractional = "50";
            break;
        case 1:
            fractional = "25";
            break;
        default:
            break;
    }
    temperature >>= 2;

    usb_printf("Temperature: %4u.%s" USB_NEWLINE, temperature, fractional);
    return true;
}

void heat_control_task(void)
{
    // Heater is on in case there is still timeout left
    if (heater_timeout > 0) {
        heater_timeout--;
        gpio_drive_high(gpio.header1.pin2);
        set_led(led_red, true);
    }
    // Turn off the heater afterwards
    else {
        gpio_drive_low(gpio.header1.pin2);
        set_led(led_red, false);
    }
}

void restore_temp_offset(void)
{
    temp_offset = eeprom_read_word(&temp_offset_eemem);
}
