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
        valor *= 1 + 1 / (cliente.getListaVeiculos().size() + 2);
        valor *= 2 + getSeguradora().getSegurosPorCliente(cliente).size() / 10;
        valor *= 5 + quantidadeSinistrosCondutor() / 10;

        return valor;
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
