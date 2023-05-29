public abstract class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    
    //Construtor
    public Cliente(String nome, String telefone, String endereco, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
    
    //Retorna as informações do Cliente
    public String toString(){
        String info = "";

        info = 
        "Informações do Cliente " + this.nome + ":" +
        "\nTelefone: " + this.telefone +
        "\nEndereco: " + this.endereco +
        "\nEmail: " + this.email;
        
        return info;
    }
    




    //----------------------- Getters e Setters -----------------------
    
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
}
