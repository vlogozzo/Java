package assignment3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String args[]) {

		System.out.println("Task 1:" + "\n"); // task 1

		Student[] oldstudents = { new Student("Jack", "Smith", 50.0, "IT"), new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"), new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"), new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media") };

		List<Student> students = Arrays.asList(oldstudents);

		System.out.println("Complete Student list"); // task 1
		students.forEach(System.out::println);
		//---------------------------------------------------------
		System.out.println("\n" + "Task 2:" + "\n"); // task 2

		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		StudentProcess.gradeRange(students, 50, 100).sorted(new StudentProcess.AscendingSortbygrade())
				.collect(Collectors.toList()).forEach(System.out::println);
		//---------------------------------------------------------
		System.out.println("\n" + "Task 3:" + "\n"); // task 3

		System.out.println("First Student who got 50.0-100.0:");
		System.out.println(StudentProcess.gradeRange(students, 50, 100).findFirst().get());
		//---------------------------------------------------------
		System.out.println("\n" + "Task 4:" + "\n"); // task 4

		System.out.println("Students in ascending order by last name then first:");
		students.stream().sorted(new StudentProcess.AscendingLastthenFirst()).forEach(System.out::println);

		System.out.println();

		System.out.println("Students in descending order by last name then first:");
		students.stream().sorted(new StudentProcess.DescendingLastthenFirst()).forEach(System.out::println);
		//---------------------------------------------------------
		System.out.println("\n" + "Task 5:" + "\n"); // task 5

		System.out.println("Unique Student last names:");
		students.stream().map(s -> s.getLastName()).distinct().sorted().forEach(System.out::println);
		//---------------------------------------------------------
		System.out.println("\n" + "Task 6:" + "\n"); // task 7

		System.out.println("Student names in order by last name then first name:");
		students.stream().sorted(new StudentProcess.AscendingLastthenFirst())
				.forEach(e -> System.out.println(e.getName()));

		System.out.println();
		//---------------------------------------------------------
		System.out.println("\n" + "Task 7:" + "\n"); // task 7

		System.out.println("Students by department:");
		Map<String, List<Student>> departmentgroup = new HashMap<String, List<Student>>();

		students.forEach(e -> departmentgroup.put(e.getDepartment(), students.stream()
				.filter(s -> s.getDepartment().equals(e.getDepartment())).collect(Collectors.toList())));

		departmentgroup.entrySet().stream().forEach(d -> System.out.println(d.getKey())); // OUTPUT NEEDS TO BE FINISHED

		System.out.println();
		//---------------------------------------------------------
		System.out.println("\n" + "Task 8:" + "\n"); // task 8

		System.out.println("Count of Students by department:");
		Map<String, Long> departmentcount = new HashMap<String, Long>();

		students.forEach(e -> departmentcount.put(e.getDepartment(),
				students.stream().filter(s -> s.getDepartment().equals(e.getDepartment())).count()));

		departmentcount.entrySet().stream()
				.forEach(d -> System.out.println(d.getKey() + " has " + d.getValue() + " Student(s)"));

		System.out.println();
		//---------------------------------------------------------
		System.out.println("\n" + "Task 9:" + "\n"); // task 9

		System.out.println("Sum of Students' grades: " + students.stream().mapToDouble(s -> s.getGrade()).sum());

		System.out.println();
		//---------------------------------------------------------
		System.out.println("\n" + "Task 10:" + "\n"); // task 10

		System.out.println("Average of Students' grades: "
				+ String.format("%3.2f", students.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble()));

		System.out.println();
	}
}
