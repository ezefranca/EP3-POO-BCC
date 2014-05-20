/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ezefranca
 */
public class CSVAcesso extends TelaInicial {

    private boolean bHeaderRow = false;

    private String sFileFullPath = "";
    private ArrayList<ArrayList<String>> alData;
    private ArrayList<String> alColNames;

    public class AboutDialog extends JDialog implements ActionListener {

        public AboutDialog(JFrame parent, String title, String message) {
            super(parent, title, true);
            if (parent != null) {
                Dimension parentSize = parent.getSize();
                Point p = parent.getLocation();
                setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
            }
            JPanel messagePane = new JPanel();
            messagePane.add(new JLabel(message));
            getContentPane().add(messagePane);
            JPanel buttonPane = new JPanel();
            JButton button = new JButton("OK");
            buttonPane.add(button);
            button.addActionListener(this);
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(messagePane, BorderLayout.CENTER);
            pack();
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
}
        /*
         * Custom constructor.
         */

        public CSVAcesso(String f, String b) {

            /**
             * check for null arguments
             */
            if (f == null || b == null) {
                System.err.println("error - argument is null");
                System.exit(0);
            }

            /**
             * set properties
             */
            bHeaderRow = Boolean.valueOf(b);
            sFileFullPath = f;

            /**
             * verify that the file exists
             */
            File checkFile = new File(sFileFullPath);
            System.out.println(sFileFullPath);

            if (!checkFile.exists()) {
                System.err.println("error - file does not exist: " + sFileFullPath);
                System.exit(0);
            }

            /**
             * initialize our data structures
             */
            alData = new ArrayList<>();
            alColNames = new ArrayList<>();

        }

        /*
         * This method parses the incoming file and stores the data in two ArrayLists.
         * The first ArrayList stores the column names (if present).
         * The second ArrayList is an ArrayList of ArrayList<String>. It stores the record
         * data.
         */
        public void parse() {

            BufferedReader br = null;
            boolean bSeenHeader = false;
            try {
                String line;
                br = new BufferedReader(new FileReader(sFileFullPath));

                /**
                 * read entire lines, one at a time
                 */
                while ((line = br.readLine()) != null) {

                    if (bHeaderRow && !bSeenHeader) {
                        /**
                         * process the header row
                         */
                        alColNames = new ArrayList<>(Arrays.asList(line.split(",")));
                        bSeenHeader = true;
                    } else {
                        /**
                         * process normal rows
                         */
                        String arr[] = line.split(",");
                        alData.add(new ArrayList<>(Arrays.asList(arr)));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
         * Print the data nicely.
         */
        public String searchLogin(javax.swing.JTextField jTextField1, javax.swing.JPasswordField JPasswordField1) {
            String checkLogin = "";
            for (int i = 0; i < alData.size(); i++) {
                ArrayList<String> user = alData.get(i);
                for (int j = 1; j < 2; j++) {
                    if (jTextField1.getText().equals(user.get(j))) {
                        char[] cPassword = JPasswordField1.getPassword();
                        String sPassword = String.valueOf(cPassword);
                        if (sPassword.equals(user.get(j + 1))) {
                            System.out.println("Login efetuado com sucesso!");
                            checkLogin = user.get(0);
                        }
                    }
                }
            }
            if ("".equals(checkLogin)) {
                AboutDialog dlg = new AboutDialog(new JFrame(), "Aviso", "Usuário ou senha inválidos!");
                System.out.println("Usuário ou senha inválidos!");
            }
            return checkLogin;
        }

        /**
         * Main driver program.
         *
         * @param args the incoming arguments
         * @param jTextField1
         * @param JPasswordField1
         */
        public static void main(String[] args, javax.swing.JTextField jTextField1, javax.swing.JPasswordField JPasswordField1) {

            if (args.length != 2) {
                System.out.println("usage: java CsvParser [full path filename] [true|false header row]");
                return;
            }

            CSVAcesso parser = new CSVAcesso(args[0], args[1]);
        }

        public boolean isHeaderRowPresent() {
            return bHeaderRow;
        }

        public void setHeaderRowPresent(boolean bHeaderRow) {
            this.bHeaderRow = bHeaderRow;
        }

        public String getsFileFullPath() {
            return sFileFullPath;
        }

        public void setsFileFullPath(String sFileFullPath) {
            this.sFileFullPath = sFileFullPath;
        }

        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
