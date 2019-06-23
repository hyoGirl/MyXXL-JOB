package com.xxl.job.JobHandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 任务Handler示例（Bean模式）
 *
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2015-12-19 19:43:36
 */

/**
 * @author ashura1110
 * @ClassName HelloHandler
 * @description TODO
 * @Date 2019/6/23 13:24
 * @Version 1.0
 */
@Component
@JobHandler(value="helloJobHandler")
public class HelloHandler extends IJobHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        logger.info("自己学习XXL-JOB的一个定时任务，配置的任务为："+param);
        return SUCCESS;
    }
}
