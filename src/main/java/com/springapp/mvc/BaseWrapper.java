package com.springapp.mvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created with IntelliJ IDEA.
 * User: LSK
 * Date: 13. 8. 16
 * Time: 오후 4:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseWrapper implements ApplicationContextAware {

    @XmlTransient
    protected ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
