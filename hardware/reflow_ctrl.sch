EESchema Schematic File Version 2
LIBS:power
LIBS:device
LIBS:transistors
LIBS:conn
LIBS:linear
LIBS:regul
LIBS:74xx
LIBS:cmos4000
LIBS:adc-dac
LIBS:memory
LIBS:xilinx
LIBS:microcontrollers
LIBS:dsp
LIBS:microchip
LIBS:analog_switches
LIBS:motorola
LIBS:texas
LIBS:intel
LIBS:audio
LIBS:interface
LIBS:digital-audio
LIBS:philips
LIBS:display
LIBS:cypress
LIBS:siliconi
LIBS:opto
LIBS:atmel
LIBS:contrib
LIBS:valves
LIBS:reflow_ctrl-cache
EELAYER 25 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L TRIAC U3
U 1 1 56A8F3B6
P 7850 1900
F 0 "U3" H 7600 2250 50  0000 C CNN
F 1 "BTA41/600B" H 7550 1650 50  0000 C CNN
F 2 "TO_SOT_Packages_THT:TO-247_Vertical_Neutral123_largePads" H 7850 1900 60  0001 C CNN
F 3 "http://www.st.com/web/en/resource/technical/document/datasheet/CD00002263.pdf" H 7850 1900 60  0001 C CNN
F 4 "http://www.digikey.de/product-detail/de/BTA41-600BRG/497-2431-5-ND/603456" H 7600 2250 50  0001 C CNN "Supplier Link"
F 5 "STMicroelectronics" H 7600 2250 50  0001 C CNN "Manufacturer"
F 6 "Digikey" H 7600 2250 50  0001 C CNN "Supplier"
F 7 "BTA41-600BRG" H 7600 2250 50  0001 C CNN "Manufacturer Part Number"
F 8 "497-2431-5-ND" H 7600 2250 50  0001 C CNN "Supplier Part Number"
	1    7850 1900
	1    0    0    -1  
$EndComp
$Comp
L OPTO-TRIAC U2
U 1 1 56A8F593
P 6600 2000
F 0 "U2" H 6400 2200 50  0000 L CNN
F 1 "MOC3063" H 6400 1800 50  0000 L CNN
F 2 "uMIDI:MOC3063_SMT" H 6600 2000 50  0001 L CIN
F 3 "https://www.fairchildsemi.com/datasheets/MO/MOC3061M.pdf" H 6575 2000 50  0001 L CNN
F 4 "MOC3063SR2VM" H 6400 2200 50  0001 L CNN "Manufacturer Part Number"
F 5 "MOC3063SR2VMCT-ND" H 6400 2200 50  0001 L CNN "Supplier Part Number"
F 6 "Fairchild Semiconductor" H 6400 2200 50  0001 L CNN "Manufacturer"
F 7 "Digikey" H 6400 2200 50  0001 L CNN "Supplier"
F 8 "http://www.digikey.de/product-detail/de/MOC3063SR2VM/MOC3063SR2VMCT-ND/2094175" H 6400 2200 50  0001 L CNN "Supplier Link"
	1    6600 2000
	1    0    0    -1  
$EndComp
$Comp
L R R5
U 1 1 56A90095
P 7000 2400
F 0 "R5" V 7080 2400 50  0000 C CNN
F 1 "360" V 7000 2400 50  0000 C CNN
F 2 "Resistors_SMD:R_1206" V 6930 2400 30  0001 C CNN
F 3 "" H 7000 2400 30  0000 C CNN
	1    7000 2400
	1    0    0    -1  
$EndComp
$Comp
L R R6
U 1 1 56A9031F
P 8550 1700
F 0 "R6" V 8630 1700 50  0000 C CNN
F 1 "39" V 8550 1700 50  0000 C CNN
F 2 "Resistors_SMD:R_1206" V 8480 1700 30  0001 C CNN
F 3 "" H 8550 1700 30  0000 C CNN
	1    8550 1700
	1    0    0    -1  
$EndComp
$Comp
L C C12
U 1 1 56A90389
P 8550 2200
F 0 "C12" H 8650 2350 50  0000 L CNN
F 1 "10n" H 8650 2250 50  0000 L CNN
F 2 "Capacitors_SMD:C_1206" H 8588 2050 30  0001 C CNN
F 3 "" H 8550 2200 60  0000 C CNN
F 4 "630V" H 8650 2050 60  0000 L CNN "Voltage"
F 5 "X7R" H 8650 2150 60  0000 L CNN "Dielectric"
	1    8550 2200
	1    0    0    -1  
$EndComp
$Comp
L F_Small F1
U 1 1 56A9124A
P 9450 1350
F 0 "F1" H 9410 1410 50  0000 L CNN
F 1 "Insert 12A slow" H 9150 1250 50  0000 L CNN
F 2 "uMIDI:Fuseholder_Schurter_20x5" H 9450 1350 60  0001 C CNN
F 3 "http://www.schurterinc.com/var/schurter/storage/ilcatalogue/files/document/datasheet/en/pdf/typ_OGD.pdf" H 9450 1350 60  0001 C CNN
F 4 "Schurter Inc." H 9410 1410 50  0001 L CNN "Manufacturer"
F 5 "0031.8231" H 9410 1410 50  0001 L CNN "Manufacturer Part Number"
F 6 "http://www.digikey.de/product-detail/de/0031.8231/486-1261-ND/640402" H 9410 1410 50  0001 L CNN "Supplier Link"
F 7 "10A" H 9410 1410 50  0001 L CNN "Rated Current"
F 8 "486-1261-ND" H 9410 1410 50  0001 L CNN "Supplier Part Number"
F 9 "Digikey" H 9410 1410 50  0001 L CNN "Supplier"
	1    9450 1350
	1    0    0    -1  
$EndComp
$Comp
L R R3
U 1 1 56A91D56
P 5950 1900
F 0 "R3" V 6030 1900 50  0000 C CNN
F 1 "390" V 5950 1900 50  0000 C CNN
F 2 "Resistors_SMD:R_0603" V 5880 1900 30  0001 C CNN
F 3 "" H 5950 1900 30  0000 C CNN
	1    5950 1900
	0    1    1    0   
$EndComp
Text Label 9750 1350 0    60   ~ 0
L_mains
Text Label 9700 2650 0    60   ~ 0
L_load
$Comp
L GND #PWR01
U 1 1 56A9FAD0
P 6250 2150
F 0 "#PWR01" H 6250 1900 50  0001 C CNN
F 1 "GND" H 6250 2000 50  0000 C CNN
F 2 "" H 6250 2150 60  0000 C CNN
F 3 "" H 6250 2150 60  0000 C CNN
	1    6250 2150
	1    0    0    -1  
$EndComp
Text Label 5550 1900 0    60   ~ 0
PWR
$Comp
L DIL8 IC1
U 1 1 56AA0615
P 7750 4800
F 0 "IC1" H 7750 5050 60  0000 C CNN
F 1 "MAX6675" V 7750 4800 50  0000 C CNN
F 2 "Housings_SOIC:SOIC-8_3.9x4.9mm_Pitch1.27mm" H 7750 4800 60  0001 C CNN
F 3 "http://datasheets.maximintegrated.com/en/ds/MAX6675.pdf" H 7750 4800 60  0001 C CNN
	1    7750 4800
	-1   0    0    1   
$EndComp
$Comp
L GND #PWR02
U 1 1 56AA0C93
P 8200 5000
F 0 "#PWR02" H 8200 4750 50  0001 C CNN
F 1 "GND" H 8200 4850 50  0000 C CNN
F 2 "" H 8200 5000 60  0000 C CNN
F 3 "" H 8200 5000 60  0000 C CNN
	1    8200 5000
	1    0    0    -1  
$EndComp
NoConn ~ 7400 4950
Text Label 8700 4750 0    60   ~ 0
TC+
Text Label 8700 4850 0    60   ~ 0
TC-
Text Label 7050 4650 0    60   ~ 0
TC_SCK
Text Label 7050 4750 0    60   ~ 0
~TC_CS
Text Label 7050 4850 0    60   ~ 0
TC_SO
$Comp
L C C11
U 1 1 56AA462E
P 8350 4800
F 0 "C11" H 8350 4900 50  0000 L CNN
F 1 "100n" H 8350 4700 50  0000 L CNN
F 2 "Capacitors_SMD:C_0603" H 8388 4650 30  0001 C CNN
F 3 "" H 8350 4800 60  0001 C CNN
	1    8350 4800
	1    0    0    -1  
$EndComp
Text Label 9750 1550 0    60   ~ 0
N_mains
Text Label 9750 1450 0    60   ~ 0
PE_mains
$Comp
L CONN_01X03 X2
U 1 1 56AFEF30
P 10450 1450
F 0 "X2" H 10450 1650 50  0000 C CNN
F 1 "Mains" V 10550 1450 50  0000 C CNN
F 2 "uMIDI:Mains_Solder" H 10450 1450 60  0001 C CNN
F 3 "" H 10450 1450 60  0000 C CNN
	1    10450 1450
	1    0    0    -1  
$EndComp
$Comp
L CONN_01X03 X3
U 1 1 56AFF4C6
P 10400 2750
F 0 "X3" H 10400 2950 50  0000 C CNN
F 1 "Load" V 10500 2750 50  0000 C CNN
F 2 "uMIDI:Mains_Solder" H 10400 2750 60  0001 C CNN
F 3 "" H 10400 2750 60  0000 C CNN
	1    10400 2750
	1    0    0    -1  
$EndComp
Text Label 9700 2850 0    60   ~ 0
N_mains
Text Label 9700 2750 0    60   ~ 0
PE_mains
$Comp
L CONN_01X02 X4
U 1 1 56B0080E
P 9300 4800
F 0 "X4" H 9300 4950 50  0000 C CNN
F 1 "Thermocouple" V 9400 4800 50  0000 C CNN
F 2 "uMIDI:Pinhead1-2" H 9300 4800 60  0001 C CNN
F 3 "" H 9300 4800 60  0000 C CNN
	1    9300 4800
	1    0    0    -1  
$EndComp
Text Label 2500 3600 0    60   ~ 0
TC_SCK
Text Label 2500 3500 0    60   ~ 0
~TC_CS
Text Label 2500 3400 0    60   ~ 0
TC_SO
Text Label 3450 3500 0    60   ~ 0
PWR
$Comp
L R R4
U 1 1 56AFAFDC
P 7000 1600
F 0 "R4" V 7080 1600 50  0000 C CNN
F 1 "360" V 7000 1600 50  0000 C CNN
F 2 "Resistors_SMD:R_1206" V 6930 1600 30  0001 C CNN
F 3 "" H 7000 1600 30  0000 C CNN
	1    7000 1600
	1    0    0    -1  
$EndComp
$Comp
L VR VR1
U 1 1 56AFB9EA
P 9050 2000
F 0 "VR1" H 9200 2100 50  0000 C TNN
F 1 "430V" H 9200 1950 50  0000 C CNN
F 2 "Varistors:RV_Disc_D21.5_W5.1_P10" H 9050 2000 60  0001 C CNN
F 3 "http://en.tdk.eu/inf/70/db/var_11/SIOV_Leaded_StandarD.pdf" H 9050 2000 60  0001 C CNN
F 4 "EPCOS (TDK)" V 9110 1954 50  0001 C TNN "Manufacturer"
F 5 "495-1412-ND" V 9110 1954 50  0001 C TNN "Supplier Part Number"
F 6 "http://www.digikey.de/product-detail/de/S14K275/495-1412-ND/593838" V 9110 1954 50  0001 C TNN "Supplier Link"
F 7 "S14K275" V 9110 1954 50  0001 C TNN "Manufacturer Part Number"
F 8 "Digikey" V 9110 1954 50  0001 C TNN "Supplier"
	1    9050 2000
	1    0    0    -1  
$EndComp
Wire Wire Line
	6900 1900 7000 1900
Wire Wire Line
	7000 1900 7000 1750
Wire Wire Line
	6900 2100 7350 2100
Wire Wire Line
	7000 2100 7000 2250
Wire Wire Line
	7000 2550 7000 2650
Wire Wire Line
	7000 2650 10200 2650
Wire Wire Line
	8550 2350 8550 2650
Wire Wire Line
	8550 2050 8550 1850
Wire Wire Line
	7000 1450 7000 1350
Wire Wire Line
	7000 1350 9350 1350
Wire Wire Line
	8550 1550 8550 1350
Connection ~ 8550 1350
Connection ~ 7000 2100
Wire Wire Line
	7850 2150 7850 2650
Connection ~ 7850 2650
Wire Wire Line
	7850 1500 7850 1350
Connection ~ 7850 1350
Connection ~ 8550 2650
Wire Wire Line
	9550 1350 10250 1350
Wire Wire Line
	5550 1900 5800 1900
Wire Wire Line
	6100 1900 6300 1900
Wire Wire Line
	6250 2150 6250 2100
Wire Wire Line
	6250 2100 6300 2100
Wire Wire Line
	8100 4950 8350 4950
Wire Wire Line
	8100 4650 8350 4650
Wire Wire Line
	8200 4650 8200 4600
Wire Wire Line
	8200 5000 8200 4950
Wire Wire Line
	8100 4750 9100 4750
Wire Wire Line
	8100 4850 9100 4850
Wire Wire Line
	7050 4650 7400 4650
Wire Wire Line
	7050 4750 7400 4750
Wire Wire Line
	7050 4850 7400 4850
Connection ~ 8200 4950
Connection ~ 8200 4650
Wire Wire Line
	9750 1450 10250 1450
Wire Wire Line
	9750 1550 10250 1550
Wire Wire Line
	9700 2750 10200 2750
Wire Wire Line
	9700 2850 10200 2850
Wire Wire Line
	2400 3400 2900 3400
Wire Wire Line
	2400 3500 2900 3500
Wire Wire Line
	2400 3600 2900 3600
Wire Wire Line
	9050 2250 9050 2650
Connection ~ 9050 2650
Wire Wire Line
	9050 1350 9050 1750
Connection ~ 9050 1350
Wire Wire Line
	3400 3500 3650 3500
Text Notes 4850 1750 0    60   ~ 0
Nominal trigger current: 5mA (60mA max)
$Comp
L HEATSINK HS1
U 1 1 56B07BF1
P 7850 1200
F 0 "HS1" H 7850 1400 50  0000 C CNN
F 1 "HEATSINK" H 7850 1150 50  0000 C CNN
F 2 "" H 7850 1200 60  0000 C CNN
F 3 "" H 7850 1200 60  0000 C CNN
F 4 "Fischer Elektronik" H 7850 1200 60  0001 C CNN "Manufacturer"
F 5 "SK 129-50 STS" H 7850 1200 60  0001 C CNN "Manufacturer Part Number"
F 6 "Reichelt" H 7850 1200 60  0001 C CNN "Supplier"
	1    7850 1200
	1    0    0    -1  
$EndComp
Text Notes 550  7700 0    60   ~ 0
TODO\n* Complete supplier links\n* Add 3 Switches and approx. 3 LEDs\n* Add netclasses
$Comp
L CONN_02X05 X?
U 1 1 56C0B2E0
P 3150 3400
F 0 "X?" H 3150 3700 50  0000 C CNN
F 1 "Master" H 3150 3100 50  0000 C CNN
F 2 "" H 3150 2200 60  0000 C CNN
F 3 "" H 3150 2200 60  0000 C CNN
	1    3150 3400
	1    0    0    -1  
$EndComp
$Comp
L +3.3V #PWR?
U 1 1 56C0C614
P 8200 4600
F 0 "#PWR?" H 8200 4450 50  0001 C CNN
F 1 "+3.3V" H 8200 4740 50  0000 C CNN
F 2 "" H 8200 4600 60  0000 C CNN
F 3 "" H 8200 4600 60  0000 C CNN
	1    8200 4600
	1    0    0    -1  
$EndComp
$Comp
L +3.3V #PWR?
U 1 1 56C0C64E
P 2850 3150
F 0 "#PWR?" H 2850 3000 50  0001 C CNN
F 1 "+3.3V" H 2850 3290 50  0000 C CNN
F 2 "" H 2850 3150 60  0000 C CNN
F 3 "" H 2850 3150 60  0000 C CNN
	1    2850 3150
	1    0    0    -1  
$EndComp
Wire Wire Line
	2850 3150 2850 3200
Wire Wire Line
	2850 3200 2900 3200
$Comp
L GND #PWR?
U 1 1 56C0CE3A
P 3450 3650
F 0 "#PWR?" H 3450 3400 50  0001 C CNN
F 1 "GND" H 3450 3500 50  0000 C CNN
F 2 "" H 3450 3650 60  0000 C CNN
F 3 "" H 3450 3650 60  0000 C CNN
	1    3450 3650
	1    0    0    -1  
$EndComp
Wire Wire Line
	3400 3600 3450 3600
Wire Wire Line
	3450 3600 3450 3650
$Comp
L C C?
U 1 1 56C0D9F5
P 1800 3350
F 0 "C?" H 1800 3450 50  0000 L CNN
F 1 "100n" H 1800 3250 50  0000 L CNN
F 2 "Capacitors_SMD:C_0603" H 1838 3200 30  0001 C CNN
F 3 "" H 1800 3350 60  0001 C CNN
	1    1800 3350
	1    0    0    -1  
$EndComp
$Comp
L C C?
U 1 1 56C209CA
P 2100 3350
F 0 "C?" H 2100 3450 50  0000 L CNN
F 1 "100n" H 2100 3250 50  0000 L CNN
F 2 "Capacitors_SMD:C_0603" H 2138 3200 30  0001 C CNN
F 3 "" H 2100 3350 60  0001 C CNN
	1    2100 3350
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR?
U 1 1 56C20A24
P 1950 3600
F 0 "#PWR?" H 1950 3350 50  0001 C CNN
F 1 "GND" H 1950 3450 50  0000 C CNN
F 2 "" H 1950 3600 60  0000 C CNN
F 3 "" H 1950 3600 60  0000 C CNN
	1    1950 3600
	1    0    0    -1  
$EndComp
Wire Wire Line
	1800 3500 1800 3550
Wire Wire Line
	1800 3550 2100 3550
Wire Wire Line
	2100 3550 2100 3500
Wire Wire Line
	1950 3600 1950 3550
Connection ~ 1950 3550
$Comp
L +3.3V #PWR?
U 1 1 56C20AF7
P 1950 3100
F 0 "#PWR?" H 1950 2950 50  0001 C CNN
F 1 "+3.3V" H 1950 3240 50  0000 C CNN
F 2 "" H 1950 3100 60  0000 C CNN
F 3 "" H 1950 3100 60  0000 C CNN
	1    1950 3100
	1    0    0    -1  
$EndComp
Wire Wire Line
	1800 3200 1800 3150
Wire Wire Line
	1800 3150 2100 3150
Wire Wire Line
	2100 3150 2100 3200
Wire Wire Line
	1950 3100 1950 3150
Connection ~ 1950 3150
$EndSCHEMATC
