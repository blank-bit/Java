package model;

public class ScoreInformation_Scanner {
	public static void main(String[] args) {

//		DataFile f1 = new DataFile();
//		DataFile f2 = new DataFile();
//		DataFile f3 = new DataFile();
//		f1.CreateFile("D:/JavaWorkplace/ScoreInformation - Scanner/src/model/AData.txt");
//		f2.CreateFile("D:/JavaWorkplace/ScoreInformation - Scanner/src/model/TData.txt");
//		f3.CreateFile("D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt");

		/**********************************/
		/*** 多态，用基类.Info()打印字段信息 ***/
		/**********************************/
//		Person ad = new Admin();
//		Person te = new Teacher();
//		Person st = new Student();
//		
//		ad.setname();
//		ad.setgender();
//		ad.setbirthdate();
//		ad.setcollege();
//		((Admin)ad).setstation();
//		
//		te.setname();
//		te.setgender();
//		te.setbirthdate();
//		te.setcollege();
//		((Teacher)te).setTCHID();
//		((Teacher)te).settitle();
//		
//		st.setname();
//		st.setgender();
//		st.setbirthdate();
//		st.setcollege();
//		((Student)st).setSTUID();
//		((Student)st).setspeciality();
//		
//		ad.Info();
//		System.out.println();
//		te.Info();
//		System.out.println();
//		st.Info();

		/**********************************/
		/*** 定义派生类对象，并打印字段信息 ***/
		/**********************************/
//		Admin a = new Admin();
//		Teacher t = new Teacher();
//		Student s = new Student();

//		a.setID();
//		a.setname();
//		a.setgender();
//		a.setbirthdate();
//		a.setcollege();
//		a.setstation();
//
//		t.setID();
//		t.setname();
//		t.setgender();
//		t.setbirthdate();
//		t.setcollege();
//		t.settitle();
//
//		s.setID();
//		s.setname();
//		s.setgender();
//		s.setbirthdate();
//		s.setcollege();
//		s.setspeciality();

//		a.AddInf();
//		t.AddInf();
//		s.AddInf();
//		a.RInfo();
//
//		a = a.CreatObj(1);
//		t = t.CreatObj(1);
//		s = s.CreatObj(1);
//
//		a.Info();
//		t.Info();
//		s.Info();
//
//		a.RInfo();
//		t.RInfo();
//		s.RInfo();
//		a.DelInf();
//		t.DelInf();
//		s.DelInf();
//		a.RInfo();
//		t.RInfo();
//		s.RInfo();

//		IOdata re = new IOdata();
//		
//		re.AddInf();
//		re.DelInf();
//		re.RInfo();

//		IOdata rt = new IOdata();
//		
//		rt.RInfo();

		Course course = new Course();
		Course c = new Course();
//		course.setcid();
//		course.setcourse();
//		course.setvalue();
//		course.settime();
//		course.setTCHid();
//		course.setTCHname();
//		c.setcid();
//		c.setcourse();
//		c.setvalue();
//		c.settime();
//		c.setTCHid();
//		c.setTCHname();
//
//		course.AddInf();
//		c.AddInf();

		course = course.CreatObj(2);
		c = c.CreatObj(1);

		course.Info();
		c.Info();

		c.IsExit();
	}
}
