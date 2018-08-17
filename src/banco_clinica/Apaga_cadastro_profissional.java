package banco_clinica;

import java.sql.ResultSet;

public class Apaga_cadastro_profissional  {

	public void testApaga_cadastro_profissional() throws Exception {

		//----------------APAGA O CADASTRO DO PROFISSIONAL NO BANCO----------------------
		connectionFactory_contas connection = new connectionFactory_contas();
		int id;
			
		String query = "SELECT Id FROM lifesys_contas_homologacao_sprint8.conta_profissional WHERE conta_profissional.CPF='37363425604'";
		ResultSet rs = connection.busca(query);

		try {
			rs.next();
			if (rs.getRow() != 0) {
				id = Integer.parseInt(rs.getString("Id"));
				//System.out.println(id);
				String query2 = "delete from lifesys_contas_homologacao_sprint8.vinculo_profissional_laudos where vinculo_profissional_laudos.ProfissionalId = "+id;
				//System.out.println(query2);
				connection.executaQuery(query2);
				
				String query3 = "delete from lifesys_contas_homologacao_sprint8.ativacao where ativacao.ContaProfissionalId = "+ id;
				//System.out.println(query3);
				connection.executaQuery(query3);
				
				String query4 = "delete from lifesys_contas_homologacao_sprint8.info_complementares_clinica where ProfissionalId = "+ id;
				//System.out.println(query5);
				connection.executaQuery(query4);
				
				String query5 = "delete from lifesys_contas_homologacao_sprint8.denuncia where ProfissionalDenunciadoId = "+ id;
				connection.executaQuery(query5);
				
				String query6 = "delete from lifesys_contas_homologacao_sprint8.conta_profissional WHERE conta_profissional.Id = "+ id;
				//System.out.println(query4);
				connection.executaQuery(query6);

				connection.stm.close();
			}
		}catch (Exception ex) {
			System.out.println("Sem conteudo");
		}

		//--------------------------------------------------------------------------------

	}
}
