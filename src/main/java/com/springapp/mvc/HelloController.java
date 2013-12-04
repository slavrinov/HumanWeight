package com.springapp.mvc;

import com.springapp.mvc.service.FooTestService;
import com.springapp.mvc.util.ValidationRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class HelloController {

    Logger log = Logger.getLogger(HelloController.class.getName());


    @Autowired
    FooTestService fooTestService;

    @Autowired
    ValidationRules validationRules;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(@RequestParam(value = "level",required = false) Integer level,@RequestParam(value = "index",required = false) Integer index, ModelMap model) {

        if (level ==null || index ==null) {
            model.addAttribute("fooTestResult","Welcome to GetHumanEdgeWeightServer.");
            model.addAttribute("msg",
                    "define your weight by adding url request params: \n" +
                    " /weight?level={level}&index={index}} or direct in url: /weight/{level}/{index}");
            return "hello";
        }
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