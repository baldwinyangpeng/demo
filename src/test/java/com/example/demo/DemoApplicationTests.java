package com.example.demo;

import com.example.demo.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		List<Student> students = new ArrayList<Student>() {
			{
				add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
				add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
				add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
				add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
				add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
				add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
				add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
				add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
				add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
				add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
			}
		};
		List<Student> whuStudents = students.stream()
				.filter(student -> "武汉大学".equals(student.getSchool()))
				.collect(Collectors.toList());

		List<Student> civilStudents = students.stream()
				.filter(student -> "土木工程".equals(student.getMajor())).limit(2)
				.collect(Collectors.toList());

		List<Student> sortedCivilStudents = students.stream()
				.filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge())
				.limit(2)
				.collect(Collectors.toList());

//		List<Student> civilStudents = students.stream()
//				.filter(student -> "土木工程".equals(student.getMajor()))
//				.skip(2)
//				.collect(Collectors.toList());

// 前面例子中的方法
int totalAge = students.stream()
				.filter(student -> "计算机科学".equals(student.getMajor()))
				.mapToInt(Student::getAge).sum();
//// 归约操作
//		int totalAge = students.stream()
//				.filter(student -> "计算机科学".equals(student.getMajor()))
//				.map(Student::getAge)
//				.reduce(0, (a, b) -> a + b);
//
//// 进一步简化
//		int totalAge2 = students.stream()
//				.filter(student -> "计算机科学".equals(student.getMajor()))
//				.map(Student::getAge)
//				.reduce(0, Integer::sum);
//
//// 采用无初始值的重载版本，需要注意返回Optional
//		Optional<Integer> totalAge = students.stream()
//				.filter(student -> "计算机科学".equals(student.getMajor()))
//				.map(Student::getAge)
//				.reduce(Integer::sum);  // 去掉初始值

// 求最大年龄
		Optional<Student> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));

// 进一步简化
		Optional<Student> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));

// 求最小年龄
		Optional<Student> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
	}

}
