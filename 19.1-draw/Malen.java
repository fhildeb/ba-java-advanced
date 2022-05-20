package draw;

/**
 * @author grupf
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

// Startklasse
public class Malen {
    public static void main(String[] args) {
        new MalenFrame();

    }
}

// die Oberfl�che
@SuppressWarnings("serial")
class MalenFrame extends JFrame {

    // Konstruktor: Einrichten der Anwendung
    public MalenFrame() {
        super("Malen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocation(200, 200);
        setResizable(false);

        // Container f�r sichtbare Dialogelemente anlegen
        JPanel contentPanel = (JPanel) this.getContentPane();

        // Mitte: Zeichenfl�che erzeuegen

        ZeichenPanel zeichenPanel = new ZeichenPanel();
        contentPanel.add(zeichenPanel, "Center");

        // oben: Farbauswahlpanel
        JPanel farbAuswahlPanel = new JPanel();
        contentPanel.add(farbAuswahlPanel, "North");
        farbAuswahlPanel.setBackground(Color.LIGHT_GRAY);

        // Beschriftung
        farbAuswahlPanel.add(new Label("Mal-Farbe auswaehlen"));

        // Farbauswahl
        Choice farbAuswahl = new Choice();
        farbAuswahl.setFont(new Font("SansSerif", Font.PLAIN, 10));
        farbAuswahl.addItemListener(new MalenFarbAuswahlStrg(zeichenPanel));
        farbAuswahlPanel.add(farbAuswahl);

        // Farben zum Auswaehlen
        farbAuswahl.addItem("Schwarz    ");
        farbAuswahl.addItem("Rot");
        farbAuswahl.addItem("Gelb");
        farbAuswahl.addItem("Gruen");
        farbAuswahl.addItem("Blau");
        farbAuswahl.addItem("Weiss");

        // unten: Knopfpanel
        JPanel knopfPanel = new JPanel();
        contentPanel.add(knopfPanel, "South");
        knopfPanel.setBackground(Color.LIGHT_GRAY);

        // Knopf zum Loeschen des Bildes
        JButton loeschKnopf = new JButton("  Bild loeschen  ");
        knopfPanel.add(loeschKnopf);
        loeschKnopf.addActionListener(new MalenLoeschKnopfStrg(zeichenPanel));

        // Knopf zum Speichern des Bildes
        JButton speicherKnopf = new JButton(" Bild speichern ");
        knopfPanel.add(speicherKnopf);
        speicherKnopf.setEnabled(true);
        speicherKnopf.addActionListener(new MalenSpeicherKnopfStrg(zeichenPanel));

        // Knopf zum Laden eines Bildes
        JButton ladeKnopf = new JButton("   Bild laden   ");
        knopfPanel.add(ladeKnopf);
        ladeKnopf.setEnabled(true);
        ladeKnopf.addActionListener(new MalenLadenKnopfStrg(zeichenPanel));

        // Knopf zum Beenden
        JButton endeKnopf = new JButton("      Ende      ");
        knopfPanel.add(endeKnopf);
        endeKnopf.addActionListener(new MalenEndeKnopfStrg(this));

        // sichtbar machen
        setVisible(true);

        // Fokus auf Farbauswahl setzen
        farbAuswahl.requestFocus();
    }

    // Methode zum Schliessen des Fensters
    void schliessenFenster() {
        dispose();
        System.exit(0);
    }
}

// Klasse f�r die Zeichenfl�che

@SuppressWarnings("serial")
class ZeichenPanel extends JPanel {
    // Malfarbe fuer die Linien, anfangs Schwarz
    private Color malFarbe = Color.BLACK;

    // der Anfangspunkt fuer eine Linie
    private Point anfang;

    // der Endpunkt fuer eine Linie
    private Point ende;

    // zur Doppelpufferung des Bildes
    private Image pufferBild;

    private Graphics pufferGraphik;

    private ArrayList<SpeicherLinie> linien;

    // Konstruktor: Einrichten der Zeichenfl�che
    public ZeichenPanel() {
        setBackground(Color.white);

        // Mausbeobachter ermittelt die Punkte und veranlasst das Zeichnen
        MalenMausStrg mstrg = new MalenMausStrg(this);
        addMouseListener(mstrg);
        addMouseMotionListener(mstrg);

        linien = new ArrayList<SpeicherLinie>();
    }

    // Methode zum Speichern einer Linie
    void speichernLinie() {
        SpeicherLinie linie = new SpeicherLinie(anfang, ende, malFarbe);
        linien.add(linie);
    }

    // Methode zum Zeichnen der Linie
    void zeichnenLinie() {
        // im Hintergrundbild malen
        pufferGraphik.setColor(malFarbe);
        pufferGraphik.drawLine(anfang.x, anfang.y, ende.x, ende.y);
        // neue Darstellung anfordern
        repaint();
    }

    protected void paintComponent(Graphics g) {
        // Hintergrundbild initialisieren, wenn nicht vorhanden
        if (pufferBild == null) {
            pufferBild = createImage(getSize().width, getSize().height);
            pufferGraphik = pufferBild.getGraphics();
            pufferGraphik.setColor(getBackground());
            pufferGraphik.fillRect(0, 0, getSize().width, getSize().height);
        }
        g.drawImage(pufferBild, 0, 0, this);
    }

    // Methode zum Setzen der Malfarbe
    void setzenFarbe(String auswahl) {
        if (auswahl.equals("Schwarz")) {
            malFarbe = Color.black;
        } else if (auswahl.equals("Rot")) {
            malFarbe = Color.red;
        } else if (auswahl.equals("Gelb")) {
            malFarbe = Color.yellow;
        } else if (auswahl.equals("Gruen")) {
            malFarbe = Color.green;
        } else if (auswahl.equals("Blau")) {
            malFarbe = Color.blue;
        } else if (auswahl.equals("Weiss")) {
            malFarbe = Color.white;
        }
    }

    // Methode zum Setzen des Anfangspunktes
    void setzenAnfangPunkt(Point p) {
        anfang = p;
    }

    // Methode zum Setzen des Endpunktes
    void setzenEndePunkt(Point p) {
        ende = p;
    }

    // Methode zum L�schen des Bilds
    void loeschenBild() {
        // Hintergrundbild neu anlegen
        pufferBild = createImage(getSize().width, getSize().height);
        pufferGraphik = pufferBild.getGraphics();
        pufferGraphik.setColor(getBackground());
        pufferGraphik.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
        linien = new ArrayList<SpeicherLinie>();
    }

    // Methode zum Speichern des Bildes
    public void speichernBild() {

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(file)));
                oos.writeObject(linien);
                oos.flush();
            } catch (IOException e) {
                System.out.println("Fehler beim Speichern!");
            } finally {
                try {
                    oos.close();
                } catch (IOException ex) {
                }
            }

        }
    }

    // Methode zum Laden des Bildes
    @SuppressWarnings("unchecked")
    public void ladenBild() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            loeschenBild(); // Altes Bild l�schen
            File file = chooser.getSelectedFile();

            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)));
                linien = (ArrayList<SpeicherLinie>) ois.readObject();

            } catch (IOException e) {
                System.out.println("Fehler beim Laden!");
            } catch (ClassNotFoundException exx) {
                System.out.println("Fehler beim Casten!");
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }

        } // Ende if

        if (linien != null) {
            Color alteMalFarbe = malFarbe;
            SpeicherLinie linie;
            for (int i = 0; i < linien.size(); i++) {
                linie = linien.get(i);
                anfang = linie.holenAnfang();
                ende = linie.holenEnde();
                malFarbe = linie.holenMalFarbe();
                zeichnenLinie();

            }
            malFarbe = alteMalFarbe;
        }

    }

}

// die Beobachter-Klassen

// Klasse zur Steuerung fuer die Farbauswahl
class MalenFarbAuswahlStrg implements ItemListener {

    private ZeichenPanel zeichenPanel;

    public MalenFarbAuswahlStrg(ZeichenPanel z) {
        zeichenPanel = z;
    }

    public void itemStateChanged(ItemEvent e) {
        String auswahl = ((String) e.getItem()).trim();
        zeichenPanel.setzenFarbe(auswahl);
    }
}

// Steuerung fuer den LoeschKnopf
class MalenLoeschKnopfStrg implements ActionListener {

    private ZeichenPanel zeichenPanel;

    public MalenLoeschKnopfStrg(ZeichenPanel z) {
        zeichenPanel = z;
    }

    public void actionPerformed(ActionEvent e) {
        zeichenPanel.loeschenBild();
    }
}

// Steuerung fuer den EndeKnopf
class MalenEndeKnopfStrg implements ActionListener {

    private MalenFrame frame;

    public MalenEndeKnopfStrg(MalenFrame f) {
        frame = f;
    }

    public void actionPerformed(ActionEvent e) {
        frame.schliessenFenster();
    }

}

// Steuerung fuer den SpeicherKnopf
class MalenSpeicherKnopfStrg implements ActionListener {

    private ZeichenPanel zeichenPanel;

    public MalenSpeicherKnopfStrg(ZeichenPanel z) {
        zeichenPanel = z;
    }

    public void actionPerformed(ActionEvent e) {
        zeichenPanel.speichernBild();
    }
}

// Steuerung fuer den LadeKnopf
class MalenLadenKnopfStrg implements ActionListener {

    private ZeichenPanel zeichenPanel;

    public MalenLadenKnopfStrg(ZeichenPanel z) {
        zeichenPanel = z;
    }

    public void actionPerformed(ActionEvent e) {
        zeichenPanel.ladenBild();
    }
}

// die Maussteuerung fuer das Malen
class MalenMausStrg implements MouseListener, MouseMotionListener {

    private ZeichenPanel zeichenPanel;

    public MalenMausStrg(ZeichenPanel z) {
        zeichenPanel = z;
    }

    // Methoden von MouseListener und MouseMotionListener implementieren

    // beim Druecken der Maustaste kann das Zeichnen beginnen
    public void mousePressed(MouseEvent e) {
        zeichenPanel.setzenAnfangPunkt(e.getPoint());
    }

    // beim Verschieben der Maus mit gedrueckter Taste wird gemalt
    public void mouseDragged(MouseEvent e) {
        zeichenPanel.setzenEndePunkt(e.getPoint());
        zeichenPanel.speichernLinie();
        zeichenPanel.zeichnenLinie();
        zeichenPanel.repaint();
        zeichenPanel.setzenAnfangPunkt(e.getPoint());
    }

    // die anderen Methoden sind leer
    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}
