import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    //scanner que será utilizado
    private static Scanner scan = new Scanner(System.in);

    //lista de seguradoras
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    //Main
    public static void main(String[] args) {
        //cria seguradora
        Seguradora seguradora = new Seguradora("16.208.979/0001-28", "Se segura", "(85) 96284-1639", 
                                               "Campinas", "naoresponda@sesegura.com", "arquivos");
                                               
        seguradoras.add(seguradora);

        //instancia ClientesPF/PJ, Veiculos, Frotas e Condutores pelos arquivos salvos
        seguradora.lerDados();

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
        SeguroPF segPF1 = seguradora.gerarSeguro(LocalDate.of(2011, 4, 3), LocalDate.now(), veiculo, pessoa);
        SeguroPJ segPJ1 = seguradora.gerarSeguro(LocalDate.of(2010, 3, 2), LocalDate.now(), frota, empresa);
        SeguroPF segPF2 = seguradora.gerarSeguro(LocalDate.of(2011, 4, 3), LocalDate.now(),
        seguradora.getListaClientesPF().get(0).getListaVeiculos().get(0), seguradora.getListaClientesPF().get(0));
        SeguroPJ segPJ2 = seguradora.gerarSeguro(LocalDate.of(2010, 3, 2), LocalDate.now(),
        seguradora.getListaClientesPJ().get(0).getListaFrota().get(0), seguradora.getListaClientesPJ().get(0));

        //cria Sinistros
        segPF1.gerarSinistro(LocalDate.now(), "aqui", condutor1);
        segPJ1.gerarSinistro(LocalDate.now(), "ali", condutor2);
        segPF2.gerarSinistro(LocalDate.now(), "aqui", seguradora.getListaCondutores().get(0));
        segPJ2.gerarSinistro(LocalDate.now(), "ali", seguradora.getListaCondutores().get(1));

        //grava dados dos sinistros e seguros instanciados nos arquivos 
        seguradora.gravarDados();

        //imprime algumas informações de objetos instanciados (descomentar para funcionar)

        System.out.println("------------ Seguradora ------------\n" + seguradora + "\n");
        // System.out.println("------------ ClientePF ------------\n" + pessoa + "\n");
        // System.out.println("------------ ClientePJ ------------\n" + empresa + "\n");
        // System.out.println("------------ Condutor ------------\n" + condutor1 + "\n");
        // System.out.println("------------ Frota ------------\n" + frota + "\n");
        // System.out.println("------------ Veiculo ------------\n" + veiculo + "\n");
        // System.out.println("------------ SeguroPF ------------\n" + segPF1 + "\n");
        // System.out.println("------------ SeguroPJ ------------\n" + segPJ1 + "\n");

        //começa Menu de Operações
        System.out.println("\n--------------------------------------------------------------------------------\n");
        System.out.println("\nPara interagir com o Menu, basta escolher o número correspondente a cada opção\n");
        System.out.println("\n--------------------------------------------------------------------------------");

        menu();
    }
    
    
    //----------------------------------------------------------------------
    //                               Menus
    //----------------------------------------------------------------------


    //Menu Inicial relativo à Seguradora
    public static void menu(){
        loop: while(true){
            System.out.println("\nEscolher Operação no Menu de Seguradoras!\n" +
                               "1 - Escolher Seguradora\n" +
                               "2 - Criar Seguradora\n" +
                               "3 - Encerrar\n");
                               
            double num = scan.nextDouble()/10;
            scan.nextLine();
            MenuOperacoes operacao = MenuOperacoes.valor(num);

            Seguradora seg;

            switch(operacao){
                //Escolhe qual seguradora irá utilizar
                case ESCOLHER:
                    if(seguradoras.size() == 0){
                        System.out.println("Não há Seguradoras Disponíveis...");
                        break;
                    }

                    seg = qualSeguradora();
                    menu1(seg);
                    
                    break;

                //Cria uma seguradora nova
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

                    seguradoras.add(new Seguradora(cnpj, nome, telefone, email, endereco, "arquivos_" + nome));

                    System.out.println("\nSeguradora cadastrada.");

                    break;

                //Encerra o Menu
                case ENCERRAR:
                    System.out.println("Até a próxima!");
                    break loop;

                //Reinicia o Menu caso dê errado
                default:
                    System.out.println("Operação Inválida...");
                    break;
            }
        }
    }

    //Menu de operações que se pode fazer na Seguradora escolhida
    public static void menu1(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação em " + seg.getNome() + ":\n" +
                               "1 - Menu do ClientePF\n" +
                               "2 - Menu do ClientePJ\n" +
                               "3 - Menu do Seguro\n" +
                               "4 - Calcular Valor da Receita\n" +
                               "5 - Gravar Sinistros e Seguros nos Arquivos\n" +
                               "6 - Checar Informações da Seguradora\n" +
                               "7 - Voltar\n");
            
            double num = scan.nextDouble();
            scan.nextLine();
            MenuOperacoes operacao = MenuOperacoes.valor(num);

            switch (operacao) {
                //entra no submenu de ClientePF
                case CLIENTES_PF:
                    menuCLIPF(seg);
                    break;

                //entra no submenu de ClientePJ
                case CLIENTES_PJ:
                    menuCLIPJ(seg);
                    break;

                //Entra no submenu de Seguros
                case SEGURO:
                    menuSEGURO(seg);
                    break;

                //Calcula a Receita Final
                case CALCULAR_RECEITA:
                    seg.calcularReceita();
                    break;

                //Mostra as Informações da Seguradora
                case GRAVAR_DADOS:
                    seg.gravarDados();
                    break;

                //Mostra as Informações da Seguradora
                case INFO_SEGURADORA:
                    System.out.println(seg);
                    break;

                //Volta ao Menu Anterior
                case VOLTAR:
                    break loop;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    //SubMenu de operações sobre ClientePF
    public static void menuCLIPF(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação no Menu do ClientePF:\n" +
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
                //Cadastrar um ClientePF
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
                
                //Checa as Informações de um ClientePF
                case CLIPF_CHECAR:
                    if(seg.getListaClientesPF().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
                    System.out.println("Cliente:");
                    c = qualClientePF(seg);
                    
                    System.out.println(c);
                    break;

                //Cadastra um Veículo ao ClientePF
                case CLIPF_CAD_VEICULO:
                    if(seg.getListaClientesPF().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
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

                //Remove um veículo de um ClientePF
                case CLIPF_REM_VEICULO:
                    if(seg.getListaClientesPF().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
                    System.out.println("Cliente:\n");
                    c = qualClientePF(seg);

                    if(c.getListaVeiculos().size() == 0){
                        System.out.println("Não há Veículos Disponíveis...");
                        break;
                    }

                    System.out.println("Digite a posição do veículo:\n");
                    Veiculo v = qualVeiculo(c);

                    c.removerVeiculo(v);
                    System.out.println("Veículo Removido.\n");
                    break;
                
                //Volta ao Menu anterior
                case CLIPF_VOLTAR :
                    break loop;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    //SubMenu de operações sobre ClientePJ
    public static void menuCLIPJ(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação no Menu do ClientePJ:\n" +
                               "1 - Cadastrar ClientePJ\n" +
                               "2 - Checar ClientePJ\n" +
                               "3 - Cadastrar Frota\n" +
                               "4 - Adicionar Veículo à Frota\n" +
                               "5 - Remover Veículo da Frota\n" +
                               "6 - Remover Frota\n" +
                               "7 - Voltar\n");
            
            double num = scan.nextDouble();
            scan.nextLine();
            num = 2 + num/10;
            MenuOperacoes operacao = MenuOperacoes.valor(num);
            ClientePJ c;
            Frota frota;

            switch (operacao) {
                //Cadastrar um ClientePJ
                case CLIPJ_CAD:
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
                
                    System.out.println("CNPJ:");
                    String cnpj = scan.nextLine();

                    if(!Validacao.validarCNPJ(cnpj)){
                        System.out.println("CNPJ Inválido.");
                        break;
                    }

                    System.out.println("Data de Fundação (AAAA-MM-DD):");
                    String dataFundacao = scan.nextLine();

                    System.out.println("Quantidade de Funcionários:");
                    int qtdeFuncionarios = scan.nextInt();
                    scan.nextLine();

                    c = new ClientePJ(nome, telefone, endereco, email, cnpj,
                                      LocalDate.parse(dataFundacao), qtdeFuncionarios);

                    seg.cadastrarCliente(c);

                    System.out.println("Cliente Cadastrado!");
                    break;
                
                //Checa as informações de um ClientePJ
                case CLIPJ_CHECAR:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }

                    System.out.println("Cliente:");
                    c = qualClientePJ(seg);
                    
                    System.out.println(c);
                    break;

                //Cadastra uma Frota a um CLientePJ
                case CLIPJ_CAD_FROTA:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }

                    System.out.println("Cliente:");
                    c = qualClientePJ(seg);

                    frota = new Frota();
                    c.cadastrarFrota(frota);

                    System.out.println("Frota de código " + frota.getCode() + " cadastrada.");
                    break;

                //Adiciona um veículo a uma frota de um ClientePJ
                case CLIPJ_ADD_FROTA:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
                    System.out.println("Cliente:\n");
                    c = qualClientePJ(seg);

                    if(c.getListaFrota().size() == 0){
                        System.out.println("Não há Frotas Disponíveis...");
                        break;
                    }

                    System.out.println("Digite a posição da frota:\n");
                    frota = qualFrota(c);
                    
                    System.out.println("Placa:");
                    String placa = scan.nextLine();

                    System.out.println("Marca:");
                    String marca = scan.nextLine();

                    System.out.println("Modelo:");
                    String modelo = scan.nextLine();
                    
                    System.out.println("Ano de Fabricação:");
                    int anoFabricacao = scan.nextInt();
                    scan.nextLine();

                    Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

                    c.atualizarFrota(frota, veiculo, "adicionar");
                    
                    System.out.println("Veículo Adicionado à Frota.\n");
                    break;

                //Remove um veículo de uma Frota
                case CLIPJ_REM_FROTA:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
                    System.out.println("Cliente:\n");
                    c = qualClientePJ(seg);

                    if(c.getListaFrota().size() == 0){
                        System.out.println("Não há Frotas Disponíveis...");
                        break;
                    }
                    System.out.println("Digite a posição da frota:\n");
                    frota = qualFrota(c);

                    if(frota.getListaVeiculos().size() == 0){
                        System.out.println("Não há Veículos Disponíveis...");
                        break;
                    }
                    System.out.println("Digite a posição do veículo:\n");
                    veiculo = qualVeiculo(frota);

                    c.atualizarFrota(frota, veiculo, "remover");
                    
                    System.out.println("Veículo Removido da Frota.\n");
                    break;
                
                //Deleta uma Frota 
                case CLIPJ_ATT_FROTA:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }

                    System.out.println("Cliente:\n");
                    c = qualClientePJ(seg);

                    if(c.getListaFrota().size() == 0){
                        System.out.println("Não há Frotas Disponíveis...");
                        break;
                    }

                    System.out.println("Digite a posição da frota:\n");
                    frota = qualFrota(c);

                    c.atualizarFrota(frota);
                    
                    System.out.println("Frota Deletada.\n");
                    break;
                
                //Volta ao Menu anterior
                case CLIPJ_VOLTAR:
                    break loop;
                
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    //SubMenu de operações sobre Seguro
    public static void menuSEGURO(Seguradora seg){
        loop: while(true){
            System.out.println("\nEscolher Operação no Menu de Seguros:\n" +
                               "1 - Gerar Seguro para ClientePF\n" +
                               "2 - Gerar Seguro para ClientePJ\n" +
                               "3 - Cancelar Seguro\n" +
                               "4 - Autorizar Condutor\n" +
                               "5 - Desautorizar Condutor\n" +
                               "6 - Gerar Sinistro\n" +
                               "7 - Checar Seguro\n" + 
                               "8 - Voltar\n");
            
            double num = scan.nextDouble();
            scan.nextLine();
            num = 3 + num/10;
            MenuOperacoes operacao = MenuOperacoes.valor(num);
            ClientePF cf;
            ClientePJ cj;
            Veiculo v;
            Frota f;
            String dataInicio;
            String dataFim;
            Seguro seguro;
            Condutor cond;


            switch (operacao) {
                //Gera um Seguro de um ClientePF
                case SEG_GERAR_PF:
                    if(seg.getListaClientesPF().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }
                    
                    System.out.println("Cliente:");
                    cf = qualClientePF(seg);
                    
                    if(cf.getListaVeiculos().size() == 0){
                        System.out.println("Não há Veículos Disponíveis...");
                        break;
                    }
                    
                    System.out.println("Veículo:");
                    v = qualVeiculo(cf);
                    
                    System.out.println("Data de Início (AAAA-MM-DD):");
                    dataInicio = scan.nextLine();
                    
                    System.out.println("Data de Fim (AAAA-MM-DD):");
                    dataFim = scan.nextLine();

                    seg.gerarSeguro(LocalDate.parse(dataInicio), LocalDate.parse(dataFim), v, cf);

                    System.out.println("Seguro Gerado!");
                    break;

                //Gera um Seguro de um ClientePJ
                case SEG_GERAR_PJ:
                    if(seg.getListaClientesPJ().size() == 0){
                        System.out.println("Não há Clientes Disponíveis...");
                        break;
                    }

                    System.out.println("Cliente:");
                    cj = qualClientePJ(seg);

                    if(cj.getListaFrota().size() == 0){
                        System.out.println("Não há Frotas Disponíveis...");
                        break;
                    }

                    System.out.println("Frota:");
                    f = qualFrota(cj);

                    System.out.println("Data de Início (AAAA-MM-DD):");
                    dataInicio = scan.nextLine();
                    
                    System.out.println("Data de Fim (AAAA-MM-DD):");
                    dataFim = scan.nextLine();

                    seg.gerarSeguro(LocalDate.parse(dataInicio), LocalDate.parse(dataFim), f, cj);

                    System.out.println("Seguro Gerado!");
                    break;
                
                //Cancela um Seguro
                case SEG_CANCELAR:
                    if(seg.getListaSeguros().size() == 0){
                        System.out.println("Não há Seguros Disponíveis...");
                        break;
                    }
                    seguro = qualSeguro(seg);

                    if(seg.cancelarSeguro(seguro)){
                        System.out.println("Seguro Cancelado!");
                    }else{
                        System.out.println("Não foi possível cancelar o Seguro...");
                    }

                    break;
                
                //Autoriza um Condutor ao Seguro
                case SEG_AUT_COND:
                    if(seg.getListaSeguros().size() == 0){
                        System.out.println("Não há Seguros Disponíveis...");
                        break;
                    }
                    seguro = qualSeguro(seg);

                    System.out.println("Nome do Condutor:");
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

                    System.out.println("Data de Nascimento (AAAA-MM-DD):");
                    String dataNascimento = scan.nextLine();

                    cond = new Condutor(cpf, nome, telefone, endereco, email, LocalDate.parse(dataNascimento));

                    seguro.autorizarCondutor(cond);

                    System.out.println("Condutor Autorizado!");
                    break;
                
                //Desautoriza um Condutor ao Seguro
                case SEG_DES_COND:
                    if(seg.getListaSeguros().size() == 0){
                        System.out.println("Não há Seguros Disponíveis...");
                        break;
                    }
                    seguro = qualSeguro(seg);

                    if(seguro.getListaCondutores().size() == 0){
                        System.out.println("Não há Condutores Disponíveis...");
                        break;
                    }
                    cond = qualCondutor(seguro);

                    if(seguro.desautorizarCondutor(cond)){
                        System.out.println("Condutor Desautorizado!");
                    }else{
                        System.out.println("Não foi possível desautorizar o Condutor...");
                    }

                    break;
                
                //Gera um Sinistro nesse Seguro
                case SEG_SINISTRO:
                    if(seg.getListaSeguros().size() == 0){
                        System.out.println("Não há Seguros Disponíveis...");
                        break;
                    }
                    seguro = qualSeguro(seg);

                    if(seguro.getListaCondutores().size() == 0){
                        System.out.println("Não há Condutores Disponíveis...");
                        break;
                    }
                    cond = qualCondutor(seguro);
                    
                    System.out.println("Data do Sinistro (AAAA-MM-DD):");
                    String data = scan.nextLine();
                    
                    System.out.println("Endereço:");
                    endereco = scan.nextLine();

                    int a = seguro.gerarSinistro(LocalDate.parse(data), endereco, cond).getId();
                    
                    System.out.println("Sinistro de Id " + a + " gerado!");
                    break;
                
                //Checa as Informações de um Seguro em Específico
                case SEG_CHECAR:
                    if(seg.getListaSeguros().size() == 0){
                        System.out.println("Não há Seguros Disponíveis...");
                        break;
                    }
                    seguro = qualSeguro(seg);
                    System.out.println(seguro);

                    break;

                //Volta ao Menu Anterior
                case SEG_VOLTAR:
                    break loop;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        }
    }

    
    //----------------------------------------------------------------------
    //                         Funções Utilizadas
    //----------------------------------------------------------------------


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

    //Escolher o ClientePF desejado dentre todos disponíveis da Seguradora
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

    //Escolher o ClientePJ desejado dentre todos disponíveis da Seguradora
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

    //Escolher o Veículo desejado dentre todos disponíveis do ClientePF
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

    //Escolher o Veículo desejado dentre todos disponíveis da Frota
    private static Veiculo qualVeiculo(Frota f){
        System.out.println("\nDigite a posição do Veículo que deseja:\n");
        for(int i = 0; i < f.getListaVeiculos().size(); i++){
            System.out.println("Veículo número " + (i+1) + " :");
            System.out.println(f.getListaVeiculos().get(i).getPlaca() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= f.getListaVeiculos().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        Veiculo v = f.getListaVeiculos().get(num);
        scan.nextLine();

        return v;
    }

    //Escolher a Frota desejada dentre todas as disponíveis do ClientePJ
    private static Frota qualFrota(ClientePJ c){
        System.out.println("\nDigite a posição da Frota que deseja:\n");
        for(int i = 0; i < c.getListaFrota().size(); i++){
            System.out.println("Frota número " + (i+1) + " :");
            System.out.println(c.getListaFrota().get(i).getCode() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= c.getListaFrota().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        Frota f = c.getListaFrota().get(num);
        scan.nextLine();

        return f;
    }

    //Escolher o Seguro desejado dentre todos os disponíveis da Seguradora
    private static Seguro qualSeguro(Seguradora seg){
        System.out.println("\nDigite a posição do Seguro que deseja:\n");
        for(int i = 0; i < seg.getListaSeguros().size(); i++){
            System.out.println("Seguro número " + (i+1) + " :");
            System.out.println(seg.getListaSeguros().get(i).getId() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= seg.getListaSeguros().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        Seguro s = seg.getListaSeguros().get(num);
        scan.nextLine();

        return s;
    }
 
    //Escolher o Condutor desejado dentre todos os disponíveis do Seguro
    private static Condutor qualCondutor(Seguro seguro){
        System.out.println("\nDigite a posição do Condutor que deseja:\n");
        for(int i = 0; i < seguro.getListaCondutores().size(); i++){
            System.out.println("Condutor número " + (i+1) + " :");
            System.out.println(seguro.getListaCondutores().get(i).getNome() + "\n");
        }

        int num;

        while(true){
            num = scan.nextInt()-1;
            if(num < 0 || num >= seguro.getListaCondutores().size()){
                System.out.println("\nNúmero inválido, digite outro!\n");
            }
            else{
                break;
            }
        }

        Condutor cond = seguro.getListaCondutores().get(num);
        scan.nextLine();

        return cond;
    }

}