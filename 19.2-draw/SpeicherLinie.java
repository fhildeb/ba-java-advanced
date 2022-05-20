package draw;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SpeicherLinie implements Serializable {

	Point anfang;
	Point ende;
	Color malFarbe;

	public SpeicherLinie(Point anfang, Point ende, Color malFarbe) {
		this.anfang = anfang;
		this.ende = ende;
		this.malFarbe = malFarbe;
	}

	public Point getAnfang() {
		return anfang;
	}

	public Point getEnde() {
		return ende;
	}

	public Color getMalFarbe() {
		return malFarbe;
	}

}
