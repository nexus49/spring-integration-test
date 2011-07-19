package com.arvatosystems.us.exporter;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:41
 */
public class ProcessedItem
{
    private ExportItem exportItem;

    public ProcessedItem(ExportItem exportItem)
    {
        this.exportItem = exportItem;
    }

    public String getExportId()
    {
        return exportItem.getExportId();
    }
    public String getItemId()
    {
        return exportItem.getItemId();
    }

    public ExportItem getExportItem()
    {
        return exportItem;
    }
}
