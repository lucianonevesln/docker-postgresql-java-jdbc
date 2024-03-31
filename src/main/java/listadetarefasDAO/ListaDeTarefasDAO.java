package listadetarefasDAO;

import listadetarefasDTO.ListaDeTarefasDTO;
import listadetarefasDTO.TarefaDTOParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ListaDeTarefasDAO {
    private Connection con;

    public ListaDeTarefasDAO(Connection con) {
        this.con = con;
    }

    public String cadastrarTarefaDAO(TarefaDTOParam tarefaDTOParam) {
        try {
            ListaDeTarefasDTO novaTarefa = new ListaDeTarefasDTO(
                    tarefaDTOParam.getNome(),
                    tarefaDTOParam.getDescricao(),
                    true,
                    LocalDateTime.now()
            );

            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into lista_de_tarefas (nome, descricao, ativo, data_de_cadastro)" +
                       "values (?, ?, ?, ?)"
            );

            preparedStatement.setString(1, novaTarefa.getNome());
            preparedStatement.setString(2, novaTarefa.getDescricao());
            preparedStatement.setObject(3, novaTarefa.isAtivo());
            preparedStatement.setObject(4, novaTarefa.getDataDeCadastro());

            preparedStatement.execute();
            preparedStatement.close();
            con.close();

            return "Tarefa cadastrada com sucesso";

        } catch (SQLException e) {
            return "Erro ao tentar cadastrar tarefa: " + e;
        }
    }

    public Set<ListaDeTarefasDTO> listarTarefasDAO() {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from lista_de_tarefas");
            ResultSet resultSet = preparedStatement.executeQuery();
            Set<ListaDeTarefasDTO> listaDeTarefasDTOSet = new HashSet<>();

            while (resultSet.next()) {
                listaDeTarefasDTOSet.add(new ListaDeTarefasDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getBoolean(4),
                        resultSet.getTimestamp(5),
                        resultSet.getTimestamp(6)
                ));
            }

            resultSet.close();
            preparedStatement.close();
            con.close();

            return listaDeTarefasDTOSet;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar cadastrar tarefa: " + e);
        }
    }

    public String alterarStatusTarefaService(String nomeDaTarefa) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(
                    "update lista_de_tarefas set ativo = false, data_de_alteracao = ? where nome = ?"
            );
            preparedStatement.setObject(1, LocalDateTime.now());
            preparedStatement.setString(2, nomeDaTarefa);

            preparedStatement.execute();
            preparedStatement.close();
            con.close();

            return "Tarefa concluída!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String deletarStatusTarefaService(String nomeDaTarefa) {
        try {PreparedStatement preparedStatement = con.prepareStatement(
                "delete from lista_de_tarefas where nome = ?"
        );
            preparedStatement.setString(1, nomeDaTarefa);

            preparedStatement.execute();
            preparedStatement.close();
            con.close();

            return "Tarefa excluída com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
