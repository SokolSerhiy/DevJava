package ua.attribute.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time>{

	@Override
	public Time convertToDatabaseColumn(LocalTime arg0) {
		return arg0==null?null:Time.valueOf(arg0);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time arg0) {
		return arg0==null?null:arg0.toLocalTime();
	}
}
