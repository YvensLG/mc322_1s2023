import java.time.LocalDate;
//import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;

    //Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora)
    {
        this.id = criarId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
        //valorMensal?
    }

    //Cria um ID para o Seguro
    public int criarId(){
        Random gerador = new Random();
        int id = gerador.nextInt(1000000000);
        return id;
    }

    //Desautoriza um Condutor (remove da lista)
    public boolean desautorizarCondutor(Condutor cond){
        if(listaCondutores.contains(cond)){
            listaCondutores.remove(cond);
            return true;
        }
        return false;
    }

    //Autoriza um Condutor (adiciona na lista)
    public boolean autorizarCondutor(Condutor cond){
        if(!listaCondutores.contains(cond)){
            listaCondutores.add(cond);
            return true;
        }
        return false;
    }

    public abstract double calcularValor();

    //public abstract boolean gerarSinistro();

    //Quantidade de Sinistros que os Condutores possuem
    public int quantidadeSinistrosCondutor(){
        int qtd = 0;

        for(Condutor cond : listaCondutores){
            qtd += cond.getListaSinistros().size();
        }

        return qtd;
    }
    
    //Retorna as informações do Seguro
    public String toString(){
        String info = "";

        info =
        "Seguro número " + this.id + ":" +
        "\nData de Início: " + this.dataInicio +
        "\nData de Fim: " + this.dataFim +
        "\nValor Mensal: " + this.valorMensal +
        "\nSeguradora: " + this.seguradora.getNome() +
        "\nLista de Sinistros: " + this.listaSinistros +
        "Lista de Condutores: " + this.listaCondutores;
        
        return info;
    }
    




    //----------------------- Getters e Setters -----------------------
    
    public int getId() {
        return this.id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public int getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    //retorna o Cliente do SeguroPF e PJ
    public abstract Cliente getCliente();

}
