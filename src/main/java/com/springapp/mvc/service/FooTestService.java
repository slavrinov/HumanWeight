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
        if (index==1) {
            return level*w/2;
        }else if (index ==2){
            return level*w/2+w;
        }else if (index ==3) {
            return level*w/2+w+ w*sum(level,2);
            //see further realization
        }else return -1;
    }


    private double sum(int level,int i) {
        //(1+(1.00/(index-1)));
        double sum =0.0;
        int k=0;
        while (k<level-3) {
            sum = sum+ 1.00/i;
            //next i by multiplication on two
            i=i*2;
            k++;
        }
        return sum;
    }



}
