<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhuk
  Date: 18.12.2015
  Time: 1:00
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
    <link rel="stylesheet" type="text/css" href="css/style4.css" />
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
                    <form action="newpurchase" onSubmit="return false">
                        <h1>List purchases</h1>

                        <table class="simple-little-table" cellspacing='0'>
                            <tr>
                                <th>Name </th>
                                <th>Count</th>
                                <th>Status</th>
                                <th>Checked</th>
                            </tr><!-- Table Header -->

                            <c:forEach items="${requestScope.Userp}" var="Purchaselists">
                                <tr>
                                <td>${Userp.name}</td>
                                <td>${Userp.Count}</td>
                                    <td><input type="checkbox" value="${Userp.id}" ${Userp.Status} /></td>
                                <td><input name="${Userp.id}" type="checkbox" value="${Userp.id}"  /></td>

                                </tr>

                            </c:forEach>
                        </table>

                        <p class="signin button">
                            <input type="submit" value="Add" onClick="send_f(this.form)"/>
                            <input type="submit" value="Delete" onClick="send_f(this.form)"/>
                        </p>

                    </form>
                </div>



            </div>
        </div>
    </section>
</div>
</body>
</html>
