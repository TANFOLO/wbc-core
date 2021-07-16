package main.java.com.wbc.core.utils;

import org.apache.commons.codec.binary.Base64;

public class ImageUtils {

	public static byte[] getBytesArray(String base64_image) {

		String encodingPrefix = "base64,";
		int contentStartIndex = base64_image.indexOf(encodingPrefix) + encodingPrefix.length();
		return Base64.decodeBase64(base64_image.substring(contentStartIndex));
	}

}
