<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Súbete.com! - Home</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
     <link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
                    <!--<link rel="stylesheet" type="text/css" href="../css/zoomStyle.css" />-->
                    <!--<link rel="stylesheet" type="text/css" href="../css/WelcomePageStyle.css" />-->
                    <link href="css/confirmBoxes.css" rel="stylesheet" type="text/css" media="screen">
                    <script language="javascript" src="<c:url value='/js/jquery-1.7.1.min.js'/>"></script>   
     <script src="js/JsCircle.js"></script>
        <script>
          
        </script>
        <script language="javascript" type="text/javascript">

                            function activePopUp()
                        {
                            $('#overlay').fadeIn('fast',function(){
                                $('#box').animate({'top':'160px'},500);
                            });
                        }

                        function closeBox(){
                                $('#box').animate({'top':'-400px'},500,function(){
                                    $('#overlay').fadeOut('fast');
                                });
                                location.reload();
                            };

                        function recoverPass()
                        {
                            purl = "<c:url value='/usr/recoverPassword.htm'/>";
                                    $.ajax({
                                        type: 'post',
                                        async: true,
                                        url: purl,
                                        data: "idUserRecover=" + $('#idUserRecover').val() +
                                                "&rnd=" + Math.random(),
                                        success: function(data) {
                                            activePopUp();
                                        }
                                    });
                        }

                    </script>
    
</head>
<body>
    
    <div id="header">
        
        <div class="container">
        
            <div id='containerimg'>
                <img src='images/subete.png' width="150%" />
            </div>
            
            <form style="float:left;left: 35%;margin-bottom: 5%;margin-top: 4%;z-index: 999" method="post" action="usr/verificarUsuario.htm">
                                        <input style="width:35%" id="user" name="user" placeholder="Usuario" type="text" required="">
                                        <input style="width:35%" placeholder="Password" id="pass" name="pass" type="password" required="" >
                                        <input class="btnSubmit" type="submit" value="Iniciar Sesión"><br>
                                        <div style="margin-top: -5%;font-style:italic">¿Aún no tienes una cuenta?.
                                            <a href="registerUser.htm">Registrarse</a> es rápido y sencillo.<br>
                                            <a href="#" onclick="$('#divRecover').show()">¿Olvidó su contraseña?</a>
                                        </div>
                                        <div id="divRecover" style="padding:15px;display:none;border: 0px solid;border-radius:5px ;background-color: whitesmoke
                                             ;width: 300px;height: 40px">
                                            <input placeholder="Usuario" type="text" id="idUserRecover">
                                            <input id="btnRecover" class="btnSubmit" type="button" value="Enviar" onclick="recoverPass()">
                                        </div>
                                    </form>

                                    <div class="overlay" id="overlay" style="display:none;"></div>

                                    <div class="box" id="box">
                                        <a class="boxclose" id="boxclose" onclick="closeBox()"></a>
                                        <h1>Confirmación de Eliminación</h1>

                                            <div id="divInfoTrip" style="float: left">
                                                <p>Su contraseña ha sido enviada a su email.</p>
                                           </div>
                                    </div> 
        </div> <!-- END .container -->
    
    </div> <!-- END #header -->
    
    <div id="main_content">
            
        <div id="slideshow_area">
        
        <div class="container" style="width: 100%;height: 90%">
            
<!--            <div id="slides">
                <img src="images/iconoMapa.jpg">
                <img src="images/iconoMapa.jpg">
                <img src="images/iconoMapa.jpg">
                <img src="images/iconoMapa.jpg">
                <img src="images/iconoMapa.jpg">
            </div>-->
            
            <p>¿Cómo funciona <span>SúbeteAPP</span>?</p>
            <div class="containermidfunciona">
                <img src="images/funciona.png" width="98.5%"/>
            </div>

            <p>¿Cuáles son los beneficios?</p>
            <div class="containermid">
                        <img src="images/vertical.png" style="position:absolute;left:49.5%;top:200%;width:0.3%"/>
<!--                        <img src="images/horizontal.png"/>
                        <img src="images/horizontal.png"/>-->
                        <table >
                            <tr >
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/seguridad.png' style="width: 8%;margin-right:2%"/>
                                        <div class='beneficio_title'>
                                            Seguridad
                                        </div>
                                        <div class='beneficio_contain'>
                                            ¿Laptop? ¿Smartphone? ¿Tablet? 
                                            Este es un servicio en el que solo 
                                            participan tus compañeros de institución, 
                                            siéntete seguro!
                                        </div>
                                        
                                    </div>
                                </td>
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/reloj.png' style="width: 9%;margin-right:2%;margin-top:1%" />
                                        <div class='beneficio_title'>
                                            Tiempo
                                        </div>
                                        <div class='beneficio_contain'>
                                            ¿Pierdes demasiado tiempo en transporte público?
                                            Viaja a velocidad de taxi a un precio económico.
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/socializa.png' style="width: 6%;margin-right:2%"/>
                                        <div class='beneficio_title'>
                                            Socializa
                                        </div>
                                        <div class='beneficio_contain'>
                                            Tus viajes ya no tienen por qué ser aburridos.
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/ahorra.png' style="width: 12%;margin-right:2%;margin-top: 3%" />
                                        <div class='beneficio_title'>
                                            Ahorra
                                        </div>
                                        <div class='beneficio_contain'>
                                            No hay mejor solución que dividir los gastos de combustible 
                                            con tus compañeros.
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/comodidad.png' style="width: 10%;margin-right:2%" />
                                        <div class='beneficio_title'>
                                            Comodidad
                                        </div>
                                        <div class='beneficio_contain'>
                                            Ya no será necesario cruzar los dedos por un asiento libre.
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div class='insidetd'>
                                        <img src='images/fb.png' />
                                        <div class='beneficio_title'>
                                            Menos contaminación
                                        </div>
                                        <div class='beneficio_contain'>
                                            
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                </div>
            
            
            
                    
                    
                    
                    
<!--                    <div id="circle"></div>
                    <div id="circle1"class="circle_min" style="position:absolute;top:90%;left:18%"></div>
                        <div id="circle2"class="circle_min" style="position:absolute;top:55%;left:22%"></div>
                        <div id="circle3"class="circle_min" style="position:absolute;top:33%;left:45%"></div>
                        <div id="circle4"class="circle_min" style="position:absolute;top:55%;left:68%"></div>
                        <div id="circle5"class="circle_min" style="position:absolute;top:90%;left:73%"></div>
                        <div id="circlemid"class="circle_mid"></div>-->
                    <!--95C6C7-->
<!--                <div class="mid_content_info mid_content_space">

                    <h2 id="clean">Socializa</h2>
                    <p>Tus viajes ya no tienen por qué ser aburridos .</p>
                    <a href="#"><img src="images/arrow_right.png" alt="arrow right">Read More</a>

                </div>

                <div class="mid_content_info mid_content_space">

                    <h2 id="responsive">Seguridad</h2>
                    <p>¿Laptop? ¿Smartphone? ¿Tablet? Este es un servicio en el que solo participan 
                        tus compañeros de institución, siéntete seguro!</p>
                    <a href="#"><img src="images/arrow_right.png" alt="arrow right">Read More</a>

                </div>

                <div class="mid_content_info mid_content_space">

                    <h2 id="fully">Rapidez y Tiempo</h2>
                    <p>¿Pierdes demasiado tiempo en transporte público? Viaja a velocidad de taxi a un precio económico.</p>
                    <a href="#"><img src="images/arrow_right.png" alt="arrow right">Read More</a>

                </div>

                <div class="mid_content_info">

                    <h2 id="ready">Economiza</h2>
                    <p>¿Se te hace difícil costear el precio del combustible solo?
                        No hay mejor solución que dividir los gastos con tus compañeros.</p>
                    <a href="#"><img src="images/arrow_right.png" alt="arrow right">Read More</a>

                </div>-->
            </div> <!-- END #mid_content -->
    

        </div> <!-- END .container -->
    
        </div> <!-- END #slideshow_area -->
        
    </div> <!-- END #main_content -->
    
    <div id="footer">
        
        <div class="container">
            
<!--            <div id="footer_about" class="footer_info">
                
                <h4>about us</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi euismod placerat dui et tincidunt. Sed sollicitudin posuere auctor. Phasellus at
                ultricies nisl. Integer at leo eros. Ut nec lorem id orci convallis porta. Donec pharetra neque eu velit dictum molestie. </p>
                
            </div>  END #footer_about 
            
            <div id="footer_explore" class="footer_info">
                
                <h4>explore</h4>
                <ul>
                    <li><a href="index.html">home</a></li>
                    <li><a href="#">about us</a></li>
                    <li><a href="#">services</a></li>
                    <li><a href="portfolio.html">portfolio</a></li>
                    <li><a href="#">blog</a></li>
                </ul>
                
            </div>  END #footer_about 
            
            <div id="footer_browse" class="footer_info">
                
                <h4>browse</h4>
                <ul>
                    <li><a href="#">careers</a></li>
                    <li><a href="#">press &amp; media</a></li>
                    <li><a href="contact.html">contact us</a></li>
                    <li><a href="#">terms of service</a></li>
                    <li><a href="#">privacy policy</a></li>
                </ul>
                
            </div>  END #footer_about 
            
            <div id="footer_contact" class="footer_info">
                
                <h4>contact us</h4>
                <p><span class="bold_text">BisLite Inc.</span>
                <br>
                Always Street 265
                <br>
                0X - 125 - Canada
                <br>
                <br>
                Phone: 987-6543-210
                <br>
                Fax: 987-6543-210</p>
                
            </div>  END #footer_about 
            
            <div id="footer_connect" class="footer_info">
                
                <h4>connect with us</h4>
                
                <ul>
                    <li><a href="#" id="facebook" title="Facebook">Facebook</a></li>
                    <li><a href="#" id="dribbble" title="Dribbble">Dribbble</a></li>
                    <li><a href="#" id="pinterest" title="Pinterest">Pinterest</a></li>
                    <li><a href="#" id="linkedin" title="LinkedIn">LinkedIn</a></li>
                    <li><a href="#" id="skype" title="Skype">Skype</a></li>
                    <li><a href="#" id="sharethis" title="Share This">ShareThis</a></li>
                </ul>
                
            </div>  END #footer_about -->
            
            <p id="copyright">© SúbeteAPP 2014 . All Rights Reserved.
            
            </p>
            
            <!--<a href="index.html" id="footer_logo">BisLite</a>-->
        
        </div> <!-- END .container -->
        
    </div> <!-- END #footer -->
    

</body></html>