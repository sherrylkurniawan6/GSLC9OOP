package GSLC9;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
  Mau ngeprint, kalau new member 
  Clothing Line 
   - Class 
      1. Customer (nama, customer ID, status, product, price)
      2. VVIP Member (alamat, email) (gratis ongkir) (price*0.2)
      3. VIP Member (alamat, email) (ongkir bayar) (price*0.1)
      4. new Member (antrian) (price*0.05)
      5. Delivery 
   - feature
      1. add member 
      2. show member 
      3. buy 
   - validation:
      1. email -> endswith : @gmai.com
      2. nama -> tidak boleh kosong
      3. status -> equal ("VVIP", "VIP", "New")
      4. alamat -> tidak boleh kosong 
      5. antrian -> random (1-10)
 */

public class Main {
	
	Scanner input = new Scanner(System.in);
	ArrayList<Customer> list = new ArrayList<>();
	Random rand = new Random();

	public Main() {
		
		int num;
		
		do {
			menu();
			num = input.nextInt();
			input.nextLine();
			
			if (num == 1) {
				// add
				add();
			} else if (num == 2) {
				// show
				show();
			} else if (num == 3) {
				// buy
				buy();
			}
		} while (num != 4);
		
		
	}
	
	public void menu() {
		// menampilkan display
		System.out.println("----ROSELINE STORE----");
		System.out.println("1. Add Member");
		System.out.println("2. Show Member");
		System.out.println("3. Buy Clothes");
		System.out.println("4. Exit");
		System.out.print("Enter Number [1-4]: ");
	}
	
	public String genID() {
		// "RS987" 
		String ID = "RS";
		int temp = 0; 
		
		for(int i = 0; i < 3; i++) {
			temp = (int) (Math.random()*(9-1) + 1);
			ID += temp;
		}
		return ID;
	}
	
	public void add() {
		String nama;
		String ID;
		String status;
		String product;
		int price;
		String alamat;
		String email;
		int noHP;
		int antrian = 0; 
		
		// validasi nama (tidak kosong)
		do {
			System.out.print("Nama: ");
			nama = input.nextLine();
		} while (nama.equals(" "));
		
		// Deklarasi ID
		ID = genID();
		
		// validasi Status (equals to VVIP , VIP, or New)
		do {
			System.out.print("Member Status [VVIP | VIP | New]: ");
			status = input.nextLine();
			
		}while (status.equals("VVIP") == false && status.equals("VIP") == false && status.equals("New") == false);
		
		do {
			System.out.print("Quality Product [Satin|Suede|Velvet]: ");
			product = input.nextLine();
		} while (product.equals("Satin") == false && product.equals("Suede") == false && product.equals("Velvet") == false);
		
		do {
			System.out.print("Input Price [50000-600000]: ");
			price = input.nextInt();
			input.nextLine();
		}while (price < 50000 || price > 600000);
		
		do {
			System.out.print("Input City: ");
			alamat = input.nextLine();
		} while (alamat.equals(" "));
		
		
		if (status.equals("VVIP")) {
			
			do {
				System.out.print("Phone number: ");
				noHP = input.nextInt();
				input.nextLine();
			} while (noHP == 0);
			
			list.add(new VVIP (nama, ID, status, product, price,alamat, noHP));
			
		} else if (status.equals("VIP")) {
			
			do {
				System.out.print("Input Email [@gmail.com]: ");
				email = input.nextLine();
			} while (!(email.endsWith("@gmail.com")));
			
			list.add(new VIP (nama, ID, status, product, price, alamat, email));
			
		} else if (status.equals("New")) {
			int temp = (int)((Math.random()*(3-1)) + 1);
			antrian = temp;
			
			list.add(new New (nama, ID, status, product, price, alamat ,antrian));
			
		}
		System.out.println("Please Enter to Continue...");
		input.nextLine();
	}
	
	public void show() {
		if (list.isEmpty()) {
			System.out.println("NO DATA!");
		} else {
			int i = 0;
			System.out.printf("| %-4s | %-10s | %-8s | %-8s | %-15s | %-18s | %-8s | %-5s |\n", "No", "Nama", "status", "product", "alamat", "email", "No HP", "Antrian");
			for (Customer t : list) {
				i++;
				if (t instanceof VVIP) {
					System.out.printf("| %-4s | %-10s | %-8s | %-8s | %-15s | %-18s | %-8s | %-5s |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), " - ", ((VVIP)t).getNoHP(), " - ");
				} else if (t instanceof VIP) {
					System.out.printf("| %-4s | %-10s | %-8s | %-8s | %-15s | %-18s | %-8s | %-5s |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), ((VIP)t).getEmail(), " - ", " - ");
				} else if (t instanceof New) {
					System.out.printf("| %-4s | %-10s | %-8s | %-8s | %-15s | %-18s | %-8s | %-5s |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), " - ", " - ", ((New)t).getAntrian() );
				}
			}
		}
		System.out.println("Please Enter to Continue...");
		input.nextLine();
	}
	
	public void buy(){
		int idx;
		String ID;
		
		if (list.isEmpty()) {
			System.out.println("NO DATA!");
		} else {
			int i = 0;
			System.out.printf("| %-4s | %-10s | %-8s | %-8s | %-15s | %-18s | %-8s | %-5s |\n", "No", "Nama", "status", "product", "alamat", "email", "No HP", "Antrian");
			for (Customer t : list) {
				i++;
				if (t instanceof VVIP) {
					System.out.printf("| %-4d | %-10s | %-8s | %-8s | %-15s | %-18s | %-8d | %-5d |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), " - ", ((VVIP)t).getNoHP(), " - ");
				} else if (t instanceof VIP) {
					System.out.printf("| %-4d | %-10s | %-8s | %-8s | %-15s | %-18s | %-8d | %-5d |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), ((VIP)t).getEmail(), " - ", " - ");
				} else if (t instanceof New) {
					System.out.printf("| %-4d | %-10s | %-8s | %-8s | %-15s | %-18s | %-8d | %-5d |\n", i, t.getNama(), t.getStatus(), t.getProduct(), t.getAlamat(), " - ", " - ", ((New)t).getAntrian() );
				}
			}
		}
		
		do {
			System.out.printf("Choose Customer[1-%d]: ", list.size());
			idx = input.nextInt();
			input.nextLine();
			
		} while (idx < 0 || idx > list.size());
		
		ID = genID();
		
		System.out.println("Transaction ID: " + ID);
		System.out.println("Product: " + list.get(idx-1).getProduct());
		System.out.println("Price: " + list.get(idx-1).getPrice());
		System.out.println("Delivery Fee: " + list.get(idx-1).ongkir());
		System.out.println("Total Price: " + list.get(idx-1).totalPrice());
		list.get(idx-1).message();
		
		System.out.println("Please Enter to Continue...");
		input.nextLine();
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
