import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoClientePJ implements I_Arquivo<ClientePJ>{
    File file;

    //Construtor
    public ArquivoClientePJ(String pasta){
        //cria um caminho até o arquivo .csv
        String str = pasta + "//clientesPJ.csv";
        this.file = new File(str);

        //checa se clientesPJ.csv já existe, e se não existe, cria um arquivo assim como o fornecido
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo clientesPJ.csv criado.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("CNPJ_CLIENTE,NOME_CLIENTE,TELEFONE,ENDERECO,EMAIL_CLIENTE,DATA_FUND,CODE_FROTA\n");
                writer.close();
            }
            else {
                System.out.println("Arquivo clientesPJ.csv já existe.");
            }
        }
        //se ocorreu algum erro
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu na criação do ArquivoClientePJ.");
        }
    }
    
    //não é necessário gravar ClientePJ nesa tarefa
    public boolean gravarArquivo (ClientePJ c){
        System.out.println("Não é possível gravar arquivos ClientePJ.");
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
            System.out.println("Algum erro inesperado ocorreu na leitura do ArquivoClientePJ.");
            return null;
        }
    }

    //converte o tipo de string dada no arquivo .csv para ClientePJ e o codigo de sua frota
    public Pair<ClientePJ, String> converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        ClientePJ c = new ClientePJ(s[1], s[2], s[3], s[4], s[0], LocalDate.parse(s[5]), 1);
        String codfrota = s[6];

        return new Pair<ClientePJ, String> (c, codfrota);
    }
}