$(document).ready(function() {

	var meminfo = new Array("","","","","");
	var bDone = false;
	
	var jsond;
	var col_names;
	var table1;
	
	/* when document is loaded the table headers must be initialized */
	/* window.onload = function(){
		fillTableHeader();
	} */
	
	$(document).ready(function(){
		fillTableHeader();
	});
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
	
	function getMemInfo()
	{
		if(0 == document.getElementById("name").value)
		{
			alert("enter a value in the first name box");
			return false;
		}
		else if(0 == document.getElementById("dob").value)
		{
			alert("please enter date of birth for the member");
			return false;
		}
		else if(0 == document.getElementById("address").value)
		{
			alert("please enter address for the member");
			return false;
		}
		else if(0 == document.getElementById("email").value)
		{
			alert("please enter email for the member");
			return false;
		}
		else if(0 == document.getElementById("phone").value)
		{
			alert("please enter phone number for the member");
			return false;
		}
		
		meminfo[0] = document.getElementById("name").value;
		meminfo[1] = document.getElementById("dob").value;
		meminfo[2] = document.getElementById("address").value;
		meminfo[3] = document.getElementById("email").value;
		meminfo[4] = document.getElementById("phone").value;
	}
	
	/*
	 * function update the database when we add a member
	 */
	function updDB()
	{
	 	var mem_data = serialTheData();
			console.log(mem_data);
			var json_data = JSON.stringify(mem_data);
			console.log(json_data);
			return new Promise((resolve, reject) => {
				$.ajax({
					type: 'post',
					url: 'http://localhost:8080/members/addMember/',
					data: json_data,
					success: function(data){console.log('data' + data);},
					contentType: "application/json",
					dataType: 'json'
					})
					.done(function(){
	 					bDone = true;
	 					console.log("inside serialTheData.done bDone is: " + bDone);
	 					document.getElementById("status").innerHTML="Operation succeeded";
						return resolve(json_data);
					})
					.fail(function(error){
							console.error(error);
	 						bDone = false;
	 						console.log("inside serialTheData.fail bDone is: " + bDone);
							return reject(error);
					})
					.always(function(){
								//called after done or failed
								console.log(bDone);
							});
				});
	 }
	
	/*
	 * The function updates the database when a delete happens
	 */
	function delDB()
	{
	}
	
	/* .serialize() in jQuery to JSON format data of the members form */
	function getFormData($form){
	    var unindexed_array = $form.serializeArray();
	    var indexed_array = {};
	
	    $.map(unindexed_array, function(n, i){
	        indexed_array[n['name']] = n['value'];
	    });
	
	    return indexed_array;
	}
	
	/* .serialize() in jQuery to JSON format data of the members form */
	function serialTheData()
	{
		var $form =  $("#form_data");
		var data = getFormData($form);
		console.log(data);
		return data;
	}
	
	function addFunc()
	{
			updDB();
			
			var table = document.getElementById("myTable");
			var rsize = table.rows.length;
			console.log("number of rows is: " + rsize);
			var csize = table.rows[0].cells.length;
		 	console.log("number of columns is: " + csize);
	
			//get the memeber info from the form if all the inputs are filled in the formula
			var ret = getMemInfo();
			if(ret == false)
				return false;
	
	/* 		if(bDone == true){ */
					
				console.log("inside adding a new row to the table.");
				var row = table.insertRow(rsize);
				var cell;
				
				for(var i=0; i < csize; i++)
				{
					cell = row.insertCell(i);
					cell.innerHTML = meminfo[i];
				}
	/*  		}
	 */
	 }
	
	
	function fillTableHeader()
	{
		table1 = document.getElementById("myTable");
		var url1 = 'http://localhost:8080/members/getRange/1/1';
	
		//set crossDomain: true, option to true to allow cross domain requests such as(SSONP) on the same domain
		$.getJSON( url1,
				function(data){
					console.log("data is: " + JSON.stringify(data));
					console.log("data is: " + JSON.stringify(data));
					jsond = JSON.stringify(data);
					console.log("data jsond is: " + jsond);
					console.log(jsond.length);
	
					if(jsond.length > 0)
					{
						var cols = JSON.parse(jsond);
						var names = cols[0];
						col_names = Object.getOwnPropertyNames(names);
					}
	
					console.log(col_names.length);
					/* find the index for the last row */
				 	var rows = table1.rows.length;
				 	/* insert the new row after the last row */
				 	var row = table1.insertRow(rows);
					var cell;
				 	var csize = col_names.length;
	
					for(var i=0; i < csize; i++)
					{
						cell = row.insertCell(i);
						cell.innerHTML = col_names[i];
					}
												
			});
	
	}
	
	//searches for the members of a range
	function searchFunc()
	{
	/* 	var $form =  $("#search_data"); */
	
		
		//build data with JSON format
		//make sure each input has an attribute name
		//both enabled and disabled inputs in the form formula is captured
		//serializeArray only captures enabled inputs in the form formula!! so it is not safe to use that in all cases.
		var range = new Array(2);
		var inputs = $("#search_data    : input");
		var obj = $.map(inputs, function(n, i){
			var o = {};
	
			o[n.name] = parseInt($(n).val());
			range[i] = parseInt($(n).val());
			return o;
			});
	/* 
		var formdata = $("#search_data").serializeArray();
		console.log(formdata);
		var data = {};
		$(formdata).each(function(index, obj){
			data[obj.name] = obj.value;
			}); 
		console.log(data);
		var json_data = JSON.stringify(data);
		console.log(json_data);
	*/
	
	console.log(obj);
	
	var json_data = JSON.stringify(obj);
	console.log(json_data);
	var url1 = 'http://localhost:8080/members/getRange/' + range[0];
	console.log(url1);
	url1 = url1 + '/' + range[1];
	
	//set crossDomain: true, option to true to allow cross domain requests such as(SSONP) on the same domain
	$.getJSON( url1,
			function(data){
				console.log("data is: " + JSON.stringify(data));
				});
				 
	  $.ajax({
		type: 'get',
			url: url1,
	//		contentType: "application/json",
			dataType: 'json',
			success: function (data) {
					
					console.log("data is: " + JSON.stringify(data));
					jsond = JSON.stringify(data);
					console.log("data jsond is: " + jsond);
					console.log(jsond.length);
	
					if(jsond.length > 0)
					{
						var cols = JSON.parse(jsond);
						var names = cols[0];
						col_names = Object.getOwnPropertyNames(names);
					}
			 }
		})				
		.done(function(){
					console.log(".done is called..")
			})
			.fail(function(error){
					console.error(error);
			})
			.always(function(){
						//called after done or failed
						console.log(".always is called..")
	
					});
	
		/* fill the result of the search in the table */
	  fillMemberTable();
	}
	
	function fillMemberTable()
	{
		console.log("from inside fillMemberTable()..");
	 	var table = document.getElementById("myTable");
		var rsize = table.rows.length;
		var csize = table.rows[0].cells.length;
		console.log("number of rows is: " + rsize);
		console.log("number of columns is: " + csize);
		console.log(jsond);
	 
	/* 	//iterate through member list and insert it
		for(var index i jsond)
		{
			for(var i = 0; i < csize; i++)
			{
				cell = row.insertCell(i);
				cell.innerHTML = jsond[index][i];
			}
		} */
							
	}
	
	function modifyFunc()
	{
	/* 	console.log(col_names);	
		for(var key in col_names)
		{
			console.log(col_names[key]);
		} 
	*/
		fillTableHeader();
	}
	
	function deleteFunc()
	{
		
	}
	
	var x = serialTheData();
	

