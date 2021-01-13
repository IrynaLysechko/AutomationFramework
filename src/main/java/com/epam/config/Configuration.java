package com.epam.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config.properties"
})
public interface Configuration extends Config {

    @Key("browser")
    String browser();

    @Key("url")
    String url();
}
