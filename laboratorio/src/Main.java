public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Yvens", "123.349.556-12", 
                                      "02/02/2004", 19, "Fortaleza");
        
        Seguradora seguradora = new Seguradora("Se segura", "(85) 96284-1639",
                                               "naoresponda@sesegura.com", "Fortaleza");
        
        Sinistro sinistro = new Sinistro("10/10/2020", "Campinas");

        Veículo veiculo = new Veículo("OSL4P15", "Honda", "Civic");

        testaCliente(cliente);

        testaSeguradora(seguradora);

        testaSinistro(sinistro);

        testaVeiculo(veiculo);
    }

    public static void testaCliente(Cliente cliente){
        System.out.println("\n*** Teste Cliente ***");
        System.out.println(cliente);
    }

    public static void testaSeguradora(Seguradora seguradora){
        System.out.println("\n*** Teste Seguradora ***");
        System.out.println(seguradora.getNome());
        System.out.println(seguradora.getTelefone());
        System.out.println(seguradora.getEmail());
        System.out.println(seguradora.getEndereco());
    }

    public static void testaSinistro(Sinistro sinistro){
        System.out.println("\n*** Teste Sinistro ***");
        System.out.println(sinistro.getData());
        System.out.println(sinistro.getEndereco());
        System.out.println(sinistro.getId());
    }

    public static void testaVeiculo(Veículo veiculo){
        System.out.println("\n*** Teste Veiculo ***");
        System.out.println(veiculo.getPlaca());
        System.out.println(veiculo.getMarca());
        System.out.println(veiculo.getModelo());
    }
}