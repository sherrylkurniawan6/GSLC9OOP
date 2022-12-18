package GSLC9;

public class VVIP extends Customer {
	

	private int noHP;
	
	public VVIP(String nama, String ID, String status, String product, int price, String alamat, int noHP) {
		super(nama, ID, status, product, price, alamat);
		this.noHP = noHP;
	}
	
	public int getNoHP() {
		return noHP;
	}

	public void setNoHP(int noHP) {
		this.noHP = noHP;
	}
	
	public int ongkir() {
		// hanya bayar ongkir utama saja 
		int ongkir = 9000;
		return ongkir;
	}

	@Override
	public int totalPrice() {
		// mendapatkan diskon sebesar 20%
		int totalPrice = (int) (this.getPrice()*0.8 + ongkir());
		return totalPrice;
	}
	
	public void message() {
		System.out.println("Thankyou for your purchase");
		System.out.println("Your order will arrived 24 hours");
	}



	

}
