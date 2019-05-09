package com.vpclub.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

@Slf4j
public class MonitorTriggerListener implements TriggerListener {


    @Override
    public String getName() {
        return "MonitorTriggerListener";
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        try {
            long costTime = context.getJobRunTime();
            log.info("记录job执行时间："+ costTime);

        } catch (Exception e) {
            log.error("记录job结束时间异常",e);
        }catch (Throwable e) {
            log.error("记录job结束时间出错",e);
        }
    }

    /**
     *  job触发事件
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        try {
//            JobDetail jobDetail = context.getJobDetail();
        } catch (Exception e) {
            log.error("记录job开始时间异常",e);
        }catch (Throwable e) {
            log.error("记录job开始时间出错",e);
        }
    }

    /**
     *  job触发事件
     */
    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

}

