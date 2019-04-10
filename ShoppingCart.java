import java.util.Scanner;

public class ShoppingCart{

	public ShoppingCart(){

		try{
			Wallet wallet = new Wallet();
			Pocket pocket = new Pocket();		
			Scanner scanner = new Scanner(System.in);
			Store store = new Store();
			
			System.out.println(wallet.getBalance());	
		
			System.out.println(store.asString());
			System.out.println("What do you want to purchase? ");

			
			String product = scanner.next();
			Integer cost = Store.getProductPrice(product);


			try{
				//if(wallet.getBalance() - cost > -1 ){                //Sleep anywhere in this if section to achive over withdrawl and end up with a negative balance. 
				//	Integer mybalance = wallet.getBalance();
				//	Thread.sleep(3000);								// If two transactions are taking place during this sleep, only the price of the second one will be charged, but both products will end up in the pocket. 
					wallet.safeWithdraw(cost);
					pocket.addProduct(product);
					System.out.println("Your new balance is: " + Integer.toString(wallet.getBalance()));
				//}
			}catch(Exception e){
				System.out.println("Exception");
			}
		}catch(Exception e){
			System.out.println("Exception");
		}

	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
	}
}