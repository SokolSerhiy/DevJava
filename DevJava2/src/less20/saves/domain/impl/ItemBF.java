package less20.saves.domain.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import less20.saves.domain.Item;

public class ItemBF implements Item, Serializable{

	private static final long serialVersionUID = -2862761801397471385L;

	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private BigDecimal price;
	
	private LocalDate date = LocalDate.now();
	
	public ItemBF(String name, BigDecimal price) {
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
		File parentDir = new File("saves");
		if(!parentDir.exists()) parentDir.mkdir();
		File currentDir = new File(parentDir, "bf");
		if(!currentDir.exists()) currentDir.mkdir();
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(currentDir, id+".save")))){
			oos.writeObject(this);
			oos.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
