import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente {
  private final String cpf;
  private String genero;
  private LocalDate dataLicenca;
  private String educacao;
  private LocalDate dataNascimento;
  private String classeEconomica;

  // Construtor
  public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
                   String cpf, String genero, LocalDate dataLicenca, String educacao,
                   LocalDate dataNascimento, String classeEconomica)
  {
    super(nome, endereco, listaVeiculos);
    this.cpf = cpf;
    this.genero = genero;
    this.dataLicenca = dataLicenca;
    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    this.classeEconomica = classeEconomica;
    setValorSeguro();
  }

  // Getters e Setters
  public String getCpf() {
    return this.cpf;
  }

  public String getGenero() {
    return this.genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public LocalDate getDataLicenca() {
    return this.dataLicenca;
  }

  public void setDataLicenca(LocalDate dataLicenca) {
    this.dataLicenca = dataLicenca;
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

  public String getClasseEconomica() {
    return this.classeEconomica;
  }

  public void setClasseEconomica(String classeEconomica) {
    this.classeEconomica = classeEconomica;
  }

  public int getIdade() {
    int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
    return idade;
  }

  // Retorna as informações do ClientePF
  public String toString() {
    // String valido;

    // if (validarCPF(getCpf())) {
    //   valido = "Válido";
    // } else {
    //   valido = "Inválido";
    // }

    return super.toString() +
        "\nCPF: " + getCpf() + " (" + "valido?" + ")" +
        "\nGênero: " + getGenero() +
        "\nData de Licença: " + getDataLicenca() +
        "\nEducação: " + getEducacao() +
        "\nData de Nascimento: " + getDataNascimento() +
        "\nClasse Econômica: " + getClasseEconomica();
  }

  // Calcula o Score do ClientePF
  public double calculaScore(){
    int quantidadeCarros = this.getListaVeiculos().size();
    int idade = getIdade();
    return CalcSeguro.VALOR_BASE.getCalculo() * CalcSeguro.FATOR_IDADE(idade) * quantidadeCarros;
  }

}
