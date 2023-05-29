import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente {
  private final String cpf;
  private String genero;
  private String educacao;
  private LocalDate dataNascimento;
  private ArrayList<Veiculo> listaVeiculos;

  // Construtor
  public ClientePF(String nome, String telefone, String endereco, String email,
                   String cpf, String genero, String educacao, LocalDate dataNascimento
                  )
  {
    super(nome, telefone, endereco, email);
    this.cpf = cpf;
    this.genero = genero;
    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    listaVeiculos = new ArrayList<Veiculo>();
  }
  
  // Retorna as informações do ClientePF
  public String toString(){
    String info;

    info = super.toString() +
           "\nCPF: " + this.cpf +
           "\nGênero: " + this.genero +
           "\nEducação: " + this.educacao +
           "\nData de Licença: " + this.dataNascimento +
           "\nLista de Veículos: " + this.listaVeiculos;

    return info;
  }

  // Se foi possível adicionar o Veículo, retorna true, caso contrário, false
  public boolean cadastrarVeiculo(Veiculo veiculo){
    if(!listaVeiculos.contains(veiculo)){
        listaVeiculos.add(veiculo);
        return true;
    }
    return false;
  }

  // Se foi possível remover o Veículo, retorna true, caso contrário, false
  public boolean removerVeiculo(Veiculo veiculo){
    if(listaVeiculos.contains(veiculo)){
        listaVeiculos.remove(veiculo);
        return true;
    }
    return false;
  }





  //----------------------- Getters e Setters -----------------------
  public String getCpf(String cpf) {
		return this.cpf;
	}

  public String getGenero() {
    return this.genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getEducacao() {
    return this.educacao;
  }

  public void setEducacao(String educacao) {
    this.educacao = educacao;
  }

  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public ArrayList<Veiculo> getListaVeiculos() {
    return this.listaVeiculos;
  }

  public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
    this.listaVeiculos = listaVeiculos;
  }
}
