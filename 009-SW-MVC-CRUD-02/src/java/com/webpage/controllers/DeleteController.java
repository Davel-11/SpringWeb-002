

package com.webpage.controllers;

import com.webpage.models.Connect;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
    
 private JdbcTemplate jdbcTemplate;
 
   public DeleteController(){
        Connect connecting = new Connect();
        this.jdbcTemplate = new JdbcTemplate(connecting.conect());
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView goHome(HttpServletRequest request ){
        int id = Integer.parseInt(request.getParameter("id"));
        
        this.jdbcTemplate.update( "delete from usuarios where id=?", id);
        return new ModelAndView("redirect:/home.htm");                
    }
    
}
