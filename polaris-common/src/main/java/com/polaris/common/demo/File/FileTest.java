package com.polaris.common.demo.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class FileTest {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\xiaojiang\\Desktop\\学习文档");
        String[] files=file.list(new FilenameFilter() {
            private Pattern pattern=Pattern.compile("22.txt");
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        for(String s:files){
            System.out.println(s);
        }
    }
}
