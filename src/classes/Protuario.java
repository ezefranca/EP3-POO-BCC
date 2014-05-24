//////////////////////////////////
/**
 * The below Java Code writes some data to a file in CSV (Comma Separated Value)
 * File
 */
package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Protuario {

    private Writer fw;

    /**
     *
     * @param usuario
     * @param data
     * @param hora
     */
    public void gravar(String usuario, String data, String hora) {

        try {
            fw = new FileWriter("protuario.csv", true);
        } catch (IOException ex) {
            Logger.getLogger(CSVGravar.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw = new PrintWriter(fw);

        //Grava usuario,data,hora em uma nova linha
        pw.print(usuario);
        pw.print(",");
        pw.print(data);
        pw.print(",");
        pw.println(hora);

        //Flush
        pw.flush();

    }

    public ArrayList<ArrayList<String>> ler(String paciente) {
        ArrayList<ArrayList<String>> protuario = new ArrayList<>();
 
        CSVAcesso csv = new CSVAcesso("protuario.csv", "true");
        csv.parse();
        csv.toString();
        System.out.println(csv);
        return csv.retornarTudo();
    }

}
