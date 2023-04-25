import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;

    //Construtor
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
                    String cnpj, LocalDate dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    //Getters e Setters
    public String getCnpj() {
		return this.cnpj;
	}

    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    //Valida o CNPJ do ClientePJ
    public boolean validarCPF(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); //remove não números
        
        if(cnpj.length() != 14) {
            return false;
        }

        //não pode ter todos os algarismos iguais
        char a = cnpj.charAt(0);
        boolean k = true;
        
        for(int i=0; i<11; i++) {
            if(cnpj.charAt(i) != a) {
                k = false;
            }
        }

        if(k) {
            return false;
        }

        //algoritmo para encontrar o penúltimo algarismo do CPF
        int[] mult1 = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int ver1 = 0;

        for(int i=0; i<12; i++){
            ver1 += mult1[i] * (cnpj.charAt(i) - '0');
        }

        ver1 = ver1 % 11;
        if(ver1 == 0 || ver1 == 1) {
            ver1 = 0;
        } else{
            ver1 = 11 - ver1;
        }

        //algoritmo para encontrar o último algarismo do CPF
        int[] mult2 = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int ver2 = 0;

        for(int i=1; i<13; i++){
            ver2 += mult2[i] * (cnpj.charAt(i) - '0');
        }

        ver2 = ver2 % 11;
        if(ver2 == 0 || ver2 == 1){
            ver2 = 0;
        }
        else{
            ver2 = 11 - ver2;
        }

        //checa se os algarismos estão corretos
        if(cnpj.charAt(12) - '0' != ver1 || cnpj.charAt(13) - '0' != ver2){
            return false;
        }else{
            return true;
        }
    }

    //Retorna as informações do ClientePF
    public String toString(){
        String valido;
        
        if(validarCPF()){
            valido = "Válido";
        }else{
            valido = "Inválido";
        }

        return super.toString() +
               "\nCNPJ: " + getCnpj() + "(" + valido + ")" +
               "\nData de Fundação: " + getDataFundacao();
    }
}
