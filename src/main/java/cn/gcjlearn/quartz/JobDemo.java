package cn.gcjlearn.quartz;/**
 * @Auther: GongCJ
 * @Introduce:
 * @Date: 2019/08/24
 * @Description: cn.gcjlearn.quartz
 * @version: 1.0
 */


import org.quartz.*;

import java.util.Date;

/**
 * @author ：GongCJ
 * @date ：Created in 2019/08/24 9:33
 * @description：定时任务的内容
 * @modified By：
 * @version: $
 */

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class JobDemo implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobDetail jobDetail = jobExecutionContext.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		System.out.println(new Date());
	}
}
