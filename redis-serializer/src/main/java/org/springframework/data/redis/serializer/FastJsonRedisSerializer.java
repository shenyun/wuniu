package org.springframework.data.redis.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.util.Assert;

/**
 * Created by yong.luo on 2016/12/7.
 */
public class FastJsonRedisSerializer implements RedisSerializer<Object> {

    public byte[] serialize(Object source) throws SerializationException {
        if (source == null) {
            return new byte[0];
        }

        try {
            return JSON.toJSONBytes(source, SerializerFeature.WriteClassName);
        } catch (Exception e) {
            throw new SerializationException("Could not write JSON: " + e.getMessage(), e);
        }
    }


    public Object deserialize(byte[] source) throws SerializationException {
        return deserialize(source, Object.class);
    }


    public <T> T deserialize(byte[] source, Class<T> type) throws SerializationException {

        Assert.notNull(type,
                "Deserialization type must not be null! Pleaes provide Object.class to make use of Jackson2 default typing.");

        if (SerializationUtils.isEmpty(source)) {
            return null;
        }

        try {
            return JSON.parseObject(source,type);
        } catch (Exception ex) {
            throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }
}
