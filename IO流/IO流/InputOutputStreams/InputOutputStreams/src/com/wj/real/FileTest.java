package com.wj.real;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  
/* 
 * 统计当前项目所在的文件夹的文件数，文件夹数 
 * 把该文件下的文件、文件夹移动到D盘 
 */  
public class FileTest {  
  
    static int fileNum = 0;  
    static int dirNum = 0;  
      
    public static void main(String[] args) throws IOException {  
        String dirName = "C:\\zhaosi2\\赵思3";  
        File dir = new File(dirName); 
        System.out.println(dirName.substring(0, 10));
        CopyDir(dir);  
        System.out.println("文件数："+fileNum);
        System.out.println("文件夹数："+dirNum);
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
        String desName =fileName.replace(fileName.substring(0,10),"C:\\赵思"); //使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        File desFile = new File(desName);
        System.out.println("替换的值"+fileName.substring(0,10));
        System.out.println("替换之后"+desFile.getPath());
        System.out.println("字符串"+desName);
        return desFile;  
    }  
  
}  