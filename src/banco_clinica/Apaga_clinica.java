package banco_clinica;

import java.sql.ResultSet;

public class Apaga_clinica  {

	public void testApaga_clinica() throws Exception {

		//----------------APAGA O CADASTRO DA CLINICA----------------------
		connectionFactory_clinica connection = new connectionFactory_clinica();
		int id;
			
		String query = "SELECT Id FROM lifesys_clinica.clinica where Identificacao = '10209323000143'";
		ResultSet rs = connection.busca(query);

		try {
			rs.next();
			if (rs.getRow() != 0) {
				id = Integer.parseInt(rs.getString("Id"));
				String query2 = "delete FROM lifesys_clinica.clinica where Id = "+id;
				connection.executaQuery(query2);
				

				connection.stm.close();
			}
		}catch (Exception ex) {
			System.out.println("Sem conteudo");
		}

		//--------------------------------------------------------------------------------

	}
}
