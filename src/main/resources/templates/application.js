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

                      /* 
                       * The following code is calling AJAX query by using JQuery which calls a rest controller web service 
                       * using AJAX theory to make the client side more responsive to the user without slowing 
                       * down the client application. 
                       */
                        $.getJSON("http://localhost:8080/loans/members/{memberId}/all", 
                      				{memberId: console.log(parseInt($('#searchBox').val()))}, 
                      				function(data) {
                      					console.log("Ajax Succeeded to Call Rest Controller");
                      					console.log("data received " + data);
                      				});

                      console.log("before xhr.send(null)");
                      xhr.send(null);
});