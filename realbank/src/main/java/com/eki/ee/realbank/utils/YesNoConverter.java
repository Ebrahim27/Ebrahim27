package com.eki.ee.realbank.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YesNoConverter implements AttributeConverter< YesNo, Integer> {


    @Override
    public Integer convertToDatabaseColumn(YesNo yesNoEnum) {
        return yesNoEnum != null? yesNoEnum.toValue() : YesNo.NO.toValue();
    }

    @Override
    public YesNo convertToEntityAttribute(Integer i) {
        return YesNo.fromValue(i);
    }
}
