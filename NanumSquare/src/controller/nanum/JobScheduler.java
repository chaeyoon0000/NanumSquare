package controller.nanum;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class JobScheduler {
    String cronExp;                    
    Class<? extends Job> clazz;
    static int i = 0;

    public JobScheduler(Class<? extends Job> clazz, String cronExp) {
        this.clazz = clazz;
        this.cronExp = cronExp;
    }
    
//    public JobScheduler(Object obj, String cronExp, Integer circleNo) {
//        this.clazz = (Class<? extends Job>) obj;
//        this.cronExp = cronExp;
//        this.circleNo = circleNo;
//    }

	public void triggerJob() {      
        Scheduler sch = null;
        SchedulerFactory schFactory = null;
        
        // schedule the job
        //    this.clazz 는 기본적으로 JobExecuter 클래스이다.
        JobDetail job = JobBuilder.newJob(this.clazz)
                .withIdentity(this.clazz.getName()+i).build();
        
        // batch.properties 에서 크론 표현식을 가져와 Trigger를 생성
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("crontrigger"+i, "crontriggergroup1"+i)
                .withSchedule(CronScheduleBuilder.cronSchedule(this.cronExp))
                .build();
        
        System.out.println(cronTrigger);
        
        try {
            schFactory = new StdSchedulerFactory();
            sch = schFactory.getScheduler();
            System.out.println(i + "번 스케쥴러 실행");
            sch.start();    //    JobExecuter.class Start
            sch.scheduleJob(job, cronTrigger);
            i++;
        } catch (SchedulerException e) {
        	e.printStackTrace();
        }
    }
}