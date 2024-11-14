package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value="hello")
public class HelloController {

//handle requests at path http://localhost:8080/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //handle requests at path http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //hnadle request http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='/hello' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name' />" +
                            "<select name='language' id='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='russian'>Russian</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet Me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            greeting = "Hello";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (language.equals("russian")) {
            greeting = "Privet";
        }
        else if (language.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + ", " + name + "!";
    }
}
