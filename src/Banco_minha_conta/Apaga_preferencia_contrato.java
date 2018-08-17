package Banco_minha_conta;

import java.sql.ResultSet;

import banco_clinica.connectionFactory_contas;

public class Apaga_preferencia_contrato  {

	public void testApaga_preferencia() throws Exception {

		//----------------APAGA A PREFERENCIA DO CONTRATO----------------------
		banco_clinica.connectionFactory_contas connection = new connectionFactory_contas();
		int id;
			
		String query = "SELECT * FROM lifesys_contas_homologacao_sprint8.conta where cnpj = '01057278000249'";
		ResultSet rs = connection.busca(query);

		try {
			rs.next();
			if (rs.getRow() != 0) {
				id = Integer.parseInt(rs.getString("Id"));
				String query1 = "DELETE FROM `lifesys_contas_homologacao_sprint8`.`conta_preferencias` WHERE `Id`= "+id;
				connection.executaQuery(query1);

				connection.stm.close();
			}
		}catch (Exception ex) {
			System.out.println("Sem conteudo");
		}

		//--------------------------------------------------------------------------------

	}
}
