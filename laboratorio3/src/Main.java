import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Seguradora seguradora = new Seguradora("Se segura", "(85) 96284-1639",
        "naoresponda@sesegura.com", "Fortaleza");

    ArrayList<Veiculo> veiculos_cliente = new ArrayList<Veiculo>();
    veiculos_cliente.add(new Veiculo("OSL4P15", "Honda", "Civic", 1999));
    veiculos_cliente.add(new Veiculo("ABC1D23", "Ferrari", "Roma", 1500));

    ArrayList<Veiculo> veiculos_empresa = new ArrayList<Veiculo>();
    veiculos_empresa.add(new Veiculo("PL4C4", "Qualquer", "Carro", 2017));

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

    seguradora.cadastrarCliente(cliente);
    seguradora.cadastrarCliente(empresa);

    Sinistro sinistro = new Sinistro(
        LocalDate.now(),
        "Manaus",
        seguradora,
        veiculos_cliente.get(0),
        cliente);

    seguradora.gerarSinistro(sinistro);
    seguradora.gerarSinistro(sinistro);

    seguradora.visualizarSinistro(cliente.getNome());
    seguradora.visualizarSinistro(empresa.getNome());

    seguradora.listarSinistros();
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