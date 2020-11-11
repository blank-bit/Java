package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreInformation_Scanner {
	public static void main(String[] args) {

		final int N = 10;

		/****************************************/
		/************ 创建角色对象 **************/
		/****************************************/
		Admin a = new Admin("10001", "王汇丰", "男", "1966-07-09", "信软", "辅导员");
		Teacher t1 = new Teacher("20001", "洪荒花", "女", "1986-12-05", "信软", "嵌入式", "教授");
		Teacher t2 = new Teacher("20002", "陈键锋", "男", "195886-01-25", "信软", "网安", "讲师");
		Student s0 = new Student("30901", "何发挥", "男", "2000-03-15", "信软", "嵌入式");
		Student s1 = new Student("30902", "奥斯", "男", "2001-06-25", "信软", "嵌入式");
		Student s2 = new Student("30903", "爱华伐光", "男", "1998-11-03", "信软", "网安");
		Student s3 = new Student("30904", "范娥", "女", "2001-05-26", "信软", "嵌入式");
		Student s4 = new Student("30905", "安慧", "女", "2000-05-15", "信软", "统技");
		Student s5 = new Student("30906", "顾颂可", "女", "2000-02-22", "信软", "网安");
		Student s6 = new Student("30907", "库克卡", "男", "2000-03-15", "信软", "嵌入式");
		Student s7 = new Student("30908", "包蓓蓓", "女", "2000-08-25", "信软", "嵌入式");
		Student s8 = new Student("30909", "何尝道", "男", "2000-03-15", "信软", "嵌入式");
		Student s9 = new Student("30910", "莉莉", "女", "2001-06-18", "信软", "数漫");

		List<Student> students = new ArrayList<Student>();
		List<Student> list = Arrays.asList(s0, s1, s2, s3, s4, s5, s6, s7, s8, s9);
		students.addAll(list);

		/****************************************/
		/************ 启动函数 ****************/
		/****************************************/
//		从键盘输入各个对象值
//		a.start();
//		t1.start();
//		for (int i = 0; i < N; i++)
//			students.get(i).start();

		/****************************************/
		/************ 添加到文件 ****************/
		/****************************************/
		a.AddInf();
		t1.AddInf();
		t2.AddInf();

		for (int i = 0; i < N; i++)
			students.get(i).AddInf();
//		s0.AddInf();
//		s1.AddInf();
//		s2.AddInf();
//		s3.AddInf();
//		s4.AddInf();
//		s5.AddInf();
//		s6.AddInf();
//		s7.AddInf();
//		s8.AddInf();
//		s9.AddInf();

		/****************************************/
		/************ 从文件重构 ****************/
		/****************************************/
		a = a.CreatObj(1);
		t1 = t1.CreatObj(1);
		t2 = t1.CreatObj(2);

		for (int i = 1; i < N + 1; i++)
			students.add(i - 1, students.get(i - 1).CreatObj(i));
//		s0 = s0.CreatObj(1);
//		s1 = s0.CreatObj(2);
//		s2 = s0.CreatObj(3);
//		s3 = s0.CreatObj(4);
//		s4 = s0.CreatObj(5);
//		s5 = s0.CreatObj(6);
//		s6 = s0.CreatObj(7);
//		s7 = s0.CreatObj(8);
//		s8 = s0.CreatObj(9);
//		s9 = s0.CreatObj(10);

		/****************************************/
		/************ 共同打印 ******************/
		/****************************************/
		a.RInfo();
		t1.RInfo();
		students.get(0).RInfo();

		/****************************************/
		/************ 单个打印 ******************/
		/****************************************/
		/*
		 * a.Info(); t1.Info(); t2.Info(); s0.Info(); s1.Info(); s2.Info(); s3.Info();
		 * s4.Info(); s5.Info(); s6.Info(); s7.Info(); s8.Info(); s9.Info();
		 */

		/****************************************/
		/************ 创建课程 ******************/
		/****************************************/
		Course course = new Course("40001", "Java", "5", "64", "10001", "洪荒花");
		Course c = new Course("40002", "C", "4", "48", "10002", "陈键锋");

		/****************************************/
		/************ 添加到文件 ****************/
		/****************************************/
		course.AddInf();
		c.AddInf();

		/****************************************/
		/************ 从文件重构 ****************/
		/****************************************/
		course = course.CreatObj(1);
		c = c.CreatObj(2);

		/****************************************/
		/************ 单个打印 ******************/
		/****************************************/
		course.Info();
		c.Info();

		/****************************************/
		/************ 产生成绩 ******************/
		/****************************************/
		Grade j = new Grade();
		Grade gc = new Grade();

		j.start("Java");
		gc.start("C");

		/****************************************/
		/************ 统计分数 ******************/
		/****************************************/
		Statistics statistics1 = new Statistics();
		Statistics statistics2 = new Statistics();

		statistics1.start("Java");
		statistics2.start("C");

		/****************************************/
		/************ 成绩查询 ******************/
		/****************************************/
		Search search = new Search();
		search.start();
	}
}
