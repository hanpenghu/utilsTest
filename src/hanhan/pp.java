package hanhan;


import org.apache.commons.codec.digest.DigestUtils;

/**
 *用于测试封装外部jar包的工具
 * */
public class pp {


    /**
     *封装log4j的得到实例
     * */
    public static org.apache.log4j.Logger getLogger(Object o){
        return org.apache.log4j.LogManager.getLogger(o.getClass().getName());
    }


    /**
     *封装apahce包的sha1加密
     * */
    public static String sha1(String s){

        return DigestUtils.shaHex(s);
    }



}
