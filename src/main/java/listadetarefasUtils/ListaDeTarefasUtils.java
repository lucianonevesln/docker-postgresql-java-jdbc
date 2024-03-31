package listadetarefasUtils;

import listadetarefasDTO.TarefaDTOParam;

public class ListaDeTarefasUtils {
    public static boolean controleDaAplicacao = true;
    public static byte opcao;

    public static void mensagemDeControle() {
        System.out.print("""
               \n########## Menu Inicial ##########
               1 - Cadastrar Tarefa;
               2 - Listar Tarefas;
               3 - Mostrar Tarefa;
               4 - Concluir Tarefa;
               5 - Excluir Tarefa;
               6 - Sair da aplicação;
               ####################################\n
               Digite sua opção:
               """);
    }

    public static void mensagemDeFimDaExecucao() {
        System.out.println("Saindo da aplicação...");
    }

}
