<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />        
          
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:out value="home.htm" />">Inicio</a></li>
                <li class="active">Agregar</li>
            </ol>
            
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                    <h1>Datos</h1>


                    <form:form method="POST" commandName="usuarios">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />

                        <p>
                            <form:label path="nombre">Nombre </form:label>
                            <form:input path="nombre" cssClass="form-control" />

                        </p>                    
                       <p>
                             <form:label path="correo">Correo</form:label>
                            <form:input path="correo" cssClass="form-control" />
                        </p>      

                        <p>
                             <form:label path="telefono">Telefono</form:label>
                            <form:input path="telefono" cssClass="form-control" />
                        </p>      

                        <hr />
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>    
            </div>
        </div>
            
        
        
    </body>
</html>

