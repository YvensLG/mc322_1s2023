import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class AppMain {
    //scanner que será utilizado
    private static Scanner scan = new Scanner(System.in);

    //lista de seguradoras
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    public static void main(String[] args) {
        //cria seguradora
        Seguradora seguradora = new Seguradora("16.208.979/0001-28", "Se segura",
                                               "(85) 96284-1639", "Campinas", "naoresponda@sesegura.com");
        
        seguradoras.add(seguradora);
        
        //cria condutores
        Condutor condutor1 = new Condutor("769.935.730-24", "João", "(49) 98929-5978",
                                          "Casa", "joao@gmail.com", LocalDate.of(1990, 10, 21));

        Condutor condutor2 = new Condutor("999.042.420-97", "Maria", "(21) 96811-5908",
                                          "Prédio", "maria@gmail.com", LocalDate.of(1991, 11, 22));

        //cria veículos
        Veiculo veiculo = new Veiculo("OSL4P15", "Honda", "Civic", 1999);
        Veiculo veiculo1 = new Veiculo("ABC1D23", "Ferrari", "Roma", 1500);
        Veiculo veiculo2 = new Veiculo("PL4C4", "Qualquer", "Carro", 2017);
        
        //cria frota e add veiculos a ela
        Frota frota = new Frota();
        frota.getListaVeiculos().add(veiculo1);
        frota.getListaVeiculos().add(veiculo2);

        //cria clientePF
        ClientePF pessoa = new ClientePF(
            "Yvens",
            "(92) 99572-4456",
            "Fortaleza",
            "yvens@gmail.com",
            "323.588.226-04",
            "Masculino",
            "Ensino Médio Completo",
            LocalDate.of(2004, 2, 2)
        );
        pessoa.getListaVeiculos().add(veiculo);
        seguradora.cadastrarCliente(pessoa);

        //cria clientePJ
        ClientePJ empresa = new ClientePJ(
            "Empresa Generica",
            "(94) 98179-4621",
            "Campinas",
            "empresa@generica.com",
            "56.505.098/0001-93",
            LocalDate.of(1900, 1, 1),
            59
        );
        empresa.getListaFrota().add(frota);
        seguradora.cadastrarCliente(empresa);

        //cria Seguros
        SeguroPF segPF = seguradora.gerarSeguro(LocalDate.of(2011, 4, 3), LocalDate.now(), veiculo, pessoa);
        SeguroPJ segPJ = seguradora.gerarSeguro(LocalDate.of(2010, 3, 2), LocalDate.now(), frota, empresa);

        //cria Sinistro
        Sinistro sinPF = segPF.gerarSinistro(LocalDate.now(), "aqui", condutor1);
        Sinistro sinPJ = segPJ.gerarSinistro(LocalDate.now(), "ali", condutor2);

        System.out.println("------------ Seguradora ------------\n" + seguradora + "\n");
        System.out.println("------------ ClientePF ------------\n" + pessoa + "\n");
        System.out.println("------------ ClientePJ ------------\n" + empresa + "\n");
        System.out.println("------------ Condutor ------------\n" + condutor1 + "\n");
        System.out.println("------------ Frota ------------\n" + frota + "\n");
        System.out.println("------------ Veiculo ------------\n" + veiculo + "\n");
        System.out.println("------------ SeguroPF ------------\n" + segPF + "\n");
        System.out.println("------------ SeguroPJ ------------\n" + segPJ + "\n");
        System.out.println("------------ Sinistro ------------\n" + sinPF + "\n");

        //começa Menu de Operações
        menu();
    }
    //Escolher a Seguradora desejada dentre todas disponíveis
    private static Seguradora qualSeguradora(){
        System.out.println("\nDigite a posição da Seguradora que deseja:\n");
        for(int i = 0; i < seguradoras.size(); i++){
            System.out.println("Seguradora número " + (i+1) + " :");
            System.out.println(seguradoras.get(i).getNome() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= seguradoras.size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }
        
        Seguradora seg = seguradoras.get(num);
        scan.nextLine();

        return seg;
    }

    //Escolher o ClientePF desejado dentre todos disponíveis
    private static ClientePF qualClientePF(Seguradora seg){
        System.out.println("\nDigite a posição do ClientePF que deseja:\n");
        for(int i = 0; i < seg.getListaClientesPF().size(); i++){
            System.out.println("Cliente número " + (i+1) + " :");
            System.out.println(seg.getListaClientesPF().get(i).getNome() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= seg.getListaClientesPF().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        ClientePF c = seg.getListaClientesPF().get(num);
        scan.nextLine();

        return c;
    }

    //Escolher o ClientePJ desejado dentre todos disponíveis
    private static ClientePJ qualClientePJ(Seguradora seg){
        System.out.println("\nDigite a posição do ClientePJ que deseja:\n");
        for(int i = 0; i < seg.getListaClientesPJ().size(); i++){
            System.out.println("Cliente número " + (i+1) + " :");
            System.out.println(seg.getListaClientesPJ().get(i).getNome() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= seg.getListaClientesPJ().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        ClientePJ c = seg.getListaClientesPJ().get(num);
        scan.nextLine();

        return c;
    }

    //Escolher o Veículo desejado dentre todos disponíveis
    private static Veiculo qualVeiculo(ClientePF c){
        System.out.println("\nDigite a posição do Veículo que deseja:\n");
        for(int i = 0; i < c.getListaVeiculos().size(); i++){
            System.out.println("Veículo número " + (i+1) + " :");
            System.out.println(c.getListaVeiculos().get(i).getPlaca() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= c.getListaVeiculos().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        Veiculo v = c.getListaVeiculos().get(num);
        scan.nextLine();

        return v;
    }

    // //Escolher o Sinistro desejado dentre todos disponíveis
    // private static Sinistro qualSinistro(Seguradora seg){
    //     System.out.println("\nDigite a posição do Sinistro que deseja:\n");
    //     for(int i = 0; i < seg.getListaSinistros().size(); i++){
    //         System.out.println("Sinistro número " + i + " :");
    //         System.out.println(seg.getListaSinistros().get(i) + "\n");
    //     }

    //     Sinistro s = seg.getListaSinistros().get(scan.nextInt());
    //     scan.nextLine();

    //     return s;
    // }

    //Menu de Operações
    public static void menu(){
        System.out.println("\n--------------------------------------------------------------------------------\n");
        System.out.println("\nPara interagir com o Menu, basta escolher o número correspondente a cada opção\n");
        System.out.println("\n--------------------------------------------------------------------------------");

        loop: while(true){
            System.out.println("\nEscolha sua Seguradora ou Crie Uma!\n" +
                               "1 - Escolher\n" +
                               "2 - Criar\n" +
                               "3 - Encerrar\n");
                               
            double num = scan.nextDouble()/10;
            scan.nextLine();
            MenuOperacoes operacao = MenuOperacoes.valor(num);

            Seguradora seg;

            switch(operacao){
                case ESCOLHER:
                    seg = qualSeguradora();
                    menu1(seg);
                    
                    break;

                case CRIAR:
                    System.out.println("CNPJ da nova seguradora:");
                    String cnpj = scan.nextLine();

                    if(!Validacao.validarCNPJ(cnpj)){
                        System.out.println("\nCNPJ Inválido.");
                        break;
                    }

                    System.out.println("\nNome da nova seguradora:");
                    String nome = scan.nextLine();

                    System.out.println("\nTelefone:");
                    String telefone = scan.nextLine();

                    System.out.println("\nEmail:");
                    String email = scan.nextLine();

                    System.out.println("\nEndereço:");
                    String endereco = scan.nextLine();

                    seguradoras.add(new Seguradora(cnpj, nome, telefone, email, endereco));

                    System.out.println("\nSeguradora cadastrada.");

                    break;

                case ENCERRAR:
                    System.out.println("Até a próxima!");
                    break loop;

                default:
                    System.out.println("Operação Inválida...");
                    break;
            }
        }
    }

    public static void menu1(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação em " + seg.getNome() + ":\n" +
                               "1 - ClientePF\n" +
                               "2 - ClientePJ\n" +
                               "3 - Calcular Receita\n" +
                               "4 - Voltar\n");
            
            double num = scan.nextDouble();
            scan.nextLine();
            MenuOperacoes operacao = MenuOperacoes.valor(num);

            switch (operacao) {
                case CLIENTES_PF:
                    menuCLIPF(seg);
                    break;

                case CLIENTES_PJ:
                    //menuCLIPJ(seg);
                    break;

                case CALCULAR_RECEITA:
                    seg.calcularReceita();
                    break;

                case VOLTAR:
                    break loop;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    public static void menuCLIPF(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação:\n" +
                               "1 - Cadastrar ClientePF\n" +
                               "2 - Checar ClientePF\n" +
                               "3 - Cadastrar Veículo\n" +
                               "4 - Remover Veículo\n" +
                               "5 - Voltar\n");
            
            double num = scan.nextDouble();
            scan.nextLine();
            num = 1 + num/10;
            MenuOperacoes operacao = MenuOperacoes.valor(num);
            ClientePF c;

            switch (operacao) {
                case CLIPF_CAD:
                    System.out.println("Nome:");
                    String nome = scan.nextLine();
                    
                    if(!Validacao.validarNome(nome)){
                        System.out.println("Nome Inválido.");
                        break;
                    }
                    System.out.println("Telefone:");
                    String telefone = scan.nextLine();

                    System.out.println("Endereco:");
                    String endereco = scan.nextLine();

                    System.out.println("Email:");
                    String email = scan.nextLine();
                
                    System.out.println("CPF:");
                    String cpf = scan.nextLine();

                    if(!Validacao.validarCPF(cpf)){
                        System.out.println("CPF Inválido.");
                        break;
                    }

                    System.out.println("Gênero:");
                    String genero = scan.nextLine();

                    System.out.println("Nível de Educação:");
                    String educacao = scan.nextLine();

                    System.out.println("Data de Nascimento (AAAA-MM-DD):");
                    String dataNascimento = scan.nextLine();

                    c = new ClientePF(nome, telefone, endereco, email, cpf, genero,
                                                educacao, LocalDate.parse(dataNascimento));

                    seg.cadastrarCliente(c);

                    System.out.println("Cliente Cadastrado!");
                    break;
                
                case CLIPF_CHECAR:
                    System.out.println("Cliente:");
                    c = qualClientePF(seg);
                    
                    System.out.println(c);
                    break;

                case CLIPF_CAD_VEICULO:
                    System.out.println("Cliente:");
                    c = qualClientePF(seg);

                    System.out.println("Placa:");
                    String placa = scan.nextLine();

                    System.out.println("Marca:");
                    String marca = scan.nextLine();

                    System.out.println("Modelo:");
                    String modelo = scan.nextLine();

                    System.out.println("Ano de Fabricação:");
                    int anoFabricacao = scan.nextInt();
                    scan.nextLine();

                    c.cadastrarVeiculo(new Veiculo(placa, marca, modelo, anoFabricacao));
                    System.out.println("Vaículo cadastrado.");
                    break;

                case CLIPF_REM_VEICULO:
                    System.out.println("Cliente:\n");
                    c = qualClientePF(seg);

                    System.out.println("Digite a posição do veículo:\n");
                    Veiculo v = qualVeiculo(c);

                    c.removerVeiculo(v);
                    System.out.println("Veículo Removido.\n");
                    break;

                case CLIPF_VOLTAR :
                    break loop;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    public static void menuLIST(Seguradora seg){
        
    }


        /*
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

            }
        }
        */

}