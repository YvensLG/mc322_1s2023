import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
  private final String cnpj;
  private LocalDate dataFundacao;
  private ArrayList<Frota> listaFrota;
  private int quantidadeFunc;

  // Construtor
  public ClientePJ(String nome, String telefone, String endereco, String email,
                   String cnpj, LocalDate dataFundacao, int quantidadeFunc
                  )
  {
    super(nome, telefone, endereco, email);
    this.cnpj = cnpj;
    this.dataFundacao = dataFundacao;
    listaFrota = new ArrayList<Frota>();
    this.quantidadeFunc = quantidadeFunc;
  }

  // Se foi possível adicionar a Frota, retorna true, caso contrário, false
  public boolean cadastrarFrota(Frota frota){
    if(!listaFrota.contains(frota)){
      listaFrota.add(frota);
      return true;
    }
    return false;
  }

  // Adiciona ou Remove um veículo de uma frota
  public boolean atualizarFrota(Frota frota, Veiculo veiculo, String acao){
    if(!listaFrota.contains(frota)){
      return false;
    }

    if(acao.equals("remover")){
      return frota.removeVeiculo(veiculo);

    }
    else if(acao.equals("adicionar")){
      return frota.addVeiculo(veiculo);

    }

    return false;
  }

  // Remove uma frota
  public boolean atualizarFrota(Frota frota){
    if(listaFrota.contains(frota)){
      listaFrota.remove(frota);
      return true;
    }
    return false;
  }

  // ???
  //public boolean getVeiculosPorFrota();


  // Retorna as informações do ClientePJ
  public String toString(){
    String info;

    info = super.toString() +
           "\nCPF: " + this.cnpj +
           "\nData de Fundação: " + this.dataFundacao +
           "\nLista de Frotas: " + this.listaFrota;

    return info;
  }





  //----------------------- Getters e Setters -----------------------

  public int getIdade() {
    int idade = Period.between(dataFundacao, LocalDate.now()).getYears();
    return idade;
  }
 
  public String getCnpj() {
		return this.cnpj;
	}

  public LocalDate getDataFundacao() {
    return this.dataFundacao;
  }

  public void setDataFundacao(LocalDate dataFundacao) {
    this.dataFundacao = dataFundacao;
  }

  public ArrayList<Frota> getListaFrota() {
    return this.listaFrota;
  }

  public void setListaFrota(ArrayList<Frota> listaFrota) {
    this.listaFrota = listaFrota;
  }

  public int getQuantidadeFunc() {
    return this.quantidadeFunc;
  }

  public void setQuantidadeFunc(int quantidadeFunc) {
    this.quantidadeFunc = quantidadeFunc;
  }
}
