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

	/****************************************/
	/************ ��ӵ��ļ� ****************/
	/****************************************/
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

	/****************************************/
	/************ ���ļ���ȡ ****************/
	/****************************************/
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
			File fread = new File(Path);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread));

			BufferedReader br = new BufferedReader(reader);

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

	/****************************************/
	/************ ���ļ���ɾ�� **************/
	/****************************************/
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

	/****************************************/
	/************ ɾ���ļ��������� **********/
	/****************************************/
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

	/****************************************/
	/************ ���ļ����ع� **************/
	/****************************************/
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

		LineNum lineNum = new LineNum();
		int l = lineNum.getLineNumber(Path);

		if (num > l || num < 1) {
			System.out.println("����ʧ�ܣ���");
			return null;
		}

		try {
			File fread = new File(Path);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread));

			BufferedReader br = new BufferedReader(reader);

			String line = "";
			while (i < num) {
				line = br.readLine();
				i++;
			}

			String[] word = line.split(" ");

			if (type == "Admin")
				a = new Admin(word[0], word[1], word[2], word[3], word[4], word[5]);
			if (type == "Teacher")
				a = new Teacher(word[0], word[1], word[2], word[3], word[4], word[5], word[6]);
			if (type == "Student")
				a = new Student(word[0], word[1], word[2], word[3], word[4], word[5]);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	/****************************************/
	/************ ���������ֶ� **************/
	/****************************************/
	public void setAll() {
		setID();
		setname();
		setgender();
		setbirthdate();
		setcollege();
	}

	/****************************************/
	/************ �ж��Ƿ���� **************/
	/****************************************/
	public boolean IsExit(String type) {
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
			BufferedReader br = new BufferedReader(new FileReader(Path));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(getID())) {
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

	public boolean IsNext() {
		String s;
		s = sc.next();
		if (s.equals("Y") || s.equals("y"))
			return true;

		// System.out.println("�ڴ����´�ʹ�ã�");
		return false;
	}

	abstract void start();
//	public void start(String type) {
//		System.out.println("�Ƿ����øö����ֵ(Y/N)��");
//		if (IsNext()) {
//			setAll();
//			System.out.println("�Ƿ���ӵ��ļ���(Y/N)��");
//			if (IsNext()) {
//				AddInf(type);
//				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
//				if (IsNext()) {
//					Info();
//					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
//					if (IsNext()) {
//						RInfo(type);
//					} else
//						return;
//				} else
//					return;
//			} else
//				return;
//		} else
//			return;
//	}
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
		if (IsExit("Admin")) {
//			System.out.println("�Ѵ��ڣ�");
			return;
		}
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

	public void setAll() {
		super.setAll();
		setstation();
		System.out.println();
	}

	public void start() {
		System.out.println("����Ա��");
		System.out.println("�Ƿ����øö����ֵ(Y/N)��");
		if (IsNext()) {
			setAll();
			System.out.println("�Ƿ���ӵ��ļ���(Y/N)��");
			if (IsNext()) {
				AddInf();
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
	}
}

/* ��ʦ�� */
class Teacher extends Person {
	private String graduate;
	private String title;

	/* �޲ι��캯�������ñ��๹�캯�� */
	Teacher() {
		this("", "");
	}

	/* �вι��캯�������ñ��๹�캯�� */
	Teacher(String graduate, String title) {
		this("", "", "", "", "", graduate, title);
	}

	/* �вι��캯�������ø��๹�캯�� */
	Teacher(String id, String name, String gender, String birthdate, String college, String graduate, String title) {
		super(id, name, gender, birthdate, college);
		this.graduate = graduate;
		this.title = title;
	}

	/* ���෽��1�� */
	public String getgraduate() {
		return graduate;
	}

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

	public void setgraduate() {
		System.out.println("�������ʦ��ҵרҵ��");
		this.graduate = sc.next();
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
		System.out.println("��ҵרҵ��" + getcollege());
		System.out.println("ְ�ƣ�" + gettitle());
		System.out.println();
	}

	public void AddInf() {
		if (IsExit("Teacher")) {
//			System.out.println("�Ѵ��ڣ�");
			return;
		}
		super.AddInf("Teacher");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getgraduate() + " ");

			out.write(gettitle() + "\r\n");

			out.flush(); // �ѻ���������ѹ���ļ�

			out.close(); // ���ǵùر��ļ�

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("��ʦ����\t\t" + "��ʦ����\t\t" + "��ʦ�Ա�\t\t" + "��ʦ��������\t" + "��ʦѧԺ\t\t" + "��ҵרҵ\t\t" + "��ʦְ��");
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

	public void setAll() {
		super.setAll();
		setgraduate();
		settitle();
	}

	public void start() {
		System.out.println("��ʦ��");
		System.out.println("�Ƿ����øö����ֵ(Y/N)��");
		if (IsNext()) {
			setAll();
			System.out.println("�Ƿ���ӵ��ļ���(Y/N)��");
			if (IsNext()) {
				AddInf();
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
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
		if (IsExit("Student")) {
//			System.out.println("�Ѵ��ڣ�");
			return;
		}
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

	public void setAll() {
		super.setAll();
		setspeciality();
	}

	public void start() {
		System.out.println("ѧ����");
		System.out.println("�Ƿ����øö����ֵ(Y/N)��");
		if (IsNext()) {
			setAll();
			System.out.println("�Ƿ���ӵ��ļ���(Y/N)��");
			if (IsNext()) {
				AddInf();
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("�Ƿ��ӡ�ö������Ϣ(Y/N)��");
				if (IsNext()) {
					Info();
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("�Ƿ��ӡ�ļ���Ϣ(Y/N)��");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
	}
}