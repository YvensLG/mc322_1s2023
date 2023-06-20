import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoClientePF implements I_Arquivo<ClientePF>{
    File file;

    //Construtor
    public ArquivoClientePF(){
        this.file = new File("arquivos//clientesPF.csv");
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo ClientesPF.csv criado.");
            }
            else {
                System.out.println("Arquivo ClientesPF.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (ClientePF c){
        System.out.println("Não é possível gravar arquivos ClientePF.");
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

    public Pair<ClientePF, String> converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        ClientePF c = new ClientePF(s[1], s[2], s[3], s[4], s[0], s[5], s[6], LocalDate.parse(s[7]));
        String placa = s[8];

        return new Pair<ClientePF, String> (c, placa);
    }
}