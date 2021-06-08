package typeHandler;

import enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/27 8:04 下午
 */
public class EnumKeyTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    public EnumKeyTypeHandler(Class<E> type) {
        if (type == null) {
            throw new RuntimeException("EnumKeyTypeHandler...枚举对象为空");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return rs.wasNull() ? null : getEnumByKey(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : getEnumByKey(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : getEnumByKey(code);
    }

    public E getEnumByKey(Integer key) {
        return getEnumByKey(type, key, "key");
    }

    public E getEnumByKey(Class<E> clazz, Object key, String keyName) {
        if (key == null) {
            return null;
        }

        try {
            E[] enums = clazz.getEnumConstants();
            if (enums == null) {
                return null;
            }

            Field field = clazz.getDeclaredField(keyName);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);

            for (E e : enums) {
                Object tempKey = field.get(e);
                if (tempKey != null && key != null && tempKey.equals(key)) {
                    return e;
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

}
