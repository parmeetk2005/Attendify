package WorkPlace;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Group implements Serializable {
	public List<List<Student>> groups;
	public Map<Integer,Integer> studentCount;
	
	public Group() {
		groups = new ArrayList<>();
		studentCount = new HashMap<>();
	}
	
	public int getStudentsInGroup(int groupNumber) {
		loadData("students.dat");
		if(!studentCount.containsKey(groupNumber)) {
			System.out.println("Group not exist's");
			return -1;
		}
		return studentCount.get(groupNumber);
	}
	
	public void displayGroups() {
		loadData("students.dat");
		for(int i = 0;i < groups.size();i++) {
			System.out.print("Group " + (i + 1) + ": ");
			for(int j = 0;j < groups.get(i).size();j++) {
				System.out.print(groups.get(i).get(j).rollNumber + " ");
			}
			System.out.println();
		}
	}
	
	public int getNumberOfGroups() {
		loadData("students.dat");
		return groups.size();
	}
	
	
	
//	-------------------------------------------------------------------------------
	public void saveData(String filename, List<List<Student>> groups, Map<Integer, Integer> studentCount) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	        oos.writeObject(groups);
	        oos.writeObject(studentCount);
	        System.out.println("Data saved successfully to " + filename);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void loadData(String filename) {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	        groups = (List<List<Student>>) ois.readObject();
	        studentCount = (Map<Integer, Integer>) ois.readObject();
	        System.out.println("Data loaded successfully from " + filename);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}