package less21.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {
	
	static {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS Person(id varchar(50) primary key, name varchar(255), age int)");
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String id = UUID.randomUUID().toString();

	private int age;
	
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void save(){
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Person(id, name, age) values (?, ?, ?)");
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setInt(3, age);
			statement.execute();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("UPDATE Person SET name=?, age=? WHERE id=?");
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, id);
			statement.execute();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(){
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
			statement.setString(1, id);
			statement.execute();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Person findOne(String id){
		Person person = null;
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				person = new Person(rs.getInt("age"), rs.getString("name"));
				person.setId(rs.getString("id"));
			}
			rs.close();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public static List<Person> findAll(){
		List<Person> persons = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Person person = new Person(rs.getInt("age"), rs.getString("name"));
				person.setId(rs.getString("id"));
				persons.add(person);
			}
			rs.close();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}