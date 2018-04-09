package assignment3;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StudentProcess {
	
	static Stream<Student> gradeRange(List<Student> students, double min, double max) {
		return students.stream().filter(s -> s.getGrade() >= min && s.getGrade() <= max);
	}
	
	static class AscendingSortbygrade implements Comparator<Student> {
		public int compare(Student a, Student b) {
			return (int) (a.getGrade() - b.getGrade());
		}
	}

	static class AscendingLastthenFirst implements Comparator<Student> {
		public int compare(Student a, Student b) {
			int test = a.getLastName().compareTo(b.getLastName());

			return (test != 0 ? test : a.getFirstName().compareTo(b.getFirstName()));
		}
	}

	static class DescendingLastthenFirst implements Comparator<Student> {
		public int compare(Student a, Student b) {
			int test = b.getLastName().compareTo(a.getLastName());

			return (test != 0 ? test : b.getFirstName().compareTo(a.getFirstName()));
		}
	}
	
	static class departmentsort implements Comparator<Student> {
		public int compare(Student a, Student b) {
			return b.getDepartment().compareTo(a.getDepartment());
		}
	}

	static Set<String> UniqueLastNames(List<Student> students) {
		Set<String> uniques = new TreeSet<>();

		students.forEach(s -> uniques.add(s.getLastName()));

		return uniques;
	}
}
