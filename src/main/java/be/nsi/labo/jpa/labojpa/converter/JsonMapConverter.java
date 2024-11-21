package be.nsi.labo.jpa.labojpa.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Converter
public class JsonMapConverter implements AttributeConverter<Map<String, Serializable>, String> {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final MapType MAP_TYPE = MAPPER.getTypeFactory()
            .constructMapType(Map.class, String.class, Serializable.class);

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(Map<String, Serializable> map) {
        if (map == null) {
            return StringUtils.EMPTY;
        }

        return MAPPER.writeValueAsString(map);
    }

    @Override
    @SneakyThrows
    public Map<String, Serializable> convertToEntityAttribute(String string) {
        if (StringUtils.isBlank(string)) {
            return defaultValue();
        }

        return MAPPER.readValue(string, MAP_TYPE);
    }

    private Map<String, Serializable> defaultValue() {
        return new HashMap<>();
    }
}
