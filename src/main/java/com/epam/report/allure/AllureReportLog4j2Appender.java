package com.epam.report.allure;

import com.google.common.base.Charsets;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;

@Plugin(name = "AllureReportLog4j2Appender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE)
public class AllureReportLog4j2Appender extends AbstractAppender {

    public AllureReportLog4j2Appender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout, true, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static AllureReportLog4j2Appender createAppender(@PluginAttribute("name") String name, @PluginElement("filter") Filter filter,
                                                            @PluginElement("layout") Layout<? extends Serializable> layout) {
        if (name == null) {
            LOGGER.error("No name provided for AllureReportLog4j2Appender");
            return null;
        }
        if (layout == null) {
            LOGGER.error("No layout provided for AllureReportLog4j2Appender");
            return null;
        }
        return new AllureReportLog4j2Appender(name, filter, layout);
    }

    @Override
    public void append(LogEvent event) {
        String message = new String(getLayout().toByteArray(event), Charsets.UTF_8);
        Allure.addAttachment("LOG", message);
    }
}
