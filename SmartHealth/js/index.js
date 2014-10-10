//Variables Globales
var numbuttons=4;

var data2={
	"recetas":[
		{
			"id":"01",
			"nombre":"Batido de Fresa",
			"palabras_clave":["fresa","batido","desayuno"],
			"categorias":["1","2","5"],
			"instrucciones":["En una batidora, combinar leche, plátano y fresas. Agregar vainilla y azúcar de manera opcional. Bator hasta obtener la consistencia deseada. Verter en vasos y servir."],
			"imagen":"01_batido_fresas.jpg",
			"video":"",
			"evaluación":"4.5",
			"porciones": 2,
			"calorias":236,
			"num_usuarios":832,
			"tiempo": 5,
			"link":"http://allrecipes.com/recipe/strawberry-oatmeal-breakfast-smoothie/"
		},
		{
			"id":"02",
			"nombre":"Langostinos Szechwan",
			"palabras_clave":["langostinos","mariscos","szechwan"],
			"categorias":["6"],
			"instrucciones":["En un bowl, mezclar agua, ketchup, salsa de soya, maicena, miel, pimienta roja molida y jengibre. Dejar reservado.","Calentar aceite en una sartén grande a fuego medio-alto. Poner cebollas y ajo y cocinar por 30 segundos. Agregar los langostinos y revolver para cubrir con aceite. Agregar a la salsa y cocinar revolviendo hasta que la salsa se encuentre burbujeando y espese."],
			"imagen":"02_langostinos_szechwan.jpg",
			"video":"",
			"evaluación":"4.5",
			"porciones": 4,
			"calorias":142,
			"num_usuarios":2393,
			"tiempo": 20,
			"link":"http://allrecipes.com/recipe/szechwan-shrimp/"
		},
		{
			"id":"03",
			"nombre":"Quiche de tofu y espinaca sin huevo",
			"palabras_clave":["tofu","espinaca","quiche","vegetariano"],
			"categorias":["2","5","8"],
			"instrucciones":["Precalentar el horno a 175 grados Celcius.",
							"En una batidora, combinar el tofu y la leche; procesar hasta que esté cremoso añadiendo más leche de ser necesario. Añadir sal y pimienta.",
							"En un bowl mediano, combinar espinaca, ajo, cebolla, queso cheddar, queso suizo y la mezcla de tofu. Mezclar bien y poner en un molde de pie preparado.",
							"Cocinar en el horno precalentado por 30 minutos o hasta que esté dorado en la superficie. Dejar reposar por 5 minutos antes de cortar."],
			"imagen":"03_quiche_tofu.jpg",
			"video":"",
			"evaluación":"4.5",
			"porciones": 6,
			"calorias":288,
			"num_usuarios":152,
			"tiempo": 45,
			"link":"http://allrecipes.com/recipe/eggless-tofu-spinach-quiche/"
		},
		{
			"id":"04",
			"nombre":"Ensalada de Feta y Col Rizada",
			"palabras_clave":["feta","col","ensalada","vegetariano"],
			"categorias":["2","3","5","7"],
			"instrucciones":["Mezclar la col con sal en un bowl por 2 minutos. Poner vinagre sobre la col y revolver. Trozar manzana, queso feta y piñones a la col."],
			"imagen":"04_ensalada_feta_kale.jpg",
			"video":"",
			"evaluación":"5",
			"porciones": 8,
			"calorias":43,
			"num_usuarios":832,
			"tiempo": 15,
			"link":"http://allrecipes.com/Recipe/Kale-and-Feta-Salad/"
		},
		{
			"id":"05",
			"nombre":"Estofado de carne",
			"palabras_clave":["carne","estofado"],
			"categorias":["4"],
			"instrucciones":["En una olla grande, cocinad la carne en aceite a fuego lento hasta que esté cocida. Disolver caldo en agua y verterlo en la olla. Esparcir romero, perejil y pimienta. Llevar a punto de ebullición y luego reducir la temperatura, cubrir la olla y cocer por 1 hora.",
							"Poner papas, zanahorias, apio y cebolla dentro de la olla. Disolver maicena en 2 cucharaditas de agua fría y echar al estofado. Cubrir y dejas cocinar por 1 hora más."],
			"imagen":"05_estofado.jpg",
			"video":"",
			"evaluación":"4.5",
			"porciones": 10,
			"calorias":401,
			"num_usuarios":1790,
			"tiempo": 140,
			"link":"http://allrecipes.com/Recipe/Beef-Stew-VI/"
		},
		{
			"id":"06",
			"nombre":"Keke de plátano",
			"palabras_clave":["plátano","keke"],
			"categorias":["9"],
			"instrucciones":["Precalentar el horno a 175 grados Celcius. Engrasar un poco una sartén de 9x5 pulgadas.",
							"En un bowl grande, combinar la harina, el polvo de hornear y la sal. En un bowl separado, mezclar la mantequilla y el azúcar rubia. Agregar los huevos y las bananas hasta que se encuentre bien mezclado. Unir la mezcla de las bananas y harina. Poner mantequilla en la sartén preparado.",
							"Cocinar en el horno precalentado de 60 a 65 minutos. Dejar enfriar en el molde por 10 minutos, luego voltearlo en otro recipiente."],
			"imagen":"06_banana_bread.jpg",
			"video":"",
			"evaluación":"4.5",
			"porciones": 8,
			"calorias":229,
			"num_usuarios":10506,
			"tiempo": 80,
			"link":"http://allrecipes.com/Recipe/Banana-Banana-Bread/"
		}
	]

}

  
var categorias2={
	"categorias":[
		{
			"id":0,
			"nombre":"Todos",
			"descripcion":""
		},
		
		{
			"id":1,
			"nombre":"Bebidas",
			"descripcion":""
		},
		{
			"id":2,
			"nombre":"Comida saludable",
			"descripcion":""
		},
		{
			"id":3,
			"nombre":"Entrada",
			"descripcion":""
		},
		{
			"id":4,
			"nombre":'Carnes',
			"descripcion":""
		},
		{
			"id":5,
			"nombre":"Vegetariano",
			"descripcion":""
		},
		{
			"id":6,
			"nombre":"Mariscos",
			"descripcion":""
		},
		{
			"id":7,
			"nombre":"Ensaladas",
			"descripcion":""
		},
		{
			"id":8,
			"nombre":"Quiches",
			"descripcion":""
		},
		{
			"id":9,
			"nombre":"Postres",
			"descripcion":""
		}
	]

}




$(document).ready($(function () 
  {
  
	paintRecipes(3);
 
     /*$(document).keydown(function(){
  		alert("hola")});*/
	$('.detalle-receta').mousedown(function(){
		var id = $(this).attr("id_receta");
  		selectRecipe(id)});

	$('#volverBtn').click(function(){
  		$('#recipe-details').addClass("invisible-block");  		
    });

    $('#favoritosBtn').click(function(){
  		alert("Adicionar a favoritos!"); 		
    });  

    $('#voicePlayBtn').click(function(){
    	var audio = new Audio();
    	var playText = text.substring(0,99);
    	audio.src ='http://translate.google.com/translate_tts?ie=utf-8&tl=es&q=' + encodeURI(playText);
		audio.play();
    	/*for (var i = 0; i <= text.length / 100;i++) {
    		playText = text.substring(i*100,i*100+99);
    		alert(playText);
    		audio.src ='http://translate.google.com/translate_tts?ie=utf-8&tl=es&q=' + encodeURI("hola" + i);
			audio.play();
			sleep(2000,alert());
    	};*/
    	
    });

  })); 
  
  function sleep(millis, callback) {
    setTimeout(function() { callback(); }, millis);
  }

  function paintRecipes(numColumns){
	var targetdiv=$('#resultadoRecetas')
    var recetaDiv="<table>";
    for ( var i=0; i<data2.recetas.length; i++ ) {
		if(i%numColumns==0)	recetaDiv+='<tr>'
        recetaDiv+= '<td><div id="receta_'+i+'" class="detalle-receta" id_receta='+i+'>';
		var puntuacion='<div id="star_'+i+'" class="rating">&nbsp;</div>';
		var textoReceta='<div id=textReceta_'+i+' class="texto-detalle"><p>'+data2.recetas[i].nombre+'</p></div>';
		var imagenReceta='<div id=imagenReceta_'+i+' class="imagen-detalle"><img src="images/'+data2.recetas[i].imagen+'" width="82 "height="76"></div>';
		recetaDiv+=puntuacion+textoReceta+imagenReceta;
		recetaDiv+='</div></td>';
		if(i%numColumns==numColumns-1) recetaDiv+='</tr>'
    }
	recetaDiv+='</table>';
	targetdiv.html(recetaDiv);
	
	for ( var i=0; i<data2.recetas.length; i++ ){
		$('#star_'+i).rating('votar.php', {maxvalue: 5, curvalue:1, id:20});
	}
  
  }

  var exampleRecipe = {
    "name":"Langostinos Szechwan",
    "keyword":"langostinos, mariscos, szechwan",
    "rating":"4",
    "raters":"2393",
    "calories":"142",
    "time":"20",
    "difficulty":"3",
    "fat":"4.4",
    "carbohydrate":"6.7",
    "fiber":"0.4",
    "proteins":"18.3",
    "cholesterol":"0.164",
    "sodium":"0.5",
    "created_at":"2014-10-08 12:16:03",
    "hits":"0",
    "categories":[
      {
        "id":"14",
        "name":"Mariscos"
      }
    ],
    "instructions":[
      "En un bowl, mezclar agua, ketchup, salsa de soya, maicena, miel, pimienta roja molida y jengibre. Dejar reservado.",
      "Calentar aceite en una sartén grande a fuego medio-alto. Poner cebollas y ajo y cocinar por 30 segundos. Agregar los langostinos y revolver para cubrir con aceite. Agregar a la salsa y cocinar revolviendo hasta que la salsa se encuentre burbujeando y espese."
    ],
    "ingredients":[
      {
        "id":"6",
        "name":"agua",
        "unit":"cucharada",
        "quantity":"4",
        "description":"NULL"
      },
      {
        "id":"7",
        "name":"ketchup",
        "unit":"cucharada",
        "quantity":"2",
        "description":"NULL"
      },
      {
        "id":"8",
        "name":"salsa de soya",
        "unit":"cucharada",
        "quantity":"1",
        "description":"NULL"
      },
      {
        "id":"9",
        "name":"maicena",
        "unit":"cucharadita",
        "quantity":"2",
        "description":"NULL"
      },
      {
        "id":"10",
        "name":"miel",
        "unit":"cucharadita",
        "quantity":"1",
        "description":"NULL"
      },
      {
        "id":"11",
        "name":"pimienta roja",
        "unit":"cucharadita",
        "quantity":"0.5",
        "description":"NULL"
      },
      {
        "id":"12",
        "name":"jenjibre",
        "unit":"cucharadita",
        "quantity":"0.25",
        "description":"NULL"
      },
      {
        "id":"13",
        "name":"aceite vegetal",
        "unit":"cucharada",
        "quantity":"1",
        "description":"NULL"
      },
      {
        "id":"14",
        "name":"cebolla verde",
        "unit":"taza",
        "quantity":"0.25",
        "description":"cortada"
      },
      {
        "id":"15",
        "name":"diente de ajo",
        "unit":"unidad",
        "quantity":"4",
        "description":"troceado"
      },
      {
        "id":"16",
        "name":"langostino",
        "unit":"gramos",
        "quantity":"340",
        "description":"cocinado, sin cola"
      }
    ]
  };

  var currentInstructions;

  function selectRecipe(recipeId){
  	//alert(recipeId);
  	fillRecipeDetails(exampleRecipe);
  	$('#recipe-details').removeClass("invisible-block");
  	
  	currentInstructions = exampleRecipe.instructions;
  	text = "";
  	for (var i = 0; i < currentInstructions.length; i++) {
  		text += currentInstructions[i];
  	};

  	var soapMessage =
    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sexy="http://www.dreamsolutions.com/sexy_service/">' +
   		'<soapenv:Header/>' +
   			'<soapenv:Body>' +
      			'<sexy:id_recipe>3</sexy:id_recipe>' +
   			'</soapenv:Body>' +
	'</soapenv:Envelope>';

    $.ajax({
    	url: "http://200.16.7.111/wordpress/index.php?/wpws/?wsdl",
    	type: "POST",
    	contentType: 'text/xml; charset=utf-8',
    	headers: {
        	SOAPAction: "http://www.dreamsolutions.com/sexy_service/smartSelectRecipeService"
    	},
    	data: soapMessage,
    	success: function(soapResponse){
        	//DO SOMETHING
        	alert("OK");
        	//alert(soapResponse);
        }
        //error: alert("error")
        
    });
	

	/*$.soap({
    	url: 'http://200.16.7.111/wordpress/index.php?/wpws/?wsdl',
    	method: 'http://www.dreamsolutions.com/sexy_service/smartSelectRecipeService',
    	data: {
        	id_recipe: '2'
    	},
    	success: function (soapResponse) {
    		alert(soapResponse);
        // do stuff with soapResponse
    	},
    	error: function (soapResponse) {
        	alert('that other server might be down...');
    	}
	});*/
  	//alert("end");
  }

  function fillRecipeDetails(details){
  	$('#recipeTitle').html(details.name);
  	
  	//ingredientes
  	var ingredientes = details.ingredients;
  	var rowDisplay;
  	for (var i = 0; i < ingredientes.length; i++) {
  		rowDisplay = '<tr> <td class="ingredientCell">' + ingredientes[i].name + '</td> <td class="umCell">' + 
  		ingredientes[i].unit + '</td> <td class="quantityCell">' + ingredientes[i].quantity + '</td> </tr>';
  		$('#ingredientsTable').append(rowDisplay);
  	}
  	
  	//instrucciones
  	var instrucciones = details.instructions;
  	var pasosDisplay = "Instrucciones: <br/>";
  	for (var i = 0; i < instrucciones.length; i++) {
  		pasosDisplay += "<br/>" + (i + 1) + ". " + instrucciones[i] +" <br/>";
  	}
  	$('#preparationDiv').html(pasosDisplay);

  	// dificultad
  	$('#dificultad').html("Dificultad: " + details.difficulty);
  	
  	// tiempo
  	$('#duracion').html("Tiempo de preparación: " + details.time + " minutos");
  	
  	// informacion nutricional
  	var nutriDisplay = "Información nutricional: <br/>";
  	nutriDisplay += "Calorías: " + details.calories + " kcal <br/>";
  	nutriDisplay += "Colesterol: " + details.cholesterol + " g <br/>";
  	nutriDisplay += "Fibra: " + details.fiber + " g <br/>";
  	nutriDisplay += "Sodio: " + details.sodium + " g <br/>";
  	nutriDisplay += "Carbohidratos: " + details.carbohydrate + " g <br/>";
  	nutriDisplay += "Grasas: " + details.fat + " g <br/>";
  	nutriDisplay += "Proteinas: " + details.proteins + " g <br/>";
  	$('#infoNutricional').html(nutriDisplay);

  	// imagen (provisional)
  	var imgDisplay= '<img id="recipeImag" src="images/02_langostinos_szechwan.jpg"/>';
  	$('#recipePhoto').html(imgDisplay);
  }	