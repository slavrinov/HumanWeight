package com.springapp.mvc.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 27.11.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FooTestService {

    // 50 kg
    int w =50;
    /*
    * getHumanEdgeWeight params:
    *
    * @param: level of pyramid structure
    * @param: index of element from 1... to level+1
    * @return: result
    *
    * */
    public double getHumanEdgeWeight(int level, int index) {
        if (index-1 > level/2) {
            index = level-index+2;
        }
        //realize this
        return level*w/2+w*(index-1)
    }


}
