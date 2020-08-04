package com.shanchuan.java;

import org.junit.Test;

import java.io.File;

/**
 * @Description:
 * file类的使用
 * 1.file类的一个对象，代表一个文件或者文件目录
 * 2.file类声明在java.io包下
 *
 * @Author: ShanChuan
 * @Data: 10:382020/8/3
 */
public class FileTest {
    /*
    如何获取file类的实例:
     public File(String pathname)
        以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果
        pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
             绝对路径：是一个固定的路径,从盘符开始
             相对路径：是相对于某个位置开始
     public File(String parent,String child)
        以parent为父路径，child为子路径创建File对象。
     public File(File parent,String child)
        根据一个父File对象和子文件路径创建File对象

     */
    @Test
    public void test1(){


        File file = new File("hello.txt");

        File file1 = new File("D:\\Code","JAVA");

        File file2 = new File(file1,"IDEAWorkSpaceStudy");

        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);
    }
    /*
     File类的获取功能
         public String getAbsolutePath()：获取绝对路径
         public String getPath() ：获取路径
         public String getName() ：获取名称
         public String getParent()：获取上层文件目录路径。若无，返回null
         public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
         public long lastModified() ：获取最后一次的修改时间，毫秒值
        适用于文件目录
         public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
         public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     File类的重命名功能
         public boolean renameTo(File dest):把文件重命名为指定的文件路径
        剪切 粘贴功能
        file1.renameTo(file2)
        前提：file1存在，file2不存在
     File类的判断功能
         public boolean isDirectory()：判断是否是文件目录
         public boolean isFile() ：判断是否是文件
         public boolean exists() ：判断是否存在
         public boolean canRead() ：判断是否可读
         public boolean canWrite() ：判断是否可写
         public boolean isHidden() ：判断是否隐藏
     File类的创建功能
         public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
         public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
        如果此文件目录的上层目录不存在，也不创建。
         public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
        注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
        路径下。
     File类的删除功能
         public boolean delete()：删除文件或者文件夹
        删除注意事项：
        Java中的删除不走回收站。
        要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test2(){

    }
}
