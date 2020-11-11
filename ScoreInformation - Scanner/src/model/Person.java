package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*基类*/
abstract class Person {
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

	Scanner sc = new Scanner(System.in);

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
	public void setID() {
		ID = sc.next();
	}

	public void setname() {
		name = sc.next();
	}

	public void setgender() {
		System.out.println("请输入性别：");
		gender = sc.next();
	}

	public void setbirthdate() {
		System.out.println("请输入出生年月：");
		birthdate = sc.next();
	}

	public void setcollege() {
		System.out.println("请输入学院：");
		college = sc.next();
	}

	/* 抽象方法 */
	abstract void Info();

	/****************************************/
	/************ 添加到文件 ****************/
	/****************************************/
	public void AddInf(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getID() + " ");

			out.write(getname() + " ");

			out.write(getgender() + " ");

			out.write(getbirthdate() + " ");

			out.write(getcollege() + " "); // \r\n即为换行

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/****************************************/
	/************ 从文件读取 ****************/
	/****************************************/
	public void RInfo(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			File fread = new File(Path);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread));

			BufferedReader br = new BufferedReader(reader);

			String line = "";

			line = br.readLine();

			String[] word = line.split(" ");

			while (line != null) {

				for (int j = 0; j < word.length; j++) {

					if (j + 1 == word.length) {
						System.out.print(String.format("%-12s", word[j]));
						System.out.print("\n");
					} else
						System.out.print(String.format("%-12s", word[j]) + "\t");
				}
				line = br.readLine(); // 一次读入一行数据

				if (line != null)
					word = line.split(" ");
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("\n");
	}

	/****************************************/
	/************ 从文件中删除 **************/
	/****************************************/
	public void DelInf(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		System.out.print("请输入要删除的姓名：");

		String s = sc.next();

		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));
			StringBuffer sb = new StringBuffer();
			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(s))
					continue;

				sb.append(temp).append("\r\n");
			}
			br.close();

			BufferedWriter bw = new BufferedWriter(new FileWriter(Path));

			bw.write(sb.toString());// 返回此序列中数据的字符串表示形式
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/****************************************/
	/************ 删除文件所有内容 **********/
	/****************************************/
	public void DelAll(String type) {

		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Path));
			out.write("");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************************/
	/************ 从文件中重构 **************/
	/****************************************/
	public Person CreatObj(String type, int num) {

		int i = 0;
		Person a = null;
		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		LineNum lineNum = new LineNum();
		int l = lineNum.getLineNumber(Path);

		if (num > l || num < 1) {
			System.out.println("构造失败！！");
			return null;
		}

		try {
			File fread = new File(Path);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(fread));

			BufferedReader br = new BufferedReader(reader);

			String line = "";
			while (i < num) {
				line = br.readLine();
				i++;
			}

			String[] word = line.split(" ");

			if (type == "Admin")
				a = new Admin(word[0], word[1], word[2], word[3], word[4], word[5]);
			if (type == "Teacher")
				a = new Teacher(word[0], word[1], word[2], word[3], word[4], word[5], word[6]);
			if (type == "Student")
				a = new Student(word[0], word[1], word[2], word[3], word[4], word[5]);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	/****************************************/
	/************ 设置所有字段 **************/
	/****************************************/
	public void setAll() {
		setID();
		setname();
		setgender();
		setbirthdate();
		setcollege();
	}

	/****************************************/
	/************ 判断是否存在 **************/
	/****************************************/
	public boolean IsExit(String type) {
		switch (type) {
		case "Admin":
			Path = APath;
			break;
		case "Teacher":
			Path = TPath;
			break;
		case "Student":
			Path = SPath;
			break;
		default:
			System.out.println("ERROR");
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));

			String temp = null;

			while ((temp = br.readLine()) != null) {
				if (temp.contains(getID())) {
					br.close();
					return true;
				}
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean IsNext() {
		String s;
		s = sc.next();
		if (s.equals("Y") || s.equals("y"))
			return true;

		// System.out.println("期待您下次使用！");
		return false;
	}

	abstract void start();
//	public void start(String type) {
//		System.out.println("是否设置该对象的值(Y/N)：");
//		if (IsNext()) {
//			setAll();
//			System.out.println("是否添加到文件中(Y/N)：");
//			if (IsNext()) {
//				AddInf(type);
//				System.out.println("是否打印该对象的信息(Y/N)：");
//				if (IsNext()) {
//					Info();
//					System.out.println("是否打印文件信息(Y/N)：");
//					if (IsNext()) {
//						RInfo(type);
//					} else
//						return;
//				} else
//					return;
//			} else
//				return;
//		} else
//			return;
//	}
}

/* 管理员类 */
class Admin extends Person {
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
		this.station = station;
	}

	/* 子类方法1类 */
	public String getstation() {
		return station;
	}

	/* 子类方法2类 */
	// 方法覆盖
	public void setID() {
		System.out.println("请输入管理员工号：");
		super.setID();
	}

	public void setname() {
		System.out.println("请输入管理员姓名：");
		super.setname();
	}

	public void setstation() {
		System.out.println("请输入岗位：");
		station = sc.next();
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("工号：" + getID());
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("岗位：" + getstation());
		System.out.println();
	}

	public Admin CreatObj(int num) {
		Admin a = null;
		a = (Admin) super.CreatObj("Admin", num);
		return a;
	}

	public void AddInf() {
		if (IsExit("Admin")) {
//			System.out.println("已存在！");
			return;
		}
		super.AddInf("Admin");

		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getstation() + "\r\n");

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("管理员工号\t" + "管理员姓名\t" + "管理员性别\t" + "管理员出生日期\t" + "管理员学院\t" + "管理员职位");
		super.RInfo("Admin");
	}

	public void DelInf() {
		super.DelInf("Admin");
	}

	public void setAll() {
		super.setAll();
		setstation();
		System.out.println();
	}

	public void start() {
		System.out.println("管理员类");
		System.out.println("是否设置该对象的值(Y/N)：");
		if (IsNext()) {
			setAll();
			System.out.println("是否添加到文件中(Y/N)：");
			if (IsNext()) {
				AddInf();
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
	}
}

/* 教师类 */
class Teacher extends Person {
	private String graduate;
	private String title;

	/* 无参构造函数，调用本类构造函数 */
	Teacher() {
		this("", "");
	}

	/* 有参构造函数，调用本类构造函数 */
	Teacher(String graduate, String title) {
		this("", "", "", "", "", graduate, title);
	}

	/* 有参构造函数，调用父类构造函数 */
	Teacher(String id, String name, String gender, String birthdate, String college, String graduate, String title) {
		super(id, name, gender, birthdate, college);
		this.graduate = graduate;
		this.title = title;
	}

	/* 子类方法1类 */
	public String getgraduate() {
		return graduate;
	}

	public String gettitle() {
		return title;
	}

	/* 子类方法2类 */
	// 方法覆盖
	public void setID() {
		System.out.println("请输入教师工号：");
		super.setID();
	}

	public void setname() {
		System.out.println("请输入教师姓名：");
		super.setname();
	}

	public void setgraduate() {
		System.out.println("请输入教师毕业专业：");
		this.graduate = sc.next();
	}

	public void settitle() {
		System.out.println("请输入职称：");
		title = sc.next();
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("教师工号：" + getID());
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("毕业专业：" + getcollege());
		System.out.println("职称：" + gettitle());
		System.out.println();
	}

	public void AddInf() {
		if (IsExit("Teacher")) {
//			System.out.println("已存在！");
			return;
		}
		super.AddInf("Teacher");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getgraduate() + " ");

			out.write(gettitle() + "\r\n");

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("教师工号\t\t" + "教师姓名\t\t" + "教师性别\t\t" + "教师出生日期\t" + "教师学院\t\t" + "毕业专业\t\t" + "教师职称");
		super.RInfo("Teacher");
	}

	public void DelInf() {
		super.DelInf("Teacher");
	}

	public Teacher CreatObj(int num) {
		Teacher a = null;
		a = (Teacher) super.CreatObj("Teacher", num);
		return a;
	}

	public void setAll() {
		super.setAll();
		setgraduate();
		settitle();
	}

	public void start() {
		System.out.println("教师类");
		System.out.println("是否设置该对象的值(Y/N)：");
		if (IsNext()) {
			setAll();
			System.out.println("是否添加到文件中(Y/N)：");
			if (IsNext()) {
				AddInf();
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
	}
}

/* 学生类 */
class Student extends Person {
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
	Student(String id, String name, String gender, String birthdate, String college, String speciality) {
		super(id, name, gender, birthdate, college);
		this.speciality = speciality;
	}

	/* 子类方法1类 */
	public String getspeciality() {
		return speciality;
	}

	/* 子类方法2类 */
	// 方法覆盖
	public void setID() {
		System.out.println("请输入学号：");
		super.setID();
	}

	public void setname() {
		System.out.println("请输入学生姓名：");
		super.setname();
	}

	public void setspeciality() {
		System.out.println("请输入专业：");
		speciality = sc.next();
	}

	/* 方法覆盖 */
	void Info() {
		System.out.println("学号：" + getID());
		System.out.println("姓名：" + getname());
		System.out.println("性别：" + getgender());
		System.out.println("出生年月：" + getbirthdate());
		System.out.println("学院：" + getcollege());
		System.out.println("专业：" + getspeciality());
		System.out.println();
	}

	public void AddInf() {
		if (IsExit("Student")) {
//			System.out.println("已存在！");
			return;
		}
		super.AddInf("Student");
		try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite, true));

			out.write(getspeciality() + "\r\n");

			out.flush(); // 把缓存区内容压入文件

			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RInfo() {
		System.out.println("学生学号\t\t" + "学生姓名\t\t" + "学生性别\t\t" + "学生出生日期\t" + "学生学院\t\t" + "学生专业");
		super.RInfo("Student");
	}

	public void DelInf() {
		super.DelInf("Student");
	}

	public Student CreatObj(int num) {
		Student a = null;
		a = (Student) super.CreatObj("Student", num);
		return a;
	}

	public void setAll() {
		super.setAll();
		setspeciality();
	}

	public void start() {
		System.out.println("学生类");
		System.out.println("是否设置该对象的值(Y/N)：");
		if (IsNext()) {
			setAll();
			System.out.println("是否添加到文件中(Y/N)：");
			if (IsNext()) {
				AddInf();
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			} else {
				System.out.println("是否打印该对象的信息(Y/N)：");
				if (IsNext()) {
					Info();
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				} else {
					System.out.println("是否打印文件信息(Y/N)：");
					if (IsNext()) {
						RInfo();
					}
				}
			}
		} else
			return;
	}
}