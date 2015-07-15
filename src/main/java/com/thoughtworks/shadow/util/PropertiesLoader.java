package com.thoughtworks.shadow.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoader {

    // constant can not changed
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
    private static String PROPERTIES_FILE_NAME = "log4j.properties";

    private static Properties _properties;

    public static synchronized String getProperty(String key) {

        if (_properties == null) {
            initialProperties();
        }
        return _properties.getProperty(key);
    }

    private static void initialProperties() {
        _properties = new Properties();
        _properties.putAll(loadProperties(PROPERTIES_FILE_NAME));
    }

    private static Properties loadProperties(String propertiesFileName) {

        final Properties properties = new Properties();
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream(propertiesFileName), "UTF-8");
            properties.load(inputStreamReader);

            Set<Object> keys = properties.keySet(); //返回属性key的集合
            for (Object key:keys) {
                logger.info(key.toString() + "---------------" + properties.get(key));
            }

            logger.warn("-------------返回的属性键值对实体--------------------------");
            Set<Entry<Object, Object>> entrys = properties.entrySet(); //返回的属性键值对实体
            for (Entry<Object, Object> entry:entrys){
                logger.info(entry.getKey() + "---------------" + entry.getValue());
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);

        } finally {
            if (inputStreamReader == null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return properties;
    }
}
