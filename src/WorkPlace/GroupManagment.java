package WorkPlace;

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GroupManagment extends Group {
	public GroupManagment() {
	}

	public void addGroup() {
		groups.add(new ArrayList<>());
		studentCount.put(groups.size() - 1,0);
		
		saveData("students.dat",groups,studentCount);
		
		System.out.println("\nGroup added successfully");
	}

	public void deleteGroup(int groupNumber) {
		loadData("students.dat");
		if (groups.size() <= groupNumber) {
			System.out.println("Group not exist's");
			return;
		}
		
		

		groups.remove(groupNumber);
		studentCount.remove(groupNumber);
		System.out.println("Group deleted successfully");
	}
}