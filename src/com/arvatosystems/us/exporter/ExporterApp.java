package com.arvatosystems.us.exporter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:31
 */
public class ExporterApp
{
    static Logger logger = Logger.getLogger(ExporterApp.class);

    public static void main(String[] args)
    {
         BasicConfigurator.configure();

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("exporter-application.xml", ExporterApp.class);

        GenericExportGateway exportGateway = (GenericExportGateway) context.getBean("genericexportgateway");
        for (int i = 1; i <= 1; i++)
        {
            String exportid = UUID.randomUUID().toString();
            logger.info("Schedule export Nr:" + exportid);
            exportGateway.startExport(new Export(exportid));
        }
        context.close();

        logger.info("main completed");
    }
}
