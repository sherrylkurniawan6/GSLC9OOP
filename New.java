package GSLC9;

public class New extends Customer{
	
	private int antrian;

	public New(String nama, String ID, String status, String product, int price, String alamat, int antrian) {
		super(nama, ID, status, product, price, alamat);
		this.antrian = antrian;
	}

	public int getAntrian() {
		return antrian;
	}

	public void setAntrian(int antrian) {
		this.antrian = antrian;
	}

	public int ongkir() {
		int ongkir = 0;
		return ongkir;
	}
	
	@Override
	public int totalPrice() {
		// mendapatkan diskon sebesar 5%
		int totalPrice = (int) (this.getPrice()*0.05 + ongkir());
		return totalPrice;
	}
	
	public void message() {
		System.out.println("There is no delivery service for New Member");
		System.out.println("Please visit us in Taro Street");
	}

}
