package less17;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import less11.Gender;
import less11.Person;

public class Main {

	public static void main(String[] args) throws MalformedURLException, IOException {
//		Person person = new Person("Ivanka", 25, Gender.FEMALE);
//		OutputStream os = null;
//		ObjectOutputStream oos = null;
//		try{
//			os = new FileOutputStream(new File("save.save"));
//			oos = new ObjectOutputStream(os);
//			oos.writeObject(person);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
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
//				new FileInputStream(
//				new File("save.save")))){
//			Person person = (Person) ois.readObject();
//			System.out.println(person);
//		}catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		try(FileWriter writer = new FileWriter("save.txt", true)){
//			writer.append(person.getName()+" "+person.getAge()+" "+person.getGender()+"\n");
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		try(Scanner sc = new Scanner(new File("save.txt"))){
//			while (sc.hasNextLine()) {
//				String line = sc.nextLine();
//				if(!line.isEmpty()){
//					String[] array = line.split(" ");
//					Person person = new Person(array[0], Integer.valueOf(array[1]), Gender.valueOf(array[2]));
//					System.out.println(person);
//				}
//			}
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
		BufferedImage bufferedImage = ImageIO.read(new FileInputStream(new File("test.jpg")));
//		for(int i = 0; i < bufferedImage.getHeight(); i++){
//			for(int j = 0; j < bufferedImage.getWidth(); j++){
//				System.out.print(bufferedImage.getRGB(j, i));
//			}
//			System.out.println();
//		}
		int dif = Math.abs(bufferedImage.getHeight()-bufferedImage.getWidth());
		BufferedImage crop = new BufferedImage(bufferedImage.getWidth()-dif, bufferedImage.getHeight(), bufferedImage.getType());
		int offset = dif/2;
		for(int y = 0; y < crop.getHeight(); y++){
			for(int x = 0; x < crop.getWidth(); x++){
				crop.setRGB(x, y, bufferedImage.getRGB(x+offset, y));
			}
		}
		ImageIO.write(crop, "jpg", new File("crop.jpg"));
	}
}