import java.time.LocalDate;

public class ClientePJ extends Cliente {
  private final String cnpj;
  private LocalDate dataFundacao;
  private int qtdeFuncionarios;

  // Construtor
  public ClientePJ(String nome, String endereco,
                   String cnpj, LocalDate dataFundacao, int qtdeFuncionarios)
  {
    super(nome, endereco);
    this.cnpj = cnpj;
    this.dataFundacao = dataFundacao;
    this.qtdeFuncionarios = qtdeFuncionarios;
    setValorSeguro(calculaScore());
  }

  // Getters e Setters
  public String getCnpj() {
    return this.cnpj;
  }

  public LocalDate getDataFundacao() {
    return this.dataFundacao;
  }

  public void setDataFundacao(LocalDate dataFundacao) {
    this.dataFundacao = dataFundacao;
  }

  public int getQtdeFuncionarios() {
    return this.qtdeFuncionarios;
  }

  public void setQtdeFuncionarios(int qtdeFuncionarios) {
    this.qtdeFuncionarios = qtdeFuncionarios;
  }

  // Retorna as informações do ClientePJ
  public String toString() {
    // String valido;

    // if (validarCNPJ(getCnpj())) {
    //   valido = "Válido";
    // } else {
    //   valido = "Inválido";
    // }

    return super.toString() +
        "\nCNPJ: " + getCnpj() + " (" + "valido??" + ")" +
        "\nData de Fundação: " + getDataFundacao();
  }

  // Calcula o Score do ClientePJ
  public double calculaScore(){
    
    int quantidadeCarros = this.getListaVeiculos().size();
    double MULT = (1 + ( (double) this.qtdeFuncionarios ) /100);
    return CalcSeguro.VALOR_BASE.getCalculo() * MULT * quantidadeCarros;
  }
}
