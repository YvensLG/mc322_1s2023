public enum CalcSeguro {
    // Lista Constantes
    VALOR_BASE  (100.0),
    FATOR_18_30 (1.2),
    FATOR_30_60 (1.0),
    FATOR_60_90 (1.5);

    public final double calculo;

    // Construtor
    CalcSeguro(double calculo) {
        this.calculo = calculo;
    }

    // Função que retorna alguma constante dependendo da idade
    public static double FATOR_IDADE(int idade){
        if(18 <= idade && idade < 30){
            return CalcSeguro.FATOR_18_30.calculo;
        }
        else if(idade < 60){
            return CalcSeguro.FATOR_30_60.calculo;
        }
        else if(idade < 90){
            return CalcSeguro.FATOR_60_90.calculo;
        }
        return 0;
    }

    // Getter
    public double getCalculo(){
        return this.calculo;
    }
}
