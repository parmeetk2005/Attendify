package WorkPlace;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;


public class StudentManagment extends GroupManagment{
	StudentManagment() {}
	
	void addStudent(Student s,int groupNumber) {
		if(groupNumber >= groups.size()) {
			System.out.println("Invalid group number!");
			return;
		}
		
		groups.get(groupNumber).add(s);
		studentCount.put(groupNumber,studentCount.get(groupNumber) + 1);
		
		saveData("students.dat",groups,studentCount);
		System.out.println("\nStudent added successfully");
	}
	
	void displayStudent(int groupNumber) {
		loadData("students.dat");
		List<Student> list = groups.get(groupNumber);
		
		for(int i = 0;i < list.size();i++) {
			System.out.println("Student name: " + list.get(i).name);
			System.out.println("Student roll number: " + list.get(i).rollNumber);
			System.out.println("Student attendance: " + list.get(i).attendance.totalAttendance);
			System.out.println("Student gender: " + list.get(i).gender);
			System.out.println();
		}
	}
	
	void removeStudent(long rollNumber,int groupNumber) {
		loadData("students.dat");
		List<Student> list = groups.get(groupNumber);
		
		for(int i = 0;i < list.size();i++) {
			if(list.get(i).rollNumber == rollNumber) {
				list.remove(i);
				break;
			}
		}
		
		System.out.println("Student removed successfully!");
	}
	
	void studentAttendance(int groupNumber) {
		loadData("students.dat");
		Scanner sc = new Scanner(System.in);
		List<Student> students = groups.get(groupNumber);
		
		for(int i = 0;i < students.size();i++) {
			Student s = students.get(i);
			
			System.out.println(s.name + " Present or Absent ?: ");
			char attend = sc.next().charAt(0);
			
			s.attendance.dilivered = s.attendance.dilivered + 1;
			
			if(attend == 'P') {
				s.attendance.attended = s.attendance.attended + 1;
				
				s.attendance.totalAttendance = ((float)s.attendance.attended / (float)s.attendance.dilivered ) * 100f;
			}else {
				s.attendance.totalAttendance = ((float)s.attendance.attended / (float)s.attendance.dilivered ) * 100f;
			}
		}
		
		System.out.println("Group Ended  !");
		
		
		saveData("students.dat",groups,studentCount);
		return;
	}
	
	
	void updateName(int groupNumber, long rollNumber, String newName) {
	    loadData("students.dat");

	    List<Student> students = groups.get(groupNumber);
	    boolean flag = false;
	    for (Student s : students) {
	        if (s.rollNumber == rollNumber) {
	            s.name = newName; // ✅ this is enough
	            flag = true;
	            break;
	        }
	    }
	    
	    if(flag) {
	    	// ✅ No need for groups.set(...) if 'groups' is a List of Lists
		    saveData("students.dat", groups, studentCount);
	    }else {
	    	System.out.println("Roll number not found");
	    }

	    
	}
}