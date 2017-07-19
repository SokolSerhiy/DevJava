package less23;

import java.sql.*;

public class Main {
	
	public static final String CONNECTION_URL = 
	"jdbc:mysql://localhost:3306/devjava4?useSSL=false";
	
	public static final String USER = "root";
	
	public static final String PASSWORD = "1987";
	
	public static final String CREATE_TABLE_PERSON_QUERY = 
	"CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, "
	+ "age INT, name VARCHAR(255))";
	
	public static final String CREATE_TABLE_BOOK_QUERY = 
	"CREATE TABLE book(id INT PRIMARY KEY AUTO_INCREMENT, "
	+ "title VARCHAR(255), person_id INT)";
	
	public static final String ADD_CONSTRAINT_PERSON_BOOK = 
	"ALTER TABLE book ADD CONSTRAINT book_person FOREIGN KEY "
	+ "(person_id) REFERENCES person(id)";
	
	public static final String INSERT_PERSON = 
	"INSERT INTO person(age, name) VALUES (?, ?)";
	
	public static final String INSERT_BOOK = 
	"INSERT INTO book(person_id, title) VALUES (?, ?)";
	
	public static final String SELECT_PERSON_BOOK = 
	"SELECT p.name, p.age, b.title FROM person p JOIN book b "
	+ "ON b.person_id=p.id";

	public static void main(String[] args) {
		try(Connection connection = 
				DriverManager.getConnection(
						CONNECTION_URL, USER, PASSWORD)){
//			Statement statement = connection.createStatement();
//			statement.execute(CREATE_TABLE_PERSON_QUERY);
//			statement.close();
			
//			Statement statement = connection.createStatement();
//			statement.execute(CREATE_TABLE_BOOK_QUERY);
//			statement.close();
			
//			Statement statement = connection.createStatement();
//			statement.execute(ADD_CONSTRAINT_PERSON_BOOK);
//			statement.close();
			
//			PreparedStatement statement = 
//					connection.prepareStatement(INSERT_PERSON);
//			statement.setInt(1, 18);
//			statement.setString(2, "Ivan");
//			statement.executeUpdate();
//			statement.setInt(1, 25);
//			statement.setString(2, "Mykola");
//			statement.executeUpdate();
//			statement.close();
			
//			PreparedStatement statement = 
//					connection.prepareStatement(INSERT_BOOK);
//			statement.setInt(1, 1);
//			statement.setString(2, "Bukvar");
//			statement.executeUpdate();
//			statement.setInt(1, 1);
//			statement.setString(2, "Chytanka");
//			statement.executeUpdate();
//			statement.close();
			
			PreparedStatement statement = 
					connection.prepareStatement(SELECT_PERSON_BOOK);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name")+" "
					+rs.getInt("age")+" "+rs.getString("title"));
			}
			rs.close();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}