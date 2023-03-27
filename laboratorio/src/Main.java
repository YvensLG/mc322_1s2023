public class Main {
    public static void main(String[] args) {
        //testando as funções
        Cliente yvens = new Cliente("Yvens", "074.629.503-08", 
                                    "02/02/2004", 19, "Fortaleza");
        
        boolean k = yvens.validarCPF();
        String out = yvens.toString();

        System.out.println(k);
        System.out.println(out);

        Sinistro sin = new Sinistro("10/10/2020", "Campinas");

        int i = sin.getId();
        System.out.println(i);
    }
}