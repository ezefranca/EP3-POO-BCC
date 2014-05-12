/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ezefranca
 */
public class CSVAcesso {
    
    private boolean bHeaderRow = false;

    private String sFileFullPath = "";
    private ArrayList<ArrayList<String>> alData;
    private ArrayList<String> alColNames;

    /*
     * Custom constructor.
     */
    public CSVAcesso(String f, String b) {

        /** check for null arguments */
        if (f == null || b == null) {
            System.err.println("error - argument is null");
            System.exit(0);
        }

        /** set properties */
        bHeaderRow = Boolean.valueOf(b);
        sFileFullPath = f;

        /** verify that the file exists */
        File checkFile = new File(sFileFullPath);
        System.out.println(sFileFullPath);
        
        if (!checkFile.exists()) {
            System.err.println("error - file does not exist: " + sFileFullPath);
            System.exit(0);
        }

        /** initialize our data structures */
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

            /** read entire lines, one at a time */
            while ((line = br.readLine()) != null) {

                if (bHeaderRow && !bSeenHeader) {
                    /** process the header row */
                    alColNames = new ArrayList<>(Arrays.asList(line.split(",")));
                    bSeenHeader = true;
                } else {
                    /** process normal rows */
                    String arr[] = line.split(",");
                    alData.add(new ArrayList<>(Arrays.asList(arr)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }        
    }

    /*
     * Print the data nicely.
     */
    public void printData() {

        if (bHeaderRow) {
            System.out.println("Coluna nomes:");
            for (int i=0; i < alColNames.size()-1; i++) {
                System.out.print(alColNames.get(i) + ",");
            }
            System.out.println(alColNames.get(alColNames.size()-1));
            System.out.println();
        }

        System.out.println("Dados:");
        for (int i=0; i < alData.size(); i++) {
            ArrayList<String> al = alData.get(i);
            for (int j=0; j < al.size()-1; j++) {
                System.out.print(al.get(j) + ",");
            }
            System.out.println(al.get(al.size()-1));
        }
    }

    /**
     * Main driver program.
     * 
     * @param args  the incoming arguments
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("usage: java CsvParser [full path filename] [true|false header row]");
            return;
        }

        CSVAcesso parser = new CSVAcesso(args[0], args[1]);
        parser.parse();
        parser.printData();

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

}
