package model;

import java.util.Scanner;

/*基类*/
abstract class Person {
/*私有字段(姓名、性别、出生年月、学院)*/
	private String name;
	private String gender;
	private String birthdate;
	private String college;
	
	Scanner sc = new Scanner(System.in);
/*无参构造函数*/
	Person(){
		this("","","","");
	}

/*有参构造函数*/
	Person(String name, String gender, String birthdate, String college){
		this.name = name;	
		this.gender = gender;
		this.birthdate = birthdate;
		this.college = college;
	}

/*方法1类*/
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

/*方法2类*/
	public void setname() {
		//System.out.println("请输入姓名：");
		name = sc.next();
	}
	
	public void setgender() {
		System.out.println("请输入性别：");
		gender = sc.next();;
	}
	public void setbirthdate() {
		System.out.println("请输入出生年月：");
		birthdate = sc.next();
	}
	public void setcollege() {
		System.out.println("请输入学院：");
		college = sc.next();
	}

/*抽象方法*/
	abstract void Info();

}



/*管理员类*/
class Admin extends Person{
/*私有字段(岗位类型)*/	
	private String station;

/*无参构造函数，调用本类构造函数*/
	Admin(){
		this("");
	}

/*有参构造函数，调用本类构造函数*/
	Admin(String station){
		this("","","","",station);
	}

/*有参构造函数，调用父类构造函数*/	
	Admin(String name, String gender, String birthdate, String college,String station){
		super(name, gender, birthdate, college);
		this.station = station;
	}

/*子类方法1类*/
	public String getstation() {
		return station;
	}

/*子类方法2类*/
	//方法覆盖
	public void setname() {
		System.out.println("请输入管理员姓名：");
		super.setname();
	}
	
	public void setstation() {
		System.out.println("请输入岗位：");
		station = sc.next();
	}
	
/*方法覆盖*/
	void Info() {
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("岗位：" + getstation());
	}
}


/*教师类*/
class Teacher extends Person{
	private String TCHID;
	private String title;

/*无参构造函数，调用本类构造函数*/
	Teacher(){
		this("","");
	}

/*有参构造函数，调用本类构造函数*/	
	Teacher(String TCHID, String title){
		this("","","","", TCHID, title);
	}

/*有参构造函数，调用父类构造函数*/
	Teacher(String name, String gender, String birthdate, String college, String TCHID, String title){
		super(name, gender, birthdate, college);
		this.TCHID = TCHID;
		this.title = title;		
	}

/*子类方法1类*/
	public String getTCHID() {
		return TCHID;
	}
	
	public String gettitle() {
		return title;
	}

	
/*子类方法2类*/
	//方法覆盖
	public void setname() {
		System.out.println("请输入教师姓名：");
		super.setname();
	}
	public void setTCHID() {
		System.out.println("请输入教师工号：");
		TCHID = sc.next();
	}
	
	public void settitle() {
		System.out.println("请输入职称：");
		title = sc.next();
	}

/*方法覆盖*/
	void Info() {
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("教师工号：" + getTCHID());
		System.out.println("职称：" + gettitle());		
	}
}


/*学生类*/
class Student extends Person{
	private String STUID;
	private String speciality;

/*无参构造函数，调用本类构造函数*/
	Student(){
		this("","");
	}

/*有参构造函数，调用本类构造函数*/
	Student(String STUID, String speciality){
		this("","","","", STUID, speciality);
	}
	
/*有参构造函数，调用父类构造函数*/
	Student(String name, String gender, String birthdate, String college, String STUID, String speciality){
		super(name, gender, birthdate, college);
		this.STUID = STUID;
		this.speciality = speciality;
	}

/*子类方法1类*/
	public String getSTUID() {
		return STUID;
	}
	
	public String getspeciality() {
		return speciality;
	}

/*子类方法2类*/
	//方法覆盖
	public void setname() {
		System.out.println("请输入学生姓名：");
		super.setname();
	}
	
	public void setSTUID() {
		System.out.println("请输入学号：");
		STUID = sc.next();
	}
	
	public void setspeciality() {
		System.out.println("请输入专业：");
		speciality = sc.next();
	}
	
/*方法覆盖*/
	void Info() {
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("学号：" + getSTUID());
		System.out.println("专业：" + getspeciality());		
	}
}