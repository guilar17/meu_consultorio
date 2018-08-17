package banco_clinica;

import java.sql.ResultSet;

public class Apaga_vinculo_profissional  {

	public void testApaga_vinculo_profissional() throws Exception {

		//----------------APAGA O VINCULO DO PROFISSIONAL NA CLINICA----------------------
		connectionFactory_clinica connection_clinica = new connectionFactory_clinica();
		connectionFactory_contas connection_contas = new connectionFactory_contas();
		int id;
		int id2;

		String query = "SELECT Id FROM lifesys_contas_homologacao_sprint8.conta_profissional WHERE conta_profissional.CPF='37363425604'";
		ResultSet rs = connection_contas.busca(query);
		String query2 = null;
		ResultSet rs2 = null;


		try {
			rs.next();
			if (rs.getRow() != 0) {
				id = Integer.parseInt(rs.getString("Id"));
				query2 = "select Id FROM lifesys_clinica.clinica_profissional where ProfissionalId = "+id;
				rs2 = connection_clinica.busca(query2);
				try {
					rs2.next();
					if (rs2.getRow() != 0) {
						id2 = Integer.parseInt(rs2.getString("Id"));				
						String query3 = "delete FROM lifesys_clinica.clinica_profissional where Id = "+id2;
						connection_clinica.executaQuery(query3);

					}
				}catch (Exception ex) {
					System.out.println("Sem conteudo");
				}
			}
		}catch (Exception ex) {
			System.out.println("Sem conteudo");
		}


		connection_clinica.stm.close();
		connection_contas.stm.close();
		//--------------------------------------------------------------------------------		
	}
}
