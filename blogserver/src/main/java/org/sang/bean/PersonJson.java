package org.sang.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


class ParseJson {
    public static void main(String[] args){

//        parseObject方法将对象形式的json字符串转换为对象
        String jsonStr = "{\"AGE\":15,\"DATE OF BIRTH\":1635735500370,\"FULL NAME\":\"John Doe\"}";
        JSONObject jObj = JSON.parseObject(jsonStr);
        Date dBirth = jObj.getDate("DATE OF BIRTH");
        System.out.println("--------------------------------------");
        System.out.println("jObj"+jObj);
        System.out.println(dBirth);
        System.out.println("00000000000000000000000000000000000000:");

//        parseObject方法将数组形式的json字符串转换为对象数组
        String jsonObjList = "[{\"AGE\":15,\"DATE OF BIRTH\":1635738540186,\"FULL NAME\":\"John Doe\"},{\"AGE\":20,\"DATE OF BIRTH\":1635738540186,\"FULL NAME\":\"Janette Doe\"}]";
        Person[] personList = JSON.parseObject(jsonObjList, new TypeReference<Person[]>(){});
        List list = Arrays.asList(personList);
        System.out.println(list);

//        parseArray方法将数组形式的json字符:1串转换为对象数组
        JSONArray personArray = JSON.parseArray(jsonObjList);
        System.out.println(personArray);
        for(int i=0; i<personArray.size();i++){
            JSONObject jsonObject = personArray.getJSONObject(i);
            System.out.println(jsonObject);
        }

//        获取json字符串中某个嵌套的对象
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String jsonStr01 = "{\"AGE\":15,\"DATE OF BIRTH\":1635735500370,\"FULL NAME\":{\"AGE\":15,\"DATE OF BIRTH\":1635744854182,\"FULL NAME\":\"John Doe\"}}";
        JSONObject jsonObj = JSON.parseObject(jsonStr01);
        System.out.println(jsonObj);
        JSONObject js01 = jsonObj.getJSONObject("FULL NAME");
        System.out.println(js01);
        System.out.println("dateofbirth:"+js01.getDate("DATE OF BIRTH"));


    }
}

