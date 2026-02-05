package WorkPlace;
import java.util.Scanner;

public class Admin extends StudentManagment{
	private static String password;
	
	Admin() {
		Admin.password = "admin";
	}
	
	public void setPassword(String pass) {
		if(Admin.password.equals(pass)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new password: ");
			String newPassword = sc.next();
			
			Admin.password = newPassword;
			System.out.println("Password Changed successfully.");
			return;
		}
		
		System.out.println("Wrong password");
	}
	
	public boolean checkPassword(String pass) {
		return Admin.password.equals(pass);
	}
}
