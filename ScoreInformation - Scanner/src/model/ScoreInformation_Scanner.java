package model;

public class ScoreInformation_Scanner {
	public static void main(String[] args) {
/**********************************/
/***��̬���û���.Info()��ӡ�ֶ���Ϣ***/
/**********************************/		
		Person ad = new Admin();
		Person te = new Teacher();
		Person st = new Student();
		
		ad.setname();
		ad.setgender();
		ad.setbirthdate();
		ad.setcollege();
		((Admin)ad).setstation();
		
		te.setname();
		te.setgender();
		te.setbirthdate();
		te.setcollege();
		((Teacher)te).setTCHID();
		((Teacher)te).settitle();
		
		st.setname();
		st.setgender();
		st.setbirthdate();
		st.setcollege();
		((Student)st).setSTUID();
		((Student)st).setspeciality();
		
		ad.Info();
		System.out.println();
		te.Info();
		System.out.println();
		st.Info();

		
/**********************************/
/***������������󣬲���ӡ�ֶ���Ϣ***/
/**********************************/
//		Admin a = new Admin();
//		Teacher t = new Teacher();
//		Student s = new Student();
//			
//		a.setname();
//		a.setgender();
//		a.setbirthdate();
//		a.setcollege();
//		a.setstation();
//		
//		t.setname();
//		t.setgender();
//		t.setbirthdate();
//		t.setcollege();
//		t.setTCHID();
//		t.settitle();
//		
//		s.setname();
//		s.setgender();
//		s.setbirthdate();
//		s.setcollege();
//		s.setSTUID();
//		s.setspeciality();
//		
//		a.Info();
//		System.out.println();
//		t.Info();
//		System.out.println();
//		s.Info();
		
	}
}

