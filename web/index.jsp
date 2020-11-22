<%-- 
    Document   : index
    Created on : 11/11/2020, 01:39:56 PM
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Log in</title>
    </head>
    <body>


        <div class = "container mt-4 col-lg-4"  >
            <div class="card col-sm-10" style="background-color: crimson ;margin-top: 150px; margin-left: 75px;" >
                <div class="card-body ">
                    <form class="form-sign"  action="Validar" method="POST">
                        <div class="form-group text-cente">
                            <h3 style="text-align: center"><b>Login</b></h3>
                            <img src="Img/cropped-logo-login.png" style="width: 80%; width: 80%; margin-left: 40px" />
                        </div>
                        <div class="form-group">
                        <label><b>Usuario:</b></label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><b>Contraseña:</b></label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">                     
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </body>
</html>
