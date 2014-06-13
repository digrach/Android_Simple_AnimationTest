// Rachael Colley 2014

package rach.dig.android_animationtest;

public class Particle {

	private double posY;
	private double posX;
	private double targetX;
	private double targetY;
	private double  size;
	private float[] color;
	private double randomEase;

	private double travelRate;
	private int maxCollisionSize;


	public Particle(double posx, double posy, double targetx, double targety) {
		this.posY = posy;
		this.posX = posx;
		this.targetX = targetx;
		this.targetY = targety;
		size = 10;
		color = makeColor();
		randomEase = Math.random() * 0.03;
		travelRate = 0.03;
		maxCollisionSize = (int) (size * 2);
	}

	public void update() {
		posX += calculateXDistance(targetX) * (travelRate);
		posY += calculateYDistance(targetY) * (travelRate + randomEase);
	}

	private double  calculateYDistance(double yTarget) {
		return yTarget - posY;
	}

	private double  calculateXDistance(double xTarget) {
		return xTarget - posX;
	}

	private float[] makeColor() {
		float[] color = new float[3];
		color[0]=(float)(Math.random()*360);  
		color[1]=1;  
		color[2]=1; 
		return color;
	}

	// Get / Set

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getTargetX() {
		return targetX;
	}

	public void setTargetX(double targetX) {
		this.targetX = targetX;
	}

	public double getTargetY() {
		return targetY;
	}

	public void setTargetY(double targetY) {
		this.targetY = targetY;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public float[] getColor() {
		return color;
	}

	public void setColor(float[] color) {
		this.color = color;
	}

	public double getRandomEase() {
		return randomEase;
	}

	public void setRandomEase(double randomEase) {
		this.randomEase = randomEase;
	}

	public double getTravelRate() {
		return travelRate;
	}

	public void setTravelRate(double travelRate) {
		this.travelRate = travelRate;
	}

	public int getMaxCollisionSize() {
		return maxCollisionSize;
	}

	public void setMaxCollisionSize(int maxCollisionSize) {
		this.maxCollisionSize = maxCollisionSize;
	}



}
