package com.shenchao.test;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MetricRegistryDemo {
    @Test
    public void testMetricRegistry() throws Exception {
        MetricRegistry metrics = new MetricRegistry();
        Slf4jReporter reporter = Slf4jReporter
                .forRegistry(metrics).convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();
        //metrics数据统计工具
        int icounter = 0;
        reporter.start(20, TimeUnit.SECONDS);
        long it = System.currentTimeMillis();
        boolean start = false;
        while (true) {
            icounter++;
            long st = System.currentTimeMillis();
            if (st - it > 10000 && !start) {
                start = true;
                System.out.println("stop metrics");
                reporter.stop();
            }
            System.out.println("counter = " + icounter);
            //开始统计timer1
            Timer.Context mTimer1 = metrics.timer("timer1").time();//--------标签timer1对应的mTimer1开始计时

            Thread.sleep(100);

            //开始统计timer2
            Timer.Context mTimer2 = metrics.timer("timer2").time();//--------标签timer2对应的mTimer2开始计时

            Thread.sleep(100);


            //结束统计timer1
            mTimer1.stop();//--------标签timer1对应的mTimer1计时结束

            //结束统计timer2
            mTimer2.stop();//--------标签timer2对应的mTimer1计时结束
        }
    }
}
