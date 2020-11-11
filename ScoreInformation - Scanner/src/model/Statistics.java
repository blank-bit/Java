package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Statistics {
	private float excellent;
	private float good;
	private float passed;
	private float failed;

	String JPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/Java.txt";
	String CPath = "D:/JavaWorkplace/ScoreInformation - Scanner/data/C.txt";
	String Path;

	public List<Float> calculation(String course) {

		List<Integer> elist = new ArrayList<Integer>();
		List<Integer> glist = new ArrayList<Integer>();
		List<Integer> plist = new ArrayList<Integer>();
		List<Integer> flist = new ArrayList<Integer>();

//		if (course == "Java")
		for (int i = 0; i < getnum(course); i++) {
			Grade grade = new Grade();
			Grade aGrade = new Grade();
			aGrade = grade.CreatObj(course, i + 1);
			int n = Integer.parseInt(aGrade.getScore());

			if (n >= 85)
				elist.add(n);
			else if (n >= 75)
				glist.add(n);
			else if (n >= 60)
				plist.add(n);
			else
				flist.add(n);
		}
//		else if (course == "C")
//			for (int i = 0; i < getnum(course); i++) {
//				Grade grade = new Grade();
//				Grade aGrade = new Grade();
//				aGrade = grade.CreatObj("C", i + 1);
//				int n = Integer.parseInt(aGrade.getScore());
//
//				if (n >= 85)
//					elist.add(n);
//				else if (n >= 75)
//					glist.add(n);
//				else if (n >= 60)
//					plist.add(n);
//				else
//					flist.add(n);
//			}

		List<Float> list = new ArrayList<>();

		list.add((float) elist.size() / getnum(course));
		list.add((float) glist.size() / getnum(course));
		list.add((float) plist.size() / getnum(course));
		list.add((float) flist.size() / getnum(course));

		return list;
	}

	public int getnum(String course) {
		switch (course) {
		case "Java":
			Path = JPath;
			break;
		case "C":
			Path = CPath;
			break;
		default:
			System.out.println("ERROR");
			break;
		}

		LineNum Num = new LineNum();

		int n = 0;

		n = Num.getLineNumber(Path);

		return n;
	}

	public float getexcellent(List<Float> list) {
		excellent = list.get(0);
		return excellent;
	}

	public float getgood(List<Float> list) {
		good = list.get(1);
		return good;
	}

	public float getpassed(List<Float> list) {
		passed = list.get(2);
		return passed;
	}

	public float getfailed(List<Float> list) {
		failed = list.get(3);
		return failed;
	}

	public void Info(List<Float> list, String course) {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(course + "优人数占比为：" + df.format(getexcellent(list) * 100) + "%\n" + "人数为："
				+ (int) (getexcellent(list) * getnum(course)) + "\n");
		System.out.println(course + "良人数占比为：" + df.format(getgood(list) * 100) + "%\n" + "人数为："
				+ (int) (getgood(list) * getnum(course)) + "\n");
		System.out.println(course + "及格人数占比为：" + df.format(getpassed(list) * 100) + "%\n" + "人数为："
				+ (int) (getpassed(list) * getnum(course)) + "\n");
		System.out.println(course + "不及格人数占比为：" + df.format(getfailed(list) * 100) + "%\n" + "人数为："
				+ (int) (getfailed(list) * getnum(course)) + "\n");
		System.out.println();
	}

	public void start(String s) {
		List<Float> list = null;
		list = calculation(s);
		Info(list, s);
	}

}
