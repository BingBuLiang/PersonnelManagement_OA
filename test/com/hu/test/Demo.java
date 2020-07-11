package com.hu.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 14:27
 * @decription
 **/
public class Demo {
    public static void main(String[] args) {
       /* String uri="/huoa/EmployeeServlet";
        int m=uri.indexOf("hyyy");
        System.out.println(m);
*/
        List<String> list = new ArrayList<String>();

        list.add("1");
        list.add("2");
        list.add("3");

       /* for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }*/
//        System.out.println(list.contains(new String("1")));
  /*List<Singer> singerList=new SingerDaoImpl().findSinger(null,null,null);
        System.out.println(new Gson().toJson(singerList));
    }*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));
    }
}
