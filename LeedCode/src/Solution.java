import java.util.ArrayList;
import java.util.List;;

public class Solution {

//    public List<String> wordBreak(String s, List<String> wordDict) {
	List<String> wordBreak(String s, List<String> wordDict) {

		List<String> b = new ArrayList<String>();

		// boolean[] d = new boolean[s.length()];
		String[] x = new String[100];
		String r = "";

		String[] a = new String[100];

		int begin = 0;

		int len = 0;
//		int m = 0;

		while (begin < s.length()) {

			rback(s, wordDict, begin, a, len);

			if (a != null) {
				for (int l = 0; l < a.length; l++) {
					if (a[l] != null && a[l + 1] != null)
						r = r + a[l] + " ";
					else if (a[l] != null)
						r = r + a[l];
				}
				b.add(r);
			}

			begin++;
		}

		System.out.println(b);

		return b;

	}

	int rback(String s, List<String> wordDict, int w, String[] a, int len) {
		System.out.println(w);
		String t = "";
		int i = w;

		while (i < s.length()) {

			String ss = s.substring(i, i + 1);

			t = t + ss;

			if (wordDict.contains(t)) {

				i = i + 1;
				a[len] = t;
				System.out.println(a[len]);
				t = "";
				len = len + 1;
				System.out.println(a[len]);
				if (i != s.length())
					rback(s, wordDict, i, a, len);
			}
		}
		return i + 1;
	}

}
