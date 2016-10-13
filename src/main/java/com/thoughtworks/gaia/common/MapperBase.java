package com.thoughtworks.gaia.common;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class MapperBase {
    protected final MapperFactory mapperFactory;

    @FunctionalInterface
    public interface MapperFunction<F, T> {
        T apply(F source, T target);
    }

    protected MapperBase() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new PassThroughConverter(DateTime.class));
        converterFactory.registerConverter(new BidirectionalConverter<Date, DateTime>() {
            @Override
            public DateTime convertTo(Date source, Type<DateTime> destinationType) {
                return new DateTime(source);
            }

            @Override
            public Date convertFrom(DateTime source, Type<Date> destinationType) {
                return source.toDate();
            }
        });
    }

    protected void register(Class<?> typeA, Class<?> typeB) {
        mapperFactory.classMap(typeA, typeB)
            .byDefault()
            .register();
    }

    public <T> T map(Object obj, Class<T> targetType) {
        return mapperFactory.getMapperFacade().map(obj, targetType);
    }

    public <F, T> T map(F obj, Class<T> targetType, MapperFunction<F, T> mapperFunction) {
        if (obj == null) {
            return null;
        }
        return mapperFunction.apply(obj, mapperFactory.getMapperFacade().map(obj, targetType));
    }

    public <T> List<T> mapList(List<? extends Object> source, Class<T> targetType) {
        if (source == null) {
            return null;
        }

        List<T> result = new ArrayList<T>(source.size());
        for (Object object : source) {
            result.add(mapperFactory.getMapperFacade().map(object, targetType));
        }
        return result;
    }

    public <F, T> List<T> mapList(List<F> source, Class<T> targetType,
                               MapperFunction<F, T> mapperFunction) {
        if (source == null) {
            return null;
        }

        List<T> result = new ArrayList<>(source.size());
        for (F object : source) {
            T mapped = mapperFactory.getMapperFacade().map(object, targetType);
            result.add(mapperFunction.apply(object, mapped));
        }
        return result;
    }
}
