package com.arvatosystems.us.exporter;

import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:46
 */
public class ExportResult
{
    List<ProcessedItem> processedItems;
    String name;

    public ExportResult(List<ProcessedItem> processedItems,String name)
    {
        this.processedItems = processedItems;
        this.name = name;
    }

    @Override
    public String toString()
    {
        if(this.processedItems.size() >0)
        {
            return "Export Result: Name/Count: "+this.name+"/"+processedItems.size()+"";
        }
        return super.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
