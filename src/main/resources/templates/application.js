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

                      var xhr = new XMLHttpRequest();
                      var open_str = "http://localhost:8080/loans/members/1/all";
                      xhr.open("GET", open_str, true);
                      xhr.onreadystatechange = function() {
                                  alert(xhr.readyState + "" + xhr.status);
                        if (xhr.readyState == 4 && xhr.status == 200) {

                            alert("session opend success");

                            var json = JSON.parse(xhr.responseText);
                            alert(JSON.stringify(json, null, 10));

                        }
                      }
                      console.log("before xhr.send(null)")
                      xhr.send(null);
});