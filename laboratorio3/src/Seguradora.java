import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;

	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	//Getters e Setters
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return this.listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	//se foi possível cadastrar retorna verdadeiro
	//se não, o cliente já está cadastrado e retorna falso
	public boolean cadastrarCliente(Cliente cliente){
		//checa se cliente está na lista
		for(int i=0; i<listaClientes.size(); i++){
			Cliente c = listaClientes.get(i);

			//checa se cpf/cnpj de c é igual ao de cliente
			if(cliente instanceof ClientePF && c instanceof ClientePF){
				if( ( (ClientePF) cliente).getCpf().equals( ( (ClientePF) c).getCpf() ) ){
					return false;
				}
			}else if(cliente instanceof ClientePJ && c instanceof ClientePJ){
				if( ( (ClientePJ) cliente).getCnpj().equals( ( (ClientePJ) c).getCnpj() ) ){
					return false;
				}
			}
		}

		//adiciona cliente na lista
		listaClientes.add(cliente);
		return true;
	}

	//se foi possível remover retorna verdadeiro
	//se não, o cliente não está cadastrado e retorna falso
	public boolean removerCliente(String cliente){
		//checa se o cliente está na lista
		for(int i=0; i<listaClientes.size(); i++){
			Cliente c = listaClientes.get(i);
			if(cliente.equals(c.getNome())){
				listaClientes.remove(i);
				return true;
			}
		}
		//se não está
		return false;
	}
	
	//lista todos os Clientes do tipoCliente (ClientePF ou ClientePJ) da lista
	public void listarClientes(String tipoCliente){
		for(int i=0; i<listaClientes.size(); i++){
			String qual = "Cliente";
			Cliente c = listaClientes.get(i);

			if(c instanceof ClientePF){
				qual += "PF";
			}else{
				qual += "PJ";
			}

			if(qual.equals(tipoCliente)){
				System.out.println(c);
			}
		}
	}

	//se foi possível gerar sinistro retorna verdadeiro
	//se não foi, retorna falso
	boolean gerarSinistro(Sinistro sinistro){
		//checa se o sinistro já está na lista
		for(int i=0; i<listaSinistros.size(); i++){
			sinistro s = listaSinistros.get(i);
			if(sinistro.getId() == s.getId()){
				return false;
			}
		}
		//se não, adiciona
		listaSinistros.add(sinistro);
		return true;
	}

	//se foi possível encontrar o sinistro, retorna true e o imprime
	//se não, retorna false
	boolean visualizarSinistro(String cliente){
		for(int i=0; i<listaSinistros.size(); i++){
			Sinistro sinistro = listaSinistros.get(i);
			if(cliente.equals( sinistro.getCliente().getNome() )){
				System.out.println(sinistro);
				return true;
			}
		}
		return false;
	}

	//imprime os sinistros da lista
	void listarSinistros(){
		for(int i=0; i<listaSinistros.size(); i++){
			Sinistro sinistro = listaSinistros.get(i);
			System.out.println(sinistro);
		}
	}
}