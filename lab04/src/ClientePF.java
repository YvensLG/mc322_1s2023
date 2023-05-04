import java.time.LocalDate;
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

  // Valida o CPF do ClientePF
  public boolean validarCPF(String cpf) {
    cpf = cpf.replaceAll("[^0-9]", ""); // remove não números

    if (cpf.length() != 11) {
      return false;
    }

    // não pode ter todos os algarismos iguais
    char a = cpf.charAt(0);
    boolean k = true;

    for (int i = 0; i < 11; i++) {
      if (cpf.charAt(i) != a) {
        k = false;
      }
    }

    if (k) {
      return false;
    }

    // algoritmo para encontrar o penúltimo algarismo do CPF
    int ver1 = 0;

    for (int i = 0; i < 9; i++) {
      ver1 += (10 - i) * (cpf.charAt(i) - '0');
    }

    ver1 = ver1 % 11;
    if (ver1 == 0 || ver1 == 1) {
      ver1 = 0;
    } else {
      ver1 = 11 - ver1;
    }

    // algoritmo para encontrar o último algarismo do CPF
    int ver2 = 0;

    for (int i = 1; i < 10; i++) {
      ver2 += (11 - i) * (cpf.charAt(i) - '0');
    }

    ver2 = ver2 % 11;
    if (ver2 == 0 || ver2 == 1) {
      ver2 = 0;
    } else {
      ver2 = 11 - ver2;
    }

    // checa se os algarismos estão corretos
    if (cpf.charAt(9) - '0' != ver1 || cpf.charAt(10) - '0' != ver2) {
      return false;
    } else {
      return true;
    }
  }

  // Retorna as informações do ClientePF
  public String toString() {
    String valido;

    if (validarCPF(getCpf())) {
      valido = "Válido";
    } else {
      valido = "Inválido";
    }

    return super.toString() +
        "\nCPF: " + getCpf() + " (" + valido + ")" +
        "\nGênero: " + getGenero() +
        "\nData de Licença: " + getDataLicenca() +
        "\nEducação: " + getEducacao() +
        "\nData de Nascimento: " + getDataNascimento() +
        "\nClasse Econômica: " + getClasseEconomica();
  }
}
