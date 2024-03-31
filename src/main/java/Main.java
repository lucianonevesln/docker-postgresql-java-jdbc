import listadetarefasDTO.TarefaDTOParam;
import listadetarefasServices.ListaDeTarefasServices;
import listadetarefasUtils.ListaDeTarefasUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        do {
                ListaDeTarefasUtils.mensagemDeControle();
                ListaDeTarefasUtils.opcao = leitura.nextByte();

            if (ListaDeTarefasUtils.opcao == 6) {
                ListaDeTarefasUtils.controleDaAplicacao = false;
                ListaDeTarefasUtils.mensagemDeFimDaExecucao();

            } else {
                switch (ListaDeTarefasUtils.opcao) {

                    case 1:
                        ListaDeTarefasServices.mensagemSolicitaNomeDaTarefaService();
                        leitura.nextLine();
                        String nome = leitura.nextLine();
                        ListaDeTarefasServices.mensagemSolicitaDescricaoDaTarefaService();
                        String descricao = leitura.nextLine();
                        ListaDeTarefasServices.cadastrarTarefaService(new TarefaDTOParam(nome, descricao));
                        break;

                    case 2:
                        ListaDeTarefasServices.listarTarefasService();
                        break;

                    case 3:
                        ListaDeTarefasServices.mensagemSolicitaNomeDaTarefaService();
                        leitura.nextLine();
                        String nomeDaTarefa = leitura.nextLine();
                        ListaDeTarefasServices.mostrarTarefaService(nomeDaTarefa);
                        break;

                    case 4:
                        ListaDeTarefasServices.mensagemSolicitaNomeDaTarefaService();
                        leitura.nextLine();
                        String tarefa = leitura.nextLine();
                        ListaDeTarefasServices.alterarStatusTarefaService(tarefa);
                        break;

                    case 5:
                        ListaDeTarefasServices.mensagemSolicitaNomeDaTarefaService();
                        leitura.nextLine();
                        String nomeTarefa = leitura.nextLine();
                        ListaDeTarefasServices.deletarTarefaService(nomeTarefa);
                        break;
                }
            }

        } while (ListaDeTarefasUtils.controleDaAplicacao);

        leitura.close();
    }
}
