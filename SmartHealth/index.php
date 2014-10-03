<!DOCTYPE html>	
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
		<link rel="stylesheet" type="text/css" href="css/styles.css"/>
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/rating.js"></script>
		<link rel="stylesheet" type="text/css" href="css/rating.css" />
		
		<script type="text/javascript">
		$(document).ready(function() {
			$('#star1').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star2').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star3').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star4').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star5').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star6').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star7').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star8').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
			$('#star9').rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
		});
		</script>
		
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <div id="main-container">
            <table>
                <tr>
                    <td id="bloque-left">
                            <div id="menu-container" class="bloque">
                                    <table cellspacing="50">
                                            <tr>
                                                    <td>
                                                            <center><img src="images/logo.png"></center>
                                                    </td>
                                            </tr>

                                            <tr>
                                                    <td>
                                                            <center><img src="images/user.png">Usuario</center>
                                                    </td>
                                            </tr>

                                            <tr>
                                                    <td>
                                                            <center>Top 10</center>
                                                    </td>
                                            </tr>

                                            <tr>
                                                    <td>
                                                            <center>Favoritos</center>
                                                    </td>
                                            </tr>

                                            <tr>
                                                    <td>
                                                            <center>Recientes</center>
                                                    </td>
                                            </tr>

                                            <tr>
                                                    <td>
                                                            <center>Categorías</center>
                                                    </td>
                                            </tr>

                                    </table>
                            </div>
                    </td>

                    <td id="bloque-center">
                            <div id="data-container" class="bloque">
                                    <div id="search">
                                            <table>
                                                    <tr>
                                                            <td>
                                                                    <h3>Recetas Sugeridas</h3>
                                                            </td>
                                                            <td>
                                                                    <form id="search-box" action="/search" method="get">
                                                                            <input type="text" name="q" size="40" placeholder="Buscar..." />
                                                                    </form>
                                                            </td>
                                                    </tr>
                                            </table>
                                    </div>

                                    <div class="resultado-recetas">
                                            <table>
                                                    <tr>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star1" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star2" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star3" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                    </tr>
                                                    <tr>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star4" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star5" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star6" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                    </tr>
                                                    <tr>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star7" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star8" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                            <td>
                                                                    <div class="detalle-receta">
                                                                            <div id="star9" class="rating">&nbsp;</div>
                                                                            <div class="texto-detalle">
                                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                                                                                    Nulla quam velit, vulputate eu pharetra nec, 
                                                                                    mattis ac neque. Duis vulputate commodo lectus.
                                                                                    </p>
                                                                            </div>
                                                                            <div class="imagen-detalle"><img src="images/ensalada.jpg"></div>
                                                                    </div>
                                                            </td>
                                                    </tr>
                                            </table>
                                    </div>
                            </div>	
                    </td>

                    <td id="bloque-right">
                        <div id="sugerencias-container" class="bloque">
                            <table>
                                <tr>
                                    <td>
                                        <img src="images/tip.jpg">Tip1
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/tip.jpg">Tip2
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/tip.jpg">Tip3
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/tip.jpg">Tip4
                                    </td>
                                </tr>

                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
		
        
    </body>
</html>
