package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDate) {
        return localDate != null ? Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }
}
