<%--
  Created by IntelliJ IDEA.
  User: Zhuk
  Date: 17.12.2015
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    function send_f(f){f.submit();}
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

<div class="container">
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>


            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="createnewlist" onSubmit="return false">
                        <h1>New list</h1>
                        <p>
                            New list name:
                            <input id="name" name="name" required="required" type="text"/>
                        </p>
                        <p>
                            Comments:
                            <input id="comments" name="comments" required="required" type="text"  />
                        </p>

                        <p class="login button">
                            <input type="submit" value="Create" onClick="send_f(this.form)" />
                        </p>

                    </form>
                </div>



            </div>
        </div>
    </section>
</div>
</body>
</html>
