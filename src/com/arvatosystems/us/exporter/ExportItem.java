package com.arvatosystems.us.exporter;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:37
 */
public class ExportItem
{
    private String exportId;
    private String itemId;

    public ExportItem(String exportId, String itemId)
    {
        this.exportId = exportId;
        this.itemId = itemId;

    }

    public String getExportId()
    {
        return exportId;
    }

    public String getItemId()
    {
        return itemId;
    }
}
