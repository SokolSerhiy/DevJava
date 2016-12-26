package library.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import library.dao.RentDao;
import library.model.Rent;
import library.model.Tenancy;
import library.model.Tenant;

public class RentDaoBfImpl implements RentDao{

	private final File folder = new File("rent");
	private final String extention = ".bf";

	{
		if (!folder.exists()) {
			folder.mkdir();
		}
	}
	
	@Override
	public void save(Rent rent) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, UUID.randomUUID().toString()
						+ extention)))) {
			oos.writeObject(rent);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnRent(Tenant tenant, Tenancy tenancy) {
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				Rent rent = (Rent) ois.readObject();
				if(rent.getTenancy().getId().equals(tenancy.getId())
						&& rent.getTenant().getId().equals(tenant.getId())
						&& rent.getEnd()==null){
					rent.setEnd(LocalDate.now());
					try(ObjectOutputStream oos = new ObjectOutputStream(
							new FileOutputStream(file))){
						oos.writeObject(rent);
						oos.flush();
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Rent> findAll() {
		List<Rent> rents = new ArrayList<>();
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				rents.add((Rent)ois.readObject());
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return rents;
	}

	@Override
	public List<Rent> findAll(Tenant tenant) {
		List<Rent> rents = new ArrayList<>();
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				Rent rent = (Rent)ois.readObject();
				if(rent.getTenant().getId().equals(tenant.getId())){
					rents.add(rent);
				}
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return rents;
	}

	@Override
	public List<Rent> findAll(Tenancy tenancy) {
		List<Rent> rents = new ArrayList<>();
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			try(ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))){
				Rent rent = (Rent)ois.readObject();
				if(rent.getTenancy().getId().equals(tenancy.getId())){
					rents.add(rent);
				}
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return rents;
	}

}
