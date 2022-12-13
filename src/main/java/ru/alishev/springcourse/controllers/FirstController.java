package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

//        System.out.println("Hello, "+name + surname);

        model.addAttribute("message", "Hello: "+ name + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam("a") int a, @RequestParam("b") int b,
                       @RequestParam("action") String action, Model model){

        double result;

        switch (action){
            case  "*":
                result = a*b;
                break;
            case "/":
                result=a/(double)b;
                break;
            case "basd":
                result= a+b;
                break;
            case "-":
                result= a-b;
                break;
            default:
                result=0;
                break;
        }

        model.addAttribute("res", result);

        return "first/calc";
    }
}
