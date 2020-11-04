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

			out.write(a.getname() + "java\r\n"); // \r\n即为换行  
	    
			out.write("文件\r\n"); // \r\n即为换行  

			out.write("输入\r\n"); // \r\n即为换行  

			out.write("测试\r\n"); // \r\n即为换行  

			out.flush(); // 把缓存区内容压入文件  

			out.close(); // 最后记得关闭文件
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void RInfo() {		
		try {
            File fread = new File("D:/JavaWorkplace/ScoreInformation - Scanner/src/model/SData.txt"); // 要读取以上路径的output.txt文件  

            InputStreamReader reader = new InputStreamReader(new FileInputStream(fread)); // 建立一个输入流对象reader  

            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  

            String line = "";  

            line = br.readLine();  
            
            String[] word = line.split("\t");
            
            int i = 1;
            
            while (line != null) {  
            	System.out.print("第" + i + "行数据 = ");
            	
            	for(int j = 0 ; j < word.length ; j++ )
            	{
          			if(j + 1 == word.length) {
          				System.out.print(word[j]);
            			System.out.print("\n");
            			}
          			else
              			System.out.print(word[j] + "\t");
            	}
                line = br.readLine(); // 一次读入一行数据  
                
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
