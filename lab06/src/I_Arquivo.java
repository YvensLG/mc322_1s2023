import java.util.ArrayList;

//interface dos tipos arquivo
public interface I_Arquivo<T>{
    //grava arquivos 
    public boolean gravarArquivo (T obj);

    //lê dos arquivos
    public ArrayList<String> lerArquivo();
}