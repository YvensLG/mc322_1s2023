import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<ClientePJ> listaClientesPJ;
	private ArrayList<ClientePF> listaClientesPF;
	private ArrayList<Seguro> listaSeguros;

	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String endereco, String email)
	{
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.listaClientesPJ = new ArrayList<ClientePJ>();
		this.listaClientesPF = new ArrayList<ClientePF>();
		this.listaSeguros = new ArrayList<Seguro>();
	}
	
	//lista todos os Clientes cadastrados na lista
	public void listarClientes(){
		for(Cliente c : listaClientesPF){
			System.out.println(c.getNome());
		}
		for(Cliente c : listaClientesPJ){
			System.out.println(c.getNome());
		}
	}

	//coloca um novo seguro na lista
	public SeguroPF gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo, ClientePF cliente){
		if(!listaClientesPF.contains(cliente)){
			return null;
		}
		
		SeguroPF seguro = new SeguroPF(dataInicio, dataFim, this, veiculo, cliente);
		listaSeguros.add(seguro);
		
		return seguro;
	}

	public SeguroPJ gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Frota frota, ClientePJ cliente){
		if(!listaClientesPJ.contains(cliente)){
			return null;
		}
		
		SeguroPJ seguro = new SeguroPJ(dataInicio, dataFim, this, frota, cliente);
		listaSeguros.add(seguro);
		
		return seguro;
	}

	//remove um seguro da lista
	public boolean cancelarSeguro(Seguro seguro){
		if(listaSeguros.contains(seguro)){
			listaSeguros.remove(seguro);

			for(Condutor c : seguro.getListaCondutores()){
				for(Sinistro s : c.getListaSinistros()){
					if(seguro.getListaSinistros().contains(s)){
						c.getListaSinistros().remove(s);
						s = null;
					}
				}
			}

			seguro = null;

			return true;
		}
		
		return false;
	}

	//adiciona um cliente na lista
	public boolean cadastrarCliente(ClientePF cliente){
		if(!listaClientesPF.contains(cliente)){
			listaClientesPF.add(cliente);
			return true;
		}
		
		return false;
	}
	public boolean cadastrarCliente(ClientePJ cliente){
		if(!listaClientesPJ.contains(cliente)){
			listaClientesPJ.add(cliente);
			return true;
		}
		
		return false;
	}

	//remove um cliente da lista
	public boolean removerCliente(ClientePF cliente){
		if(listaClientesPF.contains(cliente)){
			listaClientesPF.remove(cliente);
			return true;
		}
		
		return false;
	}
	public boolean removerCliente(ClientePJ cliente){
		if(listaClientesPJ.contains(cliente)){
			listaClientesPJ.remove(cliente);
			return true;
		}
		
		return false;
	}

	//retorna uma lista com todos os seguros de um cliente
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> segs = new ArrayList<Seguro>();

		for(Seguro s : listaSeguros){
			if(s.getCliente().equals(cliente)){
				segs.add(s);
			}
		}

		return segs;
	}

	//retorna uma lista com todos os sinistros de um cliente
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		ArrayList<Sinistro> sins = new ArrayList<Sinistro>();

		ArrayList<Seguro> segs = getSegurosPorCliente(cliente);

		for(Seguro s : segs){
			sins.addAll(s.getListaSinistros());
		}

		return sins;
	}

	//calcula o valor da receita
	public void calcularReceita(){
		double total = 0;
		
		for(Cliente cliente : listaClientesPF){
			double receita = 0;

            ArrayList<Seguro> segs = getSegurosPorCliente(cliente);

			for(Seguro s : segs){
				receita += s.getValorMensal();
			}

			String texto = "Cliente " + cliente.getNome() +
							" - Seguros: " + "R$" + String.format("%.2f", receita);

            System.out.println(texto);

			total += receita;
        }
		for(Cliente cliente : listaClientesPJ){
			double receita = 0;

            ArrayList<Seguro> segs = getSegurosPorCliente(cliente);

			for(Seguro s : segs){
				receita += s.getValorMensal();
			}

			String texto = "Cliente " + cliente.getNome() +
							" - Seguros: " + "R$" + String.format("%.2f", receita);

            System.out.println(texto);

			total += receita;
        }

		System.out.println("Receita Total: R$" + String.format("%.2f", total));
	}

	//Retorna as informações da Seguradora
    public String toString(){
        String info = "";

        info = 
        "Informações da Seguradora " + this.nome + ":" +
		"\nCNPJ: " + this.cnpj +
        "\nTelefone: " + this.telefone +
        "\nEndereco: " + this.endereco +
        "\nEmail: " + this.email +
		"\nQuantidade de ClientesPF: " + this.listaClientesPF.size() +
		"\nQuantidade de ClientesPJ: " + this.listaClientesPJ.size() +
		"\nQuantidade de Seguros: " + this.listaSeguros.size();
        
        return info;
    }





    //----------------------- Getters e Setters -----------------------
	
	public String getCnpj() {
		return this.cnpj;
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

	public ArrayList<ClientePF> getListaClientesPF() {
		return this.listaClientesPF;
	}

	public void setListaClientesPF(ArrayList<ClientePF> listaClientesPF) {
		this.listaClientesPF = listaClientesPF;
	}

	public ArrayList<ClientePJ> getListaClientesPJ() {
		return this.listaClientesPJ;
	}

	public void setListaClientes(ArrayList<ClientePJ> listaClientesPJ) {
		this.listaClientesPJ = listaClientesPJ;
	}

	public ArrayList<Seguro> getListaSeguros() {
		return this.listaSeguros;
	}

	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

}