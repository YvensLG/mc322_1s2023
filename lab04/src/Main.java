import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
        LocalDate.of(1963, 2, 2),
        "Muito Rico"
    );

    ClientePJ empresa = new ClientePJ(
        "Empresa Genérica",
        "Campinas",
        veiculos_empresa,
        "56.505.098/0001-93",
        LocalDate.of(1900, 1, 1),
        59
    );

    System.out.println(cliente.getValorSeguro());
    System.out.println(empresa.getValorSeguro());

    // while(true){
    //   if(menu(cliente, empresa, seguradora) == false){
    //     break;
    //   }
    // }
  }

  private static boolean menu(ClientePF cliente, ClientePJ empresa, Seguradora seguradora){
    System.out.println("\n0- Sair");
		System.out.println("1- Visualizar dados do ClientePF");
		System.out.println("2- Visualizar dados do ClientePJ");
		System.out.println("3- Adicionar o ClientePF na seguradora");
		System.out.println("4- Adicionar o ClientePJ na seguradora");
		System.out.println("5- Remover o ClientePF da seguradora");
		System.out.println("6- Remover o ClientePJ da seguradora");
		System.out.println("7- Listar Clientes da seguradora");
		System.out.println("8- Gerar Sinistro");
		System.out.println("9- Listar Sinistros");
    System.out.println("10- Visualizar Sinistro de um Cliente");

    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();

    System.out.println("---------------------------------------------");

    if(num == 0){
      return false;
    }
    else if(num == 1){
      System.out.println(cliente);
    }
    else if(num == 2){
      System.out.println(empresa);
    }
    else if(num == 3){
      if(seguradora.cadastrarCliente(cliente) == false){
        System.out.println("Cliente já cadastrado.");
      }
      else{
        System.out.println("Cliente cadastrado com sucesso!");
      }
    }
    else if(num == 4){
      if(seguradora.cadastrarCliente(empresa) == false){
        System.out.println("Cliente já cadastrado.");
      }
      else{
        System.out.println("Cliente cadastrado com sucesso!");
      }
    }
    else if(num == 5){
      if(seguradora.removerCliente(cliente.getNome()) == false){
        System.out.println("Cliente não está na lista.");
      }
      else{
        System.out.println("Cliente removido com sucesso!");
      }
    }
    else if(num == 6){
      if(seguradora.removerCliente(empresa.getNome()) == false){
        System.out.println("Cliente já cadastrado.");
      }
      else{
        System.out.println("Cliente removido com sucesso!");
      }
    }
    else if(num == 7){
      System.out.println("ClientesPF:");
      seguradora.listarClientes("ClientePF");
      System.out.println("ClientesPJ:");
      seguradora.listarClientes("ClientePJ");
    }
    else if(num == 8){
      System.out.println("Digite 1 para ClientePF e 2 para ClientePJ");
      int num1 = scan.nextInt();
      if(num1 == 1){
        Sinistro sinistro = new Sinistro(
          LocalDate.now(),
          "Campinas",
          seguradora,
          cliente.getListaVeiculos().get(0),
          cliente
        );
        seguradora.gerarSinistro(sinistro);

      }else if(num1 == 2){
        Sinistro sinistro = new Sinistro(
          LocalDate.now(),
          "Campinas",
          seguradora,
          empresa.getListaVeiculos().get(0),
          empresa
        );
        seguradora.gerarSinistro(sinistro);

      }else{
        System.out.println("Entrada inválida.");
        return true;
      }
      
      System.out.println("Sinistro adicionado com sucesso!");
    }
    else if(num == 9){
      seguradora.listarSinistros();
    }
    else if(num == 10){
      System.out.println("Digite 1 para ClientePF e 2 para ClientePJ");
      int num1 = scan.nextInt();
      if(num1 == 1){
        seguradora.visualizarSinistro(cliente.getNome());

      }else if(num1 == 2){
        seguradora.visualizarSinistro(empresa.getNome());

      }else{
        System.out.println("Entrada inválida.");
      }
    }

    System.out.println("---------------------------------------------");

    return true;
  }
}