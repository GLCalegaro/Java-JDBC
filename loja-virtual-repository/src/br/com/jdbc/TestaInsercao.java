package br.com.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();
		// Quando executarmos a cláusula insert, eu quero também que ele me retorne a
		// chave gerada, o ID gerado. Então eu executo, depois eu pego a chave gerada
		// dentro do meu Statement, com stm.getGeneratedKeys();.
		stm.execute("INSERT INTO PRODUTO (nome, descrição) VALUES('MOUSE', 'MOUSE SEM FIO - LOGITECH')",
				Statement.RETURN_GENERATED_KEYS);
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
	}
}
