<html>

<head>


</head>
	<title>Loose Search</title>
	<script type="text/javascript"  src="jquery.min.js"></script>
	<script type="text/javascript">
		function doSearch(){
				$.getJSON("looseSearch.do", 
								{CHARS: $("#searchBox").value()}, 
							function(data){
											alert("recieved " + data);
									});
								}
	</script>
	
	<body>
		<h1>Loose Search</h1>
		<input   type="text"  onKeyUp="doSearch();" id="searchBox">
		
		<div>
				
		</div>
	</body>
</html>