package br.com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Sempre que precisarmos fazer uma conexao, podemos utilizar a ConnectionFactory que funciona como uma "fábrica de conexoes";
public class ConnectionFactory {

	// O Datasource é uma interface que será implementada por esses drivers, que têm
	// por objetivo expor mesmo essas informações do Pool;
	public DataSource dataSource;

	// Criando pool de conexoes(abrir uma quantidade de conexões e reaproveitá-las):
	public ConnectionFactory() {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("1234");
		
		//Setando nº maximo de conexoes abertas:
		comboPooledDataSource.setMaxPoolSize(15);

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() throws SQLException {
		//O DataSource ja tem em si o método getConnection, então é só chamarmos aqui para fazer a conexao;
		return dataSource.getConnection();
	}

}
