public enum MenuOperacoes {
    //lista de operações
    ESCOLHER (0.1),
    CRIAR (0.2),
    ENCERRAR (0.3),

    CLIENTES_PF (1),
    CLIENTES_PJ (2),
    CALCULAR_RECEITA (3),
    VOLTAR(4),

    CLIPF_CAD (1.1),
    CLIPF_CHECAR (1.2),
    CLIPF_CAD_VEICULO (1.3),
    CLIPF_REM_VEICULO (1.4),
    CLIPF_VOLTAR (1.5),

    CLIPJ_CAD (2.1),
    CAD_FROTA (2.2),
    ADD_FROTA (2.3),
    REM_FROTA (2.4),
    ATT_FROTA (2.5),
    CLIPJ_VOLTAR (2.6),

    ERRO(-1);

    public final double operacao;

    //construtor
    MenuOperacoes(double operacao) {
        this.operacao = operacao;
    }

    //get
    public double getOperacao(){
        return operacao;
    }

    //dado o valor, retorna a enumeração respectiva
    public static MenuOperacoes valor(double operacao) {
        for (MenuOperacoes enumeracao : values()) {
            if (enumeracao.getOperacao() == operacao) {
                return enumeracao;
            }
        }
        return ERRO;
    }
}
