package model;

import java.io.*;

public class DataFile {
	public boolean CreateFile(String Filename)
	{
		File file = new File(Filename);
		if(file.exists()) {
            System.out.println("���������ļ�" + Filename + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�");
            return false;
        }
		
		//�ļ�����"/��\"��β
        if (Filename.endsWith(File.separator)) {
            System.out.println("���������ļ�" + Filename + "ʧ�ܣ�Ŀ���ļ�����Ϊ(�ļ���)Ŀ¼��");
            return false;
        }
        
        //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
        if(!file.getParentFile().exists()) {
            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
            System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
            if(!file.getParentFile().mkdirs()) {
            	
            	//mkdir()��ֻ�ܴ���һ��Ŀ¼�� ��:
            	//File file = new File("e:/test");
            	//file.mkdir();
            	//��������e:/·���´���testĿ¼.

            	//mkdirs(): �������Ŀ¼���磺
            	//File file = new File("e:/test/0930");
            	//file.mkdirs();
            	
            	//�����������getParentFile().mkdirs�� 
          		//�����û������ļ��е�����£����ᴴ��������֮��
          		//����ʹ�� file.createNewFile();  �������Ծ��Ա�֤���ļ������ɹ���
            	//��Ϊ�ļ����ڵ�Ŀ¼ ��û�е�������Ѿ������ˡ�
            	
                System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");
                return false;
            }
        }
        
        //����Ŀ���ļ�
        try {
        	//���ܳ����쳣�Ĵ���
            if (file.createNewFile()) {
            	//java��createNewFile������Ҫ��������ļ��Ѿ����ڣ��򲻴���������һ��false�����û�У��򷵻�true
            	//�������ļ����������ļ��У�Ŀ¼��
                System.out.println("���������ļ�" + Filename + "�ɹ���");
                return true;
            } else {
                System.out.println("���������ļ�" + Filename + "ʧ�ܣ�");
                return false;
            }
        } catch (IOException e) {
        	
        	//IOException ��ʹ�������ļ���Ŀ¼������Ϣʱ�������쳣�Ļ��ࡣ
        	//����Ҫʹ����,�ļ�,Ŀ¼����ʱ��Ҫʹ��,
        	//�����ȡһ�������������쳣,д��һ���ļ������쳣�ȵ�
        	
            e.printStackTrace();//�����쳣����䣺e.printStackTrace();
            /*e��Throwable��ʵ���쳣��������catch����У��൱��һ���βΣ�
             	* һ��try�������쳣����ô�ͽ�����쳣��Ϣ����e��
             	* ��e����printStackTrace()���쳣���һ��������
             	* �������صķ�������printStackTrace(PrintStream s) ��printStackTrace(PrintWriter s)��
           
            *e.toString()��  ����쳣����ʹ�����Ϣ

			*e.getMessage():��ô�����Ϣ

			*e.printStackTrace()���ڿ���̨��ӡ���쳣���࣬������Ϣ�ͳ���λ�õ�
			
             */
            System.out.println("���������ļ�" + Filename + "ʧ�ܣ�" + e.getMessage());
            return false;
        }
        /* try {
        	  *���ܳ����쳣�Ĵ���
        	  *} 
        	  *catch���쳣����A e��{
        	  *����������쳣��A���͵��쳣����ôִ�иô���
        	  *} ...��catch�����ж����
        	  * finally {
        	  *���տ϶�����Ҫִ�еĴ��루�����ͷ���Դ�Ĵ��룩
        	  *}(��ѡ)
        */
    }
	
	

public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {//������"\��/"��β�����"\��/"
            destDirName = destDirName + File.separator;
        }
        //����Ŀ¼
        if (dir.mkdirs()) {
            System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
            return true;
        } else {
            System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�");
            return false;
        }
	}

public static String createTempFile(String prefix, String suffix, String dirName) {
    File tempFile = null;
    if (dirName == null) {
        try{
            //��Ĭ���ļ����´�����ʱ�ļ�
            tempFile = File.createTempFile(prefix, suffix);
            //������ʱ�ļ���·��
            return tempFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());
            return null;
        }
    } else {
        File dir = new File(dirName);
        //�����ʱ�ļ�����Ŀ¼�����ڣ����ȴ���
        if (!dir.exists()) {
            if (!DataFile.createDir(dirName)) {
                System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��");
                return null;
            }
        }
        try {
            //��ָ��Ŀ¼�´�����ʱ�ļ�
            tempFile = File.createTempFile(prefix, suffix, dir);
            return tempFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());
            return null;
        }
    	}
	}
}


