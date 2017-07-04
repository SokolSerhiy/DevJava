package ua.controller;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.dao.RentTypeDao;
import ua.service.RentTypeService;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		Scanner sc = new Scanner(System.in);
		RentTypeService service = new RentTypeService(new RentTypeDao(factory), sc);
		boolean isRunGlobaly = true;
		try{
			while (isRunGlobaly) {
				System.out.println("Enter 1 to manage rent type");
				switch (sc.next()) {
				case "1":
					rentTypeMenu(service, sc);
					break;
				default:
					isRunGlobaly = false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		factory.close();
	}
	
	static void rentTypeMenu(RentTypeService service, Scanner sc){
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add rent type");
			System.out.println("Enter 2 to update rent type");
			System.out.println("Enter 3 to delete rent type by id");
			System.out.println("Enter 4 to show one by id");
			System.out.println("Enter 5 to show all");
			switch (sc.next()) {
			case "1":
				service.save();
				break;
			case "2":
				service.findAll();
				service.update();
				break;
			case "3":
				service.findAll();
				service.delete();
				break;
			case "4":
				service.findOne();
				break;
			case "5":
				service.findAll();
				break;
			default:
				isRun = false;
			}
		}
	}
}