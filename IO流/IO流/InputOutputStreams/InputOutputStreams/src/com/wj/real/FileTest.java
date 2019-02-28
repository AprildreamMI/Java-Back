package com.wj.real;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  
/* 
 * ͳ�Ƶ�ǰ��Ŀ���ڵ��ļ��е��ļ������ļ����� 
 * �Ѹ��ļ��µ��ļ����ļ����ƶ���D�� 
 */  
public class FileTest {  
  
    static int fileNum = 0;  
    static int dirNum = 0;  
      
    public static void main(String[] args) throws IOException {  
        String dirName = "C:\\zhaosi2\\��˼3";  
        File dir = new File(dirName); 
        System.out.println(dirName.substring(0, 10));
        CopyDir(dir);  
        System.out.println("�ļ�����"+fileNum);
        System.out.println("�ļ�������"+dirNum);
    }  
      
    public static void CopyDir(File dir) throws IOException{  
        File desDir = DoChange(dir);  
        desDir.mkdirs();
        System.out.println(dir.getPath());
        System.out.println(desDir.getPath());
        dirNum++;  
        File list[] = dir.listFiles();  
        for(int i=0; i<list.length; ++i){  
            if(list[i].isDirectory()){  
                CopyDir(list[i]);  
            }  
            else{  
                CopyFile(list[i]);  
            }  
        }  
    }  
      
    public static void CopyFile(File file) throws IOException{  
        File desFile = DoChange(file);  
        desFile.createNewFile();
        System.out.println(file.getPath());
        System.out.println(desFile.getPath());
        fileNum++;  
        InputStream is = null;  
        OutputStream os = null;  
        int temp = 0;  
        byte[] src = new byte[(int)file.length()];  
        try{  
            is = new FileInputStream(file);  
            os = new FileOutputStream(desFile);  
              
            is.read(src);  
            os.write(src);  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            if(is!=null){  
                is.close();  
            }  
            if(os!=null){  
                os.close();  
            }  
        }  
          
    }  
      
    public static File DoChange(File file){  
        String fileName = file.getAbsolutePath();  
        String desName =fileName.replace(fileName.substring(0,10),"C:\\��˼"); //ʹ�ø����� replacement �滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ�����
        File desFile = new File(desName);
        System.out.println("�滻��ֵ"+fileName.substring(0,10));
        System.out.println("�滻֮��"+desFile.getPath());
        System.out.println("�ַ���"+desName);
        return desFile;  
    }  
  
}  