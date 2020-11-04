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
		cid = sc.next();
	}

	public void setcourse() {
		course = sc.next();
	}

	public void setvalue() {
		value = sc.next();
	}

	public void settime() {
		time = sc.next();
	}

	public void setTCHid() {
		TCHid = sc.next();
	}

	public void setTCHname() {
		TCHname = sc.next();
	}

	public void AddInf() {

		try {
			File fwrite = new File("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt");

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getcid() + " ");

			out.write(getcourse() + " ");

			out.write(getvalue() + " ");

			out.write(gettime() + " ");

			out.write(getTCHid() + " ");

			out.write(getTCHname() + "\r\n");

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Course CreatObj(int num) {
		int i = 0;

		Course a = null;

		try {
			File fread = new File("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt"); // Ҫ��ȡ����·����output.txt�ļ�

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // ����һ������������reader

			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������

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

	public void IsExit() {
		System.out.print("������Ҫ��ӵĿγ�����");

		String s = sc.next();

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("D:/JavaWorkplace/ScoreInformation - Scanner/data/Course.txt"));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(s)) {
					System.out.println("�γ��Ѵ���������");
					br.close();
					return;
				}
			}
			br.close();

			System.out.println("�γ�δ������");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void Info() {
		System.out.println("�γ�ID��" + getcid());
		System.out.println("�γ�����" + getcourse());
		System.out.println("ѧ�֣�" + getvalue());
		System.out.println("ѧʱ��" + gettime());
		System.out.println("��ʦ���ţ�" + getTCHid());
		System.out.println("��ʦ������" + getTCHname());
		System.out.println();
	}

}
