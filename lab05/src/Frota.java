import java.util.Random;
import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    
    // Construtor
    public Frota(){
        this.code = criarCode();
        listaVeiculos = new ArrayList<Veiculo>();
    }

    //Cria um Código para a Frota
    public String criarCode(){
        Random gerador = new Random();
        int c = gerador.nextInt(1000000000);
        return String.format("%d", c);
    }

    // Se foi possível adicionar o Veículo, retorna true, caso contrário, false
    public boolean addVeiculo(Veiculo veiculo){
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    // Se foi possível remover o Veículo, retorna true, caso contrário, false
    public boolean removeVeiculo(Veiculo veiculo){
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    // Retorna as informações da Frota
    public String toString(){
        String info;

        info = "Frota de Código " + this.code +
               "\nQuantidade de Veículos: " + this.listaVeiculos.size();

        return info;
    }





    //----------------------- Getters e Setters -----------------------

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

}
