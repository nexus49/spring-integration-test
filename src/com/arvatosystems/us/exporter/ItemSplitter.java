package com.arvatosystems.us.exporter;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:36
 */
@MessageEndpoint
public class ItemSplitter {

    Logger logger = Logger.getLogger(ItemSplitter.class);

    @Splitter(inputChannel="exports", outputChannel="items")
    public List<ExportItem> split(Export export) {

        logger.info("Exporting export: "+ export.getName());
        return export.getItems();
    }
}