package banco_clinica;

//Classes necess�rias para uso de Banco de dados //


import java.sql.*;
import javax.swing.JOptionPane;

public class connectionFactory_clinica {

    //____________________________________METODO QUE CONECTA  AO BANCO_____________________________________________________________
	Connection con = null;
        Statement stm = null;

	public connectionFactory_clinica() {

		try {


			String driverName = "com.mysql.jdbc.Driver";                        

			Class.forName(driverName);




			// Configurando a nossa conex�o com um banco de dados//

			String serverName = "192.168.1.69";    //caminho do servidor do BD

			String mydatabase ="lifesys_clinica";        //nome do seu banco de dados

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root";        //nome de um usu�rio de seu BD      

			String password = "root";      //sua senha de acesso

			con = DriverManager.getConnection(url, username, password);
			stm = con.createStatement();
                        
   		} catch (Exception e) {
				System.out.println("N�o foi poss�vel conectar no banco " + e.getMessage());
		}
	}

//____________________________________METODO QUE REALIZA A EXECU��O DAS QUERYS NO BANCO_________________________________________
	public void executaQuery(String query){
		try {
			this.stm.execute(query);
		} catch (SQLException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a opera��o", null, JOptionPane.ERROR_MESSAGE);
		}

	}


	//_____________________________METEDO QUE BUSCA INFORMA��ES NO BANCO (USADO PARA COMANDOS DO TIPO SELECT)_________________________________________
	public ResultSet busca(String query){
		ResultSet rRet = null;
		try {
			rRet = this.stm.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rRet;
	}

   

}
