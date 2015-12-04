<%@ page import="inf.info" %><%--
  Created by IntelliJ IDEA.
  User: Zhuk
  Date: 16.12.2015
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script>
  function send_f(f){f.submit();}
  window.onload =function()
  {
    var tmp=<%=info.getValue()%>
    if(tmp=="1")
      alert("Success!");
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
  <link rel="stylesheet" type="text/css" href="css/style.css" />
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
              <h1>Log in</h1>
              <p>
                <label for="username" class="uname" data-icon="u" > Your username </label>
                <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
              </p>
              <p>
                <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
              </p>
              <p class="login button">
                <input type="submit" value="Login" onClick="send_f(this.form)" />
              </p>
              <p class="change_link">
                Not a member yet ?
                <a href="#toregister" class="to_register">Join us</a>
              </p>
            </form>
          </div>

          <div id="register" class="animate form">
            <form action="registration" onSubmit="return false">
              <h1> Sign up </h1>
              <p>
                <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
              </p>

              <p>
                <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
              </p>
              <p>
                <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
              </p>
              <p class="signin button">
                <input type="submit" value="Sign up" onClick="send_f(this.form)"/>
              </p>
              <p class="change_link">
                Already a member ?
                <a href="#tologin" class="to_register"> Go and log in </a>
              </p>
            </form>
          </div>

        </div>
      </div>
    </section>
  </div>
</body>
</html>
