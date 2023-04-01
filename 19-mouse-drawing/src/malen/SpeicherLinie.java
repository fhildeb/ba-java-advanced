package malen;

import java.io.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SpeicherLinie implements Serializable {
	private Point anfang;
	private Point ende;
	private Color malFarbe;

	public SpeicherLinie(Point a, Point e, Color f) {
		anfang = a;
		ende = e;
		malFarbe = f;
	}

	public Point holenAnfang() {
		return anfang;
	}

	public Point holenEnde() {
		return ende;
	}

	public Color holenMalFarbe() {
		return malFarbe;
	}

}