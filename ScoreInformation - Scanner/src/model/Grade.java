package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Grade {
	private String cid;
	private String course;
	private String TCHid;
	private String TCHname;
	private String STUid;
	private String STUname;
	private String score;
	private boolean IsUsed = false;

	Scanner sc = new Scanner(System.in);

	String TPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Teacher.txt";
	String SPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Student.txt";
	String coPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt";
	String JPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Java.txt";
	String CPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/C.txt";
	String Path;

	Random random = new Random();

	LineNum num = new LineNum();
	Teacher teacher = new Teacher();
	Student student = new Student();
	Course co = new Course();

	public Grade() {
		this("", "", "", "", "", "", "");
	}

	Grade(String cid, String course, String TCHid, String TCHname, String STUid, String STUname, String score) {
		this.cid = cid;
		this.course = course;
		this.TCHid = TCHid;
		this.TCHname = TCHname;
		this.STUid = STUid;
		this.STUname = STUname;
		this.score = score;
	}

	public String getCid() {
		return cid;
	}

	public String getCourse() {
		return course;
	}

	public String getTCHid() {
		return TCHid;
	}

	public String getTCHname() {
		return TCHname;
	}

	public String getSTUid() {
		return STUid;
	}

	public String getSTUname() {
		return STUname;
	}

	public String getScore() {
		return score;
	}

	public void setCourse(String course) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(coPath));
			String line = "";
			line = br.readLine();

			int l = 1;

			while (!line.contains(course)) {
				line = br.readLine();
				l++;
			}

			Course c = new Course();
			Course co = new Course();
			co = c.CreatObj(l);

			br.close();

			this.cid = co.getcid();
			this.course = co.getcourse();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean setTCH() {
		if (IsUsed)
			return true;

		if (!IsEmpty()) {
			Grade g = new Grade();
			g = g.CreatObj(getCourse(), 1);
			this.TCHname = g.getTCHname();
			this.TCHid = g.getTCHid();
			return true;
		}

		int tnum = 0;

		tnum = num.getLineNumber(TPath);

		Teacher t = new Teacher();

		t = teacher.CreatObj(random.nextInt(tnum) + 1);// tnum = max - min + 1; d = random.nextInt(tnum) + min

		this.TCHname = t.getname();
		this.TCHid = t.getID();

		return true;
	}

	public void setSTU() {
		if (IsFull())
			return;

		int snum = 0;

		snum = num.getLineNumber(SPath);

		Student s = new Student();

		s = student.CreatObj(random.nextInt(snum) + 1);

		while (IsExit(s.getID())) {
			s = student.CreatObj(random.nextInt(snum) + 1);
		}

		this.STUid = s.getID();
		this.STUname = s.getname();
	}

	public void setScore() {
		String s = "" + random.nextInt(101);
		this.score = s;
	}

	public void AddInf(String course) {
		if (IsFull()) {
//			System.out.println("所有学生已添加。");
			return;
		}
		switch (course) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getCid() + " ");

			out.write(getCourse() + " ");

			out.write(getTCHid() + " ");

			out.write(getTCHname() + " ");

			out.write(getSTUid() + " ");

			out.write(getSTUname() + " ");

			out.write(getScore() + "\r\n");

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Grade CreatObj(String course, int num) {
		int i = 0;
		Grade a = null;
		switch (course) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fread = new File(Path); // 要读取以上路径的output.txt文件

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // 建立一个输入流对象reader

			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

			String line = "";
			while (i < num) {
				line = br.readLine();
				i++;
			}

			String[] word = line.split(" ");

			a = new Grade(word[0], word[1], word[2], word[3], word[4], word[5], word[6]);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public boolean IsExit(String s) {
		switch (getCourse()) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(s)) {
//					System.out.println("该学生已添加！！！");
					br.close();
					return true;
				}
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean IsFull() {
		switch (getCourse()) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
		}

		LineNum lineNum = new LineNum();
		int lc = lineNum.getLineNumber(Path);
		int ls = lineNum.getLineNumber(SPath);

		if (lc == ls)
			return true;

		return false;
	}

	public boolean IsEmpty() {
		switch (getCourse()) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
		}

		LineNum lineNum = new LineNum();
		int lc = lineNum.getLineNumber(Path);

		if (lc == 0)
			return true;

		return false;
	}

	public void start(String s) {
		int num;
		System.out.println("请输入该门课的学生数：");
		num = sc.nextInt();

		if (num == 0)
			return;
		setCourse(s);
		setTCH();

		LineNum lineNum = new LineNum();
		int ls = lineNum.getLineNumber(SPath);
		if (num > ls) {
			System.out.println("ERROR请重新输入：");
			start(s);
			return;
		}
		for (int i = 0; i < num; i++) {
			setSTU();
			setScore();
			AddInf(s);
		}
	}
}
