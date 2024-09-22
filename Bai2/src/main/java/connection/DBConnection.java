package connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	public static Connection getConnection() {

		Connection connection = null;

		try {
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/MariaDB");
			connection = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
