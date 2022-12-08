package com.neo.prudential.assignment.car.json;

import com.neo.prudential.assignment.car.json.description.JsonStringSqlTypeDescriptor;
import com.neo.prudential.assignment.car.json.description.JsonTypeDescriptor;
import lombok.Getter;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * @author neo
 * @date 2022/12/8
 */
public class JsonStringType extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

    @Getter
    String name = "json";

    public JsonStringType() {
        super(JsonStringSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}
