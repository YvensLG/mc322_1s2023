import java.util.Random;
import java.time.LocalDate;

public class Sinistro {
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    
    //Construtor
    public Sinistro(String data, String endereco, Seguradora seguradora
                    Veiculo veiculo, Cliente cliente) {
        this.id = criarId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Cria um ID para o Sinistro
    public int criarId(){
        Random gerador = new Random();
        int id = gerador.nextInt(1000000000);
        return id;
    }

    //Getters e Setters
	public int getId() {
		return this.id;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguradora getSeguradora() {
		return this.seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    //Retorna as informações do Sinistro
    public String toString(){
        return "Data: " + getData() +
               "\nEndereço: " + getEndereco() +
               "\nSeguradora: " + getSeguradora() +
               "\nVeiculo: " + getVeiculo() +
               "\nCliente: " + getCliente();
    }
}
