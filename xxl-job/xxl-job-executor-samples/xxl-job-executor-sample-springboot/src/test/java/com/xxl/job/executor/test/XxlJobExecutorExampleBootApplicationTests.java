package com.xxl.job.executor.test;

import com.xxl.job.core.biz.AdminBiz;
import com.xxl.job.core.biz.model.RegistryParam;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.enums.ExecutorBlockStrategyEnum;
import com.xxl.job.core.enums.RegistryConfig;
import com.xxl.rpc.remoting.invoker.XxlRpcInvokerFactory;
import com.xxl.rpc.remoting.invoker.call.CallType;
import com.xxl.rpc.remoting.invoker.reference.XxlRpcReferenceBean;
import com.xxl.rpc.remoting.invoker.route.LoadBalance;
import com.xxl.rpc.remoting.net.NetEnum;
import com.xxl.rpc.serialize.Serializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XxlJobExecutorExampleBootApplicationTests {

	private static String addressUrl = "http://127.0.0.1:8080/xxl-job-admin".concat(AdminBiz.MAPPING);

	private static String accessToken = null;


	/**
	 * 测试代码添加任务
 	 */
	@Test
	public void registryTest() throws  Exception{

		addressUrl = addressUrl.replace("http://", "");
		AdminBiz adminBiz = (AdminBiz) new XxlRpcReferenceBean(
				NetEnum.NETTY_HTTP,
				Serializer.SerializeEnum.HESSIAN.getSerializer(),
				CallType.SYNC,
				LoadBalance.ROUND,
				AdminBiz.class,
				null,
				10000,
				addressUrl,
				accessToken,
				null,
				null).getObject();

		// test executor registry
		RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), "xxl-job-example01", "127.0.0.1:9999");
		ReturnT<String> returnT = adminBiz.registry(registryParam);
		Assert.assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);

		// stop invoker
//		XxlRpcInvokerFactory.getInstance().stop();
	}


	/**
	 * 模拟自己增加job
	 */
	@Test
	public void testAdd() {


		MyJobInfo jobInfo=new MyJobInfo();

		jobInfo.setAddTime(new Date());
		jobInfo.setAlarmEmail("594065953@qq.com");
		jobInfo.setExecutorBlockStrategy(ExecutorBlockStrategyEnum.SERIAL_EXECUTION.toString());
		jobInfo.setJobDesc("手动创建定时任务");
		jobInfo.setExecutorRouteStrategy("FIRST");
		jobInfo.setJobCron("0/2 * * * * ? *");
		jobInfo.setExecutorHandler("wordHandler");
		jobInfo.setAuthor("AAA");


	}




	@Test
	public void test() {



	}

}