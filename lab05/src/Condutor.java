import java.time.LocalDate;
//import java.time.Period;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    //Construtor
    public Condutor(String cpf, String nome, String telefone, String endereco,
                    String email, LocalDate dataNasc)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        listaSinistros = new ArrayList<Sinistro>();
    }
    
    //Adiciona Sinistro à Lista
    public boolean adicionarSinistro(Sinistro sinistro){
        if(!listaSinistros.contains(sinistro)){
            listaSinistros.add(sinistro);
            return true;
        }
        return false;
    }

    // Retorna as informações do Condutor
    public String toString(){
        String info;

        info =  "Informações do Condutor " + this.nome + ":" +
                "\nCPF: " + this.cpf +
                "\nTelefone: " + this.telefone +
                "\nEndereco: " + this.endereco +
                "\nEmail: " + this.email +
                "\nData de Nascimento: " + this.dataNasc +
                "\nLista de Sinistros: " + this.listaSinistros;

        return info;
    }


    


    //----------------------- Getters e Setters -----------------------
 
    public String getCpf() {
		return this.cpf;
	}

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

}
