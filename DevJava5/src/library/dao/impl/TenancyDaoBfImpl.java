package library.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import library.dao.TenancyDao;
import library.model.Tenancy;

public class TenancyDaoBfImpl implements TenancyDao{

	private final File folder = new File("tenancy");
	private final String extention = ".bf";

	{
		if (!folder.exists()) {
			folder.mkdir();
		}
	}
	
	@Override
	public void save(Tenancy tenancy) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, tenancy.getId()
						+ extention)))) {
			oos.writeObject(tenancy);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tenancy tenancy) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, tenancy.getId()
						+ extention)))) {
			oos.writeObject(tenancy);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Tenancy tenancy) {
		File file = new File(folder, tenancy.getId() + extention);
		file.delete();
	}

	@Override
	public Tenancy findOne(String id) {
		File file = new File(folder, id + extention);
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file))){
			return (Tenancy) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tenancy> findAll() {
		List<Tenancy> tenancies = new ArrayList<>();
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				tenancies.add((Tenancy)ois.readObject());
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return tenancies;
	}
}