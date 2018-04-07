package hanhan;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
//import java.util.regex.Matcher;
public strictfp class p {
    /**
     *对于打包后的springboot项目
     * 我们怎么读取资源路径？
     * 其实很简单
     * 所有  资源文件放到跟jar包同级目录  然后用
     * String pa = p.readAllTxt("资源文件.txt")
     * 在项目中就能读取
     *
     * */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };//md5用

    private final static String phonePattern =
            "^1[3|4|5|7|8][0-9]\\d{8}$";

    private final static String emailPattern1 =
    "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private final static String emailPattern2 =
            "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";



    public static final String jpeg=".jpeg";
    public static final String jpg="jpg";
    public static final String noExceptionSign ="《没有异常》";
    public static final String knownExceptionSign ="《已知异常》";
    public static final String unKnownExceptionSign ="《未知异常》";
    public static final String beiChuShu="beiChuShu";
    public static final String chuShu="chuShu";
    public static final String shang="shang";
    public static final String yuShu="yuShu";
    public static final String xg="/";//斜杠
    public static final String sxg="//";//双斜杠
    public static final String gq="_____________________RuanJianGuoQi__________________________The software has expired, please contact the supplier_____________________RuanJianGuoQi__________________________";//过期提醒
    public static final String NULL1="NULL";
    public static final String null1="null";
    public static final String excel="excel";
    public static final String zhifgf="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";//至分隔符
    public static final String zhi="~";//至符号
    public static final String zuHeFenGeFu="{~}";//组合分隔符,常用于分隔各种字符串组合
    public static final String manyMinus="--------------------------------------------";
    public static final String manyMinusBefore="\n--------------------------------------------";
    public static final String manyMinusAfter="--------------------------------------------\n";
    public static final String manyMinus2="\n--------------------------------------------\n";
    public static final String dexhx="_________________";//短英文下划线
    public static final String cexhx="____________________________________________";//长英文下划线
    public static final String dzwxhx="————————————————";//短中文下划线
    public static final String hlfgxd="…………………………………………";//就是^的中文状态多个组合
    public static final String zwh="？";//中文问号
    public static final String eeh="?";//英文问号
    public static final String xh="*";
    public static final String qdz="&";//and符号或者取地址符号
    public static final String zcf="……";//中文状态下的次方符号
    public static final String cf="^";//excel中的次方符号
    public static final String jnh="#";
    public static final String zgth="！";//中文感叹号
    public static final String egth="!";//英文感叹号
    public static final String at="@";
    public static final String rmb="￥";
    public static final String dollor="$";
    public static final String bfh="%";
    public static final String zmh="：";//中文冒号
    public static final String emh=":";//英文冒号
    public static final String zdh="、";//顿号、,只有中文有,英文没有
    public static final String fxg="\\";//这个其实代表一个\,因为第一个\是转义符号
    public static final String ys="|";//一竖
    public static final String edyh="'";//英文单引号的一半
    public static final String esyh="\"";//英文双引号的一半
    public static final String ejh=".";//英文句号
    public static final String zjh="。";//中文句号
    public static final String zd="，";//中文逗号
    public static final String ed=",";//英文逗号
    public static final String xyh="<";
    public static final String dyh=">";
    public static final String dh="=";//等号
    public static final String j="+";//加号
    public static final String xhx="_";//下划线
    public static final String jh="-";//减号
    public final static String fh=";";//分好
    public final static String space="";//空字符串
    public static final String  enCodeSpace="%20";
    public final static String spac=" ";//空格
    public static final String undefined="undefined";
    public static final String UTF8="UTF-8";
    public static final String GBK="GBK";
    public static final String GB2312="GB2312";
    //_________________2017-12-29 19:10:52.717_________________
    public final static String d1="yyyy-MM-dd HH:mm:ss.SS";//最后的SS是毫秒//like//2017-12-16 16:19:23.670
    //_________________2017-12-29 19:10:52.717_________________
    public final static String d16="yyyy-MM-dd HH:mm:ss.SSS";
    //_________________2017-12-29 19:10:52,717_________________
    public final static String d17="yyyy-MM-dd HH:mm:ss,SSS";
    public final static String d2="yyyy-MM-dd HH:mm:ss";
    public final static String d3="yyyy-MM-dd";

    public final static String d4="yyyy/MM/dd HH:mm:ss.SS";
    public final static String d5="yyyy/MM/dd HH:mm:ss";
    public final static String d6="yyyy/MM/dd";

    public final static String d7="yyyy.MM.dd HH:mm:ss.SS";
    public final static String d8="yyyy.MM.dd HH:mm:ss";
    public final static String d9="yyyy.MM.dd";

    public final static String d10="yyyyMMddHHmmssSS";
    public final static String d11="yyyyMMddHHmmss";
    public final static String d12="yyyyMMdd";

    public final static String fail="fail";
    public final static String FAIL="FAIL";
    public final static String success="success";
    public final static String SUCCESS="SUCCESS";

    public final static String d13="yyyy.MM.dd HH.mm.ss.SS";
    public final static String d14="yyyy.MM.dd.HH.mm.ss.SS";
    public final static String d15="yyyy.MM.dd.HH.mm.ss";
    public static final String unixBir="1970-01-01";
    public final static String hanhanBirthday_="1986-12-26";
    public final static String hanhanBirthday="1986/12/26";

    public final static String DateType="java.util.Date";
    public final static String StringType="java.lang.String";
    public final static String BigDecimalType="java.math.BigDecimal";

    public final static List<String>numberTypelist
            =Arrays.asList(new String[]{"int","java.lang.Integer",
                    "double","java.lang.Double",
                    "float","java.lang.Float","java.lang.Long"
                    ,"long","java.lang.Short","short"});

    public final static String intType="int";
    public final static String IntegerType="java.lang.Integer";
    public final static String doubleType="double";
    public final static String DoubleType="java.lang.Double";
    public final static String floatType="float";
    public final static String FloatType="java.lang.Float";
    public final static String LongType="java.lang.Long";
    public final static String longType="long";
    public final static String ShortType="java.lang.Short";
    public final static String shortType="short";

    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    public final static String baoCunShiBai="baoCunShiBai";
    public final static String baoCunShiBaiCh="保存失败";
    public final static String baoCunChengGong="baoCunChengGong";
    public final static String baoCunChengGongCh="保存成功";
    public final static String charsetUtf8="application/json;charset=utf-8";

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /**
     *按顺序拆分带组合分隔符的字符串
     * 适用于
     *
     * 阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的{~}
     *
     * 这种
     * 最后还带分隔符的组合
     * 截取后是
     * [阿拉山口打飞, 机爱丽丝打飞, 机埃里克的]
     * */
    public static List<String>chaiFenZuHeFenGeFu(String s){
        List<String>list=new LinkedList<>();
        while(s.contains(zuHeFenGeFu)){
            //就是按照{~}拆分
            String ss = s.substring(0, s.indexOf(zuHeFenGeFu));
            list.add(ss);
            s=s.substring(s.indexOf(zuHeFenGeFu)+3);
        }

        return list;
    }


    /**
     ** 适用于
     *
     * 阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的
     *
     * 这种最后没有分隔符的组合
     * 截取后是
     * [阿拉山口打飞, 机爱丽丝打飞, 机埃里克的]
     * */
    public static List<String>chaiFenZuHeFenGeFu0(String s){
        return chaiFenZuHeFenGeFu(s+zuHeFenGeFu);

    }


    /**
     *自定义组合符号的拆分
     * 用于字符串最后有分隔符的
     * 阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的{~}
     * */
    public static List<String>chaiFenZuHeFenGeFu(String s,String zuHeFenGeFuHao,int zuHeFuHaoChangDu){
        List<String>list=new LinkedList<>();
        while(s.contains(zuHeFenGeFuHao)){
            //就是按照{~}拆分
            String ss = s.substring(0, s.indexOf(zuHeFenGeFuHao));
            list.add(ss);
            s=s.substring(s.indexOf(zuHeFenGeFuHao)+zuHeFuHaoChangDu);
        }

        return list;
    }

    /**
     *用于字符串最后没有分隔符的
     * 阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的
     * 根据  ~  拆完是
     * [阿拉山口打飞{, }机爱丽丝打飞{, }机埃里克的]
     * */
    public static List<String>chaiFenZuHeFenGeFu0(String s,String zuHeFenGeFuHao,int zuHeFuHaoChangDu){
        return chaiFenZuHeFenGeFu(s+zuHeFenGeFuHao,zuHeFenGeFuHao,zuHeFuHaoChangDu);

    }

//    public static void main(String[]args){
//            String s="阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的";
//        p.p("-------------------------------------------------------");
//        p.p(chaiFenZuHeFenGeFu0(s,"~",1));
//        p.p("-------------------------------------------------------");
//    }

    /**
     *生成新类new封装
     * */

    public static p gp(){
        return new p();
    }


    /**
     *打印封装
     * */
    public static void p(Object o){
        System.out.println(o);
    }
    public static void p(String o){
        System.out.println(o);
    }

    /**
     *常用字符串组合打印或者log.error
     * 封装
     *
     *
     这种
     *
     *
     * */
    /**
     *--------------------------------------------
     123
     --------------------------------------------
     这种
     * */
    public static String str2Log(String str){
        return manyMinus2+str+manyMinus2;
    }

    /**
     *------------------log提示a-------------------
     123
     --------------------------------------------
     这种
     * */
    public static String str2Log(String str,String msg){

        int i;
        int j;
        if(msg.length()%2==0){
            i=msg.length()/2;
            j=i+1;
        }else{
            i=msg.length()/2+1;
            j=i+1;
        }

        return manyMinus2.substring(0, manyMinusBefore.length() / 2-i)
                +msg+manyMinus2.substring(manyMinusBefore.length() / 2+j)
                +str+manyMinus2;

    }
//    public static void main(String[]args){
//        p.p(str2Log("123","log提示a"));
//    }
    /**
     *uuid封装
     * */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }

    /*public static void main(String[]args){
         p.p(p.gp().sad(p.dexhx).sad(p.uuid()).sad(p.dexhx).gad());
    }*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *下面一个方法是为了解决String.valueOf(str)当str=null的情况的方法
     * */
    public static String strValeOf(Object o){
        if (null==o){
            return "null";
        }else {
            return String.valueOf(o);
        }
    }
    public static String strValeOfNull(Object o){
        if (null==o){
            return null;
        }else {
            return String.valueOf(o);
        }
    }
    public static String strValeOfSpace(Object o){
        if (null==o){
            return "";
        }else {
            return String.valueOf(o);
        }
    }
    /**
     *字符串空与null互转
     * */
    /**
     *null变空
     * */
    public static String strNullToSpace(String s){
        return (null==s?"":s);
    }

    /**
     *空变null
     * */
    public static String strSpaceToNull(String s){
        return ("".equals(s)?null:s);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *给list集合依次remove掉一个元素(必须是存的String)
     * s是空字符串和null也可以,但是list是null和size=0就不行
     * list里面的null也能去除了
     * */
        public  static List remove1EleInList(List<String> list,String s){
            if(notEmpty(list)&&s==null){
                //这种方式是可以变长删除元素的
                for(int i=0;i<list.size();i++){
                    if(null==list.get(i)){
                        list.remove(null);
                    }
                }
            }else if(notEmpty(list)){
                //s是空字符串和null也可以,但是list是null和size=0就不行
//                for(int i=0;i<list.size();i++){
//                    if(dy(list.get(i),s)){
//                        list.remove(s);
//                    }
//                }
                //下面的filter其实就是留下符合条件的意思,把不等于的过滤扔掉
                return list.stream().filter(v -> bdy(s, v)).collect(Collectors.toList());
            }
            return list;
        }
    /**
     *给list集合remove掉多个元素(必须是存的String)
     * s是空字符串和null也可以,但是list是null和size=0就不行
     * parentList是总的集合,childList是要删除的元素集合
     * 就是说从parentList中删除childList
     * 如果parentList和childList中都有null,也可以remove掉
     * */
    public  static List removeLotEleInList(List<String> parentList,List<String> childList){
        if(allNotEmpty(new Object[]{parentList,childList})){
            //s是空字符串和null也可以,但是list是null和size=0就不行
                parentList.removeAll(childList);
        }
        return parentList;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *list里面去重复
     * */
    public static List distinctList(List<String>list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //根据某几个字段去重对象 并同时合并某个字段的实例
    /**
     *map去重复,并合并某一字段,根据key的唯一性
     * */
 /*   private static void quChongFuBingHeBingMouYiXiang(){
        usr u1=new usr();
        usr u2=new usr();
        //根据name+age的字符串进行去重复,根据money字段进行合并
        //就是把name+age相同的对象他们的money加在一起并去除重复的
        u1.setAge(22);
        u1.setName("han");
        u1.setMoney(p.b("1.2"));


        u2.setAge(22);
        u2.setName("han");
        u2.setMoney(p.b("3.5"));

        //将实验去重并合并的对象放入list
        List<Object> usrs=arraylist.b().a(u1).a(u2).g();
        //打印没有合并的时候的整个对象集合
        p.p("-------------------------------------------------------");
        p.p(usrs.toString());
        p.p("-------------------------------------------------------");

        //得到去重复并合并某个字段的工具类map,根据map的key的唯一性进行去重复
        Map<String,Usr> map=new HashMap();
        //循环还没有合并的对象集合
        usrs.forEach(v->{

            Usr v1 = (Usr) v;
            String name = v1.getName() ;
            int age = v1.getAge();
            BigDecimal money = v1.getMoney();
            //将要合并的对象的字段转化成字符串连接在一起,为了将来对比用
            String nameage=name+p.strValeOf(age);
            //从map工具类中拿到相同的那个对象中的对比字段
            Usr usr = map.get(nameage);
            if(p.notEmpty(usr)){
                //如果//拿到map中本来有的重复的同类项非空,就跟当前流里面的同类项的money合并
                v1.setMoney(v1.getMoney().add(usr.getMoney()));
            }
            //把合并后的对象放到当前的那个 连接好的字符串为key 下面
            // 如果key相同,会把原来的那个覆盖掉用现在的合并后的对象替代
            map.put(nameage, v1);
        });

        //把 map的values  放入list,得到的就是去重并合并后的对象集合
        List<Usr> usrs01 = new ArrayList<>(map.values());
        //打印合并并去重后的对象
        p.p("------------------srs01.toString()-------------------------------------");
        p.p(usrs01.toString());
        p.p("-------------------------------------------------------");

    }
  */

//    public static void main(String[]args){
//        quChongFuBingHeBingMouYiXiang();
//
//
//    }




    /**
     * set集合去重不合并某个字段,注释掉的是根据对象的2个字段相加去重,没有注释的是根据对象的一个字段去重
     *测试去重,但是set始终不能对其他项合并,比如根据age+name合并后未能将money合并
     * */
  /*  private static void zhiQuChongBuHeBing(){
        usr u1=new usr();
        usr u2=new usr();
        u1.setAge(22);
        u1.setName("han");
        u1.setMoney(b("1.2"));
        u2.setAge(22);
        u2.setName("han");
        u2.setMoney(p.b("3.5"));
        List<usr> list=new arraylistT<usr>().a(u1).a(u2).g();
        p.p("-------------------------------------------------------");
        p.p(list.toString());
        p.p("-------------------------------------------------------");

        Set<usr> usrSet = new TreeSet<>(
//                (u01, u02)->(
//                        //将u01去重的字段转换成字符串连接再一起
//                        p.gp().sad(p.strValeOf(u01.getAge())).sad(u01.getName()).gad()
//                ).compareTo(
//                        ////将u02去重的字段转换成字符串连接再一起
//                        p.gp().sad(p.strValeOf(u02.getAge())).sad(u02.getName()).gad()
//                )
                //上面那个是组合字段去重复,下面这个是单一字段去重复对象
                Comparator.comparing(usr::getName)
        );
        //将要去重复的对象集合list放入去重复的set内部就能去重复
        usrSet.addAll(list);
        //将去重复后的set变成list集合
        List<usr>list1= new ArrayList<>(usrSet);

        p.p("-------------------------------------------------------");
        p(list1.toString());
        p.p("-------------------------------------------------------");
    }*/

//    public static void main(String[]args){
//        zhiQuChongBuHeBing();
//    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *排序
     * 在java中，要给数据排序，有两种实现方式，分别实现两个接口：

     一种是实现Comparable接口
     另一种是实现Comparator接口
     　　在JDK类库中，有一部分类实现了Comparable接口,如Integer Double和String等。
     　Comparable接口有一个comparTo(Object o)方法,它返回整数类型。
     对于表达式x.compareTo(y),如果返回值为0，则表示x和y相等,如果返回值大于0，
     则表示x大于y,如果返回值小于0，则表示x小于y.
     * */

    /*public static void main(String[]args){
        Usr u1=new Usr();
        u1.setAge(22).setMoney(p.b(32)).setName("hanhan1").setBir("2012-01-09");
        Usr u2=new Usr();
        u2.setAge(23).setMoney(p.b(33)).setName("hanhan2").setBir("2013-02-09");
        Usr u3=new Usr();
        u3.setAge(24).setMoney(p.b(34)).setName("hanhan3").setBir("2014-02-09");
        List l = p.gp().setArl(u2).setArl(u1).setArl(u3).getArl();
        p.p(l);
        //按年龄排序
        l.sort(Comparator.comparing(Usr::getAge));
        p.p(l);
        //按字符串生日排序
        l.sort(Comparator.comparing(Usr::getBir));
        p.p(l);
        //按字符串生日倒排序
        l.sort(Comparator.comparing(Usr::getBir).reversed());
        p.p(l);
        //根据自己写的方法规则排序
        l.sort(Comparator.comparing(Usr::Age1).reversed());
        p.p(l);


    }*/


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *构造map自动链式生成
     *
     * */
//    public p smp(String key,Object val){
//        map.put(key,val);
//        return this;
//    }
//    public Map<String,Object> gmp(){
//        return map;
//    }
    /**
     ****************************************************************************************
     * */
    //@Test
   /* private static void xx(){
        p.p(Integer.class.getName());
        p.p(int.class.getTypeName());//int
        p.p(Integer.class.getTypeName());//java.lang.Integer
        p.p(double.class.getTypeName());//double
        p.p(Double.class.getTypeName());//java.lang.Double
        p.p(float.class.getTypeName());//float
        p.p(Float.class.getTypeName());//java.lang.Float
        p.p(Long.class.getTypeName());//java.lang.Long
        p.p(long.class.getTypeName());//long
        p.p(Short.class.getTypeName());//java.lang.Short
        p.p(short.class.getTypeName());//short
    }*/

//    public static void main(String[]args){
//            xx();
//    }
    /**
     *g得到s链式连接的字符串
     * */
//    public String gad() {
//        return ads;
//    }

    /**
     * 先用gp得到一个新类,注意,一定要用gp得到new类,才能调用该方法
     *拼接字符串封装
     * 调用该方法链式增加字符串
     * 然后调用gad()得到结果
     * */
//    public p sad(String str) {
//        ads=sb.append(str).toString();
//        return this;
//    }

    //@Test
//    public void g(){
//        String gad = p.gp().sad("韩寒").sad("梦如").gad();
//        p.p(gad);//韩寒梦如
//    }
    /**
     ****************************************************************************************
     * */






    /**
     ****************************************************************************************
     * 生成linkedlist并装上东西
     * */
//    public List getLin() {
//        return lin;
//    }
//
//    public p setLin(Object o) {
//        this.lin.add(o);
//        return this;
//    }

    //@Test
//    public void f(){
//        List lin = p.gp().setLin(1).setLin(2).setLin(3).getLin();
//        p.p(lin);//[1,2,3]
//    }



    /**
     ****************************************************************************************
     * 生成arraylist并装上东西
     * */
//    public List getArl() {
//        return arl;
//    }
//
//    public p setArl(Object o) {
//        this.arl.add(o);
//        return this;
//    }
    //@Test
//    public void f1(){
//        List arl = p.gp().setArl(11).setArl(22).setArl(33).getArl();
//        p.p(arl);////[11,22,33]
//
//    }
    /**
     ****************************************************************************************
     * */
    /**
     *equals缩写,判断两个字符串如果等于返回true
     * */
       public static boolean dy(String str1 ,String str2){
           if(str1!=null){
               if(str1.equals(str2)){
                   return true;
               }else{
                   return false;
               }
           }else if(str2!=null){
               if(str2.equals(str1)){
                   return true;
               }else{
                   return false;
               }
           }else if(str1==null&&str2==null){
               p("str1和str2都是null");
               return false;
           }else{
               //这种情况基本不会发生
               return false;
           }
       }

    //equals缩写,判断两个字符串如果不等于返回true
    public static boolean bdy(String str1 ,String str2){
           if(dy(str1,str2)){
               return false;
           }else{
               return true;
           }

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(String s){
        if(null==s){
            return null;
        }else{
            try {
                return new BigDecimal(s);
            } catch (Exception e) {
                   return null;
            }
        }
    }


    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Double d){
        if(null==d){
            return null;
        }else{
            try {
                return new BigDecimal(d);
            } catch (Exception e) {
                return null;
            }
        }
    }
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Integer i){
        if(null==i){
            return null;
        }else{
            try {
                return new BigDecimal(i);
            } catch (Exception e) {
                return null;
            }
        }
    }
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Long L){
        if(null==L){
            return null;
        }else{
            try {
                return new BigDecimal(L);
            } catch (Exception e) {
                return null;
            }
        }
    }




    /**
     *传入一个Bigdecimal,如果是null,就变为0
     * */
    public static BigDecimal bNull0(BigDecimal b){
        return null==b?new BigDecimal(0):b;
    }

    /**
     *bigDecimal比大小
     * */


    public static boolean isFirstBigBigdecimal(BigDecimal b1,BigDecimal b2){
        return b1.compareTo(b2)==1?true:false;
    }

    public static boolean isFistSmallBigdecimal(BigDecimal b1,BigDecimal b2){
        return b1.compareTo(b2)==-1?true:false;
    }
    public static boolean isEqualBigdecimal(BigDecimal b1,BigDecimal b2){
        return b1.compareTo(b2)==0?true:false;
    }

//
//    public static void main(String[]args){
//        p.p(p.isFirstBig(p.b(1),p.b(0.5)));
//        p.p(p.isFistSmall(p.b(1),p.b(2)));
//        p.p(p.isEqual(p.b(3),p.b(2)));
//    }

    /**
     *bigdecimal加减乘除
     * */


    public static BigDecimal badd(BigDecimal b1,BigDecimal b2){
       return bNull0(b1).add(bNull0(b2));
    }

    public static BigDecimal b1_b2(BigDecimal b1,BigDecimal b2){
        return bNull0(b1).subtract(bNull0(b2));
    }

    public static BigDecimal b1Xb2(BigDecimal b1,BigDecimal b2){
        return bNull0(b1).multiply(bNull0(b2));
    }

    public static BigDecimal b1ChuYib2Null(BigDecimal b1,BigDecimal b2){
        if(isEqualBigdecimal(b2,b(0)))return null;
        return bNull0(b1).divide(bNull0(b2));
    }

    public static BigDecimal b1ChuYib20(BigDecimal b1,BigDecimal b2){
        if(isEqualBigdecimal(b2,b(0)))return b(0);
        return bNull0(b1).divide(bNull0(b2));
    }

//    public static void main(String[]args){
//                p(b1ChuYib2Null(b(4),b(0)));
//    }


    /**
     *bigDecimal取余
     * Bigdecimal取商
     *
     * */


    public static Map<String,BigDecimal>bigDecimalChuFa(BigDecimal beiChuShu,BigDecimal chuShu){
        BigDecimal[] results = beiChuShu.divideAndRemainder(chuShu);
        BigDecimal shang=results[0];
        BigDecimal yuShu=results[1];
        Map<String,BigDecimal>map=new LinkedHashMap<>();
        map.put("beiChuShu",beiChuShu);
        map.put("chuShu",chuShu);
        map.put("shang",shang);
        map.put("yuShu",yuShu);
        return map;

    }

//        public static void main(String[] args) {
//            Map<String, BigDecimal> map = bigDecimalChuFa(b(1001), b(20));
//            p(map);
//        }





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    /**
     ****************************************************************************************
     * */
    /**
     *2个日期相减得到的毫秒数量
     * */
        public static Long xjms(Date bigDate,Date samllDate){
            if(bigDate==null||samllDate==null){
                return null;
            }else{
                return bigDate.getTime()-samllDate.getTime();
            }
        }

    /**
     *2个日期相减得到的秒数量
     * */
    public static Long xjs(Date bigDate,Date samllDate){
        Long xjms = xjms(bigDate, samllDate);
        if(xjms ==null){
            return null;
        }else{
            return xjms/1000;
        }
    }

    /**
     *2个日期相减得到的分钟数量
     * */
    public static  Long xjmin(Date bigDate,Date samllDate){
        Long xjs = xjs(bigDate, samllDate);
        if(xjs ==null){
            return null;
        }else{
            return xjs/60;
        }
    }

    /**
     *2个日期相减得到的小时数量
     * */
    public  static Long xjh(Date bigDate,Date samllDate){
        Long xjmin = xjmin(bigDate, samllDate);
        if(xjmin ==null){
            return null;
        }else{
            return xjmin/60;
        }
    }

    /**
     *2个日期相减得到的天数
     * */
    public static Long xjd(Date bigDate,Date samllDate){
        Long xjh = xjh(bigDate, samllDate);
        if(xjh ==null){
            return null;
        }else{
            return xjh/24;
        }
    }


    //@Test
    public void testDD() throws ParseException {
        p.p(xjh(new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-14"),new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-13")));
    }
    /**
     ****************************************************************************************
     * */


    /**
     *字符串日期转化成date
     * yyyy-MM-dd HH:mm:ss.SS
     * */

    public static Date tod(String strDate,String geshi) {
        if(strDate==null){
            return null;
        }
        try {
            return new SimpleDateFormat(geshi).parse(strDate);
        } catch (ParseException e) {
//            e.printStackTrace();
            return null;
        }
    }
    /**
     *yyyy-MM-dd转换成默认日期的
     * */
    public static Date tod(String strDate) {
        if(strDate==null){
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *Date 变成 String异常的时候转换成yyyy-MM-dd HH:mm:ss.SSS
     * */
    public static String  dtoStr(Date date,String geshi) {
        if(date==null){
            return null;
        }

        try {
            return new SimpleDateFormat(geshi).format(date);
        } catch (Exception e) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
        }

    }

    /**
     *Date 变成 String默认格式
     * yyyy-MM-dd HH:mm:ss.SS
     * */
    public static String  dtoStr(Date date) {
        if(date==null){
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    public String  dtoStrs(Date date) {
        if(date==null){
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(date);
    }
    /**
     ****************************************************************************************
     * */
    //@Test
//    public void f2(){
//        p(dtoStrs(new Date()));
//    }

    /**
     ****************************************************************************************
     * */

    /**
     *小于等于我的生日,精确到日,因为我的生日只能精确到日,这玩意可以用来处理1970和1899的判断
     * */

    public static boolean isSmallOrEqMybirth(Date date){
        if(date==null){
            return false;
        }else{
            if((date.getTime())<=(p.tod(p.hanhanBirthday_).getTime())){
                return true;
            }else{
                return false;
            }
        }
    }


    /**
     *大于我的生日,精确到日,因为我的生日只能精确到日,这玩意可以用来处理1970和1899的判断
     * */

    public static boolean isBiggerThenMybirth(Date date){
        return !isSmallOrEqMybirth(date);
    }

//    public static void main(String[]args){
//          p.p(isBiggerThenMybirth(new Date()));
//        p.p(isSmallOrEqMybirth(new Date()));
//    }
    /**
     *时间比大小,精确到时间戳毫秒
     * */
    public static boolean isFirstDateBig(Date first,Date second){
        if(first==null || second==null){
            return false;
        }else{
            if(first.getTime()>second.getTime()){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     *时间比大小,精确到时间戳毫秒
     * */
    public static boolean isFirstDateSmall(Date first,Date second){
        return !isFirstDateBig(first,second);
    }
    /**
     *默认是"yyyy-MM-dd"的str格式才能比较,精确到日
     * */
    public static boolean isFirstDateBig_(String firstStr,String  secondStr){
        Date first= tod(firstStr);
        Date second=tod(secondStr);
        return isFirstDateBig(first,second);
    }

    /**
     *默认是"yyyy-MM-dd"的str格式才能比较,精确到日
     * */
    public static boolean isFirstDateSamll_(String firstStr,String  secondStr){
        Date first= tod(firstStr);
        Date second=tod(secondStr);
        return !isFirstDateBig(first,second);
    }

/**
 *默认是"yyyy/MM/dd"的str格式才能比较
 * 这里说的大小是字面大小,距离1970越远越大
 * 精确到日
 * */
public static boolean isFirstDateBig(String firstStr,String  secondStr){
    Date first= tod(firstStr,"yyyy/MM/dd");
    Date second=tod(secondStr,"yyyy/MM/dd");
    return isFirstDateBig(first,second);
}

    /**
     *默认是"yyyy/MM/dd"的str格式才能比较
     * 这里说的大小是字面大小,距离1970越远越大
     * 精确到日
     * */
    public static boolean isFirstDateSmall(String firstStr,String  secondStr){
        Date first= tod(firstStr,"yyyy/MM/dd");
        Date second=tod(secondStr,"yyyy/MM/dd");
        return !isFirstDateBig(first,second);
    }
    //@Test
   public void f3() {
    p(isFirstDateBig("2017/12/24", "2017/12/23"));//true
}
    /**
     ****************************************************************************************
     * */

    public static boolean isFirstDateBig(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy/MM/dd");
        return isFirstDateBig(first,second);
    }

    public static boolean isFirstDateBig_(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy-MM-dd");
        return isFirstDateBig(first,second);
    }
    public static boolean isFirstDateSmall(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy/MM/dd");
        return !isFirstDateBig(first,second);
    }

    public static boolean isFirstDateSmall_(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy-MM-dd");
        return !isFirstDateBig(first,second);
    }
    public static boolean isFirstDateBig(String firstStr,Date  second){
        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy/MM/dd");
            return isFirstDateBig(first,second);
        }
    }

    public static boolean isFirstDateBig_(String firstStr,Date  second){
        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy-MM-dd");
            return isFirstDateBig(first,second);
        }
    }
    public static boolean isFirstDateSmall(String firstStr,Date  second){
        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy/MM/dd");
            return !isFirstDateBig(first,second);
        }
    }

    public static boolean isFirstDateSmall_(String firstStr,Date  second){
        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy-MM-dd");
            return !isFirstDateBig(first,second);
        }
    }
    //@Test
//    public void f4() {
//        p(isFirstDateBig(new Date(), "2017/12/02"));//true
//    }
    /**
     ****************************************************************************************
     * */

    /**
     *时间戳转换成Date
     * */
    public static Date sjc2Date(String shiJianChuoStr){
        if(null==shiJianChuoStr||"".equals(shiJianChuoStr)){
            return null;
        }else{
            long lt = new Long(shiJianChuoStr);
            Date date= new Date(lt);
            return  date;
        }

    }

    public static Date sjc2Date(Long shiJianChuo){
        if(null==shiJianChuo){
            return null;
        }else{
            Date date= new Date(shiJianChuo);
            return  date;
        }

    }

    /**
     *new 一个日期
     * */
    public static Date getDate(){
        return new Date();
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //时间戳变成str格式时间

    public static String sjc2StrDate(String strSjc){
       return p.dtoStr(p.sjc2Date(strSjc),p.d16);

    }
    public static String sjc2StrDate(String strSjc,String geShi){
        return p.dtoStr(p.sjc2Date(strSjc),geShi);

    }
    public static String sjc2StrDate(Long longSjc){
        return p.dtoStr(p.sjc2Date(longSjc),p.d16);

    }

    public static String sjc2StrDate(Long longSjc,String geShi){
        return p.dtoStr(p.sjc2Date(longSjc),geShi);

    }
//    public static void main(String[]args){
//        //1970-01-01 08:02:01.344得到这种形式
//         p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(sjc2StrDate("121344"))).sad(p.dexhx).gad());
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(sjc2StrDate(121344L))).sad(p.dexhx).gad());
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(sjc2StrDate(121344L,d16))).sad(p.dexhx).gad());
//    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *把所有是类中所有是null的字段,如果是String类型,变成""
     * */
    public static Object StringTypeNull2Space(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (StringType.equals(type.getName())) {
                if(null==field.get(o)){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,space);
                }

            }
        }
        return o;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Object StringTypeSpace2Null(Object o) throws IllegalAccessException {
    List<Field> fieldList = new ArrayList<>();
    Class<?> aClass = o.getClass();
    while (aClass != null) {//用while得到所有超类的字段属性
        fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
        aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
    }
    for (Field field : fieldList) {
        field.setAccessible(true);
        Class<?> type = field.getType();
        if (StringType.equals(type.getName())) {
            if(space.equals(field.get(o))){//把o穿进去,得到o的属性值
                //设置o的属性值
                field.set(o,null);
            }

        }
    }
    return o;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *当日期小于我的生日的时候,证明这个日期不太正确,设置为null
     * 这个是针对某些框架内部会把Date设置为1970或者1899的情况
     * */
    public static Object dateTypeSamll2Null(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (DateType.equals(type.getName())) {
                if(isFirstDateBig(hanhanBirthday,(Date)field.get(o))){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,null);
                }

            }
        }
        return o;
    }


    /**
     *把字段是Date的小于1986的都设置为null
     * 把字段是String的是""的都设置为null
     * */
    public static Object dateTypeSamllAndStringTypeSpace2Null(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (DateType.equals(type.getName())) {
                if(isFirstDateBig(hanhanBirthday,(Date)field.get(o))){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,null);
                }

            }else if(StringType.equals(type.getName())){
                if(space.equals(field.get(o))){
                    field.set(o,null);
                }
            }
        }
        return o;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
//    public void f5(){
//        p(Date.class.getName());
//    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *关于list去除一个元素变长问题
     *
     * 这个工具主要是解决  从list元素里删除若干个符合条件的元素,list装的是基本类型的时候比较基本类型,是对象的时候比较对象
     * 的某一个参数值来决定是否删除list中的该对象
     *
     *
     * 参数  list 是一个装满  listEleType 类型的list
     * 参数 listEleType  是list里面装的元素的类型,注意,一定要装的是同一类型才能用该工具
     * 参数 comparedFieldName就是将来要删除的元素中如果是对象类型的,comparedFieldName就是该对象的属性名的字符串形式
     * 如果 list里装的不是对象,compareContentToFieldValue可以写个""或者NULL,因为不会走到比较对象那一步
     *
     * compareContentToFieldValue是将来安排的"比较内容",比如,你要删除的元素的属性值是compareContentToFieldValue的才删除,
     * 其他不删除,  如果list装的是一般类型不是对象,这个值就代表了list里面的元素值
     *
     *
     * compareContentToFieldValue填入的是NULL的时候删除的就是属性值是NULL的那个元素
     * */
    public static void removeSameEle(List<?> list ,Class listEleType,String comparedFieldName,Object compareContentToFieldValue) throws IllegalAccessException {

        //如果list里面没东西,直接不进行了
        if(list==null||list.size()==0){
           return;
        }
        Object listFirstObj = list.get(0);

        //此时是String类型
        if(StringType.equals(listEleType.getTypeName())||BigDecimalType.equals(listEleType.getTypeName())){
            Iterator<?> iterator = list.iterator();
            while(iterator.hasNext()){
                Object next = iterator.next();
                if(compareContentToFieldValue==null){
                    iterator.remove();
                }else if(next.equals(compareContentToFieldValue)){
                    iterator.remove();
                }
            }
        //此时是数字类型
       }else if(numberTypelist.contains(listEleType.getTypeName())) {
            Iterator<?> iterator = list.iterator();
            while(iterator.hasNext()){
                Object next = iterator.next();
                if(compareContentToFieldValue==null){
                    iterator.remove();
                }else if(next==(compareContentToFieldValue)){
                    iterator.remove();
                }
            }
       //此时是普通对象带元素的类型
       }else if(listFirstObj.getClass().getTypeName().equals(listEleType.getTypeName())){
           Iterator<?> iterator = list.iterator();
           while(iterator.hasNext()){
               Object next = iterator.next();
               Field[] declaredFields = next.getClass().getDeclaredFields();
               for(Field field:declaredFields){
                   field.setAccessible(true);
                   Object o = field.get(next);
                   String fieldName = field.getName();
                   String typeName = o.getClass().getTypeName();
                   //此时是删除是某个元素属性是NULL的那个元素
                   if(comparedFieldName.equals(fieldName)&&StringType.equals(typeName)&&o==null&&compareContentToFieldValue==null){
                       iterator.remove();
                       //属性值是String的情况
                   }else if(comparedFieldName.equals(fieldName)&&StringType.equals(typeName)&&o.equals(compareContentToFieldValue)){
                       iterator.remove();
                       //属性值是BigDecimal的情况
                   }else if(comparedFieldName.equals(fieldName)&&BigDecimalType.equals(typeName)&&o.equals(compareContentToFieldValue)){
                       iterator.remove();
                       //属性是数字类型的情况,数字类型就是numberTypelist里的所有类型
                   }else if(comparedFieldName.equals(fieldName)&&numberTypelist.contains(typeName)&&o==compareContentToFieldValue){
                       iterator.remove();
                   }else{

                   }
               }
           }
       }else{
           p.p("此时的list里面装的类型是："+listEleType.getTypeName()+"无法进行比对,请优化工具对类型的处理情况");
       }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
//    public void f8() throws IllegalAccessException {
//        List<x>list=new ArrayList<>();
//        list.addAll(p.gp().setArl(new x().setStr("str")).setArl(new x().setStr("str")).setArl(new x().setStr("xxx")).getArl());
//        p.p(list);
//        //删除字段str属性值是"xxx"的
//        removeSameEle(list,x.class,"str","xxx");
//        p.p(list);
//
//    }

    //@Test
//    public void f9() throws IllegalAccessException {
//        List<x>list=new ArrayList<>();
//        list.addAll(p.gp().setArl(new x().setStr("str")).setArl(new x().setStr("str")).setArl(new x().setStr("xxx")).getArl());
//        p.p(list);
//        //删除子弹str属性值是"xxx"的
//        removeSameEle(list,x.class,"str","str");
//        p.p(list);
//
//    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
//    public void f6(){
//        p.p("".getClass().getTypeName());
//        p.p(new Integer(5).getClass().getTypeName());
//        p.p(new BigDecimal(5).getClass().getTypeName());
//        p.p(new BigDecimal(5).equals(new BigDecimal(6)));//false
//        p.p(new BigDecimal(5).equals(new BigDecimal(5)));//true
//    }


    /**
     *System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
     * */
//    public class x{
//        public int x=1;
//        public String str="str";
//
//        public int getX() {
//            return x;
//        }
//
//        public x setX(int x) {
//            this.x = x;
//            return this;
//        }
//
//        public String getStr() {
//            return str;
//        }
//
//        public x setStr(String str) {
//            this.str = str;
//            return this;
//        }
//
//        @Override
//        public String toString() {
//            final StringBuffer sb = new StringBuffer("com.winwin.picreport.Futils.hanhan.p.x{");
//            sb.append("x=").append(x);
//            sb.append(", str='").append(str).append('\'');
//            sb.append('}');
//            return sb.toString();
//        }
//    }

    /**
     *
     * */
    //@Test
//    private void f7(){
//        Field[] declaredFields = x.class.getDeclaredFields();
//        for(Field field:declaredFields){
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
//            p.p(field.getName());
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
//        }
//
//    }
 /**
     *输入一个字符串格式的数字,然后四舍五入到max和min的小数位数,一般max
     * 和min的值都写一样,比如max=min=4就是说四舍五入后小数后面留4位
     * */
    public static String getNum(int max,int min,String num){
        BigDecimal b;
        try {
            b = new BigDecimal(num);
        } catch (Exception e) {
            p("p.getNum yao format de bu shi shuZi001");
            e.printStackTrace();
            return null;
        }
        try {
            java.text.NumberFormat  f  =  java.text.DecimalFormat.getInstance();
            f.setMaximumFractionDigits(max);
            f.setMinimumFractionDigits(min);
            return f.format(b);
        } catch (Exception e) {
            p("p.getNum yao format de bu shi shuZi002");
            e.printStackTrace();
            return null;
        }
    }

    /*public static void main(String[]args){
            p.p(getNum(4,1,"657573.1423929831"));
    }*/




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *下面这个方法通常用于前端传过来的有
     * 文件
     * 我们通过
     * 文件名
     * 和
     * 得到的
     * 绝对路径
     * 来拼凑一个文件
     * 再创建
     * dirAbsolutePath
     * 是最后带一个斜杠的文件夹路径
     * fileName是文件名字
     *
     *
     * */
    public static File getFileByFileNameAndAbsolutePath(String dirAbsolutePath,String fileName){
        return new File(dirAbsolutePath, fileName);

    }
    //file.getAbsolutePath()  de dao de shi  zui hou dai  gang de jue dui lu jing
    public static File getFileByFileNameAndAbsolutePath(File file,String fileName){
        return new File(file.getAbsolutePath(), fileName);

    }

    /**
     *删除文件
     * */
    public static void Del(File file){
        if(file!=null&&file.exists()){
            file.delete();
        }
    }

    /**
     *通过路径打得到一个file,如果是springboot jar包同一级目录,路径指的就是一个文件名
     * 如果是其他项目,路径一般指的是全路径名
     * //注意,该方法如果不存在这个文件就会返回null是将来作为判断的
     * */
    public static File getFile(String path){
        File file = new File(path);
        if(file.exists()){
            return file;
        }else{
            return null;
        }
    }

    /**
     *根据文件判断文件是否存在
     * */
    public static boolean exists(File file){
        if(file==null){
            return false;
        }else{
            if(file.exists()){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean notExists(File file){
        return !exists(file);
    }
    /**
     *根据路径判断文件是否存在
     * */
    public static boolean notExists(String filePath){
        return !exists(filePath);
    }
    public static boolean exists(String filePath){
        if(null==filePath||"".equals(filePath)){
            return false;
        }else{
            File file=new File(filePath);
            if(file==null){
                return false;
            }else{
                if(file.exists()){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *是否是email
     * */

    public static boolean isEmail1(String emailStr){
        if (Pattern.compile(emailPattern1).matcher(emailStr).find()) {
            return true;
        }
        return false;
    }
    public static boolean isEmail2(String emailStr){
        if (Pattern.compile(emailPattern2).matcher(emailStr).find()) {
            return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *null和undefined变成""
     * */
    public static String nullUndefinedToSpace(String str){
        str=(str==null?"":str);
        str=("undefined".equals(str)?"":str);
        return str;
    }
    /**
     *前提是数字的时候null变成0,undefined变成0
     * */
    public static String NumNullUndefinedToStrZero(String str){
        str=(str==null?"0":str);
        str=("undefined".equals(str)?"0":str);
        return str;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *以下是空判断和非空判断以及所有非空判断和所有空的判断,如果是包含空的
     * 判断请用   !allNotEmpty
     * */

    public static boolean empty(Object ob){

        if(notEmpty(ob)){
            return false;
        }else{
            return true;
        }

    }




    public static boolean notEmpty(Object ob){
        if(ob==null){
            return false;
        }else{
            if(ob instanceof String){
                if("".equals(ob)){return false;}else{return true;}
            }else if(ob instanceof Collection){
                if(((Collection) ob).size()>0){return true;}else{return false;}
            }else if(ob instanceof Map){
                if(((Map) ob).size()>0){return true;}else{return false;}
            }/*else if(ob instanceof JSONObject){
                if(((JSONObject) ob).isEmpty()){return false;}else{
                    if(((JSONObject) ob).size()==0){return false;}else{return true;}
                }
            }else if(ob instanceof JSONArray){
                if(((JSONArray) ob).isEmpty()){return false;}else{
                    if(((JSONArray) ob).size()==0){return false;}else{return true;}
                }
            }*/else{return true;}
        }
    }

    //所有的非空
    public static boolean allNotEmpty(Object[ ]obs){
        for(Object ob:obs){
            if(!notEmpty(ob)){return false;}
        }
        return true;
    }

    //不是所有的是空的,有不为空的
    public static boolean notAllEmpty(Object[ ]obs){
        int i=0;
        for(Object ob:obs){
            if(notEmpty(ob)){i++;}
        }
        if(i>0){
            return true;
        }else{
            return false;
        }

    }
    //测试notAllEmpty
//    public static void main(String[]args){
//           p.p(notAllEmpty(p.gp().setArl("1").setArl(null).getArl().toArray()));
//    }

    public static boolean allEmpty(Object[ ]obs){
        for(int i=1;i<=obs.length;i++){
            /**
             *循环所有,如果有一个不是空的,就代表有不是空的,不是所有是空的,返回false
             * */
            if(notEmpty(obs[i])){
                return false;
            }
            /**
             *如果到了最后一个,也是空的,就返回true,代表所有的都空了
             * */
            if(empty(obs[i])&&i==obs.length){
                return true;
            }
        }
        return false;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *n倍相同字符串的设计
     * */

    public static String nStr(String s,int n){
        StringBuilder ss=new StringBuilder();
        for(int i=0;i<n;i++){
            ss.append(s);
        }
        return ss.toString();
    }

    /*public static void main(String[]args){
        p.p(p.gp().sad(p.dexhx).sad(p.nStr("草",5)).sad(p.dexhx).gad());
    }*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *计算整型的长度
     * */

    public static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

//    public static void main(String[]args){
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(p.sizeOfInt(213123))).sad(p.dexhx).gad());
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *是否是电话号码
     * */

    public static boolean isPhoneNo(String phoneNoStr){
        if (Pattern.compile(phonePattern).matcher(phoneNoStr).find()) {
            return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * addDate是负数就代表减去几天,addDate是正数代表加上几天
     * */
    public static Date getNextDay(Date date,int addDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,addDate);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

//    public static void main(String[] args) {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date date =new Date( );
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(getNextDay(date,3)));
//
//    }
////统计小数点后面位数//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *统计小数点后面位数
     * */

    public static Integer dianHouWeiShu(String shuZi){
        //得到点号后面的位数索引//从0开始//ejh是English句号的意思
        int i = shuZi.indexOf(p.ejh) + 1;
        //截取到shuZi小数点后面(不包括)所有的位数
        shuZi = shuZi.substring(i);
        //这个长度说的是字符长度,汉字跟字母数字都一样
        Integer length = shuZi.length();
        if(i==0) {
            //此时没有.号//点号后面肯定是0
            length=0;
        }
        if(Integer.valueOf(shuZi)==0){
            //针对123.0000D这种
            length=0;
        }
        return length;
    }
    public static Integer dianHouWeiShu(Double shuZi){
        return dianHouWeiShu(String.valueOf(shuZi));
    }

//    public static void main(String[]args){
//             p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(p.dianHouWeiShu(123123.001D))).sad(p.dexhx).gad());
//    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     * 判断每一位是否是数字,如果是小数有小数点,返回的是false
     * 如果每一个字符都是数字,返回true
     */
    public static boolean isNumeric(String str){
        if(null==str){
            return false;
        }else if("".equals(str)){
            return false;
        }else{
            if(Pattern.compile("[0-9]*").matcher(str).matches()){
                return true;
            }else{
                return false;
            }
        }
    }

//    public static void main(String[]args){
//        //_________________true_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isNumeric("11231212333333333333333333333333333333"))).sad(p.dexhx).gad());
//       //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isNumeric("1123.213123"))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isNumeric(""))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isNumeric(null))).sad(p.dexhx).gad());
//    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*方法二：推荐，速度最快
  * 判断是否为整数
  * @param str 传入的字符串
  * @return 是整数返回true,否则返回false//实际上超过long的都返回true
*/

    public static boolean isInteger(String str) {
        if(empty(str)){
            return false;
        }else{
            return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
        }

    }

//    public static void main(String[]args){
//        //_________________true_________________
//         p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isInteger("11111111111111111111111111111111111111111111111111111111111111111111"))).sad(p.dexhx).gad());
//        //_________________false_________________
//         p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isInteger("11.1"))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isInteger(""))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOf(isInteger(null))).sad(p.dexhx).gad());
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *将字符串写入文本,注意会覆盖原来的文本内容
     * 注意,这个写入文件,如果文件不存在,会自动创建并写入,但是文件 路径中的文件夹必须存在
     * */
    public static boolean  writeToTxt(String strToWrite,String txtPath) {

        FileWriter writer=null;
        try {
            writer = new FileWriter(txtPath);
            writer.write(strToWrite);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    public static void main(String[]args){
//        boolean b = writeToTxt("[\"1\",\"2\"]", "C:/123");
//        System.out.println(b);
//    }
    /**
     *读文本的所有内容变为字符串
     * 读取文本
     * */
    public static String readAllTxt(String txtPath){
        File file=null; FileReader fr=null;BufferedReader br=null;
        try {
            file=new File(txtPath);
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String str="";
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            return sb.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *对于打包后的springboot项目
     * 我们怎么读取资源路径？
     * 其实很简单
     * 所有  资源文件放到跟jar包同级目录  然后用
     * String pa = p.readAllTxt("资源文件.txt")
     * 在项目中就能读取
     *
     *
     * 注意,这玩意在云蕊服务器上连接微信的时候
     * 读取txt文件必须是ansi格式编码,原来的utf-8编码被读后是乱码
     * 这个可能跟txt文件在jar包外面和平台编码有关
     *
     * 就是说在读jar外面的文件,最好用notpad++转换成ANSI编码
     *
     * */

    public static String readAllTxt(File file){

        FileReader fr=null;BufferedReader br=null;
        try {
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String str="";
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            return sb.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[]args){
//         p.p(p.gp().sad(p.dexhx).sad(readAllTxt("E:\\1\\新建文本文档.txt")).sad(p.dexhx).gad());
//
//    }


    /**
     *将流读成字符串
     * 流变字符串,设定了50K以内
     * */

    /*public static void main(String[]args){

        String s = readInputUtf8ToString(p.class.getResourceAsStream("1"));
        p(s);
    }*/


    public static String readInputGBKToString(InputStream input){
        return readInputToString(input,"GBK");
    }

    public static String readInputUtf8ToString(InputStream input){
        return readInputToString(input,"UTF-8");
    }




    private static final int PROTECTED_LENGTH = 51200;// 输入流保护 50KB

    public static String readInputToString(InputStream input,String charSet){

        if (input == null) {
            throwE("----InputStream is  null----");
        }
        //字节数组
        byte[] bcache = new byte[2048];
        int readSize = 0;//每次读取的字节长度
        int totalSize = 0;//总字节长度
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            //一次性读取2048字节
            while ((readSize = input.read(bcache)) > 0) {
                totalSize += readSize;
                if (totalSize > PROTECTED_LENGTH) {
                    throwE("---InputStream more than 50KB-----");
                }
                //将bcache中读取的input数据写入infoStream
                infoStream.write(bcache,0,readSize);
            }
        } catch (IOException e1) {
            throwE("---read inputStream Exception--");
        } finally {
            try {
                //输入流关闭
                input.close();
            } catch (IOException e) {
                throwE("-----inputStream close Exception----");
            }
        }

        try {
            return infoStream.toString(charSet);
        } catch (UnsupportedEncodingException e) {
            throwE("---return String Exception---");
        }

        return "";


    }


    /**
     *读当前类所在目录下面的文件
     *
     * 对于springboot等打包的jar项目无效
     * 在普通的jar打包的java文件中有效
     * */


    public static String duDangQianLeiMuLuXiaDeWenJian
    (String wenJianMing,Class dangQianLeiClazz,String charSetOfTxt){


        try {
            InputStream resourceAsStream = dangQianLeiClazz.getResourceAsStream(wenJianMing);


            return readInputToString(resourceAsStream,charSetOfTxt);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(duDangQianLeiMuLuXiaDeWenJian("1",p.class,p.UTF8));
//        p.p("-------------------------------------------------------");
//    }


//    public static void main(String[]args){
//        String s = duDangQianLeiMuLuXiaDeWenJian("1", arraylist.class, p.UTF8);
//        p.p("-------------------------------------------------------");
//        p.p(s);
//        p.p("-------------------------------------------------------");
//
//
//    }

    /**
     *读取项目里面某个文件夹下的txt为String
     * 读取文本为字符串
     * 读取文本为String
     * @Param srcXiangDuiLuJingQianMianBuDaiGang 意思是src相对路径前面不带杠的意思
     *
     *
     * 输入从src下开始的路径如下即可
     * com/footing/website/hanhan/1
     *
     * 上面1是个文本文件 com文件夹是在src下面
     * */

    public static  String xiangDuiSrcDeLuJingDuTxt(String srcXiangDuiLuJingQianMianBuDaiGang){
        try {
            return readAllTxt(srcPath() + srcXiangDuiLuJingQianMianBuDaiGang);
        } catch (Exception e) {
            return "";
        }
    }


//    public static void main(String[]args){
//          p(xiangDuiSrcDeLuJingDuTxt("com/footing/website/hanhan/1"));
//    }


    /**
     *java读取资源文件
     * 读取properties文件
     * 读取properties资源文件
     * 资源读取不到返回null
     * 注意   pr.getProperty("key");可以直接拿到 文件里面的东西
     * */


    public static Properties readProp(String propertiesPath){
        Properties pr=new Properties();
        try {
            pr.load(new FileReader(propertiesPath));
        } catch (IOException e) {
            e.printStackTrace();
            //有异常的话,返回一个null;
            return null;
        }
//        pr.getProperty("key");
        return pr;
    }







//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     *得到springboot打包后的jar路径
     * */
    public static String jarPath() {
        /**
         *得到类似路径
         * E:/1/000/LinZhan
         * 我们打包后的springboot 的jar包就在LinZhan文件夹里面
         * */
        String path = p.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        synchronized (p.class) {
            path = path.replace("file:/", "");
            int i = path.lastIndexOf("!");
            i = i - 18;
            path = path.substring(0, i);
            path = path.substring(0, path.lastIndexOf("/"));
        }
        //处理路径中的%20为 " "
        if(path!=null&&path.contains(enCodeSpace)){
            path=path.replace(enCodeSpace,space);
        }
//       String path="E:/";
        return path;
    }



    /**
     * 通过当前类得到当前类的加载路径
     *路径
     * 类的加载路径(类clazz所在的文件夹)
     * E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/com/footing/website/hanhan/
     * */

    public static String classLoadPath(Class clazz){
        //得到的很可能是这种路径
        //          /E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/com/footing/website/hanhan/
        String s= clazz.getResource("").getPath();
        if(p.dy(p.xg,s.substring(0,1))){
            //得到这种  类所在的文件夹
            //           E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/com/footing/website/hanhan/
            s=s.substring(1);
        }
        return s;
    }


//    public static void main(String[]args){
//
//        p.p(classLoadPath(p.class));
//    }






    /**
     *  这种玩意对于导包jar的java启动文件有灾难性的后果,因为jar里面的路径从外面一直读是读不进去的
     *通过当前类 得到工程根目录,根路径  就是得到src路径
     * E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/
     * */

    public static String srcPath(){
        //得到的很可能是这种路径
        //          /E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/
        String s= p.class.getResource("/").getPath();
        if(p.dy("/",s.substring(0,1))){
            //得到这种  类所在的文件夹
            //           E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/
            s=s.substring(1);
        }
        return s;
    }


    /**
     /E:/1/work_space/CloudPlatformMobile002/target/classes/
     这种最前面带/的路径,  跟不带一样  但是这种路径对于打包的springboot来讲,是灾难的
     因为打包后,就无法深入到jar文件内部去读取了
     * */
    public static String srcPathYuan(){
        //得到的很可能是这种路径
        //          /E:/1/work_space/luxclub_jeesite/out/production/luxclub_jeesite/
        String s= p.class.getResource("/").getPath();
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/**
 *response跨域设置
 * */
    public static void kuaYuAndUtf8Response(HttpServletResponse response, String Content_type, String charset){
    //        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding(charset);
    //        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setHeader("Content-type", Content_type);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
    }
    //////////md5////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        public static void main(String[] args){
//           System.out.println(md5Up32("ceshi0051657786").length());
//            System.out.println(md5_32("ceshi0051657786"));
//        }

    /**
     * 把字符串变成MD5加密码,顺便大写了
     * */
    public static String md5Up32(String inputString) {
        return generatePasswordToUpperCase(inputString);
    }

    /**
     * 把字符串变成MD5加密码,不大写
     * */
    public static String md5_32(String inputString) {
        return encodeByMD5(inputString);
    }

    public static String generatePasswordToUpperCase(String inputString) {
        return encodeByMD5(inputString).toUpperCase();
    }
    //////////////////////////////////////////////////////////////////////////////
    public static String generatePassword(String inputString) {
        return encodeByMD5(inputString);
    }
    //////////////////////////////////////////////////////////////////////////////
    public static String generateHexString(byte[] inputByte) {
        return encodeByMD5(inputByte);
    }

    private static String encodeByMD5(byte[] originByte) {
        if (originByte != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originByte);
                String resultString = byteArrayToHexString(results);
                String pass = resultString.toUpperCase();
                return pass;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originString.getBytes());
                String resultString = byteArrayToHexString(results);
                String pass = resultString;
                return pass;
            } catch (Exception ex) {
                ex.printStackTrace();//TODO change to use logger?
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     *图片和base64互转
     * */

    //图片转化成base64字符串
    public static String GetImageStr(String imagePath)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imagePath;//待处理的图片
        InputStream in = null;
        byte[] data = null;
//读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,String pathToGenerateImg)
    { //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
//Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
//生成jpeg图片
//新生成的图片
            OutputStream out = new FileOutputStream(pathToGenerateImg);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    ///////////////////////////////////////////////////////////////////////
//base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,File file)

    {
        System.out.println("开始把图片放入文件夹");
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
//Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
//生成jpeg图片
//新生成的图片
            System.out.println("==============="+file.getAbsolutePath());
            OutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //异常抛出
    public static void throwE(String s){
        throw new RuntimeException(s);
    }
    //异常抛出
    public static void throwE(Exception e){
        throw new RuntimeException(e);
    }
    //去除空白符
    public static String replaceBlank(String str){
        String dest = null;
        if(str == null){
            return dest;
        }else{
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
            return dest;
        }
    }



//    public static void main(String[]args){
//        String s=p.readAllTxt("E:\\1\\work_space\\LinZhan_Picture_ReportTable\\src\\main\\java\\com\\winwin\\picreport\\Bcontroller\\loginRegistModul\\auth\\权限的json.json");
//
//        p(replaceBlank(s));
//    }


    //去掉字符串数字末尾的0
//    public static void main(String[]args){
//            p(new BigDecimal("0.10000"));
//    }

    /**
     *转换编码
     * 编码转换
     * 字符串编码转换
     * */


    /**
     *转换失败变为null
     * */
    public static String changeCharsetNull(String str,String beforeCharset,String afterCharset){
        try {
            return new String(str.getBytes(beforeCharset),afterCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *转换失败变为 ""
     * */
    public static String changeCharsetSpacec(String str,String beforeCharset,String afterCharset){
        try {
            return new String(str.getBytes(beforeCharset),afterCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String  strUtf8ToGBKNull(String str) {
        try {
            return new String(str.getBytes("UTF-8"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String  strUtf8ToGBKSpace(String str) {
        try {
            return new String(str.getBytes("UTF-8"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String  strUtf8ToGB2312Null(String str) {
        try {
            return new String(str.getBytes("UTF-8"),"GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String  strUtf8ToGB2312Space(String str) {
        try {
            return new String(str.getBytes("UTF-8"),"GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String  strGBKToUtf8Space(String str) {
        try {
            return new String(str.getBytes("GBK"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String  strGBKToUtf8Null(String str) {
        try {
            return new String(str.getBytes("GBK"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String  strGB2312ToUtf8Null(String str) {
        try {
            return new String(str.getBytes("GB2312"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String  strGB2312ToUtf8Space(String str) {
        try {
            return new String(str.getBytes("GB2312"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

//    public static void main(String[]args) throws UnsupportedEncodingException {
//        String s="\u672a\u77e5\u9519\u8bef\uff0c\u8bf7\u8054\u7cfb\u7cfb\u7edf\u7ba1\u7406\u5458\u3002";
//        String s101 = p.changeCharsetNull(s, "utf-8", "utf-8");
//        p.p(s101);
//    }
/////////////////////////////微信排序///////////////////////////////////////////////////////////////////////////

    /**
     *根据list排序参数
     * 字典排序
     * */
    //排序后不拼接字符串
    public static List<String> ziDianPaiXu(List<String> weiPaiXuDeZiFuChuanJiHe){
        Collections.sort(weiPaiXuDeZiFuChuanJiHe);
        return weiPaiXuDeZiFuChuanJiHe;
    }

    //排序后再拼接字符串
    public static String ziDianPaiXuBingPinJie(List<String> weiPaiXuDeZiFuChuanJiHe){
        Collections.sort(weiPaiXuDeZiFuChuanJiHe);
        StringBuilder sb=new StringBuilder();
        for(String s:weiPaiXuDeZiFuChuanJiHe){
            sb.append(s);
        }
        return sb.toString();
    }






    public static void fuckIt(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {

        }
    }

    /**
     *线程休眠
     * */
    public static void sleep(long haoMiao) {
        try {
            Thread.sleep(haoMiao);
        } catch (InterruptedException e) {

        }
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(digitUpper(0.01));//打印  壹分
//        p.p("-------------------------------------------------------");
//    }

    /**
     * 数字金额大写转换
     * //只能精确到分
     * 异常的时候返回空
     */
    public static String digitUpper(double n) {
        try {
            String fraction[] = { "角", "分" };
            String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
            String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

            String head = n < 0 ? "负" : "";
            n = Math.abs(n);

            String s = "";
            for (int i = 0; i < fraction.length; i++) {
                s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
            }
            if (s.length() < 1) {
                s = "整";
            }
            int integerPart = (int) Math.floor(n);

            for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
                String p = "";
                for (int j = 0; j < unit[1].length && n > 0; j++) {
                    p = digit[integerPart % 10] + unit[1][j] + p;
                    integerPart = integerPart / 10;
                }
                s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
            }
            return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
    /**
     *封装三目运算符号
     * */
    public static Object threeEyeCalculate(boolean condition,Object trueIt,Object falseIt){

        return condition?trueIt:falseIt;

    }
    public static String threeEyeCalculate(boolean condition,String trueIt,String falseIt){

        return condition?trueIt:falseIt;

    }
    public static int threeEyeCalculate(boolean condition,int trueIt,int falseIt){

        return condition?trueIt:falseIt;

    }
    public static Integer  threeEyeCalculate(boolean condition,Integer trueIt,Integer falseIt){

        return condition?trueIt:falseIt;

    }
    public static Double  threeEyeCalculate(boolean condition,Double trueIt,Double falseIt){

        return condition?trueIt:falseIt;

    }
    public static double  threeEyeCalculate(boolean condition,double trueIt,double falseIt){

        return condition?trueIt:falseIt;

    }
    public static float  threeEyeCalculate(boolean condition,float trueIt,float falseIt){

        return condition?trueIt:falseIt;

    }
    public static Float  threeEyeCalculate(boolean condition,Float trueIt,Float falseIt){

        return condition?trueIt:falseIt;

    }
    public static BigDecimal  threeEyeCalculate(boolean condition,BigDecimal trueIt,BigDecimal falseIt){

        return condition?trueIt:falseIt;

    }
    public static Long  threeEyeCalculate(boolean condition,Long trueIt,Long falseIt){

        return condition?trueIt:falseIt;

    }
    public static long  threeEyeCalculate(boolean condition,long trueIt,long falseIt){

        return condition?trueIt:falseIt;

    }
    public static short  threeEyeCalculate(boolean condition,short trueIt,short falseIt){

        return condition?trueIt:falseIt;

    }
    public static Short  threeEyeCalculate(boolean condition,Short trueIt,Short falseIt){

        return condition?trueIt:falseIt;

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final long fuckIt=5*1000;
    public static final String fuckTime="2019-12-25";

    public	final	static	int	n0	=	0	;
    public	final	static	int	n1	=	1	;
    public	final	static	int	n2	=	2	;
    public	final	static	int	n3	=	3	;
    public	final	static	int	n4	=	4	;
    public	final	static	int	n5	=	5	;
    public	final	static	int	n6	=	6	;
    public	final	static	int	n7	=	7	;
    public	final	static	int	n8	=	8	;
    public	final	static	int	n9	=	9	;
    public	final	static	int	n10	=	10	;
    public	final	static	int	n11	=	11	;
    public	final	static	int	n12	=	12	;
    public	final	static	int	n13	=	13	;
    public	final	static	int	n14	=	14	;
    public	final	static	int	n15	=	15	;
    public	final	static	int	n16	=	16	;
    public	final	static	int	n17	=	17	;
    public	final	static	int	n18	=	18	;
    public	final	static	int	n19	=	19	;
    public	final	static	int	n20	=	20	;
    public	final	static	int	n21	=	21	;
    public	final	static	int	n22	=	22	;
    public	final	static	int	n23	=	23	;
    public	final	static	int	n24	=	24	;
    public	final	static	int	n25	=	25	;
    public	final	static	int	n26	=	26	;
    public	final	static	int	n27	=	27	;
    public	final	static	int	n28	=	28	;
    public	final	static	int	n29	=	29	;
    public	final	static	int	n30	=	30	;
    public	final	static	int	n31	=	31	;
    public	final	static	int	n32	=	32	;
    public	final	static	int	n33	=	33	;
    public	final	static	int	n34	=	34	;
    public	final	static	int	n35	=	35	;
    public	final	static	int	n36	=	36	;
    public	final	static	int	n37	=	37	;
    public	final	static	int	n38	=	38	;
    public	final	static	int	n39	=	39	;
    public	final	static	int	n40	=	40	;
    public	final	static	int	n41	=	41	;
    public	final	static	int	n42	=	42	;
    public	final	static	int	n43	=	43	;
    public	final	static	int	n44	=	44	;
    public	final	static	int	n45	=	45	;
    public	final	static	int	n46	=	46	;
    public	final	static	int	n47	=	47	;
    public	final	static	int	n48	=	48	;
    public	final	static	int	n49	=	49	;
    public	final	static	int	n50	=	50	;
    public	final	static	int	n51	=	51	;
    public	final	static	int	n52	=	52	;
    public	final	static	int	n53	=	53	;
    public	final	static	int	n54	=	54	;
    public	final	static	int	n55	=	55	;
    public	final	static	int	n56	=	56	;
    public	final	static	int	n57	=	57	;
    public	final	static	int	n58	=	58	;
    public	final	static	int	n59	=	59	;
    public	final	static	int	n60	=	60	;
    public	final	static	int	n61	=	61	;
    public	final	static	int	n62	=	62	;
    public	final	static	int	n63	=	63	;
    public	final	static	int	n64	=	64	;
    public	final	static	int	n65	=	65	;
    public	final	static	int	n66	=	66	;
    public	final	static	int	n67	=	67	;
    public	final	static	int	n68	=	68	;
    public	final	static	int	n69	=	69	;
    public	final	static	int	n70	=	70	;
    public	final	static	int	n71	=	71	;
    public	final	static	int	n72	=	72	;
    public	final	static	int	n73	=	73	;
    public	final	static	int	n74	=	74	;
    public	final	static	int	n75	=	75	;
    public	final	static	int	n76	=	76	;
    public	final	static	int	n77	=	77	;
    public	final	static	int	n78	=	78	;
    public	final	static	int	n79	=	79	;
    public	final	static	int	n80	=	80	;
    public	final	static	int	n81	=	81	;
    public	final	static	int	n82	=	82	;
    public	final	static	int	n83	=	83	;
    public	final	static	int	n84	=	84	;
    public	final	static	int	n85	=	85	;
    public	final	static	int	n86	=	86	;
    public	final	static	int	n87	=	87	;
    public	final	static	int	n88	=	88	;
    public	final	static	int	n89	=	89	;
    public	final	static	int	n90	=	90	;
    public	final	static	int	n91	=	91	;
    public	final	static	int	n92	=	92	;
    public	final	static	int	n93	=	93	;
    public	final	static	int	n94	=	94	;
    public	final	static	int	n95	=	95	;
    public	final	static	int	n96	=	96	;
    public	final	static	int	n97	=	97	;
    public	final	static	int	n98	=	98	;
    public	final	static	int	n99	=	99	;
    public	final	static	int	n100	=	100	;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public	final	static	String	s0	=	"0"	;
    public	final	static	String	s1	=	"1"	;
    public	final	static	String	s2	=	"2"	;
    public	final	static	String	s3	=	"3"	;
    public	final	static	String	s4	=	"4"	;
    public	final	static	String	s5	=	"5"	;
    public	final	static	String	s6	=	"6"	;
    public	final	static	String	s7	=	"7"	;
    public	final	static	String	s8	=	"8"	;
    public	final	static	String	s9	=	"9"	;
    public	final	static	String	s10	=	"10"	;
    public	final	static	String	s11	=	"11"	;
    public	final	static	String	s12	=	"12"	;
    public	final	static	String	s13	=	"13"	;
    public	final	static	String	s14	=	"14"	;
    public	final	static	String	s15	=	"15"	;
    public	final	static	String	s16	=	"16"	;
    public	final	static	String	s17	=	"17"	;
    public	final	static	String	s18	=	"18"	;
    public	final	static	String	s19	=	"19"	;
    public	final	static	String	s20	=	"20"	;
    public	final	static	String	s21	=	"21"	;
    public	final	static	String	s22	=	"22"	;
    public	final	static	String	s23	=	"23"	;
    public	final	static	String	s24	=	"24"	;
    public	final	static	String	s25	=	"25"	;
    public	final	static	String	s26	=	"26"	;
    public	final	static	String	s27	=	"27"	;
    public	final	static	String	s28	=	"28"	;
    public	final	static	String	s29	=	"29"	;
    public	final	static	String	s30	=	"30"	;
    public	final	static	String	s31	=	"31"	;
    public	final	static	String	s32	=	"32"	;
    public	final	static	String	s33	=	"33"	;
    public	final	static	String	s34	=	"34"	;
    public	final	static	String	s35	=	"35"	;
    public	final	static	String	s36	=	"36"	;
    public	final	static	String	s37	=	"37"	;
    public	final	static	String	s38	=	"38"	;
    public	final	static	String	s39	=	"39"	;
    public	final	static	String	s40	=	"40"	;
    public	final	static	String	s41	=	"41"	;
    public	final	static	String	s42	=	"42"	;
    public	final	static	String	s43	=	"43"	;
    public	final	static	String	s44	=	"44"	;
    public	final	static	String	s45	=	"45"	;
    public	final	static	String	s46	=	"46"	;
    public	final	static	String	s47	=	"47"	;
    public	final	static	String	s48	=	"48"	;
    public	final	static	String	s49	=	"49"	;
    public	final	static	String	s50	=	"50"	;
    public	final	static	String	s51	=	"51"	;
    public	final	static	String	s52	=	"52"	;
    public	final	static	String	s53	=	"53"	;
    public	final	static	String	s54	=	"54"	;
    public	final	static	String	s55	=	"55"	;
    public	final	static	String	s56	=	"56"	;
    public	final	static	String	s57	=	"57"	;
    public	final	static	String	s58	=	"58"	;
    public	final	static	String	s59	=	"59"	;
    public	final	static	String	s60	=	"60"	;
    public	final	static	String	s61	=	"61"	;
    public	final	static	String	s62	=	"62"	;
    public	final	static	String	s63	=	"63"	;
    public	final	static	String	s64	=	"64"	;
    public	final	static	String	s65	=	"65"	;
    public	final	static	String	s66	=	"66"	;
    public	final	static	String	s67	=	"67"	;
    public	final	static	String	s68	=	"68"	;
    public	final	static	String	s69	=	"69"	;
    public	final	static	String	s70	=	"70"	;
    public	final	static	String	s71	=	"71"	;
    public	final	static	String	s72	=	"72"	;
    public	final	static	String	s73	=	"73"	;
    public	final	static	String	s74	=	"74"	;
    public	final	static	String	s75	=	"75"	;
    public	final	static	String	s76	=	"76"	;
    public	final	static	String	s77	=	"77"	;
    public	final	static	String	s78	=	"78"	;
    public	final	static	String	s79	=	"79"	;
    public	final	static	String	s80	=	"80"	;
    public	final	static	String	s81	=	"81"	;
    public	final	static	String	s82	=	"82"	;
    public	final	static	String	s83	=	"83"	;
    public	final	static	String	s84	=	"84"	;
    public	final	static	String	s85	=	"85"	;
    public	final	static	String	s86	=	"86"	;
    public	final	static	String	s87	=	"87"	;
    public	final	static	String	s88	=	"88"	;
    public	final	static	String	s89	=	"89"	;
    public	final	static	String	s90	=	"90"	;
    public	final	static	String	s91	=	"91"	;
    public	final	static	String	s92	=	"92"	;
    public	final	static	String	s93	=	"93"	;
    public	final	static	String	s94	=	"94"	;
    public	final	static	String	s95	=	"95"	;
    public	final	static	String	s96	=	"96"	;
    public	final	static	String	s97	=	"97"	;
    public	final	static	String	s98	=	"98"	;
    public	final	static	String	s99	=	"99"	;
    public	final	static	String	s100	=	"100"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	int	n_100	=	-100	;
    public	final	static	int	n_99	=	-99	;
    public	final	static	int	n_98	=	-98	;
    public	final	static	int	n_97	=	-97	;
    public	final	static	int	n_96	=	-96	;
    public	final	static	int	n_95	=	-95	;
    public	final	static	int	n_94	=	-94	;
    public	final	static	int	n_93	=	-93	;
    public	final	static	int	n_92	=	-92	;
    public	final	static	int	n_91	=	-91	;
    public	final	static	int	n_90	=	-90	;
    public	final	static	int	n_89	=	-89	;
    public	final	static	int	n_88	=	-88	;
    public	final	static	int	n_87	=	-87	;
    public	final	static	int	n_86	=	-86	;
    public	final	static	int	n_85	=	-85	;
    public	final	static	int	n_84	=	-84	;
    public	final	static	int	n_83	=	-83	;
    public	final	static	int	n_82	=	-82	;
    public	final	static	int	n_81	=	-81	;
    public	final	static	int	n_80	=	-80	;
    public	final	static	int	n_79	=	-79	;
    public	final	static	int	n_78	=	-78	;
    public	final	static	int	n_77	=	-77	;
    public	final	static	int	n_76	=	-76	;
    public	final	static	int	n_75	=	-75	;
    public	final	static	int	n_74	=	-74	;
    public	final	static	int	n_73	=	-73	;
    public	final	static	int	n_72	=	-72	;
    public	final	static	int	n_71	=	-71	;
    public	final	static	int	n_70	=	-70	;
    public	final	static	int	n_69	=	-69	;
    public	final	static	int	n_68	=	-68	;
    public	final	static	int	n_67	=	-67	;
    public	final	static	int	n_66	=	-66	;
    public	final	static	int	n_65	=	-65	;
    public	final	static	int	n_64	=	-64	;
    public	final	static	int	n_63	=	-63	;
    public	final	static	int	n_62	=	-62	;
    public	final	static	int	n_61	=	-61	;
    public	final	static	int	n_60	=	-60	;
    public	final	static	int	n_59	=	-59	;
    public	final	static	int	n_58	=	-58	;
    public	final	static	int	n_57	=	-57	;
    public	final	static	int	n_56	=	-56	;
    public	final	static	int	n_55	=	-55	;
    public	final	static	int	n_54	=	-54	;
    public	final	static	int	n_53	=	-53	;
    public	final	static	int	n_52	=	-52	;
    public	final	static	int	n_51	=	-51	;
    public	final	static	int	n_50	=	-50	;
    public	final	static	int	n_49	=	-49	;
    public	final	static	int	n_48	=	-48	;
    public	final	static	int	n_47	=	-47	;
    public	final	static	int	n_46	=	-46	;
    public	final	static	int	n_45	=	-45	;
    public	final	static	int	n_44	=	-44	;
    public	final	static	int	n_43	=	-43	;
    public	final	static	int	n_42	=	-42	;
    public	final	static	int	n_41	=	-41	;
    public	final	static	int	n_40	=	-40	;
    public	final	static	int	n_39	=	-39	;
    public	final	static	int	n_38	=	-38	;
    public	final	static	int	n_37	=	-37	;
    public	final	static	int	n_36	=	-36	;
    public	final	static	int	n_35	=	-35	;
    public	final	static	int	n_34	=	-34	;
    public	final	static	int	n_33	=	-33	;
    public	final	static	int	n_32	=	-32	;
    public	final	static	int	n_31	=	-31	;
    public	final	static	int	n_30	=	-30	;
    public	final	static	int	n_29	=	-29	;
    public	final	static	int	n_28	=	-28	;
    public	final	static	int	n_27	=	-27	;
    public	final	static	int	n_26	=	-26	;
    public	final	static	int	n_25	=	-25	;
    public	final	static	int	n_24	=	-24	;
    public	final	static	int	n_23	=	-23	;
    public	final	static	int	n_22	=	-22	;
    public	final	static	int	n_21	=	-21	;
    public	final	static	int	n_20	=	-20	;
    public	final	static	int	n_19	=	-19	;
    public	final	static	int	n_18	=	-18	;
    public	final	static	int	n_17	=	-17	;
    public	final	static	int	n_16	=	-16	;
    public	final	static	int	n_15	=	-15	;
    public	final	static	int	n_14	=	-14	;
    public	final	static	int	n_13	=	-13	;
    public	final	static	int	n_12	=	-12	;
    public	final	static	int	n_11	=	-11	;
    public	final	static	int	n_10	=	-10	;
    public	final	static	int	n_9	=	-9	;
    public	final	static	int	n_8	=	-8	;
    public	final	static	int	n_7	=	-7	;
    public	final	static	int	n_6	=	-6	;
    public	final	static	int	n_5	=	-5	;
    public	final	static	int	n_4	=	-4	;
    public	final	static	int	n_3	=	-3	;
    public	final	static	int	n_2	=	-2	;
    public	final	static	int	n_1	=	-1	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public	final	static	String	s_100	=	"-100"	;
    public	final	static	String	s_99	=	"-99"	;
    public	final	static	String	s_98	=	"-98"	;
    public	final	static	String	s_97	=	"-97"	;
    public	final	static	String	s_96	=	"-96"	;
    public	final	static	String	s_95	=	"-95"	;
    public	final	static	String	s_94	=	"-94"	;
    public	final	static	String	s_93	=	"-93"	;
    public	final	static	String	s_92	=	"-92"	;
    public	final	static	String	s_91	=	"-91"	;
    public	final	static	String	s_90	=	"-90"	;
    public	final	static	String	s_89	=	"-89"	;
    public	final	static	String	s_88	=	"-88"	;
    public	final	static	String	s_87	=	"-87"	;
    public	final	static	String	s_86	=	"-86"	;
    public	final	static	String	s_85	=	"-85"	;
    public	final	static	String	s_84	=	"-84"	;
    public	final	static	String	s_83	=	"-83"	;
    public	final	static	String	s_82	=	"-82"	;
    public	final	static	String	s_81	=	"-81"	;
    public	final	static	String	s_80	=	"-80"	;
    public	final	static	String	s_79	=	"-79"	;
    public	final	static	String	s_78	=	"-78"	;
    public	final	static	String	s_77	=	"-77"	;
    public	final	static	String	s_76	=	"-76"	;
    public	final	static	String	s_75	=	"-75"	;
    public	final	static	String	s_74	=	"-74"	;
    public	final	static	String	s_73	=	"-73"	;
    public	final	static	String	s_72	=	"-72"	;
    public	final	static	String	s_71	=	"-71"	;
    public	final	static	String	s_70	=	"-70"	;
    public	final	static	String	s_69	=	"-69"	;
    public	final	static	String	s_68	=	"-68"	;
    public	final	static	String	s_67	=	"-67"	;
    public	final	static	String	s_66	=	"-66"	;
    public	final	static	String	s_65	=	"-65"	;
    public	final	static	String	s_64	=	"-64"	;
    public	final	static	String	s_63	=	"-63"	;
    public	final	static	String	s_62	=	"-62"	;
    public	final	static	String	s_61	=	"-61"	;
    public	final	static	String	s_60	=	"-60"	;
    public	final	static	String	s_59	=	"-59"	;
    public	final	static	String	s_58	=	"-58"	;
    public	final	static	String	s_57	=	"-57"	;
    public	final	static	String	s_56	=	"-56"	;
    public	final	static	String	s_55	=	"-55"	;
    public	final	static	String	s_54	=	"-54"	;
    public	final	static	String	s_53	=	"-53"	;
    public	final	static	String	s_52	=	"-52"	;
    public	final	static	String	s_51	=	"-51"	;
    public	final	static	String	s_50	=	"-50"	;
    public	final	static	String	s_49	=	"-49"	;
    public	final	static	String	s_48	=	"-48"	;
    public	final	static	String	s_47	=	"-47"	;
    public	final	static	String	s_46	=	"-46"	;
    public	final	static	String	s_45	=	"-45"	;
    public	final	static	String	s_44	=	"-44"	;
    public	final	static	String	s_43	=	"-43"	;
    public	final	static	String	s_42	=	"-42"	;
    public	final	static	String	s_41	=	"-41"	;
    public	final	static	String	s_40	=	"-40"	;
    public	final	static	String	s_39	=	"-39"	;
    public	final	static	String	s_38	=	"-38"	;
    public	final	static	String	s_37	=	"-37"	;
    public	final	static	String	s_36	=	"-36"	;
    public	final	static	String	s_35	=	"-35"	;
    public	final	static	String	s_34	=	"-34"	;
    public	final	static	String	s_33	=	"-33"	;
    public	final	static	String	s_32	=	"-32"	;
    public	final	static	String	s_31	=	"-31"	;
    public	final	static	String	s_30	=	"-30"	;
    public	final	static	String	s_29	=	"-29"	;
    public	final	static	String	s_28	=	"-28"	;
    public	final	static	String	s_27	=	"-27"	;
    public	final	static	String	s_26	=	"-26"	;
    public	final	static	String	s_25	=	"-25"	;
    public	final	static	String	s_24	=	"-24"	;
    public	final	static	String	s_23	=	"-23"	;
    public	final	static	String	s_22	=	"-22"	;
    public	final	static	String	s_21	=	"-21"	;
    public	final	static	String	s_20	=	"-20"	;
    public	final	static	String	s_19	=	"-19"	;
    public	final	static	String	s_18	=	"-18"	;
    public	final	static	String	s_17	=	"-17"	;
    public	final	static	String	s_16	=	"-16"	;
    public	final	static	String	s_15	=	"-15"	;
    public	final	static	String	s_14	=	"-14"	;
    public	final	static	String	s_13	=	"-13"	;
    public	final	static	String	s_12	=	"-12"	;
    public	final	static	String	s_11	=	"-11"	;
    public	final	static	String	s_10	=	"-10"	;
    public	final	static	String	s_9	=	"-9"	;
    public	final	static	String	s_8	=	"-8"	;
    public	final	static	String	s_7	=	"-7"	;
    public	final	static	String	s_6	=	"-6"	;
    public	final	static	String	s_5	=	"-5"	;
    public	final	static	String	s_4	=	"-4"	;
    public	final	static	String	s_3	=	"-3"	;
    public	final	static	String	s_2	=	"-2"	;
    public	final	static	String	s_1	=	"-1"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	String	stra	=	"a"	;
    public	final	static	String	strb	=	"b"	;
    public	final	static	String	strc	=	"c"	;
    public	final	static	String	strd	=	"d"	;
    public	final	static	String	stre	=	"e"	;
    public	final	static	String	strf	=	"f"	;
    public	final	static	String	strg	=	"g"	;
    public	final	static	String	strh	=	"h"	;
    public	final	static	String	stri	=	"i"	;
    public	final	static	String	strj	=	"j"	;
    public	final	static	String	strk	=	"k"	;
    public	final	static	String	strl	=	"l"	;
    public	final	static	String	strm	=	"m"	;
    public	final	static	String	strn	=	"n"	;
    public	final	static	String	stro	=	"o"	;
    public	final	static	String	strp	=	"p"	;
    public	final	static	String	strq	=	"q"	;
    public	final	static	String	strr	=	"r"	;
    public	final	static	String	strs	=	"s"	;
    public	final	static	String	strt	=	"t"	;
    public	final	static	String	stru	=	"u"	;
    public	final	static	String	strv	=	"v"	;
    public	final	static	String	strw	=	"w"	;
    public	final	static	String	strx	=	"x"	;
    public	final	static	String	stry	=	"y"	;
    public	final	static	String	strz	=	"z"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	String	strA	=	"A"	;
    public	final	static	String	strB	=	"B"	;
    public	final	static	String	strC	=	"C"	;
    public	final	static	String	strD	=	"D"	;
    public	final	static	String	strE	=	"E"	;
    public	final	static	String	strF	=	"F"	;
    public	final	static	String	strG	=	"G"	;
    public	final	static	String	strH	=	"H"	;
    public	final	static	String	strI	=	"I"	;
    public	final	static	String	strJ	=	"J"	;
    public	final	static	String	strK	=	"K"	;
    public	final	static	String	strL	=	"L"	;
    public	final	static	String	strM	=	"M"	;
    public	final	static	String	strN	=	"N"	;
    public	final	static	String	strO	=	"O"	;
    public	final	static	String	strP	=	"P"	;
    public	final	static	String	strQ	=	"Q"	;
    public	final	static	String	strR	=	"R"	;
    public	final	static	String	strS	=	"S"	;
    public	final	static	String	strT	=	"T"	;
    public	final	static	String	strU	=	"U"	;
    public	final	static	String	strV	=	"V"	;
    public	final	static	String	strW	=	"W"	;
    public	final	static	String	strX	=	"X"	;
    public	final	static	String	strY	=	"Y"	;
    public	final	static	String	strZ	=	"Z"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



















////////////////////////////////////////////////////////////////////////////////////////////////
}

