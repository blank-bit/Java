package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Course {
	private String cid;
	private String course;
	private String value;
	private String time;
	private String TCHid;
	private String TCHname;

	Scanner sc = new Scanner(System.in);

	public Course() {
		this("", "", "", "", "", "");
	}

	public Course(String cid, String course, String value, String time, String TCHid, String TCHname) {
		this.cid = cid;
		this.course = course;
		this.value = value;
		this.time = time;
		this.TCHid = TCHid;
		this.TCHname = TCHname;
	}

	public String getcid() {
		return cid;
	}

	public String getcourse() {
		return course;
	}

	public String getvalue() {
		return value;
	}

	public String gettime() {
		return time;
	}

	public String getTCHid() {
		return TCHid;
	}

	public String getTCHname() {
		return TCHname;
	}

	public void setcid() {
		System.out.println("请输入课程ID：");
		cid = sc.next();
	}

	public void setcourse() {
		System.out.println("请输入课程名：");
		course = sc.next();
	}

	public void setvalue() {
		System.out.println("请输入学分：");
		value = sc.next();
	}

	public void settime() {
		System.out.println("请输入学时：");
		time = sc.next();
	}

	public void setTCHid() {
		System.out.println("请输入教师ID：");
		TCHid = sc.next();
	}

	public void setTCHname() {
		System.out.println("请输入教师姓名：");
		TCHname = sc.next();
	}

	public void AddInf() {

		if (IsExit(getcourse()))
			return;

		try {
			File fwrite = new File("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt");

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getcid() + " ");

			out.write(getcourse() + " ");

			out.write(getvalue() + " ");

			out.write(gettime() + " ");

			out.write(getTCHid() + " ");

			out.write(getTCHname() + "\r\n");

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Course CreatObj(int num) {
		int i = 0;

		Course a = null;

		LineNum lineNum = new LineNum();
		int l = lineNum.getLineNumber("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt");

		if (num > l || num < 1) {
			System.out.println("构造失败！！");
			return null;
		}

		try {
			File fread = new File("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt");

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread));

			BufferedReader br = new BufferedReader(reader);

			String line = "";
			while (i < num) {
				line = br.readLine();
				i++;
			}

			String[] word = line.split(" ");

			a = new Course(word[0], word[1], word[2], word[3], word[4], word[5]);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public boolean IsExit(String s) {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt"));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(s)) {
//					System.out.println("课程已创建！！！");
					br.close();
					return true;
				}
			}
			br.close();

			System.out.println("新课程创建成功！");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	void Info() {
		System.out.println("课程ID：" + getcid());
		System.out.println("课程名：" + getcourse());
		System.out.println("学分：" + getvalue());
		System.out.println("学时：" + gettime());
		System.out.println("教师工号：" + getTCHid());
		System.out.println("教师姓名：" + getTCHname());
		System.out.println();
	}

}
