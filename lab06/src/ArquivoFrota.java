import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoFrota implements I_Arquivo<Frota>{
    File file;

    //Construtor
    public ArquivoFrota(String pasta){
        //cria um caminho até o arquivo .csv
        String str = pasta + "//frotas.csv";
        this.file = new File(str);

        //checa se frotas.csv já existe, e se não existe, cria um arquivo assim como o fornecido
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo frotas.csv criado.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3\n");
                writer.close();
            }
            else {
                System.out.println("Arquivo frotas.csv já existe.");
            }
        }
        //se ocorreu algum erro
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu na criação do ArquivoFrota.");
        }
    }
    
    //não é necessário gravar Frota nesa tarefa
    public boolean gravarArquivo (Frota f){
        System.out.println("Não é possível gravar arquivos Frota.");
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
            System.out.println("Algum erro inesperado ocorreu na leitura do ArquivoFrota.");
            return null;
        }
    }

    //converte o tipo de string dada no arquivo .csv para Frota e as placas de seus veículos
    public Pair<Frota, ArrayList<String>> converteString(String txt){
        String[] s = new String[] {};
        s = txt.split(",");

        Frota f = new Frota();
        f.setCode(s[0]);

        ArrayList<String> placas = new ArrayList<String>();

        for(int i=1; i<s.length; i++){
            placas.add(s[i]);
        }

        return new Pair<Frota, ArrayList<String>> (f, placas);
    }
}