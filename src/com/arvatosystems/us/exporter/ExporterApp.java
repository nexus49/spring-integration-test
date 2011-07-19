package com.arvatosystems.us.exporter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:31
 */
public class ExporterApp
{
    static Logger logger = Logger.getLogger(ExporterApp.class);
    private static ExecutorService executor = Executors.newFixedThreadPool(100);

    public static void main(String[] args)
    {
        BasicConfigurator.configure();

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("exporter-application.xml", ExporterApp.class);

        GenericExportGateway exportGateway = (GenericExportGateway) context.getBean("genericexportgateway");

        String exportid = UUID.randomUUID().toString();
        logger.info("Schedule export Nr:" + exportid);
        exportGateway.startExport(new Export(exportid));

        context.close();

        executor.execute(new Runnable()
        {
            public void run()
            {
                logger.info("waiting ");
            }
        });
        executor.shutdown();
        try
        {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        logger.info("main completed");
    }


}
