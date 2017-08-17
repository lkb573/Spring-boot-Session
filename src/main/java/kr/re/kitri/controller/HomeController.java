package kr.re.kitri.controller;


import kr.re.kitri.domain.Memeber;
import kr.re.kitri.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private AuthService authService;

    @GetMapping("")
    public String index(){
        return "index";
    }


    @PostMapping("/login")
    public String login(HttpSession session,
                        Model model,
                        @RequestParam("user_id") String userId,
                        @RequestParam("pw") String pw){

        Memeber memeber =  this.authService.authenticate(userId, pw);

        if(memeber != null){
            session.setAttribute("_MEMBER_SESSION_", memeber);
            model.addAttribute("member", memeber);
        }

        return "main";
    }

    @GetMapping("viewProducts")
    public String viewProducts(HttpSession session, Model model){

        Memeber memeber = (Memeber)session.getAttribute("_MEMBER_SESSION_");

        if(memeber == null){
            return "index";
        }

        model.addAttribute("member", memeber);

        return "products";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}