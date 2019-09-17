package stored.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedureMain {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection("jdbc:oracle:thin:@INSISCILT-4047:1521:XE", "Vaishali", "ykheb");
           CallableStatement cstmt=connection.prepareCall("{call query_emp(?,?,?,?)}");
           cstmt.setInt(1, 171);
           cstmt.registerOutParameter(2, Types.VARCHAR);
           cstmt.registerOutParameter(3, Types.INTEGER);
           cstmt.registerOutParameter(4, Types.FLOAT);
           cstmt.execute();
           String name=cstmt.getString(2);
           int salary=cstmt.getInt(3);
           float commission=cstmt.getFloat(4);
           System.out.println(name);
			System.out.println(salary);
			System.out.println(commission);
           
			 

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				if (connection != null && !connection.isClosed()) {

					connection.close();

				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
