public class Validacao {
    // Valida o CPF
    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // remove não números

        if (cpf.length() != 11) {
            return false;
        }

        // não pode ter todos os algarismos iguais
        char a = cpf.charAt(0);
        boolean k = true;

        for (int i = 0; i < 11; i++) {
            if (cpf.charAt(i) != a) {
                k = false;
            }
        }

        if (k) {
            return false;
        }

        // algoritmo para encontrar o penúltimo algarismo do CPF
        int ver1 = 0;

        for (int i = 0; i < 9; i++) {
            ver1 += (10 - i) * (cpf.charAt(i) - '0');
        }

        ver1 = ver1 % 11;
        if (ver1 == 0 || ver1 == 1) {
            ver1 = 0;
        } else {
            ver1 = 11 - ver1;
        }

        // algoritmo para encontrar o último algarismo do CPF
        int ver2 = 0;

        for (int i = 1; i < 10; i++) {
            ver2 += (11 - i) * (cpf.charAt(i) - '0');
        }

        ver2 = ver2 % 11;
        if (ver2 == 0 || ver2 == 1) {
            ver2 = 0;
        } else {
            ver2 = 11 - ver2;
        }

        // checa se os algarismos estão corretos
        if (cpf.charAt(9) - '0' != ver1 || cpf.charAt(10) - '0' != ver2) {
            return false;
        } else {
            return true;
        }
    }

    // Valida o CNPJ
    public static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); // remove não números

        //deve ter 14 números
        if (cnpj.length() != 14) {
            return false;
        }

        // não pode ter todos os algarismos iguais
        char a = cnpj.charAt(0);
        boolean k = true;

        for (int i = 0; i < 14; i++) {
            if (cnpj.charAt(i) != a) {
                k = false;
            }
        }

        if (k) {
            return false;
        }

        // algoritmo para encontrar o penúltimo algarismo do CNPJ
        int[] mult1 = new int[] { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int ver1 = 0;

        for (int i = 0; i < 12; i++) {
            ver1 += mult1[i] * (cnpj.charAt(i) - '0');
        }

        ver1 = ver1 % 11;
        if (ver1 == 0 || ver1 == 1) {
            ver1 = 0;
        } else {
            ver1 = 11 - ver1;
        }

        // algoritmo para encontrar o último algarismo do CNPJ
        int[] mult2 = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int ver2 = 0;

        for (int i = 0; i < 13; i++) {
            ver2 += mult2[i] * (cnpj.charAt(i) - '0');
        }

        ver2 = ver2 % 11;
        if (ver2 == 0 || ver2 == 1) {
            ver2 = 0;
        } else {
            ver2 = 11 - ver2;
        }

        // checa se os algarismos estão corretos
        if (cnpj.charAt(12) - '0' != ver1 || cnpj.charAt(13) - '0' != ver2) {
            return false;
        } else {
            return true;
        }
    }

    // Valida Nome
    public static boolean validarNome(String nome) {
        String nomeantigo = nome;
        nome = nome.replaceAll("[^A-Za-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u00FF\\s]", ""); // deixa somente letras e espaços

        if(nome.equals(nomeantigo)) return true;
        return false;
    }
}
