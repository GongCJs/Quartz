package cn.gcjlearn.quartz;/**
 * @Auther: GongCJ
 * @Introduce:
 * @Date: 2019/08/24
 * @Description: cn.gcjlearn.quartz
 * @version: 1.0
 */


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * @author ：GongCJ
 * @date ：Created in 2019/08/24 9:44
 * @description：
 * @modified By：
 * @version: $
 */
public class SchedulerDemo {
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		//获取一个调度执行器Scheduler
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		//创建一个作业实例
		JobDetail jobDetail
				//指定具体执行的Job实现类
				= JobBuilder.newJob(JobDemo.class)
				//设置名字，及所在的分组
				.withIdentity("jobName_Test" + Math.random(), "JobGroupName_TestGroup")
				.build();
		//创建一个触发器
		Trigger trigger
				= TriggerBuilder.newTrigger()
				.withIdentity("triggerName_Test" + Math.random(), "JobGroupName_TestGroup")
				.startNow()
				.withSchedule(cronSchedule(""))
				.forJob(jobDetail)
				.build();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
