package GSLC9;

public class VIP extends Customer{
	
	private String email;
	
	public VIP(String nama, String ID, String status, String product, int price, String alamat, String email) {
		super(nama, ID, status, product, price, alamat);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int totalPrice() {
		// mendapatkan diskon sebesar 10%
		int totalPrice = (int) (this.getPrice()*0.9 + ongkir());
		return totalPrice;
	}
	
	public int ongkir () {
		// ongkos kirim utama + jasa kurir 
		int ongkir = 9000 + 11000;
		return ongkir;
	}
	
	public void message() {
		System.out.println("Thankyou for your purchase");
		System.out.println("Your order will arrived 3 X 24 hours");
	}


	

}
