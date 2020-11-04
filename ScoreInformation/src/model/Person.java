package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*基类*/
abstract class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8203956895813677435L;
	/* 私有字段(姓名、性别、出生年月、学院) */
	private String ID;
	private String name;
	private String gender;
	private String birthdate;
	private String college;

	String APath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Administrator.txt";
	String TPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Teacher.txt";
	String SPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Student.txt";
	String Path;

	/* 无参构造函数 */
	Person() {
		this("", "", "", "", "");
	}

	/* 有参构造函数 */
	Person(String ID, String name, String gender, String birthdate, String college) {
		this.ID = ID;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.college = college;
	}

	/* 方法1类 */
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

	/* 方法2类 */
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

	/* 抽象方法 */
	abstract void Info();

}

/* 管理员类 */
class Admin extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4344318444250372480L;
	/* 私有字段(岗位类型) */
	private String station;

	/* 无参构造函数，调用本类构造函数 */
	Admin() {
		this("");
	}

	/* 有参构造函数，调用本类构造函数 */
	Admin(String station) {
		this("", "", "", "", "", station);
	}

	/* 有参构造函数，调用父类构造函数 */
	Admin(String id, String name, String gender, String birthdate, String college, String station) {
		super(id, name, gender, birthdate, college);
		setstation(station);
	}

	/* 子类方法1类 */
	public String getstation() {
		return station;
	}

	/* 子类方法2类 */
	public void setstation(String sta) {
		station = sta;
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("岗位：" + getstation());
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

/* 教师类 */
class Teacher extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1060451648079550159L;
	private String TCHID;
	private String title;

	/* 无参构造函数，调用本类构造函数 */
	Teacher() {
		this("");
	}

	/* 有参构造函数，调用本类构造函数 */
	Teacher(String title) {
		this("", "", "", "", "", title);
	}

	/* 有参构造函数，调用父类构造函数 */
	Teacher(String id, String name, String gender, String birthdate, String college, String title) {
		super(id, name, gender, birthdate, college);
		setTCHID(TCHID);
		settitle(title);

	}

	/* 子类方法1类 */
	public String getTCHID() {
		return TCHID;
	}

	public String gettitle() {
		return title;
	}

	/* 子类方法2类 */
	public void setTCHID(String tid) {
		TCHID = tid;
	}

	public void settitle(String til) {
		title = til;
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("教师工号：" + getTCHID());
		System.out.println("职称：" + gettitle());
	}
}

/* 学生类 */
class Student extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6197451306449999342L;
	private String speciality;

	/* 无参构造函数，调用本类构造函数 */
	Student() {
		this("");
	}

	/* 有参构造函数，调用本类构造函数 */
	Student(String speciality) {
		this("", "", "", "", "", speciality);
	}

	/* 有参构造函数，调用父类构造函数 */
	Student(String STUID, String name, String gender, String birthdate, String college, String speciality) {
		super(STUID, name, gender, birthdate, college);
		setspeciality(speciality);

	}

	/* 子类方法1类 */
	public String getspeciality() {
		return speciality;
	}

	/* 子类方法2类 */
	public void setspeciality(String spec) {
		speciality = spec;
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("学号：" + getID());
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("专业：" + getspeciality());
	}
}