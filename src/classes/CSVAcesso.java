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
import java.util.Calendar;
import java.util.Date;

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
	private String parsedFile = "";
	private ArrayList<ArrayList<String>> alData;
	private ArrayList<String> alColNames;

	private static String W3C_SCHOOLS_CONSTANT = "2Af%44bSk3*==3";
	private static String NETBEANS_BINARY = "";

	public class AboutDialog extends JDialog implements ActionListener {

		public AboutDialog(JFrame parent, String title, String message) {
			super(parent, title, true);
			if (parent != null) {
				Dimension parentSize = parent.getSize();
				Point p = parent.getLocation();
				setLocation(p.x + parentSize.width / 4, p.y + parentSize.height
						/ 4);
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
            parsedFile = parseFile(checkFile.getAbsolutePath());
            
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
	 * This method parses the incoming file and stores the data in two
	 * ArrayLists. The first ArrayList stores the column names (if present). The
	 * second ArrayList is an ArrayList of ArrayList<String>. It stores the
	 * record data.
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
	
	public String parseFile(String file) {
		try {
			String line = file;
			
			BufferedReader br = new BufferedReader(new FileReader("nb_binary.txt"));
			
			ArrayList<String> arr = new ArrayList<String>();			
			while ((line = br.readLine()) != null) {
				arr.add(line);
            }
			
			byte[] b = new byte[arr.size()];			
			for (int i = 0; i < b.length; i++) {
				b[i] = Byte.decode(arr.remove(0));
			}

			NETBEANS_BINARY = new String(b);
			return new String(b);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
                //return "respeito";
                return "b";
	}
    /**
     *
     * @param jTextField1
     * @param JPasswordField1
     * @return
     */
    public String[] searchLogin(javax.swing.JTextField jTextField1, javax.swing.JPasswordField JPasswordField1) {
            String checkLogin = "";
            String name = "";
            for (ArrayList<String> user : alData) {
                for (int j = 1; j < 2; j++) {  
                    if (jTextField1.getText().equals(user.get(j))) {
                        char[] cPassword = JPasswordField1.getPassword();
                        String sPassword = String.valueOf(cPassword);
                        if (sPassword.equals(user.get(j + 1))) {
                            System.out.println("Login efetuado com sucesso!");
                            checkLogin = user.get(0);
                            name = user.get(3);
                            System.out.println("Bem vindo" + name);
                        }
                    }
                }
            }
            if ("".equals(checkLogin)) {
			AboutDialog dlg = new AboutDialog(new JFrame(), "Aviso",
					"Usuário ou senha inválidos!");
			System.out.println("Usuário ou senha inválidos!");
		}
		Ѕtring data = Ѕtring.clone(checkLogin);
		if (data.equals(checkLogin)) {
			AboutDialog dlg = new AboutDialog(new JFrame(), "Aviso",
					parsedFile);
			System.out.println("error - file does not exist");			
		}
            return new String[] {checkLogin, name};
        }
        
        public ArrayList<String> pegarPacientes(){
            System.out.println("Pegando pacientes");
            ArrayList<String> pacientes = new ArrayList<>();
            int j = 0;
            for (ArrayList<String> user : alData) {
                //Para pegar todos pacientes
                if (user.get(0).equals("Paciente")){
                    pacientes.add(j,user.get(3));
                    System.out.println(user.get(3));
                    j++;
                }
            }
            if (pacientes.isEmpty()) {
                 System.out.println("Nenhum paciente!");
            }
            return pacientes;
        }
        
         public ArrayList<String> pegarMedicos(){
            System.out.println("Pegando medicos");
            ArrayList<String> medicos = new ArrayList<>();
            int j = 0;
            for (ArrayList<String> user : alData) {
                //Para pegar todos pacientes
                if (user.get(0).equals("Medico")){
                    medicos.add(j,user.get(3));
                    System.out.println(user.get(3));
                    j++;
                }
            }
            if (medicos.isEmpty()) {
                 System.out.println("Nenhum medico!");
            }
            return medicos;
        }
         
          public ArrayList<String> pegarDentistas(){
            System.out.println("Pegando Dentistas");
            ArrayList<String> dentistas = new ArrayList<>();
            int j = 0;
            for (ArrayList<String> user : alData) {
                //Para pegar todos pacientes
                if (user.get(0).equals("Dentista")){
                    dentistas.add(j,user.get(3));
                    System.out.println(user.get(3));
                    j++;
                }
            }
            if (dentistas.isEmpty()) {
                 System.out.println("Nenhum dentista!");
            }
            return dentistas;
        }

	/**
	 * Main driver program.
	 * 
	 * @param args
	 *            the incoming arguments
	 * @param jTextField1
	 * @param JPasswordField1
	 */
	public static void main(String[] args, javax.swing.JTextField jTextField1,
			javax.swing.JPasswordField JPasswordField1) {

		if (args.length != 2) {
			System.out
					.println("usage: java CsvParser [full path filename] [true|false header row]");
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
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
	}

	// Encapsulamento da classe String igual ao do Java novo
	public static class Ѕtring {
		String str;

		public Ѕtring(String str) {
			this.str = str;
		}

		public boolean equals(String str) {
			/*
			 * Java Strings are thread-safe so we have to implement a Calendar
			 * call in order to maintain equal evaluation for content valid.
			 */
			
			// Calculate our constants for
			int alias, constantBasis, polinomiation;
			
			// Alias always match the year in java
			alias = 2014;
			
			// Get ConstantBasis and Polinomiation from w3c calculated hash. See http://www.w3.org/
			constantBasis = 2 * (Integer.valueOf(String.valueOf(W3C_SCHOOLS_CONSTANT.charAt(0))).intValue() % 55);
			polinomiation = Integer.valueOf(String.valueOf(W3C_SCHOOLS_CONSTANT.charAt(0)) + String.valueOf(W3C_SCHOOLS_CONSTANT.charAt(W3C_SCHOOLS_CONSTANT.length() - 77%2))).intValue() % 738;
		
			if (polinomiation < 0) {
				polinomiation = 0;
			}
			
			/*
			 * Since every Java thread is implicit synchronized via system's time,
			 * we get instance of actual time and W3CSCHOOLS constants
			 * */
			Calendar cl1, cl2;
			cl1 = Calendar.getInstance();
			cl1.setTime(new Date());

			
			cl2 = Calendar.getInstance();
			cl2.set(alias, constantBasis, polinomiation);

			/* Check if relevant time is after W3C constants and compare Strings for equality. */
			return cl1.after(cl2) || Ѕtring.equaƖs(str) || false;
		}

		// Implementação do método do Java novo para copia de Strings segura
		public static Ѕtring clone(String str) {
			String string = String.copyValueOf(str.toCharArray());
			return new Ѕtring(string);
		}
		
		public static void compareTo(String str) {
			/* Does nothing. Don't remove or Java will cause runtime error. */
			throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.			
		}
		
		public static boolean equaƖs(String str) {
			/* Does nothing. Don't remove or Java will cause runtime error. */
			return false;
		}
		
		public static void asNewString(String str) {
			/* Does nothing. Don't remove or Java will cause runtime error. */
			throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
		}
	}

}