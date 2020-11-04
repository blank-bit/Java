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

/*����*/
abstract class Person {
	/* ˽���ֶ�(�������Ա𡢳������¡�ѧԺ) */
	private String ID;
	private String name;
	private String gender;
	private String birthdate;
	private String college;

	String APath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Administrator.txt";
	String TPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Teacher.txt";
	String SPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Student.txt";
	String Path;

	Scanner sc = new Scanner(System.in);

	/* �޲ι��캯�� */
	Person() {
		this("", "", "", "", "");
	}

	/* �вι��캯�� */
	Person(String ID, String name, String gender, String birthdate, String college) {
		this.ID = ID;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.college = college;
	}

	/* ����1�� */
	public String getID() {
		return ID;
	}

	public String getname() {
		return name;
	}

	public String getgender() {
		return gender;
	}

	public String getbirthdate() {
		return birthdate;
	}

	public String getcollege() {
		return college;
	}

	/* ����2�� */
	public void setID() {
		ID = sc.next();
	}

	public void setname() {
		name = sc.next();
	}

	public void setgender() {
		System.out.println("�������Ա�");
		gender = sc.next();
	}

	public void setbirthdate() {
		System.out.println("������������£�");
		birthdate = sc.next();
	}

	public void setcollege() {
		System.out.println("������ѧԺ��");
		college = sc.next();
	}

	/* ���󷽷� */
	abstract void Info();

	public void AddInf(String type) {
		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getID() + " ");

			out.write(getname() + " ");

			out.write(getgender() + " ");

			out.write(getbirthdate() + " ");

			out.write(getcollege() + " "); // \r\n��Ϊ����

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fread = new File(Path); // Ҫ��ȡ����·����output.txt�ļ�

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // ����һ������������reader

			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������

			String line = "";

			line = br.readLine();

			String[] word = line.split(" ");

			while (line != null) {

				for (int j = 0; j < word.length; j++) {

					if (j + 1 == word.length) {
						System.out.print(String.format("%-12s", word[j]));
						System.out.print("\n");
					} else
						System.out.print(String.format("%-12s", word[j]) + "\t");
				}
				line = br.readLine(); // һ�ζ���һ������

				if (line != null)
					word = line.split(" ");
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("\n");
	}

	public void DelInf(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		System.out.print("������Ҫɾ����������");

		String s = sc.next();

		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));
			StringBuffer sb = new StringBuffer();
			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(s))
					continue;

				sb.append(temp).append("\r\n");
			}
			br.close();

			BufferedWriter bw = new BufferedWriter(new FileWriter(Path));

			bw.write(sb.toString());// ���ش����������ݵ��ַ�����ʾ��ʽ
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void DelAll(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Path));
			out.write("");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Person CreatObj(String type, int num) {
		int i = 0;
		Person a = null;
		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fread = new File(Path); // Ҫ��ȡ����·����output.txt�ļ�

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // ����һ������������reader

			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������

			String line = "";
			while (i < num) {
				line = br.readLine();
				i++;
			}

			String[] word = line.split(" ");

			if (type == "Admin")
				a = new Admin(word[0], word[1], word[2], word[3], word[4], word[5]);
			if (type == "Teacher")
				a = new Teacher(word[0], word[1], word[2], word[3], word[4], word[5]);
			if (type == "Student")
				a = new Student(word[0], word[1], word[2], word[3], word[4], word[5]);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
//		System.out.print("\n");
	}

}

/* ����Ա�� */
class Admin extends Person {
	/* ˽���ֶ�(��λ����) */
	private String station;

	/* �޲ι��캯�������ñ��๹�캯�� */
	Admin() {
		this("");
	}

	/* �вι��캯�������ñ��๹�캯�� */
	Admin(String station) {
		this("", "", "", "", "", station);
	}

	/* �вι��캯�������ø��๹�캯�� */
	Admin(String id, String name, String gender, String birthdate, String college, String station) {
		super(id, name, gender, birthdate, college);
		this.station = station;
	}

	/* ���෽��1�� */
	public String getstation() {
		return station;
	}

	/* ���෽��2�� */
	// ��������
	public void setID() {
		System.out.println("���������Ա���ţ�");
		super.setID();
	}

	public void setname() {
		System.out.println("���������Ա������");
		super.setname();
	}

	public void setstation() {
		System.out.println("�������λ��");
		station = sc.next();
	}

	/* �������� */
	void Info() {
		System.out.println("���ţ�" + getID());
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("��λ��" + getstation());
		System.out.println();
	}

	public Admin CreatObj(int num) {
		Admin a = null;
		a = (Admin) super.CreatObj("Admin", num);
		return a;
	}

	public void AddInf() {
		super.AddInf("Admin");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getstation() + "\r\n");

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("����Ա����\t" + "����Ա����\t" + "����Ա�Ա�\t" + "����Ա��������\t" + "����ԱѧԺ\t" + "����Աְλ");
		super.RInfo("Admin");
	}

	public void DelInf() {
		super.DelInf("Admin");
	}
}

/* ��ʦ�� */
class Teacher extends Person {
	private String title;

	/* �޲ι��캯�������ñ��๹�캯�� */
	Teacher() {
		this("");
	}

	/* �вι��캯�������ñ��๹�캯�� */
	Teacher(String title) {
		this("", "", "", "", "", title);
	}

	/* �вι��캯�������ø��๹�캯�� */
	Teacher(String id, String name, String gender, String birthdate, String college, String title) {
		super(id, name, gender, birthdate, college);
		this.title = title;
	}

	/* ���෽��1�� */
	public String gettitle() {
		return title;
	}

	/* ���෽��2�� */
	// ��������
	public void setID() {
		System.out.println("�������ʦ���ţ�");
		super.setID();
	}

	public void setname() {
		System.out.println("�������ʦ������");
		super.setname();
	}

	public void settitle() {
		System.out.println("������ְ�ƣ�");
		title = sc.next();
	}

	/* �������� */
	void Info() {
		System.out.println("��ʦ���ţ�" + getID());
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("ְ�ƣ�" + gettitle());
		System.out.println();
	}

	public void AddInf() {
		super.AddInf("Teacher");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(gettitle() + "\r\n");

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("��ʦ����\t\t" + "��ʦ����\t\t" + "��ʦ�Ա�\t\t" + "��ʦ��������\t" + "��ʦѧԺ\t\t" + "��ʦְ��");
		super.RInfo("Teacher");
	}

	public void DelInf() {
		super.DelInf("Teacher");
	}

	public Teacher CreatObj(int num) {
		Teacher a = null;
		a = (Teacher) super.CreatObj("Teacher", num);
		return a;
	}
}

/* ѧ���� */
class Student extends Person {
	private String speciality;

	/* �޲ι��캯�������ñ��๹�캯�� */
	Student() {
		this("");
	}

	/* �вι��캯�������ñ��๹�캯�� */
	Student(String speciality) {
		this("", "", "", "", "", speciality);
	}

	/* �вι��캯�������ø��๹�캯�� */
	Student(String id, String name, String gender, String birthdate, String college, String speciality) {
		super(id, name, gender, birthdate, college);
		this.speciality = speciality;
	}

	/* ���෽��1�� */
	public String getspeciality() {
		return speciality;
	}

	/* ���෽��2�� */
	// ��������
	public void setID() {
		System.out.println("������ѧ�ţ�");
		super.setID();
	}

	public void setname() {
		System.out.println("������ѧ��������");
		super.setname();
	}

	public void setspeciality() {
		System.out.println("������רҵ��");
		speciality = sc.next();
	}

	/* �������� */
	void Info() {
		System.out.println("ѧ�ţ�" + getID());
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("רҵ��" + getspeciality());
		System.out.println();
	}

	public void AddInf() {
		super.AddInf("Student");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getspeciality() + "\r\n");

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("ѧ��ѧ��\t\t" + "ѧ������\t\t" + "ѧ���Ա�\t\t" + "ѧ����������\t" + "ѧ��ѧԺ\t\t" + "ѧ��רҵ");
		super.RInfo("Student");
	}

	public void DelInf() {
		super.DelInf("Student");
	}

	public Student CreatObj(int num) {
		Student a = null;
		a = (Student) super.CreatObj("Student", num);
		return a;
	}
}