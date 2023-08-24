package br.com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {

			// Auto commit serve para podermos controlar nossas transações;
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descrição) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);) {
				adicionarVariavel("Fone de ouvido", "Philips - Bluetooth", stm);
				adicionarVariavel("Teclado", "Teclado sem fio - Logitech", stm);

				// Quando eu realizar o Commit na minha transação, se tiver algum erro, eu posso
				// dar um rollback, ou seja, eu posso explicitar o rollback falando o seguinte:
				// desfaz tudo e me dá uma mensagem.
				connection.commit();
			} catch (Exception e) {
				// Imprimindo a exceção
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descrição, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descrição);

		if (nome.equals("Teclado")) {
			throw new RuntimeException("ERRO, não foi possível inserir o produto.");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O ID criado foi: " + id);
			}
		}
	}

}
