public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("Se segura", "(85) 96284-1639",
                                               "naoresponda@sesegura.com", "Fortaleza");
        
        ArrayList<Veiculo> veiculos_cliente = new ArrayList<>();
        veiculos_cliente.add(new Veiculo("OSL4P15", "Honda", "Civic"));
        veiculos_cliente.add(new Veiculo("ABC1D23", "Ferrari", "Roma"));

        ClientePF cliente = new ClientePF(
            "Yvens",
            "Fortaleza",
            veiculos_cliente,
            "123.349.556-12",
            "Masculino",
            LocalDate.of(2020, 1, 8),
            "Ensino Médio Completo",
            LocalDate.of(2004, 2, 2),
            "Muito Rico"
        );

        testaClientePF(cliente);
    }

    public static void testaCliente(ClientePF cliente){
        System.out.println("\n*** Teste ClientePF ***");
        System.out.println(cliente);
    }
}