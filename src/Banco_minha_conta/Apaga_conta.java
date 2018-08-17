package Banco_minha_conta;

import java.sql.ResultSet;

import banco_clinica.connectionFactory_contas;

public class Apaga_conta  {

	public void testApaga_conta() throws Exception {

		//----------------APAGA O CADASTRO DO MINHA CONTA----------------------
		banco_clinica.connectionFactory_contas connection = new connectionFactory_contas();
		int id;
			
		String query = "SELECT * FROM lifesys_contas_homologacao_sprint8.conta where cnpj = '01057278000249'";
		ResultSet rs = connection.busca(query);

		try {
			rs.next();
			if (rs.getRow() != 0) {
				id = Integer.parseInt(rs.getString("Id"));
				String query1 = "delete FROM lifesys_contas_homologacao_sprint8.ativacao where contaid = "+id;
				String query2 = "delete FROM lifesys_contas_homologacao_sprint8.conta where Id = "+id;
				connection.executaQuery(query1);
				connection.executaQuery(query2);
				

				connection.stm.close();
			}
		}catch (Exception ex) {
			System.out.println("Sem conteudo");
		}

		//--------------------------------------------------------------------------------

	}
}
