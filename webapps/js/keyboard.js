$(function(){
	
	$('#usr').focus();
	var $write=$('#usr');
	var key_num=false;
	
	$('#usr').focus(function()
	{
		$write=$('#usr');	
		
	});
	
	$('#pwd').focus(function()
	{
		$write=$('#pwd');		
	});
	
	var shift = false,
		capslock = false;
	
	$('.keyboard li').click(function(){
		var $this = $(this),
			character = $this.html(); // If it's a lowercase letter, nothing happens to this variable
		
		// Caps lock
		if ($this.hasClass('capslock')) {
			$('.letter').toggleClass('uppercase');
			capslock = true;
			$write.focus();
			return false;
		}
		
		// Delete
		if ($this.hasClass('delete')) {
			var html = $write.val();
			$write.val(html.substr(0, html.length - 1));
			$write.focus();
			return false;
		}
		
		// Uppercase letter
		if ($this.hasClass('uppercase')) character = character.toUpperCase();
		
		
		
		if ($this.hasClass('symbol')) character = $('span:visible', $this).html();
		if ($this.hasClass('space')) character = ' ';
		
		//Bloquear/Desbloquear pad numerico
		if ($this.hasClass('numeric_display')) return false;
		
		// Add the character
		$write.val($write.val() + character);
		$write.focus();
	});
	
	
	$('.numeric_display').click(function()
	{
		if (key_num==false)	
		{
			$('#key_num').css('display','inline');
			$('#container').css('margin-left','200px');
			key_num=true;
			
		}				
		else 
		{
			$('#key_num').css('display','none');
			$('#container').css('margin-left','380px');
			key_num=false;
			
		}
		
	});
	
	function reset()
	{
		$('.usr').val("");
		$('.pwd').val("");
	
	}
	
	
	
});