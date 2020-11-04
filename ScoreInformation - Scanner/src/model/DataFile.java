package model;

import java.io.*;

public class DataFile {
	public boolean CreateFile(String Filename)
	{
		File file = new File(Filename);
		if(file.exists()) {
            System.out.println("创建单个文件" + Filename + "失败，目标文件已存在！");
            return false;
        }
		
		//文件名以"/或\"结尾
        if (Filename.endsWith(File.separator)) {
            System.out.println("创建单个文件" + Filename + "失败，目标文件不能为(文件夹)目录！");
            return false;
        }
        
        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()) {
            	
            	//mkdir()：只能创建一层目录， 如:
            	//File file = new File("e:/test");
            	//file.mkdir();
            	//这样会在e:/路径下创建test目录.

            	//mkdirs(): 创建多层目录，如：
            	//File file = new File("e:/test/0930");
            	//file.mkdirs();
            	
            	//这样，你调用getParentFile().mkdirs， 
          		//如果在没有这个文件夹的情况下，他会创建出来，之后
          		//你在使用 file.createNewFile();  这样可以绝对保证，文件创建成功，
            	//因为文件所在的目录 在没有的情况下已经创建了。
            	
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }
        
        //创建目标文件
        try {
        	//可能出现异常的代码
            if (file.createNewFile()) {
            	//java中createNewFile方法主要是如果该文件已经存在，则不创建，返回一个false，如果没有，则返回true
            	//仅仅是文件，不包括文件夹（目录）
                System.out.println("创建单个文件" + Filename + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + Filename + "失败！");
                return false;
            }
        } catch (IOException e) {
        	
        	//IOException 是使用流、文件和目录访问信息时引发的异常的基类。
        	//当你要使用流,文件,目录访问时需要使用,
        	//比如读取一段输入流发生异常,写入一个文件发生异常等等
        	
            e.printStackTrace();//捕获异常的语句：e.printStackTrace();
            /*e是Throwable的实例异常对象，用在catch语句中，相当于一个形参，
             	* 一旦try捕获到了异常，那么就将这个异常信息交给e，
             	* 由e处理，printStackTrace()是异常类的一个方法。
             	* 与它重载的方法还有printStackTrace(PrintStream s) 和printStackTrace(PrintWriter s)。
           
            *e.toString()：  获得异常种类和错误信息

			*e.getMessage():获得错误信息

			*e.printStackTrace()：在控制台打印出异常种类，错误信息和出错位置等
			
             */
            System.out.println("创建单个文件" + Filename + "失败！" + e.getMessage());
            return false;
        }
        /* try {
        	  *可能出现异常的代码
        	  *} 
        	  *catch（异常类名A e）{
        	  *如果出现了异常类A类型的异常，那么执行该代码
        	  *} ...（catch可以有多个）
        	  * finally {
        	  *最终肯定必须要执行的代码（例如释放资源的代码）
        	  *}(可选)
        */
    }
	
	

public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {//不是以"\或/"结尾，添加"\或/"
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
	}

public static String createTempFile(String prefix, String suffix, String dirName) {
    File tempFile = null;
    if (dirName == null) {
        try{
            //在默认文件夹下创建临时文件
            tempFile = File.createTempFile(prefix, suffix);
            //返回临时文件的路径
            return tempFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建临时文件失败！" + e.getMessage());
            return null;
        }
    } else {
        File dir = new File(dirName);
        //如果临时文件所在目录不存在，首先创建
        if (!dir.exists()) {
            if (!DataFile.createDir(dirName)) {
                System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
                return null;
            }
        }
        try {
            //在指定目录下创建临时文件
            tempFile = File.createTempFile(prefix, suffix, dir);
            return tempFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建临时文件失败！" + e.getMessage());
            return null;
        }
    	}
	}
}


