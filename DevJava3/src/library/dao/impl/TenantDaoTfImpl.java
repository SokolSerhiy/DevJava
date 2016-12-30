package library.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.UUID;

import library.dao.TenantDao;
import library.model.Tenant;
import library.model.User;

import org.junit.Test;

public class TenantDaoTfImpl implements TenantDao{

	private final File folder = new File("tenant");

	{
		if (!folder.exists()) {
			folder.mkdir();
		}
	}
	
	@Override
	public void save(Tenant tenant) {
		Class<?> tenantClass = tenant.getClass();
		String fileName = tenantClass.getSimpleName()+".txt";
		File file = new File(folder, fileName);
		Field[] fields = tenantClass.getDeclaredFields();
		String line = tenantClass.getCanonicalName()+" ";
		for (Field field : fields) {
			if(!Modifier.isStatic(field.getModifiers())){
				line+=field.getName()+"=";
				field.setAccessible(true);
				line+=get(field, tenant)+" ";
			}
		}
		try(PrintWriter pw = new PrintWriter(
			new BufferedWriter(new FileWriter(file, true)))){
			pw.println(line);
			pw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Object get(Field field, Object ref){
		try{
			return field.get(ref);
		}catch(IllegalAccessException|IllegalArgumentException e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void update(Tenant tenant) {
		
	}

	@Override
	public void delete(Tenant tenant) {
		
	}

	@Override
	public Tenant findOne(String id) {
		return null;
	}

	@Override
	public List<Tenant> findAll() {
		return null;
	}
}