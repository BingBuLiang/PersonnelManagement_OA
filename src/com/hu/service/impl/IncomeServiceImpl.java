package com.hu.service.impl;

import com.hu.dao.IncomeDao;
import com.hu.dao.PaymentDao;
import com.hu.dao.impl.IncomDaoImpl;
import com.hu.dao.impl.PaymentDaoImpl;
import com.hu.service.IncomeService;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-07-09 15:46
 * @decription
 **/
public class IncomeServiceImpl implements IncomeService {

    @Override
    public String getBarData() {

        IncomeDao icDao = new IncomDaoImpl();
        List<Object []> list = icDao.findStaticsData();

        StringBuilder icTypeArr = new StringBuilder("[");
        StringBuilder amountArr = new StringBuilder("[");
        for(int i=0;i<list.size();i++){
            Object [] arr = list.get(i);
            if(i<list.size()-1){
                icTypeArr.append("\""+arr[0]+"\",");
                amountArr.append(arr[1]+",");
            }else{
                icTypeArr.append("\""+arr[0]+"\"");
                amountArr.append(arr[1]);
            }
        }
        icTypeArr.append("]");
        amountArr.append("]");


        String jsonStr = "["+icTypeArr.toString()+","+amountArr.toString()+"]";
        return jsonStr;
    }

    @Override
    public String getPieData(int type) {
        //调用DAO层获取支出入数据（List）
        PaymentDao pmDao = new PaymentDaoImpl();
        List<Object []> list = pmDao.findStaticsData(type);

        StringBuilder jsonStr =new StringBuilder("[");
        for(int i=0;i<list.size();i++){
            Object [] arr = list.get(i);
            jsonStr.append("{");
            jsonStr.append("\"value\":"+arr[1]+",");
            jsonStr.append("\"name\":\""+arr[0]+"\"");

            if(i<list.size()-1){
                jsonStr.append("},");
            }else{
                jsonStr.append("}");
            }

        }
        jsonStr.append("]");

        //返回jsonStr
        return jsonStr.toString();
    }

}
