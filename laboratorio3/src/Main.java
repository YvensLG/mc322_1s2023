import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Seguradora seguradora = new Seguradora("Se segura", "(85) 96284-1639",
        "naoresponda@sesegura.com", "Fortaleza");

    ArrayList<Veiculo> veiculos_cliente = new ArrayList<Veiculo>();
    veiculos_cliente.add(new Veiculo("OSL4P15", "Honda", "Civic"));
    veiculos_cliente.add(new Veiculo("ABC1D23", "Ferrari", "Roma"));

    ArrayList<Veiculo> veiculos_empresa = new ArrayList<Veiculo>();
    veiculos_empresa.add(new Veiculo("PL4C4", "Qualquer", "Carro"));

    ClientePF cliente = new ClientePF(
        "Yvens",
        "Fortaleza",
        veiculos_cliente,
        "323.588.226-04",
        "Masculino",
        LocalDate.of(2020, 1, 8),
        "Ensino Médio Completo",
        LocalDate.of(2004, 2, 2),
        "Muito Rico");

    ClientePJ empresa = new ClientePJ(
        "Empresa Genérica",
        "Campinas",
        veiculos_empresa,
        "56.505.098/0001-93",
        LocalDate.of(1900, 1, 1));

    testaClientePF(cliente);
    testaClientePJ(empresa);
  }

  public static void testaClientePF(ClientePF cliente) {
    System.out.println("\n*** Teste ClientePF ***");
    System.out.println(cliente);
  }

  public static void testaClientePJ(ClientePJ empresa) {
    System.out.println("\n*** Teste ClientePJ ***");
    System.out.println(empresa);
  }
}