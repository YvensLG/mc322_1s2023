import java.time.LocalDate;
//import java.time.Period;
//import java.util.ArrayList;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    //Construtor
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
                    Veiculo veiculo, ClientePF cliente)
    {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Calcula o Valor do Seguro
    public double calcularValor(){
        double valor = 1.0;

        valor *= CalcSeguro.VALOR_BASE.getCalculo();
        valor *= CalcSeguro.FATOR_IDADE(cliente.getIdade());
        valor *= 1.0 + 1.0 / (cliente.getListaVeiculos().size() + 2.0);
        valor *= 2.0 + getSeguradora().getSinistrosPorCliente(cliente).size() / 10.0;
        valor *= 5.0 + quantidadeSinistrosCondutor() / 10.0;

        return valor;
    }

    //Retorna as informações do SeguroPF
    public String toString(){
        String info = "";

        info =  super.toString() + 
                "\nCliente: " + cliente.getNome() +
                "\nVeículo: " + veiculo.getPlaca();
        
        return info;
    }





    //----------------------- Getters e Setters -----------------------
    
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

}
