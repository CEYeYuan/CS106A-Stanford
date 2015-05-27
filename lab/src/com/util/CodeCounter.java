package com.util; 
 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
 
public class CodeCounter { 
 
    static long commentLine = 0; 
    static long whiteLine = 0; 
    static long normalLine = 0; 
    static long totalLine = 0; 
    static boolean comment = false; 
 
    public static void main(String[] args) { 
        File file = new File("C:\\Users\\yeyuan\\workspace"); // ������������Ҫͳ�Ƶ��ļ���·�� 
        getChild(file); 
        System.out.println("��Ч��������: " + normalLine); 
        System.out.println("ע������: " + commentLine); 
        System.out.println("�հ�����: " + whiteLine); 
        System.out.println("�ܴ�������: " + totalLine); 
    } 
 
    private static void getChild(File child) { // ������Ŀ¼ 
        if (child.getName().matches(".*\\.java$")) { // ֻ��ѯjava�ļ� 
            BufferedReader br = null; 
            try { 
                br = new BufferedReader(new FileReader(child)); 
            } catch (FileNotFoundException e1) { 
                e1.printStackTrace(); 
            } 
            String line = ""; 
            try { 
                while ((line = br.readLine()) != null) { 
                    parse(line); 
                } 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        if (child.listFiles() != null) { 
            for (File f : child.listFiles()) { 
                getChild(f); 
            } 
        } 
    } 
 
    private static void parse(String line) { 
        line = line.trim(); 
        totalLine++; 
        if (line.length() == 0) { 
            whiteLine++; 
        } else if (comment) { 
            commentLine++; 
            if (line.endsWith("*/")) { 
                comment = false; 
            } else if (line.matches(".*\\*/.+")) { 
                normalLine++; 
                comment = false; 
            } 
        } else if (line.startsWith("//")) { 
            commentLine++; 
        } else if (line.matches(".+//.*")) { 
            commentLine++; 
            normalLine++; 
        } else if (line.startsWith("/*") && line.matches(".+\\*/.+")) { 
            commentLine++; 
            normalLine++; 
            if (findPair(line)) { 
                comment = false; 
            } else { 
                comment = true; 
            } 
        } else if (line.startsWith("/*") && !line.endsWith("*/")) { 
            commentLine++; 
            comment = true; 
        } else if (line.startsWith("/*") && line.endsWith("*/")) { 
            commentLine++; 
            comment = false; 
        } else if (line.matches(".+/\\*.*") && !line.endsWith("*/")) { 
            commentLine++; 
            normalLine++; 
            if (findPair(line)) { 
                comment = false; 
            } else { 
                comment = true; 
            } 
        } else if (line.matches(".+/\\*.*") && line.endsWith("*/")) { 
            commentLine++; 
            normalLine++; 
            comment = false; 
        } else { 
            normalLine++; 
        } 
    } 
 
    private static boolean findPair(String line) { // ����һ����/*��*/�Ƿ�ɶԳ��� 
        int count1 = 0;  
        int count2 = 0; 
        Pattern p = Pattern.compile("/\\*"); 
        Matcher m = p.matcher(line); 
        while (m.find()) { 
            count1++; 
        } 
        p = Pattern.compile("\\*/"); 
        m = p.matcher(line); 
        while (m.find()) { 
            count2++; 
        } 
        return (count1 == count2); 
    } 
 
}