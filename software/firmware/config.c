/// \file
/// \brief      Device configuration

/*
 * Copyright 2015 Sebastian Neuser
 *
 * This file is part of the uMIDI firmware.
 *
 * the uMIDI firmware is free software: you can redistribute it and/or modify
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

#include <stddef.h>

#include "lib/background_tasks.h"
#include "lib/gpio.h"
#include "lib/leds.h"
#include "lib/serial_communication.h"
#include "lib/spi.h"
#include "lib/usb.h"

#include "config.h"
#include "app.h"


////////////////////////////////////////////////////////////////
//                     V A R I A B L E S                      //
////////////////////////////////////////////////////////////////

//---------------- Background tasks ----------------//
background_task_t high_frequency_tasks[] = {
    &serial_communication_task,
};
uint8_t high_frequency_tasks_size = sizeof(high_frequency_tasks)/sizeof(background_task_t);

background_task_t mid_frequency_tasks[] = {
    &usb_main_task,
};
uint8_t mid_frequency_tasks_size = sizeof(mid_frequency_tasks)/sizeof(background_task_t);

background_task_t low_frequency_tasks[] = {
    &update_leds,
    &heat_control_task,
};
uint8_t low_frequency_tasks_size = sizeof(low_frequency_tasks)/sizeof(background_task_t);


//---------------- Commands ----------------//
struct serial_command serial_commands[] = {
    {
        .cmd_string = "led",
        .help_string = "<l> <a>\n"
                       "Manipulates the two on-board LEDs:\n"
                       "<l> : LED to manipulate\n"
                       "      'g' = green LED\n"
                       "      'r' = red LED\n"
                       "<a> : LED mode / action\n"
                       "      'b' = blink\n"
                       "      'f' = flash\n"
                       "      't' = toggle",
        .handler = &exec_led
    },
    {
        .cmd_string = "shot",
        .help_string = "<t>\n"
                       "Enable the heater for a given time\n"
                       "<t> : the on-time in 10ms steps, range [1, 10000]",
        .handler = &exec_shot
    },
    {
        .cmd_string = "offs",
        .help_string = "<t>\n"
                       "Stores an offset for temperature measurements\n"
                       "<t> : offset in [K/4], 16 bit signed integer",
        .handler = &exec_offs
    },
    {
        .cmd_string = "temp",
        .help_string = "Read out the current temperature in Celsius",
        .handler = &exec_temp
    },
};
uint8_t serial_commands_size = sizeof(serial_commands) / sizeof(struct serial_command);


//---------------- GPIO ----------------//
struct gpio_mapping gpio_mappings[] = {
    { &gpio.header1.pin2, GPIO_OUTPUT },
};
uint8_t gpio_mappings_size = sizeof(gpio_mappings)/sizeof(struct gpio_mapping);


//---------------- SPI ----------------//
struct spi_config spi_config = {
    .clk_phase      = true,
    .clk_polarity   = false,
    .word_length    = 16,
    .clk_pin        = &gpio.header1.pin5,
    .miso_pin       = &gpio.header1.pin9,
    .mosi_pin       = NULL,
    .ncs_pin        = &gpio.header1.pin7,
};
