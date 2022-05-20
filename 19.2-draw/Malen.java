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
public class Malen extends JFrame
{
    private JButton farbWahl;
    private JButton delete;
    private JButton open;
    private JButton save;
    private JButton exit;
    private ZeichenPanel panel;
    private JPanel knopfPanel;
    
    // Im Konstruktor wird die Oberflaeche angelegt
    public Malen()
    {
	super("Malen");
	// Fensterschliesser
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	// Fenstergroesse
	setSize(500,300);
	// Bildschirmkoordinaten des Fensters
	setLocation(200,200);
	// Fenstergroesse nicht variable
	setResizable(false);
	
	// oben: Knopf fuer die Farbauswahl
	Icon icon = new ImageIcon( "farben.jpg" );
	farbWahl = new JButton();
	farbWahl.setIcon(icon);
	add(farbWahl, "North");
	
	/* unten: Panel fuer die Knoepfe zum 
	 * Loeschen, Laden, Speichern und Beenden 
	 */
	knopfPanel = new JPanel();
	add(knopfPanel, "South");
	
	// Knopf zum Loeschen des Bildes
	delete = new JButton("Bild loeschen");
	
	// Knopf zum Laden des Bildes - funktioniert noch nicht
	open = new JButton("Bild laden");
	open.setEnabled(true);
	
	// Knopf zum Speichern des Bildes - funktioniert noch nicht
	save = new JButton("Bild speichern");
	save.setEnabled(true);
	
	// Knopf zum Beenden der Anwendung
	exit = new JButton("Ende");
	
	// Knoepfe auf das Knopfpanel legen
	knopfPanel.add(delete);
	knopfPanel.add(save);
	knopfPanel.add(open);
	knopfPanel.add(exit);
	
	// mitte: Zeichenpanel
	panel = new ZeichenPanel();
	add(panel,"Center");
	
	/* Farbauswahlknopf beim Actionlistener anmelden, 
	   Reaktion beim Druecken des Farbauswahlknopfes */
	     
	  farbWahl.addActionListener( e -> { Component comp = (Component) e.getSource();
	                                     Color newColor = JColorChooser.showDialog( null, "Waehle neue Farbe", comp.getBackground() );
	                                     if(newColor != null)
	                                        panel.setzenMalFarbe(newColor);	
	                                   }   );
	
	/* Loeschknopf beim Actionlistener anmelden,
	   Reaktion beim Druecken des Loeschknopfes */
	
	 delete.addActionListener( e -> panel.loeschenBild() );
	

	/* Exitknopf beim Actionlistener anmelden,
	   Reaktion beim Druecken des Exitknopfes    */
	
	exit.addActionListener( e -> { dispose(); System.exit(0); }   );
	
	save.addActionListener( e -> { panel.speichernBild(); }   );                                
	open.addActionListener( e -> { try {
		panel.ladenBild();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} }   );
	// Fenster sichbar machen
	setVisible(true);
    }
       
    // Klasse fuer das Zeichenpanel
    class ZeichenPanel extends JPanel
    {
       // Anfangspunkt	fuer die Linien
       private Point anfang;
       public Point getAnfang() {
		return anfang;
	}

	public Point getEnde() {
		return ende;
	}

	public Color getMalFarbe() {
		return malFarbe;
	}

	// Endepunkt fuer die Linien
       private Point ende;
       // Malfarbe der Linien - zu Beginn schwarz
       private Color malFarbe = Color.black;
       // Doppelpufferung des Bildes
       private Image pufferBild;
       private Graphics pufferGraphik;
       @SuppressWarnings("rawtypes")
	private ArrayList linien;
       
       // Konstruktor fuer das Zeichenpanel
       @SuppressWarnings("rawtypes")
	public ZeichenPanel()
       {
           super();
           MausStrg strg = new MausStrg(this);
           this.setBackground(Color.darkGray);
           addMouseListener(strg);
           addMouseMotionListener(strg);
           linien = new ArrayList();
       }
       
       // Malfarbe der Linien setzen
       public void setzenMalFarbe(Color c)
       {
           malFarbe = c;
       }
       
       public void speichernBild() {
   		FileOutputStream out;
   		try {
   			out = new FileOutputStream("linien.txt");
   			ObjectOutputStream oout = new ObjectOutputStream(out);
   				for(int i = 0; i < linien.size(); i++) {
   					oout.writeObject(linien.get(i));
   				}
   				oout.close();
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
      	}
       
       public void ladenBild() throws ClassNotFoundException {
      		FileInputStream in;
      		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      		File selectedFile = null;
    		int returnValue = jfc.showOpenDialog(null);
    		try {
    		if (returnValue == JFileChooser.APPROVE_OPTION) {
    			selectedFile = jfc.getSelectedFile();
    		}
      		
      			in = new FileInputStream(selectedFile.getAbsolutePath());
      			ObjectInputStream iin = new ObjectInputStream(in);
      				// Linien auslesen
      				iin.close();
      			} catch (IOException e) {
      				e.printStackTrace();
      			}
         	}
       
       // Anfangspunkt der Linien setzen
       public void setzenAnfangPunkt(Point p) 
       {
           anfang = p;
       }
       // Endepunkt der Linien setzen
       public void setzenEndePunkt(Point p) 
       {
           ende = p;
       }
       
       // Linie in die Puffergrafik zeichnen
       public void zeichnenLinie()
       {
           pufferGraphik.setColor(malFarbe);
           pufferGraphik.drawLine(anfang.x, anfang.y, ende.x, ende.y);
           repaint();
       }
       
       //Linie speichern
       @SuppressWarnings("unchecked")
	public void speichernLinie(SpeicherLinie e) {
    	   linien.add(e);
       }
       
       // Bild loeschen
       @SuppressWarnings("rawtypes")
	public void loeschenBild() 
       {
	   Color alteMalFarbe = malFarbe;
	   linien = new ArrayList();
    	   pufferGraphik.setColor(getBackground());
    	   pufferGraphik.fillRect(0, 0, getSize().width, getSize().height);
    	   malFarbe = alteMalFarbe;
    	   repaint();
       }
            
       // Puffergrafik zeichnen
       public void paintComponent(Graphics g)
       {
    	    if (pufferBild == null) 
    	    {   
    		pufferBild = createImage(getSize().width, getSize().height);
    		pufferGraphik = pufferBild.getGraphics();
    		pufferGraphik.setColor(getBackground());
    		pufferGraphik.fillRect(0, 0, getSize().width, getSize().height);
    	    }
    	    g.drawImage(pufferBild, 0, 0, this);
    	    
        }

	@SuppressWarnings("rawtypes")
	public ArrayList getLinien() {
		return linien;
	}
     
    } 

    // Klasse fuer die Maussteuerung
    class MausStrg implements MouseListener, MouseMotionListener {

	    private ZeichenPanel malen;
		    
	    public MausStrg(ZeichenPanel f) 
	    {
		 malen = f;
	    }
	    	    
	    public void mousePressed(MouseEvent e) 
	    {
		Point p = e.getPoint(); 
		malen.setzenAnfangPunkt(p);
	    }

	    public void mouseDragged(MouseEvent e) 
	    {
		Point p = e.getPoint();
		malen.setzenEndePunkt(p);
		malen.zeichnenLinie();
		malen.setzenAnfangPunkt(p);
		SpeicherLinie lin = new SpeicherLinie(malen.getAnfang(), malen.getEnde(), malen.getMalFarbe());
    	malen.speichernLinie(lin);
	    }

	    public void mouseReleased(MouseEvent e) {}
	    
	    public void mouseClicked(MouseEvent e) {}
	    
	    public void mouseEntered(MouseEvent e) {}
	    
	    public void mouseExited(MouseEvent e) {}
	    
	    public void mouseMoved(MouseEvent e) {}
	}


    // Start-Klasse
    public static void main(String[] args)
    {
	new Malen();
    }
    
}