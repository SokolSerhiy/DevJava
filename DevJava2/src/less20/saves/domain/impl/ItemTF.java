package less20.saves.domain.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import less20.saves.domain.Item;

public class ItemTF implements Item{

	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private BigDecimal price;
	
	private LocalDate date = LocalDate.now();
	
	public ItemTF(String id, String name, BigDecimal price, LocalDate date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public ItemTF(String name, BigDecimal price) {
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
		File currentFile = new File(parentDir, "save.txt");
		try(FileWriter writer = new FileWriter(currentFile, true)){
			writer.append(id+" "+name+" "+price+" "+date+"\n");
			writer.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
