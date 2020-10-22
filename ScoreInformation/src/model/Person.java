package model;

/*����*/
abstract class Person {
/*˽���ֶ�(�������Ա𡢳������¡�ѧԺ)*/
	private String name;
	private String gender;
	private String birthdate;
	private String college;
	
/*�޲ι��캯��*/
	Person(){
		this("","","","");
	}

/*�вι��캯��*/
	Person(String name, String gender, String birthdate, String college){
		setname(name);
		setgender(gender);
		setbirthdate(birthdate);
		setcollege(college);	
	}

/*����1��*/
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

/*����2��*/
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

/*���󷽷�*/
	abstract void Info();

}



/*����Ա��*/
class Admin extends Person{
/*˽���ֶ�(��λ����)*/	
	private String station;

/*�޲ι��캯�������ñ��๹�캯��*/
	Admin(){
		this("");
	}

/*�вι��캯�������ñ��๹�캯��*/
	Admin(String station){
		this("","","","",station);
	}

/*�вι��캯�������ø��๹�캯��*/	
	Admin(String name, String gender, String birthdate, String college,String station){
		super(name, gender, birthdate, college);
		setstation(station);
	}

/*���෽��1��*/
	public String getstation() {
		return station;
	}

/*���෽��2��*/
	public void setstation(String sta) {
		station = sta;
	}
	
/*��������*/
	void Info() {
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("��λ��" + getstation());
	}
}


/*��ʦ��*/
class Teacher extends Person{
	private String TCHID;
	private String title;

/*�޲ι��캯�������ñ��๹�캯��*/
	Teacher(){
		this("","");
	}

/*�вι��캯�������ñ��๹�캯��*/	
	Teacher(String TCHID, String title){
		this("","","","", TCHID, title);
	}

/*�вι��캯�������ø��๹�캯��*/
	Teacher(String name, String gender, String birthdate, String college, String TCHID, String title){
		super(name, gender, birthdate, college);
		setTCHID(TCHID);
		settitle(title);
		
	}

/*���෽��1��*/
	public String getTCHID() {
		return TCHID;
	}
	
	public String gettitle() {
		return title;
	}

	
/*���෽��2��*/
	public void setTCHID(String tid) {
		TCHID = tid;
	}
	
	public void settitle(String til) {
		title = til;
	}

/*��������*/
	void Info() {
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("��ʦ���ţ�" + getTCHID());
		System.out.println("ְ�ƣ�" + gettitle());		
	}
}


/*ѧ����*/
class Student extends Person{
	private String STUID;
	private String speciality;

/*�޲ι��캯�������ñ��๹�캯��*/
	Student(){
		this("","");
	}

/*�вι��캯�������ñ��๹�캯��*/
	Student(String STUID, String speciality){
		this("","","","", STUID, speciality);
	}
	
/*�вι��캯�������ø��๹�캯��*/
	Student(String name, String gender, String birthdate, String college, String STUID, String speciality){
		super(name, gender, birthdate, college);
		setSTUID(STUID);
		setspeciality(speciality);

	}

/*���෽��1��*/
	public String getSTUID() {
		return STUID;
	}
	
	public String getspeciality() {
		return speciality;
	}

/*���෽��2��*/
	public void setSTUID(String sid) {
		STUID = sid;
	}
	
	public void setspeciality(String spec) {
		speciality = spec;
	}
	
/*��������*/
	void Info() {
		System.out.println("������" + getname());
		System.out.println("�Ա�" + getgender());
		System.out.println("�������£�" + getbirthdate());
		System.out.println("ѧԺ��" + getcollege());
		System.out.println("ѧ�ţ�" + getSTUID());
		System.out.println("רҵ��" + getspeciality());		
	}
}