# Rechtschreibung (Main)

This program offers a simple spelling aid that checks a text against a dictionary of correctly spelled words. It reads the dictionary from a text file and stores it in a HashSet. The program scans the input text line by line, identifying any misspelled words and keeping them in a HashMap. Finally, it generates an error report displaying the line numbers and the misspelled words found in those lines.

## Terminal Output

```bash
Zeile 1: in diesem paktikum lernen sie wie man daten in dateien mit
gesammelte Fehler: {1=[paktikum]}
Zeile 2: wahlfreiem zugriff engl random access files speichen
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen]}
Zeile 3: kann derartige dateien kann man sich als arrays auf einem
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[]}
Zeile 4: speichermedium vortellen die rolle des index fuer den
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen]}
Zeile 5: zugriff auf ein bestimtes datenelment uebernimmt dabei ein
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment]}
Zeile 6: dateiziger engl file pointer der die stelle angibt an
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer]}
Zeile 7: der der naechste zugriff auf die datei stattfindet bei
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[]}
Zeile 8: lesen oder schreiben wird dieser zeiger um die ensprechende
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende]}
Zeile 9: anzahl von bytes versetzt
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[]}
Zeile 10:
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[]}
Zeile 11: in einem einfachn beispiel sehen sie wie man zahlen in
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn]}
Zeile 12: einer datei mit wahlfreiem zugriff speichen und wieder
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen]}
Zeile 13: auslesen kann ein zweites beispiel zeigt ihnen anhand
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen], 13=[]}
Zeile 14: von zeichenkettn wie auch daten unterschiedlicher laenge
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen], 13=[], 14=[zeichenkettn]}
Zeile 15: in einer datei mit wahlfreiem zugriff abgelegt werden
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen], 13=[], 14=[zeichenkettn], 15=[]}
Zeile 16: koennen wenn man in einer zughoerigen index-datei die
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen], 13=[], 14=[zeichenkettn], 15=[], 16=[zughoerigen, index-datei]}
Zeile 17: datepositionen speichert
gesammelte Fehler: {1=[paktikum], 2=[engl, speichen], 3=[], 4=[vortellen], 5=[bestimtes, datenelment], 6=[dateiziger, engl, file, pointer], 7=[], 8=[ensprechende], 9=[], 10=[], 11=[einfachn], 12=[speichen], 13=[], 14=[zeichenkettn], 15=[], 16=[zughoerigen, index-datei], 17=[datepositionen]}
```
