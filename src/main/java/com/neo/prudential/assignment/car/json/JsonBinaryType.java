package com.neo.prudential.assignment.car.json;

import com.neo.prudential.assignment.car.json.description.JsonBinarySqlTypeDescriptor;
import com.neo.prudential.assignment.car.json.description.JsonTypeDescriptor;
import lombok.Getter;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * @author neo
 * @date 2022/12/8
 */
public class JsonBinaryType extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

    @Getter
    String name = "jsonb";

    public JsonBinaryType() {
        super(JsonBinarySqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}
