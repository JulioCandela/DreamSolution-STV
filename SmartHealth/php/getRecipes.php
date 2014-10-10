<?php

try {

$id_category=null;

if (isset($_GET['id_category'])) 
{
	$id_category = $_GET['id_category'];
}

$client = new SoapClient('http://200.16.7.111/wordpress/index.php?/wpws/?wsdl');


$response = $client->smartGeneralSearchService($id_category);

$jsonFile= json_encode($response,true);


print_r ($jsonFile);


} catch (Exception $e) {

printf("Message = %s ",$e->__toString());

}

?>