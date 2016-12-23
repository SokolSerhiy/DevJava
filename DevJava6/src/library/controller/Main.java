package library.controller;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import library.dao.RentDao;
import library.dao.TenancyDao;
import library.dao.TenantDao;
import library.model.Book;
import library.model.Rent;
import library.model.Tenancy;
import library.model.Tenant;
import library.model.User;

public class Main {

	private static TenancyDao tenancyDao;

	private static TenantDao tenantDao;

	private static RentDao rentDao;

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("1 User");
			System.out.println("2 Book");
			System.out.println("3 Rent");
			System.out.println("4 Switch save type");
			System.out.println("0 Exit");
			switch (sc.next()) {
			case "1":
				userMenu();
				break;
			case "2":
				bookMenu();
				break;
			case "3":
				rentMenu();
				break;
			default:
				sc.close();
				return;
			}
		}
	}

	private static void rentMenu() {
		while (true) {
			System.out.println("Enter 1 to add rent");
			System.out.println("Enter 2 to return rent");
			System.out.println("Enter 3 to show all rents");
			System.out.println("Enter 4 to show rents by user");
			System.out.println("Enter 5 to show rents by book");
			System.out.println("Enter 0 to exit from rent menu");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter user id");
				tenantDao.findAll().forEach(System.out::println);
				String userId = sc.next();
				System.out.println("Enter book id");
				tenancyDao.findAll().forEach(System.out::println);
				String bookId = sc.next();
				Rent rent = new Rent();
				rent.setStart(LocalDate.now());
				rent.setTenant(tenantDao.findOne(userId));
				rent.setTenancy(tenancyDao.findOne(bookId));
				rentDao.save(rent);
				break;
			case "2":
				System.out.println("Enter user id");
				tenantDao.findAll().forEach(System.out::println);
				userId = sc.next();
				System.out.println("Enter book id");
				tenancyDao.findAll().forEach(System.out::println);
				bookId = sc.next();
				Tenant tenant = tenantDao.findOne(userId);
				Tenancy tenancy = tenancyDao.findOne(bookId);
				rentDao.returnRent(tenant, tenancy);
				break;
			case "3":
				rentDao.findAll().forEach(System.out::println);
				break;
			case "4":
				System.out.println("Enter user id");
				tenantDao.findAll().forEach(System.out::println);
				userId = sc.next();
				tenant = tenantDao.findOne(userId);
				rentDao.findAll(tenant).forEach(System.out::println);
				break;
			case "5":
				System.out.println("Enter book id");
				tenancyDao.findAll().forEach(System.out::println);
				bookId = sc.next();
				tenancy = tenancyDao.findOne(bookId);
				rentDao.findAll(tenancy).forEach(System.out::println);
				break;
			default:
				return;
			}
		}
	}

	private static void bookMenu() {
		while (true) {
			System.out.println("Enter 1 to add book");
			System.out.println("Enter 2 to update book");
			System.out.println("Enter 3 to delete book");
			System.out.println("Enter 4 to find book by id");
			System.out.println("Enter 5 to show all books");
			System.out.println("Enter 0 to exit from book menu");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter title");
				String title = sc.next();
				String id = UUID.randomUUID().toString();
				Book book = new Book();
				book.setId(id);
				book.setTitle(title);
				tenancyDao.save(book);
				break;
			case "2":
				System.out.println("Enter title");
				title = sc.next();
				System.out.println("Enter id");
				id = sc.next();
				book = new Book();
				book.setId(id);
				book.setTitle(title);
				tenancyDao.update(book);
				break;
			case "3":
				System.out.println("Enter id");
				id = sc.next();
				tenancyDao.delete(tenancyDao.findOne(id));
				break;
			case "4":
				System.out.println("Enter id");
				id = sc.next();
				System.out.println(tenancyDao.findOne(id));
				break;
			case "5":
				tenancyDao.findAll().forEach(System.out::println);
				break;
			default:
				return;
			}
		}
	}

	private static void userMenu() {
		while (true) {
			System.out.println("Enter 1 to add user");
			System.out.println("Enter 2 to update user");
			System.out.println("Enter 3 to delete user");
			System.out.println("Enter 4 to find user by id");
			System.out.println("Enter 5 to show all users");
			System.out.println("Enter 0 to exit from user menu");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				User user = new User();
				user.setAge(age);
				user.setName(name);
				String id = UUID.randomUUID().toString();
				user.setId(id);
				tenantDao.save(user);
				break;
			case "2":
				System.out.println("Enter name");
				name = sc.next();
				System.out.println("Enter age");
				age = sc.nextInt();
				System.out.println("Enter id");
				id = sc.next();
				user = new User();
				user.setAge(age);
				user.setName(name);
				user.setId(id);
				tenantDao.update(user);
				break;
			case "3":
				System.out.println("Enter id");
				id = sc.next();
				tenantDao.delete(tenantDao.findOne(id));
				break;
			case "4":
				System.out.println("Enter id");
				id = sc.next();
				System.out.println(tenantDao.findOne(id));
				break;
			case "5":
				tenantDao.findAll().forEach(System.out::println);
				break;
			default:
				return;
			}
		}
	}
}