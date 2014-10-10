<?php

try {

$client = new SoapClient('http://200.16.7.111/wordpress/index.php?/wpws/?wsdl');

$response = $client->smartGeneralSearchService();

$jsonFile= json_encode($response,true);


print_r ($jsonFile);


} catch (Exception $e) {

printf("Message = %s ",$e->__toString());

}

?>