import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;

	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String endereco, String email)
	{
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSeguros = new ArrayList<Seguro>();
	}
	
	//lista todos os Clientes cadastrados na lista
	public void listarClientes(){
		for(Cliente c : listaClientes){
			System.out.println(c.getNome());
		}
	}

	//coloca um novo seguro na lista
	public SeguroPF gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo, ClientePF cliente){
		if(!listaClientes.contains(cliente)){
			return null;
		}
		
		SeguroPF seguro = new SeguroPF(dataInicio, dataFim, this, veiculo, cliente);
		listaSeguros.add(seguro);
		
		return seguro;
	}

	public SeguroPJ gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Frota frota, ClientePJ cliente){
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
	public boolean cadastrarCliente(Cliente cliente){
		if(!listaClientes.contains(cliente)){
			listaClientes.add(cliente);
			return true;
		}
		
		return false;
	}

	//remove um cliente da lista
	public boolean removerCliente(Cliente cliente){
		if(listaClientes.contains(cliente)){
			listaClientes.remove(cliente);
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
		
		for(Cliente cliente : listaClientes){
			double receita = 0;

            ArrayList<Seguro> segs = getSegurosPorCliente(cliente);

			for(Seguro s : segs){
				receita += s.getValorMensal();
			}

			String texto = "Cliente " + cliente.getNome() +
							" - Seguros: " + "R$" + String.format("%.2f", receita);

            System.out.println(texto);
        }

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
		"\nQuantidade de Clientes: " + this.listaClientes.size() +
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

	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Seguro> getListaSeguros() {
		return this.listaSeguros;
	}

	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

}