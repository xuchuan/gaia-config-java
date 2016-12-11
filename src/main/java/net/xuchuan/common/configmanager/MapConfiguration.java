package net.xuchuan.common.configmanager;

import java.util.HashMap;
import java.util.Map;

public class MapConfiguration extends AbstractConfiguration {
    private Map<String, String> valueMap;

    public MapConfiguration(String name, Map<String, String> valueMap) {
        this(null, name, valueMap);
    }

    public MapConfiguration(Configuration baseConfig, String name, Map<String, String> valueMap) {
        super(baseConfig, name);
        this.valueMap = valueMap;
        this.doReload();
    }

    public MapConfigurationBuilder getBuilder() {
        Map<String, String> valueMap = new HashMap<String, String>();
        for (Map.Entry<String, ConfigItem> entry : this.itemMap.entrySet()) {
            valueMap.put(entry.getKey(), entry.getValue().getValue());
        }
        return new MapConfigurationBuilder(name, valueMap);
    }

    protected void doReload() {
        doReloadFromMap(valueMap);
    }
}