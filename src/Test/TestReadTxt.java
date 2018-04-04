package Test;


import hanhan.p;
import hanhan.pp;

import java.io.IOException;

public class TestReadTxt {


    public static void main(String[]args) throws IOException {
        String s = p.readAllTxt("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
        p.p("---------------------读utf-8----------------------------------");
        p.p(s);
        p.p("-------------------------------------------------------");


        s= pp.usCodeReadTxt("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt","GB2312");
        p.p("-------------------------------------------------------");
        p.p(s);
        p.p("-------------------------------------------------------");

    }


}
