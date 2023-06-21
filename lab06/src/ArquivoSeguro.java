import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.Scanner;
// import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoSeguro implements I_Arquivo<Seguro>{
    File file;

    //Construtor
    public ArquivoSeguro(String pasta){
        //cria um caminho até o arquivo .csv
        String str = pasta + "//seguros.csv";
        this.file = new File(str);

        //remove o seguros.csv se já existe, e cria outro em seu lugar
        try {
            boolean value = file.delete();

            if (value) {
                System.out.println("Arquivo seguros.csv recriado.");
            }
            else {
                System.out.println("Arquivo seguros.csv criado.");
            }

            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("ID,DATA_INICIO,DATA_FIM,NOME_SEGURADORA,LISTA_ID_SINISTROS,LISTA_CPF_CONDUTORES,VALOR_MENSAL\n");
            writer.close();
        }
        //se ocorreu algum erro
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu na criação do ArquivoSeguro.");
        }
    }

    //grava no arquivo "file" os dados do Seguro
    public boolean gravarArquivo (Seguro s){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            String str = s.getId() + "," + s.getDataInicio() + "," + s.getDataFim() + "," + 
            s.getSeguradora().getNome() + ",";

            for(Sinistro sin : s.getListaSinistros()){
                str += sin.getId() + "  ";
            }

            str += ",";

            for(Condutor cond : s.getListaCondutores()){
                str += cond.getCpf() + "  ";
            }

            str += "," + String.format("R$ %.2f", s.calcularValor());

            writer.write(str + '\n');
            writer.close();
            return true;

        }
        //se ocorreu algum erro
        catch (IOException e){
            System.out.println("Algum erro inesperado ocorreu na gravação do ArquivoSeguro.");
            return false;
        }
    }

    //não é necessário ler Seguro nesa tarefa
    public ArrayList<String> lerArquivo(){
        System.out.println("Não é possível ler arquivos Seguro.");
        return null;
    }
}