package core.less13;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import core.less10.Gender;
import core.less10.Person;

public class Main {

	private static final Scanner sc = new Scanner(System.in);
	private static final Controller controller = new Controller();

	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to save");
			System.out.println("Enter 4 to save to text file");
			System.out.println("Enter 5 to read from text file");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				System.out.println("Enter gender");
				Gender gender = Gender.valueOf(sc.next().toUpperCase());
				Person person = new Person(name, age, gender);
				controller.add(person);
				break;
			case "2":
				controller.getPersons().forEach(System.out::println);
				break;
			case "3":
				controller.save();
				break;
			case "4":
				System.out.println("Enter file name");
				String fileName = sc.next();
				controller.saveToTextFile(fileName);
				break;
			case "5":
				System.out.println("Enter file name");
				String fileName1 = sc.next();
				controller.read(fileName1).forEach(System.out::println);
				break;
			default:
				sc.close();
				return;
			}
		}
	}
	
	static void read() throws IOException{
		BufferedImage bi = ImageIO.read(new File(""));
		
		ImageIO.write(bi, "jpg", new File(""));
	}
}