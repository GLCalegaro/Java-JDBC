package br.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();

		// Se quiser ficar somente com os dados da tabela inciais, eu utilizo o método
		// que chama getUpdateCount(), que nos retorna um inteiro. Esse inteiro
		// significa o seguinte, quantas linhas que foram modificadas após o Statement
		// ser executado.
		Integer linhasAlteradas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram alteradas: " + linhasAlteradas);

	}
}
