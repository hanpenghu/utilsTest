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
public strictfp class p implements pI{
    /**
     *对于打包后的springboot项目
     * 我们怎么读取资源路径？
     * 其实很简单
     * 所有  资源文件放到跟jar包同级目录  然后用
     * String pa = p.readAllTxt("资源文件.txt")
     * 在项目中就能读取
     *
     * */

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

   















////////////////////////////////////////////////////////////////////////////////////////////////
}

