import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoVeiculo implements I_Arquivo<Veiculo>{
    File file;

    //Construtor
    public ArquivoVeiculo(){
        this.file = new File("arquivos//veiculos.csv");
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo veiculos.csv criado.");
            }
            else {
                System.out.println("Arquivo veiculos.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (Veiculo v){
        System.out.println("Não é possível gravar arquivos Veiculo.");
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

    public Veiculo converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Veiculo v = new Veiculo(s[0], s[1], s[2], Integer.parseInt(s[3]));

        return v;
    }
}