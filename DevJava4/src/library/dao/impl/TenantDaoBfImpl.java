package library.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import library.dao.TenantDao;
import library.model.Tenant;

public class TenantDaoBfImpl implements TenantDao {

	private final File folder = new File("tenant");
	private final String extention = ".bf";

	{
		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	@Override
	public void save(Tenant tenant) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, tenant.getId()
						+ extention)))) {
			oos.writeObject(tenant);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tenant tenant) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, tenant.getId()
						+ extention)))) {
			oos.writeObject(tenant);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Tenant tenant) {
		File file = new File(folder, tenant.getId() + extention);
		file.delete();
	}

	@Override
	public Tenant findOne(String id) {
		File file = new File(folder, id + extention);
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file))){
			return (Tenant) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tenant> findAll() {
		List<Tenant> tenants = new ArrayList<>();
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				tenants.add((Tenant)ois.readObject());
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return tenants;
	}
}