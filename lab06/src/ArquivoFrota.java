import java.io.File;
import java.io.IOException;
import java.util.Scanner;
// import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoFrota implements I_Arquivo<Frota>{
    File file;

    //Construtor
    public ArquivoFrota(String pasta){
        String str = pasta + "//frotas.csv";
        this.file = new File(str);
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo frotas.csv criado.");
            }
            else {
                System.out.println("Arquivo frotas.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (Frota f){
        System.out.println("Não é possível gravar arquivos Frota.");
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

    public Frota converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Frota f = new Frota();
        f.setCode(s[0]);

        //olhar isso depois
        String placa1 = s[1], placa2 = s[2], placa3 = s[3];

        return f;
    }
}