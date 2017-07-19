package less23;

import java.sql.*;

public class Main {
	
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/devjava3?useSSL=false";

	public static final String USER = "root";
	
	public static final String PASSWORD = "1987";
	
	public static final String CREATE_TABLE_PERSON_QUERY = 
	"CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, "
	+ "name VARCHAR(255), age INT)";
	
	public static final String CREATE_TABLE_BOOK_QUERY = 
	"CREATE TABLE book(id INT PRIMARY KEY AUTO_INCREMENT, "
	+ "title VARCHAR(255), person_id INT)";
	
	public static final String ADD_CONSTRAINT_QUERY = 
	"ALTER TABLE book ADD CONSTRAINT book_person "
	+ "FOREIGN KEY (person_id) REFERENCES person(id)";
	
	public static final String INSERT_PERSON_QUERY = 
	"INSERT INTO person(age, name) values (?, ?)";
	
	public static final String INSERT_BOOK_QUERY = 
	"INSERT INTO book(title, person_id) values (?, ?)";
	
	public static final String SELECT_FROM_PERSON_BOOK = 
	"SELECT p.name, p.age, b.title FROM person p JOIN book b "
	+ "ON p.id=b.person_id";
	
	public static void main(String[] args) {
		try(Connection connection = 
				DriverManager.getConnection(
						CONNECTION_URL, USER, PASSWORD)){
			System.out.println("Done");
//			Statement statement = connection.createStatement();
//			statement.execute(CREATE_TABLE_PERSON_QUERY);
//			statement.close();
			
//			Statement statement = connection.createStatement();
//			statement.execute(CREATE_TABLE_BOOK_QUERY);
//			statement.close();
			
//			Statement statement = connection.createStatement();
//			statement.execute(ADD_CONSTRAINT_QUERY);
//			statement.close();
			
//			PreparedStatement statement =
//					connection.prepareStatement(INSERT_PERSON_QUERY);
//			statement.setInt(1, 18);
//			statement.setString(2, "Mykola");
//			statement.executeUpdate();
//			statement.close();
			
//			PreparedStatement statement1 =
//					connection.prepareStatement(INSERT_BOOK_QUERY);
//			statement1.setInt(2, 1);
//			statement1.setString(1, "Chytanka");
//			statement1.executeUpdate();
//			statement1.close();
			
			PreparedStatement statement = 
					connection.prepareStatement(SELECT_FROM_PERSON_BOOK);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name")+" "+
						rs.getInt("age")+" "+rs.getString("title"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}