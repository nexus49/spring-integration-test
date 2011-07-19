package com.arvatosystems.us.exporter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:35
 */
public class Export
{
    private String name;

    public Export(String name)
    {
        this.name = name;
    }

    public List<ExportItem> getItems() {
        List<ExportItem> returnList = new ArrayList<ExportItem>();
        returnList.add(new ExportItem(name, "1"));
        returnList.add(new ExportItem(name, "2"));
        returnList.add(new ExportItem(name, "3"));
        return returnList;
    }

    public String getName()
    {
        return name;
    }
}
