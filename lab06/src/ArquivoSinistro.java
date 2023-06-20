import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.Scanner;
// import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoSinistro implements I_Arquivo<Sinistro>{
    File file;

    //Construtor
    public ArquivoSinistro(String pasta){
        String str = pasta + "//sinistros.csv";
        this.file = new File(str);
        try {
            boolean value = file.delete();
            
            if (value) {
                System.out.println("Arquivo sinistros.csv recriado.");
            }
            else {
                System.out.println("Arquivo sinistros.csv criado.");
            }

            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("ID,DATA,ENDERECO,CPF_CONDUTOR,ID_SEGURO\n");
            writer.close();
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (Sinistro s){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            String str = s.getId() + "," + s.getData() + "," + s.getEndereco() + "," + 
            s.getCondutor().getCpf() + "," + s.getSeguro().getId();

            writer.write(str + '\n');
            writer.close();
            return true;

        } catch (IOException e){
            System.out.println("Algum erro inesperado ocorreu.");
            return false;
        }
    }

    public ArrayList<String> lerArquivo(){
        System.out.println("Não é possível ler arquivos Sinistro.");
        return null;
    }
}