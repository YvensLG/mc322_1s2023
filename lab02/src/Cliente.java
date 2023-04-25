public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    //Construtor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Retorna as informações do Cliente
    public String toString(){
        String out = "";

        String valido;
        if(validarCPF()){
            valido = "Válido";
        }else{
            valido = "Inválido";
        }

        out += "Cliente " + getNome() + ", de CPF " + getCpf() + " (" + valido + ")"
            + "\nNascido em " + getDataNascimento() + " (" + getIdade() + " anos)"
            + "\nEndereço: " + getEndereco();

        return out;
    }

    //Valida o CPF do cliente
    public boolean validarCPF() {
        String cpf = this.cpf.replaceAll("[^0-9]", ""); //remove não números
        
        if(cpf.length() != 11) {
            return false;
        }

        //não pode ter todos os algarismos iguais
        char a = cpf.charAt(0);
        boolean k = true;
        
        for(int i=0; i<11; i++) {
            if(cpf.charAt(i) != a) {
                k = false;
            }
        }

        if(k) {
            return false;
        }

        //algoritmo para encontrar o penúltimo algarismo do CPF
        int ver1 = 0;

        for(int i=0; i<9; i++){
            ver1 += (10 - i) * (cpf.charAt(i) - '0');
        }

        ver1 = ver1 % 11;
        if(ver1 == 0 || ver1 == 1) {
            ver1 = 0;
        } else{
            ver1 = 11 - ver1;
        }

        //algoritmo para encontrar o último algarismo do CPF
        int ver2 = 0;

        for(int i=1; i<10; i++){
            ver2 += (11 - i) * (cpf.charAt(i) - '0');
        }

        ver2 = ver2 % 11;
        if(ver2 == 0 || ver2 == 1){
            ver2 = 0;
        }
        else{
            ver2 = 11 - ver2;
        }

        //checa se os algarismos estão corretos
        if(cpf.charAt(9) - '0' != ver1 || cpf.charAt(10) - '0' != ver2){
            return false;
        }else{
            return true;
        }
    }
}
