package cn.matrix.newpojo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userNumber;			//用户编号
	private String userAssetNumber;		//用户财产编号
	private String userAddress;			//用户地址

	private double[] gps=new double[3];	//GPS坐标
	private int[] pixel = new int[3];	//像素坐标


	private String userName;				//用户名


	private Phase userPhase;				//用户相型
	public User() {
		
	}
	public User(String userNumber, String userAssetNumber, String userAddress, String userName,Phase userPhase) {
		super();
		this.userNumber = userNumber;
		this.userAssetNumber = userAssetNumber;
		this.userAddress = userAddress;
		this.userName = userName;
		this.userPhase = userPhase;
	}
	public User(String userNumber, String userAssetNumber, String userAddress, String userName,Phase userPhase,double[] gps,int[] pixel ) {
		super();
		this.userNumber = userNumber;
		this.userAssetNumber = userAssetNumber;
		this.userAddress = userAddress;
		this.userName = userName;
		this.userPhase = userPhase;
		this.gps = gps;
		this.pixel = pixel;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserAssetNumber() {
		return userAssetNumber;
	}
	public void setUserAssetNumber(String userAssetNumber) {
		this.userAssetNumber = userAssetNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Phase getUserPhase() {
		return userPhase;
	}

	public void setUserPhase(Phase userPhase) {
		this.userPhase = userPhase;
	}
	public double[] getGps() {
		return gps;
	}

	public void setGps(double[] gps) {
		this.gps = gps;
	}

	public int[] getPixel() {
		return pixel;
	}

	public void setPixel(int[] pixel) {
		this.pixel = pixel;
	}
}
