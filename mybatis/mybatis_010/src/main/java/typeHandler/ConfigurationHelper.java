package typeHandler;

import annotation.EnumHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.atteo.classindex.ClassIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/9 4:44 下午
 */
public class ConfigurationHelper {

    private static final Class HANDLER_ENUM_CLAZZ = EnumHandler.class;

    private static final Class HANDLER_CLAZZ = EnumKeyTypeHandler.class;

    public static void loadEnumHandler(SqlSessionFactory factory) throws ClassNotFoundException {
        List<String> list = getJavaType();
        TypeHandlerRegistry typeHandlerRegistry = factory.getConfiguration().getTypeHandlerRegistry();
        for (String javaTypeClass : list) {
            typeHandlerRegistry.register(javaTypeClass, HANDLER_CLAZZ.getName());
        }
    }

    /**
     * 找出 @EnumHandler 标注的类
     * @return
     */
    private static List<String> getJavaType() {
        List<String> list = new ArrayList<>();
        final Iterable<Class<?>> klasses = ClassIndex.getAnnotated(HANDLER_ENUM_CLAZZ);
        for (Class<?> clazz : klasses) {
            list.add(clazz.getName());
        }
        return list;
    }

}
