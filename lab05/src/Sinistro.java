import java.util.Random;
import java.time.LocalDate;

public class Sinistro {
    private final int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;

    //Construtor
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro)
	{
        this.id = criarId();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
		seguro.gerarSinistro(this);
    }

    //Cria um ID para o Sinistro
    public int criarId(){
        Random gerador = new Random();
        int id = gerador.nextInt(1000000000);
        return id;
    }

	//Retorna as informações do Sinistro
    public String toString(){
        String info = "";

        info = 
        "Sinistro " + this.id + ":" +
        "\nData: " + this.data +
        "\nEndereco: " + this.endereco +
        "\nCondutor: " + this.condutor.getNome() +
		"\nSeguro: " + this.seguro.getId();
        
        return info;
    }
    




    //----------------------- Getters e Setters -----------------------
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

	public Condutor getCondutor() {
		return this.condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
    
}
