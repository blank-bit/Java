import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
		Solution a = new Solution();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		System.out.println(wordDict);
		
		a.wordBreak("catsanddog", wordDict);
	}
}
