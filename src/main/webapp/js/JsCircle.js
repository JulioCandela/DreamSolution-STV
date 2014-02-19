



$(document).ready(function()
{
    var ev=null;
    function parpadear()
    {
        $(ev).animate({
            opacity: 0.5,
        },800);
        parpadear2();
        
    };
    
    function parpadear2()
    {
        $(ev).animate({
            opacity: 1
        },800);
        parpadear();
    }
    
    $(".circle_min").click(function()
    {
        if (ev!=null)
        {
            $(ev).stop(true,true);
            $(ev).animate({
                opacity:1
            })
        }
        ev=$(this).attr('id');
        ev="#"+ev;
        
        var lastletter=ev.charAt(ev.length-1);
        var color;
        switch (lastletter)
        {
            case '1': color="#87CC91";break;
            case '2':color="#F2EE7E";break;
            case '3':color="#76DDE8";break;
            case '4':color="#D6D6D6";break;
            case '5':color="#F29B9B";break;
        }
        
//        $("#circlemid").css("background-color",color);
//        $("#circlemid").stop().animate({
//            
//            backgroundColor:'#ababab'
//        },800);
        
        parpadear();
    })
    
});

