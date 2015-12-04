<%@ page import="inf.info" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhuk
  Date: 17.12.2015
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function send_f(f){f.submit();}
        window.onload =function()
        {
            var tmp=<%=info.getValue()%>
            if(tmp=="1")
                alert("New list added successfully!");
            if(tmp=="2")
                alert("Error!");

        }
    </script>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style2.css" />
        <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    </head>
<body>
<form action="authorization" onSubmit="return false">
    <div class="container">
        <section>
            <div id="container_demo" >
                <a class="hiddenanchor" id="toregister"></a>
                <a class="hiddenanchor" id="tologin"></a>


                <div id="wrapper">
                    <div id="login" class="animate form">
                        <form  action="mysuperscript.php" autocomplete="on">
                            <h1>Menu</h1>
                            <p>
                            <p class="signin button">
                                <input type="submit" value="My Lists" onClick="location.href = 'mylists'"/>
                            </p>
                            </p>
                            <p>
                            <p class="signin button">
                                <input type="submit" value="New List" onClick="location.href = '/newlist'"/>
                            </p>
                            </p>

                            <p class="signin button">
                                <input type="submit" value="Sign out" onClick="location.href = 'menu/lists'"/>
                            </p>


                        </form>
                    </div>



                </div>
            </div>
        </section>
    </div>
</form>
</body>
</head>
<body>

</body>
</html>
