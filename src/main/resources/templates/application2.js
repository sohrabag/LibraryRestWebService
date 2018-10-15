/* application.js */

//$(document).ready(function() {
//	//create a <p> node with the price
//
//	//to add this tag to the DOM tree we have following methods:
//	//.append(<element>), .prepend(<element>), .after(<element>), .before(<element>)
//	/*.appendTo(<element>), .prependTo(<element>), .insertAfter(<element>), 
//							.insertBefore(<element>)*/
//
//	$('button').on('click', function(){
//		var price = $('<p>From $399.99</P>');
//		//run this function on click
//		$(this).closest('.vacation').append(price);
//		$(this).remove();
//	});
//
//});

$(document).ready(function() {

//                      var xhr = new XMLHttpRequest();
//                      var open_str = "http://localhost:8080/loans/members/1/all";
//                      xhr.open("GET", open_str, true);
//                      xhr.onreadystatechange = function() {
//                                  alert(xhr.readyState + "" + xhr.status);
//                        if (xhr.readyState == 4 && xhr.status == 200) 
//                        {
//
//                            alert("session opend success");
//
//                            var json = JSON.parse(xhr.responseText);
//                            //alert(JSON.stringify(json, null, 10));
//                            console.log(JSON.stringify(json, null, 10));
//                            /* The following code is a Javascript + JQuery code to call a rest web server */
//                            $('#results').text('');
//                            		
//                            for(var index in json)
//                           	{
//                           		$('#results').append('<p>' + json[index].book.title + '</p>');
//                           	}
//                            
//                        	}
//                      }
//  console.log("before xhr.send(null)");
//  xhr.send(null);
                      /* 
                       * The following code is calling AJAX query by using JQuery which calls a rest controller web service 
                       * using AJAX theory to make the client side more responsive to the user without slowing 
                       * down the client application. 
                       * http://localhost:8080/loans/all
                       * 
                       * 
                       */
 
// 						var x = document.getElementById("searchBox");
//						x.value = '1';
//						console.log(parseInt(x.value));
						var memid = $('#searchBox').val();
						
						if(memid.length === 0)
							{
								console.log("The memberId string is empty");
							}
						else
							{
								$.getJSON("http://localhost:8080/loans/members/memberId/all", 
	                      				{ memberId: parseInt($('#searchBox').val()) }, 
	                      				function(data) {
	                      					console.log("Ajax Succeeded to Call Rest Controller");
	                      					console.log("data received " + data);
	                      					$("#results").text('');
	                      					for(var index in data)
	                      						{
	                      							$("#results").append('<p>' + data[index].book.title + '</p>');
	                      						}
	                      				});
		                        	console.log(parseInt($('#searchBox').val()));
							}

//						$.getJSON("http://localhost:8080/loans/all",  function(data) {
//								console.log("success calling the rest controller");
//								alert(JSON.stringify(data, null, 10));
//								$("#results").text('');
//								for(var index in data)
//									{
//										$("#results").append('<p>' +data[index].book.title + '</p>');
//									}
//							console.log("before calling JSON.stringify(data)");
//							alert(JSON.stringify(data, null, 10));
//							console.log("after calling JSON.stringify(data)");
//								var items = [];
//								$.each(data, function( key, val ) {
//									items.push( "<li id='" + key + "'>" + val + "</li>");
//								});
//								
//								$( "<ul/>" , {
//									"class": "my-new-list", 
//									html: items.join("")
//								}).appendTo( "body" );
//						});
});

function onKeyUpHandler()
{
	var memid = $('#searchBox').val();
	var id = parseInt(memid);
	var url = "http://localhost:8080/loans/members/" + id + "/all";

	if(memid.length === 0)
	{
		console.log("The memberId string is empty");
	}
	else
	{
		$.getJSON(url, 
				{ memberId: id }, 
				function(data) {
					console.log("Ajax Succeeded to Call Rest Controller");
					console.log("data received " + data);
					$("#results").text('');
					for(var index in data)
						{
							$("#results").append('<p>' + data[index].book.title + '</p>');
						}
				});
			console.log(parseInt($('#searchBox').val()));
	}
}