# Multi-Type Indexed Storage Management

These programs demonstrate storing various data types of varying lengths in a RandomAccessFile using an index file. The method writes an array of data into a RandomAccessFile and maintains an index file that stores the starting positions of each string in the data file. The second method reads a specific string from the data file based on the given index by utilizing the index file to locate the correct starting position of the desired string.

## DoublesSpeichern (Main)

This program is using indexed storage management to write and read double values.

### Terminal Output

```bash
1.0
2.0
...
5.0
```

## NterIntWertInDatei (Main)

This program uses indexed storage management to read the int on a specific position in the file.

### Terminal Output

Parameter: `zahlen.txt` `2`

```bash
Die 2. Zahl in zahlen.txt ist 857748512
Datei zahlen.txt wurde geschlossen.
```

## QuadrratzahlenSpeichern (Main)

This program uses indexed storage management to write and read square numbers.

### Terminal Output

```bash
Datei quadrate.dat wurde geoeffnet.
In die Datei quadrate.dat wurde geschrieben: 0
In die Datei quadrate.dat wurde geschrieben: 1
...
In die Datei quadrate.dat wurde geschrieben: 9216
In die Datei quadrate.dat wurde geschrieben: 9409
In die Datei quadrate.dat wurde geschrieben: 9604
In die Datei quadrate.dat wurde geschrieben: 9801
In die Datei quadrate.dat wurde geschrieben: 10000
Dateizeiger in quadrate.dat wurde zurueck zum Anfang gesetzt.
an Dateiposition 0 beginnt 0
an Dateiposition 4 beginnt 1
an Dateiposition 8 beginnt 4
an Dateiposition 12 beginnt 9
...
an Dateiposition 388 beginnt 9409
an Dateiposition 392 beginnt 9604
an Dateiposition 396 beginnt 9801
an Dateiposition 400 beginnt 10000
Datei quadrate.dat wurde geschlossen.
```

## StringSchreiben (Main)

This program uses indexed storage management to write strings into a file.

### Terminal Output

```bash
Testnachricht
Das ist ein Text
LaLaLa
Guten Morgen
Herrliches Wetter
Herr
Minister
20 Jahre
Bli Bla Blub
Nina
```

## StringSpeichern (Main)

This program uses indexed storage management to store and read strings from a file passed on to the program as a parameter.

### Terminal Output

Parameter: `arg1` `arg2` `arg3`

```bash
Die Kommandozeilen-Parameter in umgekehrter Reihenfolge:
arg3
arg2
arg1
```
