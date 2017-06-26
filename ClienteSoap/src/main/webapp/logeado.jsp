<%-- 
    Document   : logeado
    Created on : 22-jun-2017, 9:57:38
    Author     : jdcaparros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>

        <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
        <script type="text/javascript">
//            
            function ajaxPost() {
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8090/nuevo",
                    data: JSON.stringify({
                        mensaje: $("#mensaje").val(),
                        usuarioId:${user.id}
                    }),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        const r = JSON.parse(data);
                        $("#hueco").html(r);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        $("#hueco").html("Error: " + textStatus + " " + errorThrown);
                    }
                });
            }
            function verTodosLosTweets() {                
                fetch("http://localhost:8090/tweets")
                        .then((resp) => resp.json())
                        .then(data => {
                            const d = JSON.stringify(data, null, 2);
                            console.table(data);
                            console.log('Id del primer usuario recibido:' + data[0].id);
                            $('#hueco').html(d);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
            }
            function verTweets(ident) {
                console.log('Id del usuario que quiere ver sus tweets: ' + ident);
                fetch("http://localhost:8090/tweets/" + ident)
                        .then((resp) => resp.json())
                        .then(data => {
                            const d = JSON.stringify(data, null, 2);
                            console.table(data);
                            console.log('Id del primer usuario recibido:' + data[0].id);
                            $('#hueco').html(d);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
            }
        </script>


    </head>
    <body>
        <h1 align="center">Bienvenido ${user.nombre} !</h1>
        <hr width="50%" /><br />
        <div class="container">
            <ul class="nav nav-pills" >
                <li role="presentation" class="active"><a href="#">Home</a></li>
                <li role="presentation"><a onclick="verTodosLosTweets()"> Todos los tweet</a></li>
                <li role="presentation"><a onclick="verTweets(${user.id})">Tus tweets</a></li>
<!--                <li role="presentation"><a onclick="ajaxPost()"></a></li>-->
                <li role="presentation"><a href="index.html">Salir</a></li>
            </ul>
        </div>
        <div class="container">
            <pre id="hueco">Hueco para ver los datos</pre>
        </div>
        <div class="container">
            <h1>Nuevo tweet</h1>
            <textarea rows="4" cols="50" name="mensaje" id="mensaje" placeholder="Introduce un texto"></textarea>
            <br><button onclick="ajaxPost()">Enviar</button>
        </div>
    </body>
</html>
