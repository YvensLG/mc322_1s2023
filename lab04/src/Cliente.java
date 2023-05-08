import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;
    
    //Construtor
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
        this.valorSeguro = 0;
    }
    
    //Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    
    public double getValorSeguro() {
        return this.valorSeguro;
    }

    public void setValorSeguro() {
        this.valorSeguro = calculaScore();
    }

    //Retorna as informações do Cliente
    public String toString(){
        return "Nome: " + getNome() +
               "\nEndereço: " + getEndereco() +
               "\nVeiculos: " + getListaVeiculos();
    }

    public double calculaScore(){
        return 0.0;
    }
}
