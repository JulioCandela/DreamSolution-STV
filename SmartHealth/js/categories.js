


function mostrarCategories()
{

	busquedaRecetas(2);
    $("#search-advanced").hide();
    $(".resultado-recetas").css("width","70%");
	$(".resultado-recetas").css("height","70%");
	$(".resultado-recetas").css("float","left"); 
	$(".resultado-recetas").css("left","47px"); 
	
	$("#categorias-menu").show();

}