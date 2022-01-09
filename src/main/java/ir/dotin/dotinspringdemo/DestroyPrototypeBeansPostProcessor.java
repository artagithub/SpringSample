package ir.dotin.dotinspringdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DestroyPrototypeBeansPostProcessor implements BeanPostProcessor, BeanFactoryAware , DisposableBean {

    private BeanFactory beanFactory;

    private final List<Object> prototypeBeans = new LinkedList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Scope annotation = AnnotationUtils.getAnnotation(bean.getClass(), Scope.class);
        if (annotation != null) {
            if(annotation.value().equals(ConfigurableBeanFactory.SCOPE_PROTOTYPE)){
                prototypeBeans.add(bean);
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
        synchronized (prototypeBeans) {
            for (Object bean : prototypeBeans) {
                if (bean instanceof DisposableBean) {
                    DisposableBean disposable = (DisposableBean)bean;
                    try {
                        disposable.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            prototypeBeans.clear();
        }
    }

}
