package ua;

public class Coordinate {
	
	public final int x;
	
	public final int y;
	
	public final boolean isFrog;
	
	public final boolean isStar;
	
	public final boolean isTree;
	
	public boolean isFinal;
	
	public Coordinate child;
	
	public int count;
	
	public int dist = Integer.MAX_VALUE-1;
	
	public Coordinate(int x, int y, boolean isFrog, boolean isStar,
			boolean isTree) {
		this.x = x;
		this.y = y;
		this.isFrog = isFrog;
		this.isStar = isStar;
		this.isTree = isTree;
	}
}
