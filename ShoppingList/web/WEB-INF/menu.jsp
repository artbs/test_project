<%--
  Created by IntelliJ IDEA.
  User: Zhuk
  Date: 17.12.2015
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
                    <form action="authorization" onSubmit="return false">
                        <h1>My lists</h1>




                        <table class="simple-little-table" cellspacing='0'>
                            <tr>
                                <th>List name </th>
                                <th>Date</th>
                                <th>Status</th>
                                <th>Checked</th>
                            </tr><!-- Table Header -->

                            <c:forEach items="${Userlists}" var="Userlist">
                                <td><a href="\showlist?${Userlists.id}">${Userlists.name}</a></td>
                                <td>${Userlists.comments}</td>

                                <td><input id=" " type="checkbox"  /></td>
                            </c:forEach>
                        </table>
                    </form>
                </div>



            </div>
        </div>
    </section>
</div>
</body>
</html>