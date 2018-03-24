import hanhan.p;

public class TestModel {
    public String str1="";
    public String str2=null;

    public String getStr1() {
        return str1;
    }

    public TestModel setStr1(String str1) {
        this.str1 = str1;
        return this;
    }

    public String getStr2() {
        return str2;
    }

    public TestModel setStr2(String str2) {
        this.str2 = str2;
        return this;
    }

    public static void f() {
        TestModel testModel=new TestModel();
        testModel.setStr1(null);
        testModel.setStr2(null);
        try {
            Object o = p.StringTypeNull2Space(testModel);
            p.p(p.str2Log(o.toString()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }



    public static void f1() {
        TestModel testModel=new TestModel();
        testModel.setStr1("");
        testModel.setStr2("");
        try {
            Object o = p.StringTypeSpace2Null(testModel);
            p.p(p.str2Log(o.toString()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestModel{");
        sb.append("str1='").append(str1).append('\'');
        sb.append(", str2='").append(str2).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[]args){
        f1();
    }
}
