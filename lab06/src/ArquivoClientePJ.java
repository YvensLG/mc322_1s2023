import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoClientePJ implements I_Arquivo<ClientePJ>{
    File file;

    //Construtor
    public ArquivoClientePJ(){
        this.file = new File("arquivos//clientesPJ.csv");
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo clientesPJ.csv criado.");
            }
            else {
                System.out.println("Arquivo clientesPJ.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (ClientePJ c){
        System.out.println("Não é possível gravar arquivos ClientePJ.");
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

    public Pair<ClientePJ, String> converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        ClientePJ c = new ClientePJ(s[1], s[2], s[3], s[4], s[0], LocalDate.parse(s[5]), 1);
        String codfrota = s[6];

        return new Pair<ClientePJ, String> (c, codfrota);
    }
}