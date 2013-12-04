package com.springapp.mvc.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 27.11.13
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ValidationRules {

    public void isValid(int lvl, int idx) throws Exception {
        if ((lvl <0) || (idx <= 0)) {
            throw new Exception("validation: numbers must have positive values");
        }
        if ((idx > lvl+1)) {
            throw new Exception("validation: no element with such index on this level ");
        }
    }
}
