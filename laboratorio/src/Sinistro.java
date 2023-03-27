import java.util.Random;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;
    
    //Construtor
	public Sinistro(String data, String endereco) {
		this.data = data;
        this.endereco = endereco;
        this.id = criarId();
	}

    //Getters
    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getData() {
        return data;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    //Cria um ID para o Sinistro
    public int criarId(){
        Random gerador = new Random();
        int id = gerador.nextInt(1000000000);
        return id;
    }
}
