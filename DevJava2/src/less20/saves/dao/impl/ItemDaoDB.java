package less20.saves.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import less20.saves.dao.ItemDao;
import less20.saves.domain.Item;
import less20.saves.domain.impl.ItemDB;

public class ItemDaoDB implements ItemDao{
	
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

	@Override
	public Item findOne(String id) {
		try(Connection connection = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Item WHERE id=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				return new ItemDB(rs.getString(1), rs.getString(2), rs.getBigDecimal(3), rs.getDate(4).toLocalDate());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> findAll() {
		List<Item> items = new ArrayList<>();
		try(Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "1987")){
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Item");
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					items.add(new ItemDB(rs.getString(1), rs.getString(2), rs.getBigDecimal(3), rs.getDate(4).toLocalDate()));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return items;
	}
}
