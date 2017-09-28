package com.liferay.blade.cli.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringUtil {

	private static String[] _emptyStringArray = new String[0];

	public static String[] split(String s, char delimiter) {
		if (s == null) {
			return _emptyStringArray;
		}

		s = s.trim();

		if (s.length() == 0) {
			return _emptyStringArray;
		}

		List<String> nodeValues = new ArrayList<>();

		_split(nodeValues, s, 0, delimiter);

		return nodeValues.toArray(new String[nodeValues.size()]);
	}
	
	public static String replace(String s, char oldSub, char newSub) {
		if (s == null) {
			return null;
		}

		return s.replace(oldSub, newSub);
	}
	
	
	public static String[] split(String s, String delimiter) {
		if (s == null || (delimiter == null) ||
			delimiter.equals(StringPool.BLANK)) {

			return _emptyStringArray;
		}

		s = s.trim();

		if (s.equals(delimiter)) {
			return _emptyStringArray;
		}

		if (delimiter.length() == 1) {
			return split(s, delimiter.charAt(0));
		}

		List<String> nodeValues = new ArrayList<>();

		int offset = 0;

		int pos = s.indexOf(delimiter, offset);

		while (pos != -1) {
			nodeValues.add(s.substring(offset, pos));

			offset = pos + delimiter.length();

			pos = s.indexOf(delimiter, offset);
		}

		if (offset < s.length()) {
			nodeValues.add(s.substring(offset));
		}

		return nodeValues.toArray(new String[nodeValues.size()]);
	}
	
	private static void _split(
		Collection<String> values, String s, int offset, char delimiter) {

		int pos = s.indexOf(delimiter, offset);

		while (pos != -1) {
			values.add(s.substring(offset, pos));

			offset = pos + 1;

			pos = s.indexOf(delimiter, offset);
		}

		if (offset < s.length()) {
			values.add(s.substring(offset));
		}
	}
}
