public enum MenuOperacoes {
    //lista de operações
    ESCOLHER (0.1),
    CRIAR (0.2),
    ENCERRAR (0.3),

    CLIENTES_PF (1),
    CLIENTES_PJ (2),
    SEGURO (3),
    CALCULAR_RECEITA (4),
    INFO_SEGURADORA (5),
    VOLTAR(6),

    CLIPF_CAD (1.1),
    CLIPF_CHECAR (1.2),
    CLIPF_CAD_VEICULO (1.3),
    CLIPF_REM_VEICULO (1.4),
    CLIPF_VOLTAR (1.5),

    CLIPJ_CAD (2.1),
    CLIPJ_CHECAR (2.2),
    CLIPJ_CAD_FROTA (2.3),
    CLIPJ_ADD_FROTA (2.4),
    CLIPJ_REM_FROTA (2.5),
    CLIPJ_ATT_FROTA (2.6),
    CLIPJ_VOLTAR (2.7),

    SEG_GERAR_PF (3.1),
    SEG_GERAR_PJ (3.2),
    SEG_CANCELAR (3.3),
    SEG_AUT_COND (3.4),
    SEG_DES_COND (3.5),
    SEG_SINISTRO (3.6),
    SEG_CHECAR (3.7),
    SEG_VOLTAR (3.8),

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
