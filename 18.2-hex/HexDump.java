package hex;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HexDump extends JFrame {

    private JPanel jContentPane = null;

    private JMenuBar jJMenuBar = null;

    private JMenu fileMenu = null;

    private JMenuItem exitMenuItem = null;

    private JMenuItem openMenuItem = null;

    private JLabel dateiLabel = null;

    private JTextField dateiTextField = null;

    private JScrollPane jScrollPane = null;

    private JLabel neueDateiLabel = null;

    private JTextField neueDateiTextField = null;

    private JButton dumpButton = null;

    private JTextArea dumpTextArea = null;

    /**
     * This method initializes jTextField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getDateiTextField() {
        if (dateiTextField == null) {
            dateiTextField = new JTextField();
            dateiTextField.setBounds(new java.awt.Rectangle(53, 12, 375, 18));
            dateiTextField.setBackground(new java.awt.Color(238, 238, 238));
            dateiTextField.setEditable(false);
            dateiTextField.setText("");
            dateiTextField.setFont(new java.awt.Font("Courier New",
                    java.awt.Font.PLAIN, 12));
        }
        return dateiTextField;
    }

    /**
     * This method initializes jScrollPane
     * 
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setBounds(new java.awt.Rectangle(12, 40, 416, 218));
            jScrollPane.setViewportView(getDumpTextArea());
        }
        return jScrollPane;
    }

    /**
     * This method initializes jTextField1
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getNeueDateiTextField() {
        if (neueDateiTextField == null) {
            neueDateiTextField = new JTextField();
            neueDateiTextField.setBounds(new java.awt.Rectangle(87, 270, 261,
                    18));
            neueDateiTextField.setText("");
            neueDateiTextField.setFont(new java.awt.Font("Courier New",
                    java.awt.Font.PLAIN, 12));
        }
        return neueDateiTextField;
    }

    /**
     * This method initializes jButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getDumpButton() {
        if (dumpButton == null) {
            dumpButton = new JButton();
            dumpButton.setBounds(new java.awt.Rectangle(353, 270, 75, 18));
            dumpButton.setText("dump");
            dumpButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String filename = neueDateiTextField.getText();
                    try {
                        dumpTextArea.setText(HexDumpTool.dump(filename));
                        dateiTextField.setText(filename);
                        neueDateiTextField.setText("");
                    } catch (IOException ioe) {
                        dumpTextArea.setText("Fehler bei " + filename);
                        neueDateiTextField.setText("");
                    }
                    // System.out.println("actionPerformed()"); // TODO
                    // Auto-generated Event stub actionPerformed()
                }
            });
        }
        return dumpButton;
    }

    /**
     * This method initializes jTextArea
     * 
     * @return javax.swing.JTextArea
     */
    private JTextArea getDumpTextArea() {
        if (dumpTextArea == null) {
            dumpTextArea = new JTextArea();
            dumpTextArea.setFont(new java.awt.Font("Courier New",
                    java.awt.Font.PLAIN, 12));
        }
        return dumpTextArea;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HexDump application = new HexDump();
        application.setVisible(true);
    }

    /**
     * This is the default constructor
     */
    public HexDump() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new java.awt.Dimension(450, 350));
        this.setMinimumSize(new java.awt.Dimension(500, 400));
        this.setJMenuBar(getJJMenuBar());
        this.setSize(450, 350);
        this.setContentPane(getJContentPane());
        this.setTitle("HexDump");
        this.setVisible(true);
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            neueDateiLabel = new JLabel();
            neueDateiLabel.setBounds(new java.awt.Rectangle(12, 270, 71, 18));
            neueDateiLabel.setText("neue Datei");
            dateiLabel = new JLabel();
            dateiLabel.setBounds(new java.awt.Rectangle(12, 12, 38, 18));
            dateiLabel.setText("Datei");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(dateiLabel, null);
            jContentPane.add(getDateiTextField(), null);
            jContentPane.add(getJScrollPane(), null);
            jContentPane.add(neueDateiLabel, null);
            jContentPane.add(getNeueDateiTextField(), null);
            jContentPane.add(getDumpButton(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes jJMenuBar
     * 
     * @return javax.swing.JMenuBar
     */
    private JMenuBar getJJMenuBar() {
        if (jJMenuBar == null) {
            jJMenuBar = new JMenuBar();
            jJMenuBar.add(getFileMenu());
        }
        return jJMenuBar;
    }

    /**
     * This method initializes jMenu
     * 
     * @return javax.swing.JMenu
     */
    private JMenu getFileMenu() {
        if (fileMenu == null) {
            fileMenu = new JMenu();
            fileMenu.setText("Datei");
            fileMenu.add(getOpenMenuItem());
            fileMenu.addSeparator();
            fileMenu.add(getExitMenuItem());
        }
        return fileMenu;
    }

    /**
     * This method initializes jMenuItem
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getExitMenuItem() {
        if (exitMenuItem == null) {
            exitMenuItem = new JMenuItem();
            exitMenuItem.setText("beenden");
            exitMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return exitMenuItem;
    }

    /**
     * This method initializes jMenuItem
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getOpenMenuItem() {
        if (openMenuItem == null) {
            openMenuItem = new JMenuItem();
            openMenuItem.setText("oeffnen");
            openMenuItem.setActionCommand("Open");
            openMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File(System
                            .getProperty("user.dir")));
                    int returnVal = chooser.showOpenDialog(HexDump.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String filename = chooser.getSelectedFile().toString();
                        try {
                            dumpTextArea.setText(HexDumpTool.dump(filename));
                            dateiTextField.setText(filename);
                            neueDateiTextField.setText("");
                        } catch (IOException ioe) {
                            dateiTextField.setText(ioe.getMessage());
                            dumpTextArea.setText("");
                            neueDateiTextField.setText("");
                        }
                    } else {
                        dateiTextField.setText("");
                        dumpTextArea.setText("");
                        neueDateiTextField.setText("");
                    }
                    // System.out.println("actionPerformed()"); // TODO
                    // Auto-generated Event stub actionPerformed()
                }
            });
        }
        return openMenuItem;
    }

} // @jve:decl-index=0:visual-constraint="10,10"