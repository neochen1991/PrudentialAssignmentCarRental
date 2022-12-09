package com.neo.prudential.assignment.car.utils.json.description;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author neo
 * @date 2022/12/8
 */
public class JsonBinarySqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {

    public static final JsonBinarySqlTypeDescriptor INSTANCE = new JsonBinarySqlTypeDescriptor();

    @Override
    public <X> ValueBinder<X> getBinder(JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicBinder<X>(javaTypeDescriptor, this) {

            @Override
            protected void doBind(PreparedStatement preparedStatement, X value, int index, WrapperOptions wrapperOptions) throws SQLException {
                preparedStatement.setObject(index, getJavaDescriptor().unwrap(value, JsonNode.class, wrapperOptions), getSqlType());
            }

            @Override
            protected void doBind(CallableStatement callableStatement, X value, String name, WrapperOptions wrapperOptions) throws SQLException {
                callableStatement.setObject(name, getJavaDescriptor().unwrap(value, JsonNode.class, wrapperOptions), getSqlType());
            }
        };
    }
}
