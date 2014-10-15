package com.spec.first.util;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	
	public static String convertCharset(String src,
			String srcCharset, String dstCharset) throws UnsupportedEncodingException {
		if (src == null) {
			return null;
		}
		if (srcCharset == null) {
			srcCharset = "ISO-8859-1";
		}
		if (dstCharset == null) {
			dstCharset = "UTF-8";
		}
		return new String(src.getBytes(srcCharset), dstCharset);
	}
	
}
