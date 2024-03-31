package listadetarefasDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ListaDeTarefasDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private boolean ativo;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAlteracao;
    private String retornoDataDeCadastro;
    private String retornoDataDeAlteracao;

    public ListaDeTarefasDTO(String nome, String descricao, boolean ativo, LocalDateTime dataDeCadastro) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.dataDeCadastro = dataDeCadastro;
    }

    public ListaDeTarefasDTO(Integer id, String nome, String descricao, boolean ativo, Timestamp dataDeCadastro, Timestamp dataDeAlteracao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.retornoDataDeCadastro = String.valueOf(dataDeCadastro);
        this.retornoDataDeAlteracao = String.valueOf(dataDeAlteracao);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | " + "Nome: " + nome +
                " | " + "Descricao: " + descricao +
                " | " + "Ativo: " + ativo +
                " | " + "Data de cadastro: " + retornoDataDeCadastro +
                " | " + "Data de alteração: " + retornoDataDeAlteracao;
    }
}
