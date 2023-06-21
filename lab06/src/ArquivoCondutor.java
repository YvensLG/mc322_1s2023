import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoCondutor implements I_Arquivo<Condutor>{
    File file;

    //Construtor
    public ArquivoCondutor(String pasta){
        //cria um caminho até o arquivo .csv
        String str = pasta + "//condutores.csv";
        this.file = new File(str);

        //checa se condutores.csv já existe, e se não existe, cria um arquivo assim como o fornecido
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo condutores.csv criado.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("CPF_CONDUTOR,NOME_CONDUTOR,TELEFONE,ENDERECO,EMAIL,DATA_NASCIMENTO\n");
                writer.close();
            }
            else {
                System.out.println("Arquivo condutores.csv já existe.");
            }
        }
        //se ocorreu algum erro
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu na criação do ArquivoCondutor.");
        }
    }
    
    //não é necessário gravar Condutor nesa tarefa
    public boolean gravarArquivo (Condutor c){
        System.out.println("Não é possível gravar arquivos Condutor.");
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
            System.out.println("Algum erro inesperado ocorreu na leitura do ArquivoCondutor.");
            return null;
        }
    }

    //converte o tipo de string dada no arquivo .csv para Condutor
    public Condutor converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Condutor c = new Condutor(s[0], s[1], s[2], s[3], s[4], LocalDate.parse(s[5]));

        return c;
    }
}