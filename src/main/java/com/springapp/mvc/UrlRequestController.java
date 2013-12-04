package com.springapp.mvc;

import com.springapp.mvc.service.FooTestService;
import com.springapp.mvc.util.ValidationRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 27.11.13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/{level}/{index}")
public class UrlRequestController {

    Logger log = Logger.getLogger(UrlRequestController.class.getName());

    @Autowired
    FooTestService fooTestService;

    @Autowired
    ValidationRules validationRules;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@PathVariable("level") String level,
                               @PathVariable("index") String index,
                               ModelMap model) {
        int lvl=0,idx=0;
        try {
            lvl = Integer.valueOf(level);
            idx = Integer.valueOf(index);
            validationRules.isValid(lvl, idx);
        }catch (Exception e) {
            log.log(Level.WARNING,"failed request with level ="+level+" and index ="+index);
            log.log(Level.WARNING, "see rules of request path variables");
            model.addAttribute("fooTestResult","failed request with level ="+level+
                                " and index ="+ index+ ".\n "+e.getMessage());
            return "hello";
        }
        //see further realization
        if (lvl>= 8)  {
            model.addAttribute("fooTestResult", "in this test calculation is carried out up to the 8th level");
            return "hello";
        }
        model.addAttribute("fooTestResult", String.valueOf(fooTestService.getHumanEdgeWeight(lvl,idx)));
        return "hello";
    }

}