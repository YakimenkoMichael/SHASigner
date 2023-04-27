package com.jms.util;

import com.jms.shasigner.Hex;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/**
 * @author Yakimenko Michael
 */
public class LoadPrivateKey {
    public byte[] getPrivateKey(String source) throws IOException {
        InputStream inputStream = new FileInputStream(source);
        byte[] buffer = IOUtils.toByteArray(inputStream);
        return Arrays.copyOfRange(buffer, 0, buffer.length);
    }

    public String convert2Hex(String source) throws IOException {
        byte[] buffer = getPrivateKey(source);
        char[] chars = Hex.encodeHex(Arrays.copyOfRange(buffer, 0, buffer.length));
        return new String(chars);
    }
}
