package com.dolethanhtuan.blogapp.converter;

import com.dolethanhtuan.blogapp.entity.Status;
import jakarta.persistence.AttributeConverter;

public class PostStatusConverter implements AttributeConverter<Status,Character> {
    @Override
    public Character convertToDatabaseColumn(Status attribute) {
        return attribute.toString().charAt(0);
    }

    @Override
    public Status convertToEntityAttribute(Character dbData) {
        if(dbData == 'O')
            return Status.valueOf("OPENING");
        else if(dbData == 'C')
            return Status.valueOf("CLOSED");
        throw new IllegalArgumentException(dbData.toString());
    }
}
