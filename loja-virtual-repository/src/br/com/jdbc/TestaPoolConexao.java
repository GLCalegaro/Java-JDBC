package br.com.jdbc;
import java.sql.SQLException;

public class TestaPoolConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		//Testando limite de conexao com 20:
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de nº: " + i);
		}
	}

}
