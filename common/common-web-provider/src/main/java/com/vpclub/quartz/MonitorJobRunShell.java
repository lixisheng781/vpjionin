package com.vpclub.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.core.JobRunShell;
import org.quartz.core.JobRunShellFactory;
import org.quartz.spi.TriggerFiredBundle;

@Slf4j
public class MonitorJobRunShell extends JobRunShell {

    /**
     * 创建一个新的实例 JobRunShellImpl.
     */
    public MonitorJobRunShell(Scheduler scheduler, TriggerFiredBundle bndle) {
        super(scheduler, bndle);
    }

    @Override
    protected void begin() throws SchedulerException {
        super.begin();
        try {
//            JobDetail jobDetail = jec.getJobDetail();
        } catch (Exception e) {
            log.error("记录job开始时间异常",e);
        }catch (Throwable e) {
            log.error("记录job开始时间出错",e);
        }

    }

    @Override
    protected void complete(boolean successfulExecution) throws SchedulerException {
        super.complete(successfulExecution);
        try {
            log.info("complete:" + successfulExecution);
        } catch (Exception e) {
            log.error("记录job结束时间异常",e);
        }catch (Throwable e) {
            log.error("记录job结束时间出错",e);
        }
    }
}

