package listadetarefasDTO;

public class TarefaDTOParam {
    private String nome;
    private String descricao;

    public TarefaDTOParam(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
