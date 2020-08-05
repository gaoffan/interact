package org.sacc.interact.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder=new StringBuilder();
        if(src==null||src.length<=0){
            return null;
        }
        String hv;
        for(int i=0;i<src.length;i++){
            hv=Integer.toHexString(src[i] &0xFF).toUpperCase();
            if(hv.length()<2){
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String getFileHeader(MultipartFile file) throws IOException {
        InputStream is=null;
        String value=null;
        is=file.getInputStream();
        byte[] b=new byte[4];
        is.read(b,0,b.length);
        value=bytesToHexString(b);
        is.close();
        return value;
    }
}
