package model;

import java.util.Scanner;

/*����*/
abstract class Person {
/*˽���ֶ�(�������Ա𡢳������¡�ѧԺ)*/
	private String name;
	private String gender;
	private String birthdate;
	private String college;
	
	Scanner sc = new Scanner(System.in);
/*�޲ι��캯��*/
	Person(){
		this("","","","");
	}

/*�вι��캯��*/
	Person(String name, String gender, String birthdate, String college){
		this.name = name;	
		this.gender = gender;
		this.birthdate = birthdate;
		this.college = college;
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
	public void setname() {
		//System.out.println("������������");
		name = sc.next();
	}
	
	public void setgender() {
		System.out.println("�������Ա�");
		gender = sc.next();;
	}
	public void setbirthdate() {
		System.out.println("������������£�");
		birthdate = sc.next();
	}
	public void setcollege() {
		System.out.println("������ѧԺ��");
		college = sc.next();
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
		this.station = station;
	}

/*���෽��1��*/
	public String getstation() {
		return station;
	}

/*���෽��2��*/
	//��������
	public void setname() {
		System.out.println("���������Ա������");
		super.setname();
	}
	
	public void setstation() {
		System.out.println("�������λ��");
		station = sc.next();
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
		this.TCHID = TCHID;
		this.title = title;		
	}

/*���෽��1��*/
	public String getTCHID() {
		return TCHID;
	}
	
	public String gettitle() {
		return title;
	}

	
/*���෽��2��*/
	//��������
	public void setname() {
		System.out.println("�������ʦ������");
		super.setname();
	}
	public void setTCHID() {
		System.out.println("�������ʦ���ţ�");
		TCHID = sc.next();
	}
	
	public void settitle() {
		System.out.println("������ְ�ƣ�");
		title = sc.next();
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
		this.STUID = STUID;
		this.speciality = speciality;
	}

/*���෽��1��*/
	public String getSTUID() {
		return STUID;
	}
	
	public String getspeciality() {
		return speciality;
	}

/*���෽��2��*/
	//��������
	public void setname() {
		System.out.println("������ѧ��������");
		super.setname();
	}
	
	public void setSTUID() {
		System.out.println("������ѧ�ţ�");
		STUID = sc.next();
	}
	
	public void setspeciality() {
		System.out.println("������רҵ��");
		speciality = sc.next();
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