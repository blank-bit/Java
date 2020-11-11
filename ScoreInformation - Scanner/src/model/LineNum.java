package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNum {

	public int getLineNumber(String Path) {

		File file = new File(Path);
		if (file.exists()) {
			if (file.length() != 0) {
				try {
					FileReader fileReader = new FileReader(Path);
					LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
					lineNumberReader.skip(Long.MAX_VALUE);// 开始一个字符一个字符的跳过 一直到最后一个字符。读取完成
					int lines = lineNumberReader.getLineNumber();
					fileReader.close();
					lineNumberReader.close();
					return lines;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return 0;
		}

		return 0;
	}
}
