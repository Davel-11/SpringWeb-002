
package com.webpage.controllers;

import com.webpage.models.Connect;
import com.webpage.models.Usuarios;
import com.webpage.models.UsuariosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("add.htm")
public class AddController {
         UsuariosValidar usuariosvalidar;
         private JdbcTemplate jdbcTemplate;
    
         public AddController(){
             this.usuariosvalidar = new UsuariosValidar();
             Connect con = new Connect();
             this.jdbcTemplate = new JdbcTemplate(con.conect());
             
         }
    
         
         @RequestMapping(method=RequestMethod.GET)
          public ModelAndView form(){
         
         ModelAndView mav = new ModelAndView();
         
         mav.setViewName("add");
         mav.addObject("usuarios", new Usuarios());
         return mav;
     }
          
          @RequestMapping(method=RequestMethod.POST)
     public ModelAndView form(
             @ModelAttribute("usuarios") Usuarios u,
             BindingResult result,
             SessionStatus status
     ){
         this.usuariosvalidar.validate(u, result);
         if(result.hasErrors()) {
             ModelAndView mav = new ModelAndView();
             mav.setViewName("add");
             mav.addObject("usuarios", new Usuarios());
             return mav;
         } else { 
            this.jdbcTemplate.update( 
                    "INSERT INTO usuarios(nombre, correo, telefono) VALUES (? , ?, ?)",
                    u.getNombre(), u.getCorreo(), u.getTelefono());            
                    return new ModelAndView("redirect:/home.htm");
         }         
     }
          
         
}

