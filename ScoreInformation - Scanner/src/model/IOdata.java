package model;

import java.util.*;
import java.io.*;


public class IOdata {
	
	Admin a = new Admin();
	
	Scanner sc = new Scanner(System.in);
	String Path = "D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt"; 
	
	public void AddInf() {
	try {
			File fwrite = new File(Path);

			BufferedWriter out = new BufferedWriter(new FileWriter(fwrite,true));  

			out.write(a.getname() + "java\r\n"); // \r\n��Ϊ����  
	    
			out.write("�ļ�\r\n"); // \r\n��Ϊ����  

			out.write("����\r\n"); // \r\n��Ϊ����  

			out.write("����\r\n"); // \r\n��Ϊ����  

			out.flush(); // �ѻ���������ѹ���ļ�  

			out.close(); // ���ǵùر��ļ�
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void RInfo() {		
		try {
            File fread = new File("D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt"); // Ҫ��ȡ����·����output.txt�ļ�  

            InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // ����һ������������reader  

            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  

            String line = "";  

            line = br.readLine();  
            
            String[] word = line.split("\t");
            
            int i = 1;
            
            while (line != null) {  
            	System.out.print("��" + i + "������ = ");
            	
            	for(int j = 0 ; j < word.length ; j++ )
            	{
          			if(j + 1 == word.length) {
          				System.out.print(word[j]);
            			System.out.print("\n");
            			}
          			else
              			System.out.print(word[j] + "\t");
            	}
                line = br.readLine(); // һ�ζ���һ������  
                
                if(line != null)
                	word = line.split("\t");
                
                i++;
            }
            
            br.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void DelInf() {
	try {
		String s = sc.next();
		BufferedReader br=new BufferedReader(new FileReader( "D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt"));
		StringBuffer sb = new StringBuffer();
		String temp = null;

		while((temp = br.readLine())!=null)
		{			
			if(temp.contains(s)) 
				continue;
			
			sb.append(temp).append( "\r\n");
		}
		br.close();
		BufferedWriter bw=new BufferedWriter(new FileWriter( "D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt"));
		bw.write(sb.toString());
		bw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
