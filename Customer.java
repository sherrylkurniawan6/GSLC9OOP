package GSLC9;

public abstract class Customer implements Ongkir{
	
	private String nama;
	private String ID;
	private String status;
	private String product;
	private int price;
	private String alamat;
	
	public Customer(String nama, String ID, String status, String product, int price, String alamat) {
		this.nama = nama;
		this.ID = ID;
		this.status = status;
		this.product = product;
		this.price = price;
		this.alamat = alamat;
	}
	
	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract int totalPrice();

	

}
