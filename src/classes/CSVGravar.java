/////////////////////////////////////
/**
 * The below Java Code writes some data to a file in CSV (Comma Separated Value)
 * File
 */
package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVGravar {
    private Writer fw;

    /**
     *
     * @param param1
     * @param param2
     * @param param4
     * @param param3
     * @param arquivo
     */
    public void gravar(String param1, String param2, String param3, String param4, String arquivo) {

        try {
            fw = new FileWriter(arquivo, true);
        } catch (IOException ex) {
            Logger.getLogger(CSVGravar.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw = new PrintWriter(fw);

        //Grava usuario,param2,param3 em uma nova linha
        pw.print(param1 + "," + param2 + "," + param3 + "," + param4 + "\n");
        pw.flush();

    }
}

