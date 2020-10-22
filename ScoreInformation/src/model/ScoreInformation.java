package model;

public class ScoreInformation {
	public static void main(String[] args) {
/**********************************/
/***多态，用基类.Info()打印字段信息***/
/**********************************/
		Person ad = new Admin();
		Person te = new Teacher();
		Person st = new Student();
		
		ad.setname("程");
		ad.setgender("男");
		ad.setbirthdate("2000-01-01");
		ad.setcollege("UESTC");
		((Admin)ad).setstation("辅导员");
		
		te.setname("王");
		te.setgender("男");
		te.setbirthdate("2001-01-10");
		te.setcollege("UESTC");
		((Teacher)te).setTCHID("20010110");
		((Teacher)te).settitle("教授");
		
		st.setname("李");
		st.setgender("男");
		st.setbirthdate("2000-02-22");
		st.setcollege("UESTC");
		((Student)st).setSTUID("20000222");
		((Student)st).setspeciality("软件工程");

		ad.Info();
		System.out.println();
		te.Info();
		System.out.println();
		st.Info();
		
		
/**********************************/
/***定义派生类对象，并打印字段信息***/
/**********************************/		
//		Admin a = new Admin();
//		Teacher t = new Teacher();
//		Student s = new Student();
//		
//		a.setname("程");
//		a.setgender("男");
//		a.setbirthdate("2000-01-01");
//		a.setcollege("UESTC");
//		a.setstation("辅导员");
//		
//		t.setname("王");
//		t.setgender("男");
//		t.setbirthdate("2001-01-10");
//		t.setcollege("UESTC");
//		t.setTCHID("20010110");
//		t.settitle("教授");
//		
//		s.setname("李");
//		s.setgender("男");
//		s.setbirthdate("2000-02-22");
//		s.setcollege("UESTC");
//		s.setSTUID("20000222");
//		s.setspeciality("软件工程");
//		
//		a.Info();
//		t.Info();
//		s.Info();

	}
}
