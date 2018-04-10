package Test.测试SubList;


import hanhan.arraylist;
import hanhan.p;

import java.util.ArrayList;
import java.util.List;

public class TestSubList {


    public void f(){
        List<Object> 父list = arraylist.b().a("1").a("2").a("3").a("4").a("5").g();
        p.p("--------------父类list-----------------------------------------");
        p.p(父list);
        p.p("-------------------------------------------------------");

        List<Object> 子list = 父list.subList(1, 3);//从0索引,得到第1 和第2个,第三个不要(就是最后一个不包含)
        p.p("------------------子类subList-------------------------------------");
        p.p(子list);//  测试结果证明, subList的集合是  [)   这种包前不包后
        p.p("-------------------------------------------------------");


        子list.add("6");

        p.p("-----------------子list添加后父list也响应增加,而且父增加是在截取的子的那个后面增加--------------------------------------");
        p.p(子list);//[2, 3, 6]
        p.p(父list);//[1, 2, 3, 6, 4, 5]
        p.p("-------------------------------------------------------");

        //要想子增父不增,可以这样得到子,不要直接得到子,而是new出一个

        List 脱离子list =new ArrayList(父list.subList(0,2));
        脱离子list.add("9");
        p.p("----------此时因为是new的新的脱离型list,所以,脱离型list再增加的时候,父list不增加---------------------------------------------");
        p.p(脱离子list);
        p.p(父list);
        p.p("-------------------------------------------------------");

    }


    public static void main(String[]args){
            new TestSubList().f();
    }


}
