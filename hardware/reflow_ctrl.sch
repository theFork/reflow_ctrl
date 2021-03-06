EESchema Schematic File Version 2
LIBS:reflow_ctrl-cache
EELAYER 25 0
EELAYER END
$Descr User 7874 5906
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
P 4450 1450
F 0 "U3" H 4200 1800 50  0000 C CNN
F 1 "BTA41/600B" H 4150 1200 50  0000 C CNN
F 2 "TO_SOT_Packages_THT:TO-247_Vertical_Neutral123_largePads" H 4450 1450 60  0001 C CNN
F 3 "http://www.st.com/web/en/resource/technical/document/datasheet/CD00002263.pdf" H 4450 1450 60  0001 C CNN
F 4 "http://www.digikey.de/product-detail/de/BTA41-600BRG/497-2431-5-ND/603456" H 4200 1800 50  0001 C CNN "Supplier Link"
F 5 "STMicroelectronics" H 4200 1800 50  0001 C CNN "Manufacturer"
F 6 "Digikey" H 4200 1800 50  0001 C CNN "Supplier"
F 7 "BTA41-600BRG" H 4200 1800 50  0001 C CNN "Manufacturer Part Number"
F 8 "497-2431-5-ND" H 4200 1800 50  0001 C CNN "Supplier Part Number"
	1    4450 1450
	1    0    0    -1  
$EndComp
$Comp
L OPTO-TRIAC U2
U 1 1 56A8F593
P 3200 1550
F 0 "U2" H 3000 1750 50  0000 L CNN
F 1 "MOC3063" H 3000 1350 50  0000 L CNN
F 2 "uMIDI:Semi-Optotriac_MOC3063-SMD" H 3200 1550 50  0001 L CIN
F 3 "https://www.fairchildsemi.com/datasheets/MO/MOC3061M.pdf" H 3175 1550 50  0001 L CNN
F 4 "MOC3063SR2VM" H 3000 1750 50  0001 L CNN "Manufacturer Part Number"
F 5 "MOC3063SR2VMCT-ND" H 3000 1750 50  0001 L CNN "Supplier Part Number"
F 6 "Fairchild Semiconductor" H 3000 1750 50  0001 L CNN "Manufacturer"
F 7 "Digikey" H 3000 1750 50  0001 L CNN "Supplier"
F 8 "http://www.digikey.de/product-detail/de/MOC3063SR2VM/MOC3063SR2VMCT-ND/2094175" H 3000 1750 50  0001 L CNN "Supplier Link"
	1    3200 1550
	1    0    0    -1  
$EndComp
$Comp
L R R5
U 1 1 56A90095
P 3600 1950
F 0 "R5" V 3680 1950 50  0000 C CNN
F 1 "360" V 3600 1950 50  0000 C CNN
F 2 "uMIDI:Pas_1206" V 3530 1950 30  0001 C CNN
F 3 "" H 3600 1950 30  0000 C CNN
	1    3600 1950
	1    0    0    -1  
$EndComp
$Comp
L R R6
U 1 1 56A9031F
P 5150 1200
F 0 "R6" V 5230 1200 50  0000 C CNN
F 1 "39" V 5150 1200 50  0000 C CNN
F 2 "uMIDI:Pas_1206" V 5080 1200 30  0001 C CNN
F 3 "" H 5150 1200 30  0000 C CNN
	1    5150 1200
	1    0    0    -1  
$EndComp
$Comp
L C C12
U 1 1 56A90389
P 5150 1850
F 0 "C12" H 5250 2000 50  0000 L CNN
F 1 "10n" H 5250 1900 50  0000 L CNN
F 2 "uMIDI:Pas_1206" H 5188 1700 30  0001 C CNN
F 3 "" H 5150 1850 60  0000 C CNN
F 4 "630V" H 5250 1700 60  0000 L CNN "Voltage"
F 5 "X7R" H 5250 1800 60  0000 L CNN "Dielectric"
	1    5150 1850
	1    0    0    -1  
$EndComp
$Comp
L F_Small F1
U 1 1 56A9124A
P 6050 900
F 0 "F1" H 6010 960 50  0000 L CNN
F 1 "Insert 12A slow" H 5750 800 50  0000 L CNN
F 2 "uMIDI:Fuseholder_Schurter_20x5" H 6050 900 60  0001 C CNN
F 3 "http://www.schurterinc.com/var/schurter/storage/ilcatalogue/files/document/datasheet/en/pdf/typ_OGD.pdf" H 6050 900 60  0001 C CNN
F 4 "Schurter Inc." H 6010 960 50  0001 L CNN "Manufacturer"
F 5 "0031.8231" H 6010 960 50  0001 L CNN "Manufacturer Part Number"
F 6 "http://www.digikey.de/product-detail/de/0031.8231/486-1261-ND/640402" H 6010 960 50  0001 L CNN "Supplier Link"
F 7 "10A" H 6010 960 50  0001 L CNN "Rated Current"
F 8 "486-1261-ND" H 6010 960 50  0001 L CNN "Supplier Part Number"
F 9 "Digikey" H 6010 960 50  0001 L CNN "Supplier"
	1    6050 900 
	1    0    0    -1  
$EndComp
$Comp
L R R3
U 1 1 56A91D56
P 2550 1450
F 0 "R3" V 2630 1450 50  0000 C CNN
F 1 "390" V 2550 1450 50  0000 C CNN
F 2 "uMIDI:Pas_0603" V 2480 1450 30  0001 C CNN
F 3 "" H 2550 1450 30  0000 C CNN
	1    2550 1450
	0    1    1    0   
$EndComp
Text Label 6350 900  0    60   ~ 0
L_mains
Text Label 6300 2200 0    60   ~ 0
L_load
$Comp
L GND #PWR01
U 1 1 56A9FAD0
P 2850 1700
F 0 "#PWR01" H 2850 1450 50  0001 C CNN
F 1 "GND" H 2850 1550 50  0000 C CNN
F 2 "" H 2850 1700 60  0000 C CNN
F 3 "" H 2850 1700 60  0000 C CNN
	1    2850 1700
	1    0    0    -1  
$EndComp
Text Label 2150 1450 0    60   ~ 0
PWR
$Comp
L DIL8 IC1
U 1 1 56AA0615
P 5450 3450
F 0 "IC1" H 5450 3700 60  0000 C CNN
F 1 "MAX6675" V 5450 3450 50  0000 C CNN
F 2 "Housings_SOIC:SOIC-8_3.9x4.9mm_Pitch1.27mm" H 5450 3450 60  0001 C CNN
F 3 "http://datasheets.maximintegrated.com/en/ds/MAX6675.pdf" H 5450 3450 60  0001 C CNN
	1    5450 3450
	-1   0    0    1   
$EndComp
$Comp
L GND #PWR02
U 1 1 56AA0C93
P 5900 3650
F 0 "#PWR02" H 5900 3400 50  0001 C CNN
F 1 "GND" H 5900 3500 50  0000 C CNN
F 2 "" H 5900 3650 60  0000 C CNN
F 3 "" H 5900 3650 60  0000 C CNN
	1    5900 3650
	1    0    0    -1  
$EndComp
NoConn ~ 5100 3600
Text Label 6400 3400 0    60   ~ 0
TC+
Text Label 6400 3500 0    60   ~ 0
TC-
Text Label 4750 3300 0    60   ~ 0
TC_SCK
Text Label 4750 3400 0    60   ~ 0
~TC_CS
Text Label 4750 3500 0    60   ~ 0
TC_SO
$Comp
L C C11
U 1 1 56AA462E
P 6050 3450
F 0 "C11" H 6050 3550 50  0000 L CNN
F 1 "100n" H 6050 3350 50  0000 L CNN
F 2 "uMIDI:Pas_0603" H 6088 3300 30  0001 C CNN
F 3 "" H 6050 3450 60  0001 C CNN
	1    6050 3450
	1    0    0    -1  
$EndComp
Text Label 6350 1100 0    60   ~ 0
N_mains
Text Label 6350 1000 0    60   ~ 0
PE_mains
$Comp
L CONN_01X03 X2
U 1 1 56AFEF30
P 7050 1000
F 0 "X2" H 7050 1200 50  0000 C CNN
F 1 "Mains" V 7150 1000 50  0000 C CNN
F 2 "uMIDI:Mains_Solder" H 7050 1000 60  0001 C CNN
F 3 "" H 7050 1000 60  0000 C CNN
	1    7050 1000
	1    0    0    -1  
$EndComp
$Comp
L CONN_01X03 X3
U 1 1 56AFF4C6
P 7000 2300
F 0 "X3" H 7000 2500 50  0000 C CNN
F 1 "Load" V 7100 2300 50  0000 C CNN
F 2 "uMIDI:Mains_Solder" H 7000 2300 60  0001 C CNN
F 3 "" H 7000 2300 60  0000 C CNN
	1    7000 2300
	1    0    0    -1  
$EndComp
Text Label 6300 2400 0    60   ~ 0
N_mains
Text Label 6300 2300 0    60   ~ 0
PE_mains
$Comp
L CONN_01X02 X4
U 1 1 56B0080E
P 7000 3450
F 0 "X4" H 7000 3600 50  0000 C CNN
F 1 "Thermocouple" V 7100 3450 50  0000 C CNN
F 2 "uMIDI:Pinhead1-2" H 7000 3450 60  0001 C CNN
F 3 "" H 7000 3450 60  0000 C CNN
	1    7000 3450
	1    0    0    -1  
$EndComp
Text Label 2500 3400 2    60   ~ 0
TC_SCK
Text Label 2500 3500 2    60   ~ 0
~TC_CS
Text Label 2500 3600 2    60   ~ 0
TC_SO
Text Label 1400 3200 0    60   ~ 0
PWR
$Comp
L R R4
U 1 1 56AFAFDC
P 3600 1150
F 0 "R4" V 3680 1150 50  0000 C CNN
F 1 "360" V 3600 1150 50  0000 C CNN
F 2 "uMIDI:Pas_1206" V 3530 1150 30  0001 C CNN
F 3 "" H 3600 1150 30  0000 C CNN
	1    3600 1150
	1    0    0    -1  
$EndComp
$Comp
L VR VR1
U 1 1 56AFB9EA
P 5650 1550
F 0 "VR1" H 5800 1650 50  0000 C TNN
F 1 "430V" H 5800 1500 50  0000 C CNN
F 2 "Varistors:RV_Disc_D7_W4.5_P5" H 5650 1550 60  0001 C CNN
F 3 "http://en.tdk.eu/inf/70/db/var_11/SIOV_Leaded_StandarD.pdf" H 5650 1550 60  0001 C CNN
F 4 "EPCOS (TDK)" V 5710 1504 50  0001 C TNN "Manufacturer"
F 5 "495-1412-ND" V 5710 1504 50  0001 C TNN "Supplier Part Number"
F 6 "http://www.digikey.de/product-detail/de/S14K275/495-1412-ND/593838" V 5710 1504 50  0001 C TNN "Supplier Link"
F 7 "S14K275" V 5710 1504 50  0001 C TNN "Manufacturer Part Number"
F 8 "Digikey" V 5710 1504 50  0001 C TNN "Supplier"
	1    5650 1550
	1    0    0    -1  
$EndComp
Text Notes 1450 1300 0    60   ~ 0
Nominal trigger current: 5mA (60mA max)
$Comp
L HEATSINK HS1
U 1 1 56B07BF1
P 4450 750
F 0 "HS1" H 4450 950 50  0000 C CNN
F 1 "HEATSINK" H 4450 700 50  0000 C CNN
F 2 "uMIDI:Mech-Heatsink_Fischer_SK129_STS" H 4450 750 60  0001 C CNN
F 3 "http://www.fischerelektronik.de/web_fischer/en_GB/heatsinks/A04/Extruded%20heatsinks%20for%20PCB%20mounting/PR/SK129_50.8_/index.xhtml" H 4450 750 60  0001 C CNN
F 4 "Fischer Elektronik" H 4450 750 60  0001 C CNN "Manufacturer"
F 5 "SK 129-50 STS" H 4450 750 60  0001 C CNN "Manufacturer Part Number"
F 6 "Reichelt" H 4450 750 60  0001 C CNN "Supplier"
	1    4450 750 
	1    0    0    -1  
$EndComp
$Comp
L CONN_02X05 X1
U 1 1 56C0B2E0
P 1850 3400
F 0 "X1" H 1850 3700 50  0000 C CNN
F 1 "Master" H 1850 3100 50  0000 C CNN
F 2 "uMIDI:Con-boxed_header-THT" H 1850 2200 60  0001 C CNN
F 3 "" H 1850 2200 60  0000 C CNN
	1    1850 3400
	-1   0    0    -1  
$EndComp
$Comp
L +3.3V #PWR03
U 1 1 56C0C614
P 5900 3250
F 0 "#PWR03" H 5900 3100 50  0001 C CNN
F 1 "+3.3V" H 5900 3390 50  0000 C CNN
F 2 "" H 5900 3250 60  0000 C CNN
F 3 "" H 5900 3250 60  0000 C CNN
	1    5900 3250
	1    0    0    -1  
$EndComp
$Comp
L +3.3V #PWR04
U 1 1 56C0C64E
P 2150 3100
F 0 "#PWR04" H 2150 2950 50  0001 C CNN
F 1 "+3.3V" H 2150 3240 50  0000 C CNN
F 2 "" H 2150 3100 60  0000 C CNN
F 3 "" H 2150 3100 60  0000 C CNN
	1    2150 3100
	-1   0    0    -1  
$EndComp
$Comp
L GND #PWR05
U 1 1 56C0CE3A
P 1550 3650
F 0 "#PWR05" H 1550 3400 50  0001 C CNN
F 1 "GND" H 1550 3500 50  0000 C CNN
F 2 "" H 1550 3650 60  0000 C CNN
F 3 "" H 1550 3650 60  0000 C CNN
	1    1550 3650
	-1   0    0    -1  
$EndComp
$Comp
L C C1
U 1 1 56C0D9F5
P 1900 4500
F 0 "C1" H 1900 4600 50  0000 L CNN
F 1 "100n" H 1900 4400 50  0000 L CNN
F 2 "uMIDI:Pas_0603" H 1938 4350 30  0001 C CNN
F 3 "" H 1900 4500 60  0001 C CNN
	1    1900 4500
	1    0    0    -1  
$EndComp
$Comp
L C C2
U 1 1 56C209CA
P 2200 4500
F 0 "C2" H 2200 4600 50  0000 L CNN
F 1 "100n" H 2200 4400 50  0000 L CNN
F 2 "uMIDI:Pas_0603" H 2238 4350 30  0001 C CNN
F 3 "" H 2200 4500 60  0001 C CNN
	1    2200 4500
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR06
U 1 1 56C20A24
P 2050 4750
F 0 "#PWR06" H 2050 4500 50  0001 C CNN
F 1 "GND" H 2050 4600 50  0000 C CNN
F 2 "" H 2050 4750 60  0000 C CNN
F 3 "" H 2050 4750 60  0000 C CNN
	1    2050 4750
	1    0    0    -1  
$EndComp
$Comp
L +3.3V #PWR07
U 1 1 56C20AF7
P 2050 4250
F 0 "#PWR07" H 2050 4100 50  0001 C CNN
F 1 "+3.3V" H 2050 4390 50  0000 C CNN
F 2 "" H 2050 4250 60  0000 C CNN
F 3 "" H 2050 4250 60  0000 C CNN
	1    2050 4250
	1    0    0    -1  
$EndComp
NoConn ~ 1600 3300
NoConn ~ 1600 3400
$Comp
L PWR_FLAG #FLG08
U 1 1 56C22014
P 1050 4400
F 0 "#FLG08" H 1050 4495 50  0001 C CNN
F 1 "PWR_FLAG" V 1050 4750 50  0000 C CNN
F 2 "" H 1050 4400 60  0000 C CNN
F 3 "" H 1050 4400 60  0000 C CNN
	1    1050 4400
	0    1    1    0   
$EndComp
$Comp
L PWR_FLAG #FLG09
U 1 1 56C22108
P 1050 4600
F 0 "#FLG09" H 1050 4695 50  0001 C CNN
F 1 "PWR_FLAG" V 1050 4950 50  0000 C CNN
F 2 "" H 1050 4600 60  0000 C CNN
F 3 "" H 1050 4600 60  0000 C CNN
	1    1050 4600
	0    1    1    0   
$EndComp
$Comp
L GND #PWR010
U 1 1 56C22149
P 1000 4650
F 0 "#PWR010" H 1000 4400 50  0001 C CNN
F 1 "GND" H 1000 4500 50  0000 C CNN
F 2 "" H 1000 4650 60  0000 C CNN
F 3 "" H 1000 4650 60  0000 C CNN
	1    1000 4650
	1    0    0    -1  
$EndComp
$Comp
L +3.3V #PWR011
U 1 1 56C22402
P 1000 4400
F 0 "#PWR011" H 1000 4250 50  0001 C CNN
F 1 "+3.3V" H 1000 4540 50  0000 C CNN
F 2 "" H 1000 4400 60  0000 C CNN
F 3 "" H 1000 4400 60  0000 C CNN
	1    1000 4400
	0    -1   -1   0   
$EndComp
Text Label 3550 1450 0    60   ~ 0
MOC_A1
Text Label 3550 1650 0    60   ~ 0
MOC_A2
Text Label 5150 1650 1    60   ~ 0
Snub
Text Label 4950 900  0    60   ~ 0
L_main_fused
NoConn ~ 1600 3500
Wire Wire Line
	3500 1450 3600 1450
Wire Wire Line
	3600 1450 3600 1300
Wire Wire Line
	3500 1650 3950 1650
Wire Wire Line
	3600 1650 3600 1800
Wire Wire Line
	3600 2100 3600 2200
Wire Wire Line
	3600 2200 6800 2200
Wire Wire Line
	5150 2000 5150 2200
Wire Wire Line
	5150 1700 5150 1350
Wire Wire Line
	3600 1000 3600 900 
Wire Wire Line
	3600 900  5950 900 
Wire Wire Line
	5150 1050 5150 900 
Connection ~ 5150 900 
Connection ~ 3600 1650
Wire Wire Line
	4450 1700 4450 2200
Connection ~ 4450 2200
Wire Wire Line
	4450 1050 4450 900 
Connection ~ 4450 900 
Connection ~ 5150 2200
Wire Wire Line
	6150 900  6850 900 
Wire Wire Line
	2150 1450 2400 1450
Wire Wire Line
	2700 1450 2900 1450
Wire Wire Line
	2850 1700 2850 1650
Wire Wire Line
	2850 1650 2900 1650
Wire Wire Line
	5800 3600 6050 3600
Wire Wire Line
	5800 3300 6050 3300
Wire Wire Line
	5900 3300 5900 3250
Wire Wire Line
	5900 3650 5900 3600
Wire Wire Line
	5800 3400 6800 3400
Wire Wire Line
	5800 3500 6800 3500
Wire Wire Line
	4750 3300 5100 3300
Wire Wire Line
	4750 3400 5100 3400
Wire Wire Line
	4750 3500 5100 3500
Connection ~ 5900 3600
Connection ~ 5900 3300
Wire Wire Line
	6350 1000 6850 1000
Wire Wire Line
	6350 1100 6850 1100
Wire Wire Line
	6300 2300 6800 2300
Wire Wire Line
	6300 2400 6800 2400
Wire Wire Line
	5650 1800 5650 2200
Connection ~ 5650 2200
Wire Wire Line
	5650 900  5650 1300
Connection ~ 5650 900 
Wire Wire Line
	2150 3100 2150 3200
Wire Wire Line
	2150 3200 2100 3200
Wire Wire Line
	1600 3600 1550 3600
Wire Wire Line
	1550 3600 1550 3650
Wire Wire Line
	1900 4650 1900 4700
Wire Wire Line
	1900 4700 2200 4700
Wire Wire Line
	2200 4700 2200 4650
Wire Wire Line
	2050 4750 2050 4700
Connection ~ 2050 4700
Wire Wire Line
	1900 4350 1900 4300
Wire Wire Line
	1900 4300 2200 4300
Wire Wire Line
	2200 4300 2200 4350
Wire Wire Line
	2050 4250 2050 4300
Connection ~ 2050 4300
Wire Wire Line
	1000 4650 1000 4600
Wire Wire Line
	1000 4600 1050 4600
Wire Wire Line
	1000 4400 1050 4400
Wire Wire Line
	2500 3400 2100 3400
Wire Wire Line
	2500 3600 2100 3600
Wire Wire Line
	2500 3500 2100 3500
Wire Wire Line
	1400 3200 1600 3200
NoConn ~ 2100 3300
$Comp
L GND #PWR?
U 1 1 576EC66B
P 6650 3550
F 0 "#PWR?" H 6650 3300 50  0001 C CNN
F 1 "GND" H 6650 3400 50  0000 C CNN
F 2 "" H 6650 3550 60  0000 C CNN
F 3 "" H 6650 3550 60  0000 C CNN
	1    6650 3550
	1    0    0    -1  
$EndComp
Wire Wire Line
	6650 3550 6650 3500
Connection ~ 6650 3500
$EndSCHEMATC
