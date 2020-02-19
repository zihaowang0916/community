package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello there";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    //处理get请求
    // aged/?current=1&limit=20
    @RequestMapping(path = "/aged", method = RequestMethod.GET)
    @ResponseBody
    public String getAged(int current, int limit){
        System.out.println(current);
        System.out.println(limit);
        return "an old man";
    }

    @RequestMapping(path = "/aged/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getAgedId(@PathVariable("id") int id){
        System.out.println(id);
        return "an aged again";
    }

    //处理POST请求
    @RequestMapping(path="/aged", method = RequestMethod.POST)
    @ResponseBody
    public String saveAged(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path="/carer",method=RequestMethod.GET)
    public ModelAndView getCarer(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path="/estate",method=RequestMethod.GET)
    public String getEstate(Model model){
        model.addAttribute("name","德威");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //响应JSON数据（异步请求）
    //Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path="/emp",method=RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",14);
        emp.put("salary","8000");
        list.add(emp);

        Map<String,Object> emp1 = new HashMap<>();
        emp1.put("name","张三");
        emp1.put("age",14);
        emp1.put("salary","8000");
        list.add(emp1);
        return list;
    }

}
