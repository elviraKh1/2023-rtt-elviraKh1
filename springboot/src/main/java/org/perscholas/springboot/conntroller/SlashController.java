package org.perscholas.springboot.conntroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SlashController {

    //    public void index() {
//        User user = new User();
//
//        user.setId(1);
//        user.setEmail("qwe@aqqw.er");
//    }
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }
}
