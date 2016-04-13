package edu.hm.cs.ob;
public class Point {

	private int x;
	private int y;
	private int z;
	
	Point() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	Point(final int x, final int y, final int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	void moveX(int x) {
		this.x = x;
	}
	
	void moveY(int y) {
		this.y = y;
	}
	
	void moveZ(int z) {
		this.z = z;
	}
	
	
	void moveXY(final int x, final int y) {
		moveX(x);
		moveY(y);
	}
	
	void moveXZ(final int x, final int z) {
		moveX(x);
		moveY(z);
	}
	
	void moveYZ(final int y, final int z) {
		moveX(y);
		moveY(z);
	}
	
	void moveXYZ(final int x, final int y, final int z) {
		moveXY(x, y);
		moveYZ(y, z);
	}
	
	void scale(final int s) {
		this.x = this.x * s;
		this.y = this.y * s;
		this.z = this.z * s;
	}
	
	public String toString() {
		return "\"(" + x + "," + y + "," + z +")\"";
	}
}
