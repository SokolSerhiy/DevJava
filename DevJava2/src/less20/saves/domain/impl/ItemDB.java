package less20.saves.domain.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.UUID;

import less20.saves.domain.Item;

public class ItemDB implements Item{
	
	static{
		try(Connection connection = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS Item(id varchar(50) primary key, name varchar(255), price decimal(19,2), _date date)");
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private BigDecimal price;
	
	private LocalDate date = LocalDate.now();
	
	public ItemDB(String id, String name, BigDecimal price, LocalDate date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public ItemDB(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void save() {
		try(Connection connection = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Item(id, name, price, _date) values (?, ?, ?, ?)");
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setBigDecimal(3, price);
			statement.setDate(4, new Date(System.currentTimeMillis()));
			statement.execute();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
