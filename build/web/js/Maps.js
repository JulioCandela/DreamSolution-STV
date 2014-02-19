

function loadGoogleMaps(x,y)
{
    var map;
    var options = {
        zoom: 15
        , center: new google.maps.LatLng(x, y)
        , mapTypeId: google.maps.MapTypeId.MAP
    };
    map = new google.maps.Map(document.getElementById('mapGoogle'), options);
    new google.maps.Marker({
        position: map.getCenter()
        , map: map
        , title: 'Pontificia Universidad Catolica del Perú'
        , icon: 'http://gmaps-samples.googlecode.com/svn/trunk/markers/green/blank.png'
        , cursor: 'default'
        , draggable: false
    });
};

var mapSave;
var markerSave=null;
var locationSave;

function saveGoogleMaps()
{
    var options=
            {
        zoom: 10
        , center: new google.maps.LatLng(-12.02, -76.95)
        , mapTypeId: google.maps.MapTypeId.MAP
            }
   mapSave = new google.maps.Map(document.getElementById('mapGoogle'), options);   
   
   google.maps.event.addListener(mapSave, 'click', function(event) {
    putMarkerClick(event.latLng);
  });
    
}

function putMarkerClick(location)
{
    if (markerSave) markerSave.setMap(null);
    locationSave=location;
    document.getElementById("idPositionMap").value=locationSave;
    markerSave=new google.maps.Marker({
        position: locationSave
        , map: mapSave
        , title: 'Pontificia Universidad Catolica del Perú'
        , icon: 'http://gmaps-samples.googlecode.com/svn/trunk/markers/green/blank.png'
        , cursor: 'default'
        , draggable: true
    });
}