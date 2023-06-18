public enum CalcSeguro {
    // Lista Constantes
    VALOR_BASE  (10.0),
    FATOR_30 (1.25),
    FATOR_30_60 (1.0),
    FATOR_60 (1.5);

    public final double calculo;

    // Construtor
    CalcSeguro(double calculo) {
        this.calculo = calculo;
    }

    // Função que retorna alguma constante dependendo da idade
    public static double FATOR_IDADE(int idade){
        if(idade < 30){
            return CalcSeguro.FATOR_30.calculo;
        }
        else if(idade <= 60){
            return CalcSeguro.FATOR_30_60.calculo;
        }
        else if(idade > 60){
            return CalcSeguro.FATOR_60.calculo;
        }
        return 0;
    }

    // Getter
    public double getCalculo(){
        return this.calculo;
    }
}
