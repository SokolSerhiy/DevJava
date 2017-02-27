package ua;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static int field = 0;
	static int tree = 1;
	static int star = 2;
	static int[][] array = new int[10][16];
	static Coordinate coordinate;
	
	public static void main(String[] args) {
		Coordinate[] all = new Coordinate[160];
		int[][] matr = new int[160][160];
		int frogX = 2;
		int frogY = 2;
		int starX = 9;
		int starY = 9;
		coordinate = new Coordinate(frogX, frogY, true, false, false);
		coordinate.count = 0;
		List<Coordinate> trees = new ArrayList<>();
		trees.add(new Coordinate(8, 10, false, false, true));
		array[starX][starY] = star;
		array[3][3] = tree;
		array[3][4] = tree;
		array[3][5] = tree;
		array[4][3] = tree;
		array[4][4] = tree;
		array[4][5] = tree;
		array[5][3] = tree;
		array[5][4] = tree;
		array[5][5] = tree;
		array[6][3] = tree;
		array[6][4] = tree;
		array[6][5] = tree;
		array[8][8] = tree;
		array[8][7] = tree;
		array[8][5] = tree;
		System.out.println(find(frogX, frogY, 0));
		int index = 0;
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j < 16; j++){
				if(i==frogX&&j==frogY){
					all[index] = new Coordinate(i, j, true, false, false);
					all[index].dist = 0;
				}else if(i==starX&&j==starY){
					all[index] = new Coordinate(i, j, false, true, false);
				} else {
					all[index] = new Coordinate(i, j, false, false, false);
				}
				for(Coordinate coor : trees){
					if(coor.x == all[index].x&&coor.y == all[index].y){
						all[index] = coor;
					}
				}
				index++;
			}
		}
		for(int i = 0; i < 160; i ++){
			for(int j = 0; j < 160; j++){
				if(all[i].y+3==all[j].y&&all[i].x==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+2==all[j].y&&all[i].x+1==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+1==all[j].y&&all[i].x+2==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+2==all[j].y&&all[i].x-1==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+1==all[j].y&&all[i].x-2==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+3>=16&&all[i].y+3-16==all[j].y&&all[i].x==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+2>=16&&all[i].y+2-16==all[j].y&&all[i].x+1==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+1>=16&&all[i].y+1-16==all[j].y&&all[i].x+2==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+2>=16&&all[i].y+2-16==all[j].y&&all[i].x-1==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].y+1>=16&&all[i].y+1-16==all[j].y&&all[i].x-2==all[i].x){
					matr[i][j] = 1;
				}
				if(all[i].isTree||all[j].isTree){
					matr[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < 160; i ++){
			for(int j = 0; j < 160; j++){
				if(matr[i][j]==0){
					System.out.print("0");
				}else {
					System.out.print("1");
				}
			}
			System.out.println();
		}
		boolean again = true;
		int jumps = Integer.MAX_VALUE;
		while(again){
			int mindist = Integer.MAX_VALUE-1;
			int row = Integer.MAX_VALUE;
			for(int i = 0; i < 160; i++){
				if(!all[i].isFinal&&all[i].dist<mindist){
					mindist=all[i].dist;
					row = i;
				}
				if(row != Integer.MAX_VALUE){
					for(int j = 0; j < 160; j++){
						if((matr[row][j] == 1)&&(1+all[row].dist < all[j].dist)){
							all[j].dist = 1+all[row].dist;
						}
					}
					all[row].isFinal = true;
					if(all[row].isStar){
						again = false;
						jumps = all[row].dist;
					}
				}else{
					again = false;
				}
			}
		}
		if(jumps < Integer.MAX_VALUE){
			System.out.println("jumps = "+jumps);
		}else{
			System.out.println("fail");
		}
	}
	
	static int find(int x, int y, int count){
		if(x<10&&y<16&&x>=0&&y>=0&&array[x][y]!=tree){
			if(array[x][y]==star) return count;
//			if(coordinate.count > count){
//				
//			}else{
//				
//			}
			int a = find(x+2, y+1, count+1);
			int b = find(x-2, y+1, count+1);
			int c = find(x+1, y+2, count+1);
			int d = find(x-1, y+2, count+1);
			int e = find(x, y+3, count+1);
			a = Integer.min(a, b);
			a = Integer.min(a, c);
			a = Integer.min(a, d);
			a = Integer.min(a, e);
			return a;
		}
		return Integer.MAX_VALUE;
	}

}
