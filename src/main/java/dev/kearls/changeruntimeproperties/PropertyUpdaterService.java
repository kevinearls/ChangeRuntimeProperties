package dev.kearls.changeruntimeproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyUpdaterService {
    private static final String DYNAMIC_PROPERTIES_SOURCE_NAME = "dynamicProperties";

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void fireRefreshEvent() {
        eventPublisher.publishEvent(new RefreshEvent(this, "RefreshEvent", "Refreshing scope"));
    }

    public void updateProperty(String key, String value) {
        MutablePropertySources propertySources = environment.getPropertySources();
        if (!propertySources.contains(DYNAMIC_PROPERTIES_SOURCE_NAME)) {
            Map<String, Object> dynamicProperties = new HashMap<>();
            dynamicProperties.put(key, value);
            propertySources.addFirst(new MapPropertySource(DYNAMIC_PROPERTIES_SOURCE_NAME, dynamicProperties));
        } else {
            MapPropertySource propertySource = (MapPropertySource) propertySources.get(DYNAMIC_PROPERTIES_SOURCE_NAME);
            propertySource.getSource().put(key, value);
        }

        fireRefreshEvent();
    }
}
