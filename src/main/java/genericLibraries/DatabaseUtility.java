package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains reusable to read from and modify data
 * @author SANDHYA
 */

public class DatabaseUtility {
	private Connection connection;
	private Statement statement;
	/**
	 * This method initializes database
	 * @param url
	 * @param username
	 * @param password
	 */
	public void databaseInit(String url,String username,String password)
	{
		Driver dbDriver=null;
		try {
			dbDriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 * this method fetches the data from database
	 * @param query
	 * @param colName
	 * @return
	 */
	public  List<Object> readFromDatabase(String query,String colName)
	{
		ResultSet result=null;
		try {
		 result=statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Object>list=new ArrayList<Object>();
		
			try {
				list.add(result.getObject(colName));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}
	/**
	 * This method modifies the data in the database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query)
	{
		int result=0;
		try {
			result=statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method is used to close the database connection
	 */
	public void closeadatabase()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
