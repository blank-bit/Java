package model;

public class ScoreInformation {
	public static void main(String[] args) {
		/**********************************/
		/*** ��̬���û���.Info()��ӡ�ֶ���Ϣ ***/
		/**********************************/
		Admin ad = new Admin("2000112", "��", "��", "2000323", "����", "����Ա");
//		Person te = new Teacher();
//		Person st = new Student();

//		ad.setname("��");
//		ad.setgender("��");
//		ad.setbirthdate("2000-01-01");
//		ad.setcollege("UESTC");
//		((Admin) ad).setstation("����Ա");

//		te.setname("��");
//		te.setgender("��");
//		te.setbirthdate("2001-01-10");
//		te.setcollege("UESTC");
//		((Teacher) te).setTCHID("20010110");
//		((Teacher) te).settitle("����");

//		st.setname("��");
//		st.setgender("��");
//		st.setbirthdate("2000-02-22");
//		st.setcollege("UESTC");
//		st.setID("20000222");
//		((Student) st).setspeciality("�������");

		ad.AddInfo(ad);
		ad = null;
		Admin admin = new Admin();
		ad = admin.ReadInfo();
		ad.Info();
		System.out.println(ad.getbirthdate());
//		te.Info();
//		System.out.println();
//		st.Info();

		/**********************************/
		/*** ������������󣬲���ӡ�ֶ���Ϣ ***/
		/**********************************/
//		Admin a = new Admin();
//		Teacher t = new Teacher();
//		Student s = new Student();
//		
//		a.setname("��");
//		a.setgender("��");
//		a.setbirthdate("2000-01-01");
//		a.setcollege("UESTC");
//		a.setstation("����Ա");
//		
//		t.setname("��");
//		t.setgender("��");
//		t.setbirthdate("2001-01-10");
//		t.setcollege("UESTC");
//		t.setTCHID("20010110");
//		t.settitle("����");
//		
//		s.setname("��");
//		s.setgender("��");
//		s.setbirthdate("2000-02-22");
//		s.setcollege("UESTC");
//		s.setSTUID("20000222");
//		s.setspeciality("�������");
//		
//		a.Info();
//		t.Info();
//		s.Info();

	}
}
