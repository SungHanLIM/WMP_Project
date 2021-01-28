<!DOCTYPE html>
<html>
<head>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
</head>
<body>
	
	<h3>WMP Project</h3>
	
	<form action="cmdStrDivision.do" method="post" onsubmit="return formCheck();">
		<label for="url">URL </label>
		<input type="text" id="url" name="url" class="form-control">
		
		<br/><label for="typeId" >Type </label>
		<select id="typeId" name="typeId">
		  <option value="1">Remove HTML</option>
		  <option value="2">All</option>
		</select>
	
		</br><label for="unit">Bundle Unit </label>	
		<input type="text" id="unit" name="unit" class="form-control" placeholder="number greater than 0">
		
		<br/><br/><input type="submit">
	</form>
	
	</br></br><b>Code: </b>${code}
	</br><b>Result: </b>${result}
	</br></br><b>Quotient</b>
	</br>${quotient}</br>
	</br><b>Remainder</b> 
	</br>${remainder}
	
	<script type="text/javascript" charset="utf-8">
		/*<![CDATA[*/
	
		function formCheck() {
			var url = document.forms[0].url.value;
			var unit = document.forms[0].unit.value;

			if (!url) {
				alert("Please enter the URL address.");
				return false;
			} 
			
			if (isNaN(unit) || unit < 1) {
				alert("Please check the unit number: greater than 0");
				return false;
			}

		}

		/*]]>*/
	</script>
</body>
</html>
