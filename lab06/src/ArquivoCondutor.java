import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoCondutor implements I_Arquivo<Condutor>{
    File file;

    //Construtor
    public ArquivoCondutor(String pasta){
        String str = pasta + "//condutores.csv";
        this.file = new File(str);
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo condutores.csv criado.");
            }
            else {
                System.out.println("Arquivo condutores.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (Condutor c){
        System.out.println("Não é possível gravar arquivos Condutor.");
        return false;
    }

    public ArrayList<String> lerArquivo(){
        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();
            ArrayList<String> lista = new ArrayList<String>();
            
            while(scan.hasNextLine()){
                lista.add(scan.nextLine());
            }

            scan.close();
            return lista;

        } catch (IOException e){
            System.out.println("Algum erro inesperado ocorreu.");
            return null;
        }
    }

    public Condutor converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Condutor c = new Condutor(s[0], s[1], s[2], s[3], s[4], LocalDate.parse(s[5]));

        return c;
    }
}