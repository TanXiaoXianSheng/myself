package provider.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/16 2:20 下午
 */
public class SpringStudySelector implements ImportSelector, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
        return new String[]{Config.class.getName()};
    }

}
