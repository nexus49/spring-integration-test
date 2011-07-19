package com.arvatosystems.us.exporter;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;

import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:45
 */
@MessageEndpoint
public class ItemAggregator
{
    Logger logger = Logger.getLogger(ItemAggregator.class);

    @Aggregator(inputChannel = "processedItems", outputChannel = "deliveries")
    public ExportResult prepareDelivery(List<ProcessedItem> processedItems) {
        logger.info("Export complete create delivery: Count"+ processedItems.size());
        return new ExportResult(processedItems, processedItems.get(0).getExportId());
    }

    @CorrelationStrategy
    public String correlateByExportId(ProcessedItem processedItem) {
    	logger.info("Check if all items are there: "+processedItem.getExportId()+"/"+processedItem.getItemId());
        return processedItem.getExportId();
    }
}
