package com.xxl.job.executor.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/6/23 17:16
 * @Version 1.0
 */
@JobHandler(value="worldHandler")
@Component
public class HelloHandler  extends IJobHandler {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public ReturnT<String> execute(String param) throws Exception {
//        XxlJobLogger.log("XXL-JOB, Hello World.");




        logger.info("XXL-JOB, Hello World."+param);
        JSONObject jsonObject = JSON.parseObject(param);

        System.out.println(JSON.toJSON(param));

//		for (int i = 0; i < 5; i++) {
//			XxlJobLogger.log("beat at:" + i);
//			TimeUnit.SECONDS.sleep(2);
//		}
        return SUCCESS;
    }

}
