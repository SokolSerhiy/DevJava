package ua.service;

import java.util.List;
import java.util.Scanner;

import ua.dao.RentTypeDao;
import ua.entity.RentType;

public class RentTypeService {

	private final RentTypeDao dao;
	
	private final Scanner sc;

	public RentTypeService(RentTypeDao dao, Scanner sc) {
		this.dao = dao;
		this.sc = sc;
	}

	public void add(){
		String name = readName();
		dao.save(new RentType(name));
	}
	
	public void update(){
		int id = readId();
		String name = readName();
		dao.update(new RentType(id, name));
	}
	
	public void delete(){
		int id = readId();
		dao.delete(id);
	}
	
	public void findOne() {
		int id = readId();
		RentType type = dao.findOne(id);
		print(type);
	}
	
	public void findAll() {
		List<RentType> list = dao.findAll();
		for (RentType rentType : list) {
			print(rentType);
		}
	}
	
	private void print(RentType rentType) {
		System.out.println(rentType.getId()+" "+rentType.getName());
	}
	
	private int readId() {
		System.out.println("Enter tent type id");
		return sc.nextInt();
	}
	
	private String readName(){
		System.out.println("Enter rent type name");
		return sc.next();
	}
}
