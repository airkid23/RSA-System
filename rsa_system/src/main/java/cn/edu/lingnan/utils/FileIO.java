package cn.edu.lingnan.utils;

import java.io.*;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.utils
 * @DESCRIPTION 读取明文文件内容并返回
 * @Author wzj
 * @create: 2020-06-03 21:12
 **/
public class FileIO {
    public String readFile() throws IOException {
        String message = "";
        String path = "/home/wzj/IdeaProjects/RSA_Springboot/rsa_system/src/main/resources/static/file/message.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            message += line;
        }
        fileInputStream.close();
        return message;
    }

    public void writeFile(String content) throws IOException {
        String path = "/home/wzj/IdeaProjects/RSA_Springboot/rsa_system/src/main/resources/static/file/encryptMessage.txt";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();

    }
}
