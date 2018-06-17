

package com.webpage.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuariosValidar  implements Validator {
    
     private static final String EmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   
    
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return Usuarios.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Usuarios usuario = (Usuarios) obj;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "campo nombre requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo", "campo correo requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.telefono", "campo telefono requerido");
        
                
        
        if ( !( usuario.getCorreo() != null && usuario.getCorreo().isEmpty() ) ) {
            this.pattern = Pattern.compile(EmailPattern);
            this.matcher = pattern.matcher( usuario.getCorreo());
        } 
        
        if(!matcher.matches()){
            errors.rejectValue("correo", "correo.incorrect", "el Correo es Invalido");
        }
    }
    
}
