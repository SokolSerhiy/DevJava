package lesson4;

public class Main {
	// (int i = 65; i < 91; i++)
	// (int i = 97; i < 123; i++)
	// (int i = 48; i < 58; i++)
	public static void main(String[] args) {
		char[] array = new char[12];
		int digit = 1;
		int upperLetter = 1;
		for (int i = 0; i < array.length; i++) {
			int way = (int) Math.round(Math.random() * (2 - 0));
			double rand = Math.random();
			if(way==0&&upperLetter<=2){
				array[i] = (char) Math.round(rand * (90 - 65) + 65);
				upperLetter++;
			}else if(way==1&&digit<=3){
				array[i] = (char) Math.round(rand * (57 - 48) + 48);
				digit++;
			}else if(way==2&&i-digit-upperLetter<5){
				array[i] = (char) Math.round(rand * (122 - 97) + 97);
			}else{
				i--;
			}
		}
		System.out.println(array);
	}
}