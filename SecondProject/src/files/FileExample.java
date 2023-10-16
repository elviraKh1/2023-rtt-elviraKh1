package files;

import java.io.*;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("sample.txt");

        System.out.println(file.getAbsoluteFile());
        System.out.println("File exists? "+file.exists());


    //    File parent = file.getParentFile();
      //  System.out.println(parent.getAbsoluteFile());

        File dir = new File("C:\\javaGITHUB\\2023-rtt-elviraKh1\\");
        File parent2 = new File("..");
        System.out.println(dir.getAbsolutePath());

        File parentAll = new File("..\\..\\..\\..");
        System.out.println(parentAll.getAbsolutePath());
        for (File f : parentAll.listFiles()){
            System.out.println(f.getName());
        }

        String str ="+++++++++++++++++++++++++" ;
//        BufferedWriter bf = new BufferedWriter(new FileWriter(file,true));
        PrintWriter bf = new PrintWriter(new FileWriter(file,true));
        try {
            bf.append(' ');
            bf.append(str);
            bf.flush();
            bf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
