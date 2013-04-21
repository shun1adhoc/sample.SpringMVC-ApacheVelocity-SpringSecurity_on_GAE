package sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import java.security.Principal;


@Controller
@RequestMapping("/velocity")
public class VelocityController {

    //DI via Spring
    String message;

    public void setMessage(String message) {
        this.message = message;
    }


    @RequestMapping(value="/{path}", method = RequestMethod.GET)
    public String getMovie(@PathVariable String path, ModelMap model, Principal principal) {

        model.addAttribute("path", path);
        model.addAttribute("message", this.message);

        String name = principal.getName(); //get logged in username
        model.addAttribute("username", name);

        //return to .vm page, configured in mvc-dispatcher-servlet.xml, view resolver
        return "sample";
    }



    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }
    
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
 
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
 
    	model.addAttribute("message", this.message);
        return "logout";
    }

    // @RequestMapping(value = "/403", method = RequestMethod.GET)
    // public String accessDenied(ModelMap model) {
    //     model.addAttribute("message", this.message);
    //     return "403";
    // }

}
