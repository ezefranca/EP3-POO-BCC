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

public class Questionario {
     private final String arquivo = "questionario.csv";

    private Writer fw;

    /**
     *
     * @param paciente
     * @param questao
     */
    public void gravar(String paciente, String[] questao) {

        try {
            fw = new FileWriter(arquivo, true);
        } catch (IOException ex) {
            Logger.getLogger(CSVGravar.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw = new PrintWriter(fw);

        //Grava usuario,data,hora em uma nova linha
        pw.print(paciente + "," + questao[0] + "," + questao[1] + "," + questao[2] + "," + questao[3] + "\n");
        pw.flush();
        
        //Flush
        pw.flush();

    }

    public ArrayList<ArrayList<String>> ler(String paciente) {
        ArrayList<ArrayList<String>> protuario = new ArrayList<>();
 
        CSVAcesso csv = new CSVAcesso(arquivo, "true");
        csv.parse();
        csv.toString();
        System.out.println(csv);
        return csv.retornarTudo();
    }

}
