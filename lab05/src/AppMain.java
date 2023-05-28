import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class AppMain {
    //scanner que será utilizado
    private static Scanner scan = new Scanner(System.in);

    //lista de seguradoras
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    public static void main(String[] args) {
        Seguradora seguradora;
        Veiculo veiculo;
        Sinistro sinistro;

        //cria seguradora
        seguradora = new Seguradora("Se segura", "(85) 96284-1639",
        "naoresponda@sesegura.com", "Fortaleza");
        
        seguradoras.add(seguradora);
        
        //cria clientePF
        ClientePF cliente = new ClientePF(
            "Yvens",
            "Fortaleza",
            "323.588.226-04",
            "Masculino",
            LocalDate.of(2020, 1, 8),
            "Ensino Médio Completo",
            LocalDate.of(2004, 2, 2),
            "Muito Rico"
        );

        //cria clientePJ
        ClientePJ empresa = new ClientePJ(
            "Empresa Generica",
            "Campinas",
            "56.505.098/0001-93",
            LocalDate.of(1900, 1, 1),
            59
        );

        //adiciona veiculos a PF
        veiculo = new Veiculo("OSL4P15", "Honda", "Civic", 1999);
        cliente.addVeiculo(veiculo);
        veiculo = new Veiculo("ABC1D23", "Ferrari", "Roma", 1500);
        cliente.addVeiculo(veiculo);

        //adiciona veiculo a PJ
        veiculo = new Veiculo("PL4C4", "Qualquer", "Carro", 2017);
        empresa.addVeiculo(veiculo);

        //cadastra clientes na seguradora
        seguradora.cadastrarCliente(cliente);
        seguradora.cadastrarCliente(empresa);

        
        //gera sinistro a PF
        sinistro = new Sinistro(LocalDate.of(2020, 3, 3), "Avenida 1", seguradora,
        cliente.getListaVeiculos().get(0), cliente);
        seguradora.gerarSinistro(sinistro);
        
        //gera sinistro a PJ
        sinistro = new Sinistro(LocalDate.of(2021, 5, 4), "Avenida 2", seguradora,
        empresa.getListaVeiculos().get(0), empresa);
        seguradora.gerarSinistro(sinistro);
        
        //atualiza valor seguro dos clientes
        seguradora.calcularPrecoSeguroCliente();

        //gera e imprime a receita total
        System.out.println(seguradora.calcularReceita());

        //começa Menu de Operações
        menu();
    }

    //Escolher a Seguradora desejada dentre todas disponíveis
    private static Seguradora qualSeguradora(){
        System.out.println("\nDigite a posição da Seguradora que deseja:\n");
        for(int i = 0; i < seguradoras.size(); i++){
            System.out.println("Seguradora número " + i + " :");
            System.out.println(seguradoras.get(i) + "\n");
        }
        
        Seguradora seg = seguradoras.get(scan.nextInt());
        scan.nextLine();

        return seg;
    }

    //Escolher o Cliente desejado dentre todos disponíveis
    private static Cliente qualCliente(Seguradora seg){
        System.out.println("\nDigite a posição do Cliente que deseja:\n");
        for(int i = 0; i < seg.getListaClientes().size(); i++){
            System.out.println("Cliente número " + i + " :");
            System.out.println(seg.getListaClientes().get(i) + "\n");
        }

        Cliente c = seg.getListaClientes().get(scan.nextInt());
        scan.nextLine();

        return c;
    }

    //Escolher o Veículo desejado dentre todos disponíveis
    private static Veiculo qualVeiculo(Cliente c){
        System.out.println("\nDigite a posição do Veículo que deseja:\n");
        for(int i = 0; i < c.getListaVeiculos().size(); i++){
            System.out.println("Veículo número " + i + " :");
            System.out.println(c.getListaVeiculos().get(i) + "\n");
        }

        Veiculo v = c.getListaVeiculos().get(scan.nextInt());
        scan.nextLine();

        return v;
    }

    //Escolher o Sinistro desejado dentre todos disponíveis
    private static Sinistro qualSinistro(Seguradora seg){
        System.out.println("\nDigite a posição do Sinistro que deseja:\n");
        for(int i = 0; i < seg.getListaSinistros().size(); i++){
            System.out.println("Sinistro número " + i + " :");
            System.out.println(seg.getListaSinistros().get(i) + "\n");
        }

        Sinistro s = seg.getListaSinistros().get(scan.nextInt());
        scan.nextLine();

        return s;
    }

    //Menu de Operações
    public static void menu(){

        //while so acaba quando o operador apertar 0-Sair
        loop: while(true){
            System.out.println("\n Digite um número correspondente a uma opção:\n" +
                               "1- Cadastrar\n" +
                               "2- Listar\n" +
                               "3- Excluir\n" +
                               "4- Gerar Sinistro\n" +
                               "5- Transferir Seguro\n" +
                               "6- Calcular Receita Seguradora\n" +
                               "0- Sair\n");

            double num = scan.nextDouble();
            scan.nextLine();
            MenuOperacoes operacao = MenuOperacoes.valor(num);

            Seguradora seg;
            Sinistro sin;
            Cliente c;

            //separação de casos para cada uma das opções de operação
            switch (operacao) {
                //cadastros
                case CADASTRAR:
                    System.out.println("\n Digite um número correspondente a uma opção:\n" +
                                            "1- Cadastrar Cliente\n" +
                                            "2- Cadastrar Veículo\n" +
                                            "3- Cadastrar Seguradora\n" +
                                            "4- Voltar\n");
                                            
                    double numC = scan.nextDouble();
                    scan.nextLine();
                    numC = num + numC/10;
                    MenuOperacoes opC = MenuOperacoes.valor(numC);
                    switch (opC) {

                        //cadastrar cliente em uma seguradora
                        case CAD_CLIENTE:
                            seg = qualSeguradora();
                            System.out.println(seg);
                            System.out.println("ClientePF ou ClientePJ?");
                            String tipo = scan.nextLine();
                            if(tipo.equals("ClientePF")) {
                                System.out.println("Nome:");
                                String nome = scan.nextLine();

                                if(!Validacao.validarNome(nome)){
                                    System.out.println("Nome Inválido.");
                                    break;
                                }

                                System.out.println("Endereco:");
                                String endereco = scan.nextLine();

                                System.out.println("CPF:");
                                String cpf = scan.nextLine();

                                if(!Validacao.validarCPF(cpf)){
                                    System.out.println("CPF Inválido.");
                                    break;
                                }

                                System.out.println("Masculino, Feminino, Outro:");
                                String genero = scan.nextLine();

                                System.out.println("Data da Licenca (AAAA-MM-DD):");
                                String dataLicenca = scan.nextLine();

                                System.out.println("Nível de Educação:");
                                String educacao = scan.nextLine();

                                System.out.println("Data de Nascimento (AAAA-MM-DD):");
                                String dataNascimento = scan.nextLine();

                                System.out.println("Classe Econômica:");
                                String classeEconomica = scan.nextLine();

                                c = new ClientePF(nome, endereco, cpf, genero, LocalDate.parse(dataLicenca),
                                                  educacao, LocalDate.parse(dataNascimento), classeEconomica);

                                seg.cadastrarCliente(c);

                                System.out.println("Cliente Cadastrado!");
                                seg.calcularPrecoSeguroCliente();
                                System.out.println("Seguro:" + c.getValorSeguro());
                            }
                            else if(tipo.equals("ClientePJ")) {
                                System.out.println("Nome:");
                                String nome = scan.nextLine();

                                if(!Validacao.validarNome(nome)){
                                    System.out.println("Nome Inválido.");
                                    break;
                                }

                                System.out.println("Endereco:");
                                String endereco = scan.nextLine();

                                System.out.println("CNPJ:");
                                String cnpj = scan.nextLine();

                                if(!Validacao.validarCNPJ(cnpj)){
                                    System.out.println("CNPJ Inválido.");
                                    break;
                                }

                                System.out.println("Data de Fundacao (AAAA-MM-DD):");
                                String dataFundacao = scan.nextLine();

                                System.out.println("Quantidade de Funcionários:");
                                int qtdeFuncionarios = scan.nextInt();
                                scan.nextLine();

                                c = new ClientePJ(nome, endereco, cnpj, LocalDate.parse(dataFundacao), qtdeFuncionarios);

                                seg.cadastrarCliente(c);

                                System.out.println("Cliente Cadastrado!");
                                seg.calcularPrecoSeguroCliente();
                                System.out.println("Seguro:" + c.getValorSeguro());
                            }
                            else {
                                System.out.println("Comando Inválido.");
                            }
                            break;

                        //cadastrar seguradora na lista de seguradoras
                            case CAD_SEGURADORA:
                            System.out.println("Nome da nova seguradora:");
                            String nome = scan.nextLine();

                            System.out.println("Telefone:");
                            String telefone = scan.nextLine();

                            System.out.println("Email:");
                            String email = scan.nextLine();

                            System.out.println("Endereço:");
                            String endereco = scan.nextLine();

                            seguradoras.add(new Seguradora(nome, telefone, email, endereco));

                            System.out.println("Seguradora cadastrada.");
                            break;

                        //cadastrar veiculo a um cliente
                        case CAD_VEICULO:
                            seg = qualSeguradora();

                            System.out.println("Cliente:");
                            c = qualCliente(seg);

                            System.out.println("Placa:");
                            String placa = scan.nextLine();

                            System.out.println("Marca:");
                            String marca = scan.nextLine();

                            System.out.println("Modelo:");
                            String modelo = scan.nextLine();

                            System.out.println("Ano de Fabricação:");
                            int anoFabricacao = scan.nextInt();
                            scan.nextLine();

                            c.addVeiculo(new Veiculo(placa, marca, modelo, anoFabricacao));
                            System.out.println("Vaículo cadastrado.");
                            break;
                        
                        //voltar ao menu principal
                        case CAD_VOLTAR:
                            break;
                        
                        //caso algo dê errado
                        default: 
                            System.out.println("Operação Inválida");
                            break;
                    }
                break;
                
                //listas
                case LISTAR:
                    System.out.println("\n Digite um número correspondente a uma opção:\n" +
                                            "1- Listar Clientes por Seguradora\n" +
                                            "2- Listar Sinistros por Seguradora\n" +
                                            "3- Listar Sinistros por Cliente\n" +
                                            "4- Listar Veículos por Cliente\n" +
                                            "5- Listar Veículos por Seguradora\n" +
                                            "6- Voltar\n");
                                            
                    double numL = scan.nextDouble();
                    scan.nextLine();
                    numL = num + numL/10;
                    MenuOperacoes opL = MenuOperacoes.valor(numL);
                    switch (opL) {
                        //listar clientes de uma seguradora (dividido entre PF e PJ)
                        case LIST_CLIENTE:
                            seg = qualSeguradora();

                            System.out.println("ClientePF ou ClientePJ?:\n");
                            String P = scan.nextLine();

                            seg.listarClientes(P);
                            break;
                        
                        //listar sinistros de um Cliente
                        case LIST_SINISTRO_CLI:
                            seg = qualSeguradora();
                            c = qualCliente(seg);

                            seg.visualizarSinistro(c.getNome());
                            break;
                        
                        //listar sinistros de uma seguradora
                        case LIST_SINISTRO_SEG:
                            seg = qualSeguradora();
                            seg.listarSinistros();
                            break;

                        //listar veículos de um cliente
                        case LIST_VEICULO_CLI:
                            seg = qualSeguradora();
                            c = qualCliente(seg);

                            System.out.println(c.getListaVeiculos());
                            break;
                        
                        //listar veículos de uma seguradora
                        case LIST_VEICULO_SEG:
                            seg = qualSeguradora();
                            seg.listarVeiculos();
                            break;
                        //voltar ao menu principal
                        case LIST_VOLTAR:
                            break;
                        
                        //caso algo dê errado
                        default: 
                            System.out.println("Operação Inválida");
                            break;
                    }
                    break;    
                
                //excluir algo
                case EXCLUIR:
                    System.out.println("\n Digite um número correspondente a uma opção:\n" +
                                        "1- Excluir Cliente\n" +
                                        "2- Excluir Veiculo\n" +
                                        "3- Excluir Sinistro\n" +
                                        "4- Voltar\n");
                                        
                    double numE = scan.nextDouble();
                    scan.nextLine();
                    numE = num + numE/10;
                    MenuOperacoes opE = MenuOperacoes.valor(numE);

                    switch (opE) {
                        //excluir um cliente de uma seguradora
                        case EXC_CLIENTE:
                            seg = qualSeguradora();

                            System.out.println("Digite a posição do cliente que será excluído:\n");
                            c = qualCliente(seg);

                            seg.removerCliente(c.getNome());
                            System.out.println("Cliente Removido.\n");
                            break;

                        //excluir um veículo de um cliente
                        case EXC_VEICULO:
                            seg = qualSeguradora();

                            System.out.println("Digite a posição do cliente que possui o veículo:\n");
                            c = qualCliente(seg);

                            System.out.println("Digite a posição do veículo:\n");
                            Veiculo v = qualVeiculo(c);

                            c.remVeiculo(v);
                            System.out.println("Veículo Removido.\n");
                            break;
                        
                        //excluir sinistro de uma seguradora
                        case EXC_SINISTRO:
                            seg = qualSeguradora();

                            System.out.println("Digite a posição do Sinistro:\n");
                            sin = qualSinistro(seg);

                            seg.excluirSinistro(sin);
                            System.out.println("Sinistro Removido.\n");
                            break;

                        //voltar ao menu principal
                        case EXC_VOLTAR:
                            break;

                        //caso algo dê errado
                        default:
                            System.out.println("Operação Inválida");
                            break;
                    }
                    break;
                
                //gera um sinistro
                case GERAR_SINISTRO:
                    seg = qualSeguradora();

                    System.out.println("Digite a posição do cliente:\n");
                    Cliente cliente = qualCliente(seg);

                    System.out.println("Digite a posição do veiculo:\n");
                    Veiculo veiculo = qualVeiculo(cliente);

                    System.out.println("Local do sinistro: ");
                    String endereco = scan.nextLine();
                    
                    Sinistro sinistro = new Sinistro(LocalDate.now(), endereco, seg, veiculo, cliente);
                    
                    seg.gerarSinistro(sinistro);

                    System.out.println("Sinistro gerado.");

                    break;    
                
                //transfere o seguro de um cliente ao outro
                case TRANSFERIR_SEGURO:
                    seg = qualSeguradora();

                    System.out.println("Digite a posição do cliente que fará a transferência:\n");
                    Cliente cliente1 = qualCliente(seg);

                    System.out.println("Digite a posição do cliente que receberá a transferência:\n");
                    Cliente cliente2 = qualCliente(seg);
                    
                    seg.transferirSeguro(cliente1, cliente2);
                    System.out.println("Transferência Realizada\n");

                    break;    
                
                //calcula a receita de uma seguradora
                case CALCULAR_RECEITA:
                    seg = qualSeguradora();
                    seg.calcularPrecoSeguroCliente();
                    System.out.println("A receita total é " + seg.calcularReceita());
                    break;
                
                //fecha o menu
                case SAIR:
                    System.out.println("Fechando Menu");
                    break loop;
                
                //caso algo dê errado
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }
}