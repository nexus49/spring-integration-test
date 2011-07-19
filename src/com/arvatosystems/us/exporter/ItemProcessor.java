package com.arvatosystems.us.exporter;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:40
 */
@Component
public class ItemProcessor
{
    Logger logger = Logger.getLogger(ItemProcessor.class);

    @ServiceActivator(inputChannel = "items", outputChannel = "processedItems")
    public ProcessedItem processItem(ExportItem exportItem)
    {
        logger.info("Processing item:" + exportItem.getExportId() + "/" + exportItem.getItemId());
        return new ProcessedItem(exportItem);
    }
}
