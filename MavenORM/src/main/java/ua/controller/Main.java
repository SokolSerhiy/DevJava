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
		boolean isRun = true;
		try {
			while (isRun) {
				System.out.println("Enter 1 to add rent type");
				System.out.println("Enter 2 to update rent type");
				System.out.println("Enter 3 to delete rent type");
				System.out.println("Enter 4 to find one by id");
				System.out.println("Enter 5 to find all");
				switch (sc.next()) {
				case "1":
					service.add();
					break;
				case "2":
					service.update();
					break;
				case "3":
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		factory.close();
	}
}