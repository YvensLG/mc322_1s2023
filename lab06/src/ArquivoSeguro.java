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
    public ArquivoSeguro(){
        this.file = new File("arquivos//seguro.csv");
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("Arquivo seguro.csv criado.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("ID,DATA_INICIO,DATA_FIM,NOME_SEGURADORA,VALOR_MENSAL,LISTA_ID_SINISTROS,LISTA_CPF_CONDUTORES,CODE_FROTA/PLACA_VEICULO,CLIENTE\n");
                writer.close();
            }
            else {
                System.out.println("Arquivo seguro.csv já existe.");
            }
        }
        catch(Exception e) {
            System.out.println("Algum erro inesperado ocorreu.");
        }
    }
    
    public boolean gravarArquivo (Seguro s){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            String str = s.getId() + "," + s.getDataInicio() + "," + s.getDataFim() + "," + 
            s.getSeguradora().getNome() + "," + s.calcularValor() + ",";

            for(Sinistro sin : s.getListaSinistros()){
                str += sin.getId() + ";";
            }

            str += ",";

            for(Condutor cond : s.getListaCondutores()){
                str += cond.getCpf() + ";";
            }

            str += ",";

            if(s instanceof SeguroPF){
                str += ((SeguroPF)s).getVeiculo().getPlaca() + ",";
                str += ((SeguroPF)s).getCliente().getCpf() + ",";
            }
            else if(s instanceof SeguroPJ){
                str += ((SeguroPJ)s).getFrota().getCode() + ",";
                str += ((SeguroPJ)s).getCliente().getCnpj();
            }

            writer.write(str);
            writer.close();
            return true;

        } catch (IOException e){
            System.out.println("Algum erro inesperado ocorreu.");
            return false;
        }
    }

    public ArrayList<String> lerArquivo(){
        System.out.println("Não é possível ler arquivos Seguro.");
        return null;
    }
}