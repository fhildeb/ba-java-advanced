package draw;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// Oberflaeche
@SuppressWarnings("serial")
public class Malen extends JFrame {
	private JButton farbWahl;
	private JButton delete;
	private JButton open;
	private JButton save;
	private JButton exi
	vate ZeichenPanel panel;
		 JPanel knopfPane

	Im Konstruktor wird die Oberflaeche angelegt
	public Malen() {
		super("Malen");
		// Fensterschliesser
			setDefaultCloseOperat

		// Fenstergroesse

	 Bildschirmkoordinaten des Fensters
	tLocation(200, 200);
		stergroesse nic
		izable(false);
		
		n: Knopf fuer die Farb
		con = new ImageIcon(

		hl.setIcon(icon);
		rbWahl, "North");

		

		schen, Laden, Speichern und Beenden
		

		opfPanel, "South");
		
		pf zum Loeschen des Bildes
		 = new JButton("Bild loeschen");

		pf zum Laden de
		 new JButton("Bild laden");

		
		pf zum Speichern des Bildes - funk
		 new JButton("Bild speichern");
		etEnabled(true);
		

		 new JButton("Ende");
		
		epfe auf das Knopfpanel leg
		anel.add(delete);
		anel.add(save);
		anel.add(open);
		anel.add(exit);

		te: Zeichenpanel
		= new ZeichenPanel();
		nel, "Center");
		

		bauswahlknopf beim Actionlistene
		ktion beim Druecken des Farbauswahlknopfes
		
		

		nent comp = (Component) e.getSour
		 newColor = JColorChooser.showDialog(null, "Waehle neue 
		ewCo

		l.setzen

		
		
		
		
		schknopf beim Actionlistener anmelden,
		ktion beim Druecken des Lo
		
		

		
		
	knopf beim Actionlistener

	
		
		ddActi
	

		
		

	anel.speichernBild();
	;
		ddActionLi
		
	panel.ladenBild();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		// Fenster sichbar mache

	tVisible(true);
	

	Klasse fuer das Zeichenpanel
	ss ZeichenPanel exten

	 ntanfang;
	
		
		
		anfang;
		
	
	blic Point getEnde() {

	

	blic Color getMalFarbe() {
	eturn malFarbe;
		

		epunkt fuer die Linien
		e Point ende;
		farbe der Linien - zu Be
		e Color malFarbe = Color.black
 
	e Image puf

	rBild;
	i

	ivate ArrayList linien;
	
		struktor fuer das Zeichenpanel
		

	ssWarnings("rawty
	
	
	ausStrg strg = new MausStrg(this)
	his.setBackground(Colo
		useListener(strg);
		useMotionListener(strg);
		n = new ArrayList();
		
		
	 

	alFarbe = c;
		
		
			d speichernBild() {
			tStream out;
			
			w FileOutputStream("linien.txt");
		c
		(int i = 0; i < linien.size(); i++) 
		

	oout.close();
	 catch (IOException e) {
		intStackTrace();
			
		
			
		 void ladenBild() throws ClassNotFou
			Stream in;
		Chooser jfc = new JFileChooser(FileSy
			ctedFile = null;
		eturnValue = jfc.showOpenDialog(null
			
		returnValue == JFileChooser.APPROVE_O
			dFile = jfc.getSelected
		
	

	ObjectInputStream iin = new ObjectInputS
	// Linien auslesen
		close();
	 

	
	
		
	 

	nfang = p;
	
		
		epunkt der Linien setzen
		 void setzenEndePunkt(Point p) {
		= p;
		
		
		ie in die Puffergrafik zeichnen
	b

	ufferGraphik.drawLine(anfang.x, anf
	epaint();

		
		ie speichern
		essWarnings("unchecked")

			d(e);

			
			esche
				ngs("rawtypes")
						ld() {
								;
				ArrayList();
				.setColor(ge
			phik.fillRect(0, 0, getSi
				teMalFarbe;
			;
				
					
				k zeichnen
				i
			r

		e
	p

	
	.drawImage(pufferBild, 0, 0, t
	
		
		
		essWarnings("rawtypes")
			ayList getLinien() {
			nien;

			
			
				
						steuerung
								Listener, MouseMotionListene
				

			
				g(ZeichenPanel f) {
			;
				
			
				usePr
					int();
				nfangPunkt(p);
				
			

		 p = e.getPo

		.zeichnenLinie();
			zenAnfangPunkt(p);
			inie lin = new Speic
			ichernLinie(lin);
				
				
				useReleased(MouseEvent e)
				
				

			
			
		 

	
		public void mouseExited(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}
	}


	lic static void main(String[] args

	
		
	

	
		
		
	

	

	
		
	

	
		
	

	

	
		
	

	
		
	

	

	
		
	

	
		
	

	

	
		
	

	
		
	

	

	
		
	

	

	
	
		
	

	
	
		
		
		
		
		
	

	
	
	

	
	

	
	

	
	

	
	