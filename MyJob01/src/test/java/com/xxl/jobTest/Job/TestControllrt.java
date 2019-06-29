package com.xxl.jobTest.Job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.glue.GlueTypeEnum;
import com.xxl.jobTest.HttpUtils;
import org.apache.http.params.CoreConnectionPNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xulei
 * @Date: 2019/6/25 0025 10:11
 * @Description:
 */
public class TestControllrt {

    private static String addressUrl = "http://localhost:8070/xxl-job-admin";

    public static void main(String[] args) {


        String addJob = addJob();
//        String pageListData = getPageList();


    }
    /**
     * 手动增加定时任务。并设置默认启动
     */


//    httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
//        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);


    public static  void getExecuter(){

    }

    /**
     * 手动增加定时任务
     */
    public static String addJob() {

//        jobGroup: 2
//        jobDesc: 我的第2个job
//        executorRouteStrategy: FIRST
//        jobCron: */5 * * * * ? *
//        glueType: BEAN
//        executorHandler: worldHandler
//        executorBlockStrategy: SERIAL_EXECUTION
//        childJobId:
//        executorTimeout: 0
//        executorFailRetryCount: 0
//        author: xulei
//        alarmEmail: 594065953@qq.com
//        executorParam: 我的第2个job
//        glueRemark: GLUE代码初始化
//        glueSource:


        JSONObject jsonParam = new JSONObject();

        jsonParam.put("jobDesc", "我的第100个job");
        jsonParam.put("jobGroup", 2);
        jsonParam.put("executorRouteStrategy", "FIRST");
        jsonParam.put("jobCron", "*/6 * * * * ? *");
        jsonParam.put("glueType", "BEAN");


        //手动写死handler
        jsonParam.put("executorHandler", "worldHandler");
        jsonParam.put("executorBlockStrategy", "SERIAL_EXECUTION");


        jsonParam.put("author", "xulei");
        jsonParam.put("alarmEmail", "594065953@qq.com");

        //模拟10000个数据去传递


        List<String> list=new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            String ss="ASDFG"+"-"+i;
            list.add(ss);
        }


        WxMpMassOpenIdsMessage wxMpMassOpenIdsMessage=new WxMpMassOpenIdsMessage();

        wxMpMassOpenIdsMessage.setToUsers(list);
        list=null;

//        wxMpMassOpenIdsMessage.setClientMsgId("");

        wxMpMassOpenIdsMessage.setContent("双11活动破产了");

        wxMpMassOpenIdsMessage.setMediaId("123456789");

        wxMpMassOpenIdsMessage.setSendIgnoreReprint(true);

        String jsonString = JSON.toJSONString(wxMpMassOpenIdsMessage);

        jsonParam.put("executorParam", jsonString);


        /**
         * 没有增加group的返回值
         */

        String addressUrl = "http://localhost:8070/xxl-job-admin/jobinfo/add";
//        String data = HttpUtils.postJson(addressUrl,JSON.toJSONString(map));

        Object data = HttpUtils.doPost(addressUrl, jsonParam);

        System.out.println(JSON.toJSONString(data));

//        "{\"code\":200,\"msg\":null,\"content\":\"7\"}"

        JSONObject jsonObject = JSONObject.parseObject(data.toString());

        int code = (int) jsonObject.get("code");



        if(code==200){

            String content = (String) jsonObject.get("content");


            //调用启动接口

            String startUrl = "http://localhost:8070/xxl-job-admin/jobinfo/start";


            Map<String, Object> map = new HashMap<>();

            map.put("id", Integer.parseInt(content));
            Object postMap = HttpUtils.postMap(startUrl, map);
            System.out.println(JSON.toJSONString(postMap));
            getPageList();
        }
        return data.toString();

    }


    /**
     * 获取任务管理列表
     *
     * @return
     */
    public static String getPageList() {

        String addressUrl = "http://localhost:8070/xxl-job-admin/jobinfo/pageList";

        Map<String, Object> map = new HashMap<>();

        map.put("start", 0);
        map.put("length", 15);
        map.put("jobGroup", 2);
        map.put("jobDesc", "");
        map.put("executorHandler", "");
        map.put("filterTime", "");

        Object data = HttpUtils.postMap(addressUrl, map);

        JSONObject parse = JSONObject.parseObject(data.toString());


        System.out.println("列表获取到的数据为： "+parse);

        return data.toString();
    }
}
