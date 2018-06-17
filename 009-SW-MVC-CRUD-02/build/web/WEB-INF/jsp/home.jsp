<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Ejemplo JDBC template 2</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <div class="container">
            <div class="row">
                <h1>JDBC  Template</h1>
                <p>
                    <a href="<c:out value="add.htm" />" class="btn btn-success">agregar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>E-mail</th>
                            <th>Telefono</th>
                            <th>Acciones</th>
                        </tr>                        
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}" /></td>
                                <td><c:out value="${dato.nombre}" /></td>
                                <td><c:out value="${dato.correo}" /></td>
                                <td><c:out value="${dato.telefono}" /></td>
                                <td><a href="<c:out value="edit.htm?id=${dato.id}" />" class="btn btn-success"><span class="glyphicon glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                <a href="<c:out value="delete.htm?id=${dato.id}" />" class="btn btn-success"><span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                </table>
            </div>            
        </div>
        
    </body>
</html>

