package com.arvatosystems.us.exporter;

import org.springframework.integration.annotation.Gateway;

/**
 * Created by Bastian Echterhoelter
 * Date: 7/19/11
 * Time: 14:34
 */
public interface GenericExportGateway
{
    @Gateway(requestChannel = "exports")
    void startExport(Export export);
}
