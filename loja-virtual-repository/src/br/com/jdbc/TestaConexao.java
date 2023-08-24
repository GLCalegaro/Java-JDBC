package br.com.jdbc;

import java.sql.*;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		// O SELECT e outros campos que nós queremos trazer para dentro da nossa tabela,
		// eles são considerados no mundo Java como Statements.
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRIÇÃO FROM PRODUTO");
		boolean resultado = stm.execute();

		// Para pegar todo o conteúdo dos meus produtos adicionados à minha tabela
		// utilizamos o ResultSet rst stm.getResultSet()
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descrição = rst.getString("DESCRIÇÃO");
			System.out.println(descrição);
		}

		connection.close();
	}

}
