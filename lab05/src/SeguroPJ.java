import java.time.LocalDate;
//import java.time.Period;
//import java.util.ArrayList;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    //Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
                    Frota frota, ClientePJ cliente)
    {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    //Calcula o Valor do Seguro
    public double calcularValor(){
        double valor = 1.0;

        valor *= CalcSeguro.VALOR_BASE.getCalculo();
        valor *= 10 + ( cliente.getQuantidadeFunc() ) /10;
        valor *= 1 + 1 / ( frota.getListaVeiculos().size() + 2);
        valor *= 1 + 1 / ( cliente.getIdade() +2);
        valor *= 2 + getSeguradora().getSinistrosPorCliente(cliente).size() / 10;
        valor *= 5 + quantidadeSinistrosCondutor() / 10;

        return valor;
    }

    //Retorna as informações do SeguroPJ
    public String toString(){
        String info = "";

        info =  super.toString() + 
                "\nCliente: " + cliente.getNome() +
                "\nFrota: " + frota.getClass();
        
        return info;
    }





    //----------------------- Getters e Setters -----------------------
    
    public Frota getFrota() {
        return this.frota;
    }

    public void setVeiculo(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }


}
