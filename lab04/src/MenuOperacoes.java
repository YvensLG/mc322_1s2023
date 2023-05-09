public enum MenuOperacoes {
    CADASTRAR (1),
    LISTAR (2),
    EXCLUIR (3),
    GERAR_SINISTRO (4),
    TRANSFERIR_SEGURO (5),
    CALCULAR_RECEITA (6),
    SAIR (0),

    CAD_CLIENTE(1.1),
    CAD_VEICULO(1.2),
    CAD_SEGURADORA(1.3),
    CAD_VOLTAR(1.4),

    LIST_CLIENTE(2.1),
    LIST_SINISTRO_SEG(2.2),
    LIST_SINISTRO_CLI(2.3),
    LIST_VEICULO_CLI(2.4),
    LIST_VEICULO_SEG(2.5),
    LIST_VOLTAR(2.6),

    EXC_CLIENTE(3.1),
    EXC_VEICULO(3.2),
    EXC_SINISTRO(3.3),
    EXC_VOLTAR(3.4),

    ERRO(-1);

    public final double operacao;

    MenuOperacoes(double operacao) {
        this.operacao = operacao;
    }

    public double getOperacao(){
        return operacao;
    }

    public static MenuOperacoes valor(double operacao) {
        for (MenuOperacoes enumeracao : values()) {
            if (enumeracao.getOperacao() == operacao) {
                return enumeracao;
            }
        }
        return ERRO;
    }
}
