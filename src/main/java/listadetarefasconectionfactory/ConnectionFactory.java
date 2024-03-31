package listadetarefasconectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection recuperarConexao() {
        try {
            return DriverManager
                    .getConnection(
                            "jdbc:postgresql://172.18.0.10:5432/lista_de_tarefas?user=postgres&password=admin123"
                    );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}