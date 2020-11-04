package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*����*/
abstract class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8203956895813677435L;
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
	public void setID(String id) {
		ID = id;
	}

	public void setname(String nam) {
		name = nam;
	}

	public void setgender(String gen) {
		gender = gen;
	}

	public void setbirthdate(String date) {
		birthdate = date;
	}

	public void setcollege(String col) {
		college = col;
	}

	/* ���󷽷� */
	abstract void Info();

}

/* ����Ա�� */
class Admin extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4344318444250372480L;
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
		setstation(station);
	}

	/* ���෽��1�� */
	public String getstation() {
		return station;
	}

	/* ���෽��2�� */
	public void setstation(String sta) {
		station = sta;
	}

	/* �������� */
	void Info() {
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("��λ��" + getstation());
	}

	public void AddInfo(Admin ad) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("D:/JavaWorkplace/ScoreInformation - Scanner/data/Administrator.txt"));
			out.writeObject(ad);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin ReadInfo() {
		Admin ad = null;
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("D:/JavaWorkplace/ScoreInformation - Scanner/data/Administrator.txt"));
			ad = (Admin) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ad;
	}
}

/* ��ʦ�� */
class Teacher extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1060451648079550159L;
	private String TCHID;
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
		setTCHID(TCHID);
		settitle(title);

	}

	/* ���෽��1�� */
	public String getTCHID() {
		return TCHID;
	}

	public String gettitle() {
		return title;
	}

	/* ���෽��2�� */
	public void setTCHID(String tid) {
		TCHID = tid;
	}

	public void settitle(String til) {
		title = til;
	}

	/* �������� */
	void Info() {
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("��ʦ���ţ�" + getTCHID());
		System.out.println("ְ�ƣ�" + gettitle());
	}
}

/* ѧ���� */
class Student extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6197451306449999342L;
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
	Student(String STUID, String name, String gender, String birthdate, String college, String speciality) {
		super(STUID, name, gender, birthdate, college);
		setspeciality(speciality);

	}

	/* ���෽��1�� */
	public String getspeciality() {
		return speciality;
	}

	/* ���෽��2�� */
	public void setspeciality(String spec) {
		speciality = spec;
	}

	/* �������� */
	void Info() {
		System.out.println("ѧ�ţ�" + getID());
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("רҵ��" + getspeciality());
	}
}