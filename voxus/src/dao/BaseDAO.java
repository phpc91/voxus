package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	private static String user="admin", passwd="admin123", 	
			endpoint="voxus-db.cyki8d0w5wwv.sa-east-1.rds.amazonaws.com/voxus";
	
	public BaseDAO() {
		try{
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	protected static final Connection createConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mariadb://"+endpoint+"?user="+user+"&password="+passwd);
	}
}
