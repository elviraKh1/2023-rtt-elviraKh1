package org.perscholas.springboot.conntroller;

import org.perscholas.springboot.database.entity.User;
import org.springframework.stereotype.Controller;

@Controller
public class SlashController {

    public void index() {
        User user = new User();

        user.setId(1);
        user.setEmail("qwe@aqqw.er");
    }
}
