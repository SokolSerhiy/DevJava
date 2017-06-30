package less17;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException {
//		Person person = new Person("Ivan", 18);
//		OutputStream os = null;
//		ObjectOutputStream oos = null;
//		try{
//			os = new FileOutputStream(new File("save.save"));
//			oos = new ObjectOutputStream(os);
//			oos.writeObject(person);
//		}catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(oos!=null){
//				try {
//					oos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if(os!=null){
//				try {
//					os.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		try(ObjectInputStream ois = 
//				new ObjectInputStream(
//						new FileInputStream(
//								new File("save.save")))){
//			Person person = (Person) ois.readObject();
//			System.out.println(person);
//		}catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Person person = new Person("Petro", 27);
//		try(FileWriter writer = new FileWriter("save.txt", true)){
//			writer.append(person.getName()+" "+person.getAge()+"\n");
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		try(Scanner sc = new Scanner(new File("save.txt"))){
//			while(sc.hasNextLine()){
//				String line = sc.nextLine();
//				if(!line.isEmpty()){
//					String[] array = line.split(" ");
//					Person person = new Person(array[0], Integer.valueOf(array[1]));
//					System.out.println(person);
//				}
//			}
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		BufferedImage image = ImageIO.read(new File("test.jpg"));
//		int offset = (image.getWidth()-image.getHeight())/2;
//		BufferedImage crop = new BufferedImage(image.getHeight(), image.getHeight(), image.getType());
//		for(int y = 0; y < crop.getHeight(); y++){
//			for(int x = 0; x< crop.getWidth(); x++){
//				crop.setRGB(x, y, image.getRGB(x+offset, y));
//			}
//		}
//		ImageIO.write(crop, "jpg", new File("crop.jpg"));
	}
}