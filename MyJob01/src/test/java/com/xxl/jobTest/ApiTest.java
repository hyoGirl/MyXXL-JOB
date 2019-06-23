package com.xxl.jobTest;

import com.alibaba.fastjson.JSON;
import com.xxl.job.JobAPP01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/6/23 22:11
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JobAPP01.class)
public class ApiTest {

//    private static String addressUrl = "http://127.0.0.1:8080/xxl-job-admin".concat(AdminBiz.MAPPING);
    private static String addressUrl = "http://localhost:8080/xxl-job-admin";

    private static String accessToken = null;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAdd() {

    }

    @Test
//    @PermessionLimit(limit = false)
    public void testPageList() {


        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//        @RequestParam(required = false, defaultValue = "0") int start,
//        @RequestParam(required = false, defaultValue = "10") int length,
//        int jobGroup, String jobDesc, String executorHandler, String filterTime

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();

        map.add("start", 0);
        map.add("length", 5);
        map.add("jobGroup", 3);
        map.add("jobDesc","自己学习测试02");
        map.add("executorHandler","");
        map.add("filterTime","");


        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        addressUrl="http://localhost:8080/xxl-job-admin/jobinfo/pageList";
        ResponseEntity<String> entity = restTemplate.postForEntity(addressUrl, request, String.class);
        System.out.println(JSON.toJSON(entity.getBody()));

    }


    @Test
    public void testPageList2() {


    }
}
