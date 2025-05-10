package dev.kearls.changeruntimeproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    private PropertyUpdaterService propertyUpdaterService;

    @Autowired
    private ExampleBean exampleBean;

    @PostMapping("/update")
    public String updateProperty(@RequestParam String key, @RequestParam String value) {
        propertyUpdaterService.updateProperty(key, value);
        return "Property updated.";
    }

    @GetMapping("/customProperty")
    public String getCustomProperty() {
        return exampleBean.getCustomProperty();
    }
}
