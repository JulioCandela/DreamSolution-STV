<?php

try {

$id_recipe=null;

if (isset($_GET['id_recipe'])) 
{
	$id_recipe = $_GET['id_recipe'];
}

$client = new SoapClient('http://200.16.7.111/wordpress/index.php?/wpws/?wsdl');

$params = array(
  "id_recipe" => $id_recipe
);

$response = $client->__soapCall("smartSelectRecipeService", $params);

$jsonFile= json_encode($response,true);


print_r ($jsonFile);


} catch (Exception $e) {

printf("Message = %s ",$e->__toString());

}

?>