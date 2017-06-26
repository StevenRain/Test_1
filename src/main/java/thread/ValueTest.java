package thread;

import lombok.Data;

/**
 * Created by Steven
 * Date:2017/6/23
 * Time:17:18
 */
public class ValueTest {

	@Data
	static class Student {
		private Integer id = 1;
		private String name;
	}

	public static void main(String[] args) {
		Student student = new Student();
		System.out.println(student.getId());
		System.out.println(student.getName());
	}
}
