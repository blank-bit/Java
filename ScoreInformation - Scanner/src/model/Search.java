package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Search {
	private String id;
	private String course;

	Scanner sc = new Scanner(System.in);

	String JPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Java.txt";
	String CPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/C.txt";
	String Path;

	public String getid() {
		return id;
	}

	public String getCourse() {
		return course;
	}

	public void setid() {
		System.out.println("请输入查询的学生ID：");
		id = sc.next();
	}

	public void setCourse() {
		System.out.println("请输入查询的课程名：");
		course = sc.next();
	}

	public void grade() {

		if (!IsExit())
			return;

		switch (getCourse()) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default: {
			System.out.println("ERROR");
			return;
		}
		}

		try {
			File fread = new File(Path);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // 建立一个输入流对象reader

			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

			String line = "";

			line = br.readLine();
			while (!line.contains(getid())) {
				line = br.readLine();
			}

			String[] word = line.split(" ");

			br.close();

			System.out.println(getCourse() + "成绩为：" + word[6]);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	public boolean IsExit() {
		switch (getCourse()) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default: {
			System.out.println("ERROR");
			return false;
		}
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(getid())) {
					br.close();
					return true;
				}
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("该学生不存在！！！");
		return false;
	}

	public boolean IsNext() {
		String s;
		s = sc.next();
		if (s.equals("Y") || s.equals("y"))
			return true;

		System.out.println("期待您的下次使用！");
		return false;
	}

	public void start() {
		setid();
		setCourse();
		grade();
		System.out.println("是否继续查询(Y/N)：");

		if (IsNext())
			start();
	}

}
