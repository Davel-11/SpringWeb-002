
package com.webpage.controllers;

import com.webpage.models.Connect;
import com.webpage.models.Usuarios;
import com.webpage.models.UsuariosValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

    @Controller
    @RequestMapping("edit.htm")
    public class EditController {

        UsuariosValidar usuariosvalidar;
        private JdbcTemplate jdbctemplate ;

        public EditController(){
            this.usuariosvalidar = new UsuariosValidar();
            Connect connecting = new Connect();
            this.jdbctemplate = new JdbcTemplate(connecting.conect());
        }
    
    public Usuarios selectUser(int id){
        final Usuarios usuario = new Usuarios();
        String sql = "Select * From usuarios where id='"+id+"' ";
        
        return (Usuarios) jdbctemplate.query(
                sql, new ResultSetExtractor<Usuarios>()
                {
                    public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setCorreo(rs.getString("correo"));
                        usuario.setTelefono(rs.getString("telefono"));
                        
                        }
                    return usuario;
                    }
                }                
        );
    }
    
    //------------- GET METHOD ----------------
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        
        Usuarios se = this.selectUser(id);
        
        mav.setViewName("edit");
        mav.addObject("datos", new Usuarios(id, se.getNombre(), se.getCorreo(), se.getTelefono() ));
               
        return mav;
    }
    
    
    
     //------------- POST METHOD ----------------
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("datos") Usuarios u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request    
        ){
            this.usuariosvalidar.validate(u, result);
            if (result.hasErrors()){
                ModelAndView mav = new ModelAndView();
                
                int id= Integer.parseInt(request.getParameter("id"));
                Usuarios usuario = this.selectUser(id);
                
                mav.setViewName("edit");
                mav.addObject("datos", new Usuarios(id,usuario.getNombre(), usuario.getCorreo(), usuario.getTelefono() ));
                
                return mav;
            }else{
                  int id  = Integer.parseInt(request.getParameter("id"));
                   
                  this.jdbctemplate.update("update usuarios "
                          + "SET nombre=?, "
                          + "correo=?, "
                          + "telefono=? "                          
                          + "where id=?",                 
                          u.getNombre(), 
                          u.getCorreo(), 
                          u.getTelefono(),                           
                          id
                          ); 
                  return new ModelAndView("redirect:/home.htm");
            }
        }   
    
    
    
    
}
