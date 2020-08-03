package org.sacc.interact.util;

import org.sacc.interact.pojo.*;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ToolUtils {



    public static Issue setIssue(IssueParam issueParam){
        LocalDateTime now=LocalDateTime.now();
        Issue issue=new Issue();
        issue.setGroupId(issueParam.getGroupId());
        issue.setContent(issueParam.getContent());
        issue.setUserId(issueParam.getUserId());
        if(issueParam.isAnonymous()){
            issue.setUserId(0);
        }
        issue.setCreateTime(now);
        issue.setUpdateTime(now);
        return issue;
    }
    public static IssueReply setIssueReply(IssueReplyParam issueReplyParam){
        LocalDateTime now=LocalDateTime.now();
        IssueReply issueReply=new IssueReply();
        issueReply.setContent(issueReplyParam.getContent());
        issueReply.setIssueId(issueReply.getIssueId());
        issueReply.setUserId(issueReply.getUserId());
        if(issueReplyParam.isAnonymous()){
            issueReply.setUserId(0);
        }
        issueReply.setCreateTime(now);
        issueReply.setUpdateTime(now);
        return issueReply;
    }

    public static byte[] getFile(byte[] data,String name) throws IOException {

       // OutputStream outputStream=new ByteArrayOutputStream(data);
       // ZipFile zipFile=new ZipFile(String.valueOf(InputStream));
        InputStream input = new ByteArrayInputStream(data);

        ZipInputStream zipInputStream = new ZipInputStream(input, Charset.forName("GBK"));

        ZipEntry ze = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        while ((ze = zipInputStream.getNextEntry()) != null) {
            if(!ze.isDirectory()) {
                String path = ze.getName();
                String fileName = path.substring(path.lastIndexOf("/") + 1);
                if (name.equals(fileName)) {
                    //  InputStream inputStream = zipFile.getInputStream(ze);
                    byte[] byte_s = new byte[1024 * 1024 * 16];
                    int num = -1;
                    while ((num = zipInputStream.read(byte_s, 0, byte_s.length)) > -1) {//通过read方法来读取文件内容
                        byteArrayOutputStream.write(byte_s, 0, num);
                    }
                }
            }
        }

        zipInputStream.closeEntry();
        input.close();

        return byteArrayOutputStream.toByteArray();
    }
    public static List<String> getMenu(byte[] data) throws IOException {
        List<String> name=new ArrayList<>();
        InputStream input = new ByteArrayInputStream(data);

        ZipInputStream zipInputStream = new ZipInputStream(input, Charset.forName("GBK"));

        ZipEntry ze = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        while ((ze = zipInputStream.getNextEntry()) != null) {
            name.add(ze.getName());
        }

        zipInputStream.closeEntry();
        input.close();

        return name;
    }

    public static boolean checkText(String fileName){
        String typelist="java cpp c py html css js h txt ";
        String fileType=fileName.substring(fileName.lastIndexOf(".")+1);
        return typelist.contains(fileType);
    }

}
