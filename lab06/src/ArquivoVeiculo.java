import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoVeiculo implements I_Arquivo<Veiculo>{
    File file;

    //Construtor
    public ArquivoVeiculo(String pasta){
        //cria um caminho até o arquivo .csv
        String str = pasta + "//veiculos.csv";
        this.file = new File(str);

        //checa se veiculos.csv já existe, e se não existe, cria um arquivo assim como o fornecido
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo veiculos.csv criado.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("PLACA,MARCA,MODELO,ANO_FAB\n");
                writer.close();
            }
            else {
                System.out.println("Arquivo veiculos.csv já existe.");
            }
        }
        //se ocorreu algum erro
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu na criação do ArquivoVeiculo.");
        }
    }
    
    //não é necessário gravar Veiculo nesa tarefa 
    public boolean gravarArquivo (Veiculo v){
        System.out.println("Não é possível gravar arquivos Veiculo.");
        return false;
    }

    //lê o arquivo "file" e retorna o que está escrito nele
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

        }
        //se ocorreu algum erro
        catch (IOException e){
            System.out.println("Algum erro inesperado ocorreu na leitura do ArquivoVeiculo.");
            return null;
        }
    }

    //converte o tipo de string dada no arquivo .csv para Veiculo
    public Veiculo converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Veiculo v = new Veiculo(s[0], s[1], s[2], Integer.parseInt(s[3]));

        return v;
    }
}