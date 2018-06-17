

package com.webpage.controllers;

import com.webpage.models.Connect;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
    
    private JdbcTemplate jdbcTemplate;
    
    public HomeController(){
        Connect con=new Connect();
        this.jdbcTemplate= new JdbcTemplate(con.conect());
    }
    
    
    @RequestMapping("home.htm")
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView();
        
        //consulta sql
        String sql = "select * from usuarios";
        List datos=this.jdbcTemplate.queryForList(sql);
        
        //pasar parametros
        mav.addObject("datos", datos);
        
        mav.setViewName("home");
        return mav;
    }
    
}
