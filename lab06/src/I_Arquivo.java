import java.util.ArrayList;

public interface I_Arquivo<T>{
    public boolean gravarArquivo (T obj);

    public ArrayList<String> lerArquivo(/*algo*/);
}