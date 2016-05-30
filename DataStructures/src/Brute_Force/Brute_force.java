package Brute_Force;

/**
 * 字符串匹配操作 设s为主串，t为模式串，i为主串当前比较字符的下表，j为模式串当前比较字符的下表，令i的初始值为start，j的初始值为0，
 * 从主串的第start个字符（i=start）和模式串的第j个字符比较，若相等，则继续比较后续字符（i++，j++）；
 * 否则从主串的第二个字符重新和模式串比较（i返回原始位置加1，j返回0）。
 * 
 * @author 东
 *
 */
public class Brute_force {
	// t为子串，start是主串的匹配起始位置
	public int indexOF_Brute_Force(String t, int start) {
		if (this != null && t != null && t.length() > 0 && this.length() >= t.length()) {
			int slen, tlen, i = start, j = 0;
			slen = this.length();
			tlen = t.length();
			while ((i < slen) && (j < tlen)) {
				if (this.charAt(i) == t.charAt(j)) {
					i++;
					j++;
				} else {
					i = i - j + 1;
					j = 0;
				}
			}
			if (j >= t.length()) {
				return i - t.length();
			} else {
				return -1;
			}
		}
	}
}
