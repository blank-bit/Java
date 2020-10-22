package model;

/*基类*/
abstract class Person {
/*私有字段(姓名、性别、出生年月、学院)*/
	private String name;
	private String gender;
	private String birthdate;
	private String college;
	
/*无参构造函数*/
	Person(){
		this("","","","");
	}

/*有参构造函数*/
	Person(String name, String gender, String birthdate, String college){
		setname(name);
		setgender(gender);
		setbirthdate(birthdate);
		setcollege(college);	
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
		setstation(station);
	}

/*子类方法1类*/
	public String getstation() {
		return station;
	}

/*子类方法2类*/
	public void setstation(String sta) {
		station = sta;
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
		setTCHID(TCHID);
		settitle(title);
		
	}

/*子类方法1类*/
	public String getTCHID() {
		return TCHID;
	}
	
	public String gettitle() {
		return title;
	}

	
/*子类方法2类*/
	public void setTCHID(String tid) {
		TCHID = tid;
	}
	
	public void settitle(String til) {
		title = til;
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
		setSTUID(STUID);
		setspeciality(speciality);

	}

/*子类方法1类*/
	public String getSTUID() {
		return STUID;
	}
	
	public String getspeciality() {
		return speciality;
	}

/*子类方法2类*/
	public void setSTUID(String sid) {
		STUID = sid;
	}
	
	public void setspeciality(String spec) {
		speciality = spec;
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