import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.jdbc.ConnectionFactory;
import br.com.jdbc.dao.ProdutoDAO;
import br.com.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto game = new Produto("Alice: Madness Returns",
				"Poderá Alice salvar o País das Maravilhas, e a si mesma, da loucura que consome os dois?");

		// Verificando se há conexão disponivel:
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(game);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}

}
