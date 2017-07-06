package ua.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.dao.RentTypeDao;
import ua.service.RentTypeService;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		Scanner sc = new Scanner(System.in);
		RentTypeService service = new RentTypeService(new RentTypeDao(factory), sc);
		EntityManager em = factory.createEntityManager();
		boolean isRun = true;
		try {
			System.out.println(em.createQuery("SELECT new ua.domain.ApartmentIndex(a.id, a.photoUrl, a.version, a.price, rt.name, area.name, a.rate, a.rooms) FROM Apartment a JOIN a.rentType rt JOIN a.area area WHERE a.id = 1").getSingleResult());
			em.close();
			while (isRun) {
				System.out.println("Enter 1 to add rent type");
				System.out.println("Enter 2 to update rent type");
				System.out.println("Enter 3 to delete rent type");
				System.out.println("Enter 4 to find one by id");
				System.out.println("Enter 5 to find all");
				System.out.println("Enter 6 to find by apartment price");
				System.out.println("Enter 7 to find apartment by rent type id");
				System.out.println("Enter 8 to show criteria test");
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
				case "6":
					service.findByApartmentPrice();
					break;
				case "7":
					service.findAll();
					service.findApartmentByRentTypeId();
					break;
				case "8":
					service.criteria();
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