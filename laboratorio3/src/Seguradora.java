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
		for(int i=0; i<listaClientes.size(); i++){
			if(listaClientes.get(i) == cliente){
				return false;
			}
		}
		listaClientes.add(cliente);
		return true;
	}

	//se foi possível remover retorna verdadeiro
	//se não, o cliente não está cadastrado e retorna falso
	public boolean removerCliente(String cliente){
		for(int i=0; i<listaClientes.size(); i++){
			if(listaClientes.get(i).getNome() == cliente){
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	//lista todos os Clientes do tipoCliente (ClientePF ou ClientePJ)
	public void listarClientes(String tipoCliente){
		for(int i=0; i<listaClientes.size(); i++){
			String qual = "Cliente";
			Cliente cliente = listaClientes.get(i);

			if(cliente instanceof ClientePF){
				qual += "PF";
			}else{
				qual += "PJ";
			}

			if(qual == tipoCliente){
				System.out.println(cliente);
			}
		}
	}

	//se foi possível gerar sinistro retorna verdadeiro
	//se não, retorna falso
	//nao entendi esse pra falar a verdade
	// boolean gerarSinistro(){
		
	// }

	//se foi possível encontrar o sinistro, retorna true e o imprime
	//se não, retorna false
	boolean visualizarSinistro(String cliente){
		for(int i=0; i<listarSinistros.size(); i++){
			Sinistro sinistro = listaSinistros.get(i);
			if(sinistro.getCliente().getNome() == cliente){
				System.out.println(sinistro);
				return true;
			}
		}
		return false;
	}

	//imprime os sinistros da lista
	void listarSinistros(){
		for(int i=0; i<listarSinistros.size(); i++){
			Sinistro sinistro = listaSinistros.get(i);
			System.out.println(sinistro);
		}
	}
}