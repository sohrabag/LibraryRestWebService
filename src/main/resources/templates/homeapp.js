


$(document).ready(function() {
//	var x = $("alerts");
//	x.style.display = "none";

	
	function showHide()
	{
		var visible = document.getElementById("alerts");
		if(visible.style.display === "none")
		{
			visible.style.display = "block";
		}
		else
		{
			visible.style.display = "none";
		}

	}

	function validate()
	{
		
		console.log("Hejsna");
		
		var x = document.forms["myForm"]["uname"].value;
		var y = document.forms["myForm"]["pname"].value;

		if(x == "sohrab" && y=="sohrab")
		{
			document.getElementById("pdemo").innerHTML = "you are authorized";

			showHide();
		}
		
	}
});

/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
