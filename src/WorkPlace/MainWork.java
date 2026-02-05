package WorkPlace;
import java.util.Scanner;
import java.util.List;

public class MainWork {
	public static void addGroup(Admin admin) {
		admin.addGroup();
	}
	
	public static void deleteGroup(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the group number: ");
		int groupNumber = sc.nextInt();
		
		admin.deleteGroup(groupNumber - 1);
	}
	
	public static void addStudentToGroup(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the name: ");
		String name = sc.nextLine();
		
		System.out.print("\nEnter the Roll Number: ");
		long rollNumber = sc.nextLong();
		
		System.out.println("\nEnter the gender: ");
		String gender = sc.next();
		
		Student s = new Student(name,rollNumber,gender);
		
		System.out.print("Enter the group number in which you have to add student: ");
		int groupNumber = sc.nextInt();
		
		admin.addStudent(s, groupNumber - 1);
	}
	
	public static void changeAdminPassword(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the password: ");
		String pass = sc.next();
		
		admin.setPassword(pass);
	}
	
	public static void viewStudentsInGroup(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the group number: ");
		int groupNumber = sc.nextInt();
		
		admin.displayStudent(groupNumber - 1);
	}
	
	public static void takeAttendance(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Group to take attendance: ");
		int groupNumber = sc.nextInt();
		
		admin.studentAttendance(groupNumber - 1);		
	}
	
	public static void checkAttendance(Admin admin) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the group number: ");
		int groupNumber = sc.nextInt();
		
		groupNumber--;
		
		System.out.println("Enter the student roll number: ");
		long rollNumber = sc.nextLong();
		
		if(admin.studentCount.containsKey(groupNumber)) {
			
			List<Student> students = admin.groups.get(groupNumber);
			
			boolean flag = false;
			
			for(int i = 0;i < students.size();i++) {
				Student s = students.get(i);
				
				if(s.rollNumber == rollNumber) {
					System.out.println("Attendance is: " + s.attendance.totalAttendance);
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("Student does not exists.");
			}
			
		}else {
			System.out.println("Group does not exist.");
		}
	}
	
	public static void updateName(Admin admin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the group number: ");
		int groupNumber = sc.nextInt();
		
		groupNumber--;
		
		System.out.println("Enter the roll number of student: ");
		long rollNumber = sc.nextLong();
		
		sc.nextLine();
		
		System.out.println("Enter the new name of student: ");
		String newName = sc.nextLine();
		
		admin.updateName(groupNumber, rollNumber, newName);
		
	}
	
	public static void numberOfGroups(Admin admin) {
		admin.loadData("students.dat");
		System.out.println("Number of students are: " + admin.studentCount.size());
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		
		System.out.println("Enter the password: ");
		String pass = sc.next();
		
		if(admin.checkPassword(pass)) {
			
			for (int i = 0; i < 5; i++) {
		        System.out.println();
		    }
			
			boolean running = true;

	        while (running) {
	            System.out.println("\n\n========= Attendify =========");
	            System.out.println("1. Add Group");
	            System.out.println("2. Delete Group");
	            System.out.println("3. Add Student to Group");
	            System.out.println("4. Change Admin Password");
	            System.out.println("5. View Student's of group");
	            System.out.println("6. Take Attendance");
	            System.out.println("7. View Current Attendance");
	            System.out.println("8. Update Name of Student");
	            System.out.println("9. Number of groups");
	            System.out.println("10. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    addGroup(admin);
	                    break;
	                case 2:
	                    deleteGroup(admin);
	                    break;
	                case 3:
	                    addStudentToGroup(admin);
	                    break;
	                case 4:
	                    changeAdminPassword(admin);
	                    break;
	                case 5:
	                	viewStudentsInGroup(admin);
	                	break;
	                case 6:
	                	takeAttendance(admin);
	                	break;
	                case 7:
	                	checkAttendance(admin);
	                	break;
	                case 8:
	                	updateName(admin);
	                	break;
	                case 9:
	                	numberOfGroups(admin);
	                	break;
	                case 10:
	                    System.out.println("✅ Exiting program... Goodbye!");
	                    running = false;
	                    break;
	                default:
	                    System.out.println("❌ Invalid choice! Please try again.");
	            }
	        }
			
		}else {
			System.out.println("Access Denied");
		}
	}
}