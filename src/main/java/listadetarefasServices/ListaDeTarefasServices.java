package listadetarefasServices;

import listadetarefasDAO.ListaDeTarefasDAO;
import listadetarefasDTO.ListaDeTarefasDTO;
import listadetarefasDTO.TarefaDTOParam;
import listadetarefasconectionfactory.ConnectionFactory;

import java.sql.Connection;
import java.util.NoSuchElementException;
import java.util.Set;

public class ListaDeTarefasServices {

    public static void mensagemSolicitaNomeDaTarefaService() {
        System.out.println("\nDigite o nome da tarefa: ");
    }

    public static void mensagemSolicitaDescricaoDaTarefaService() {
        System.out.println("Digite a descrição da tarefa: ");
    }

    public static void cadastrarTarefaService(TarefaDTOParam tarefaDTOParam) {
        Connection con = ConnectionFactory.recuperarConexao();
        new ListaDeTarefasDAO(con).cadastrarTarefaDAO(tarefaDTOParam);
    }

    public static void listarTarefasService() {
        Connection con = ConnectionFactory.recuperarConexao();
        Set<ListaDeTarefasDTO> listaDeTarefasDTOSet = new ListaDeTarefasDAO(con).listarTarefasDAO();

        listaDeTarefasDTOSet.stream().forEach(tarefa -> {
            System.out.println(tarefa);
        });
    }

    public static void mostrarTarefaService(String nomeDaTarefa) {
        Connection con = ConnectionFactory.recuperarConexao();
        Set<ListaDeTarefasDTO> listaDeTarefasDTOSet = new ListaDeTarefasDAO(con).listarTarefasDAO();

        System.out.println(
                listaDeTarefasDTOSet
                        .stream()
                        .filter(tarefa -> (tarefa.getNome().equals(nomeDaTarefa)))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("Não existe tarefa cadastrada com esse nome!"))
        );
    }

    public static void alterarStatusTarefaService(String nomeDaTarefa) {
        Connection con = ConnectionFactory.recuperarConexao();
        String retorno = new ListaDeTarefasDAO(con).alterarStatusTarefaService(nomeDaTarefa);

        System.out.println(retorno);
    }

    public static void deletarTarefaService(String nomeDaTarefa) {
        Connection con = ConnectionFactory.recuperarConexao();
        String retorno = new ListaDeTarefasDAO(con).deletarStatusTarefaService(nomeDaTarefa);

        System.out.println(retorno);;
    }

}
