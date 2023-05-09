import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;
    
    //Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
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

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public double getValorSeguro() {
        return this.valorSeguro;
    }
    
    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
    
    public void addVeiculo(Veiculo v) {
        listaVeiculos.add(v);
    }
    
    public void remVeiculo(Veiculo v) {
        listaVeiculos.remove(v);
    }
    
    public double calculaScore(){
        return 0.0;
    }
    
    //Retorna as informações do Cliente
    public String toString(){
        return "Nome: " + getNome() +
        "\nEndereço: " + getEndereco() +
        "\nVeiculos: " + getListaVeiculos();
    }
}
