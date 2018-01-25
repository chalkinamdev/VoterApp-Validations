function validate(frm) {
	
	alert("client side form validation...");
	frm.vflag.value = "yes";
	
	document.getElementById("nameErr").innerHTML = "";
	document.getElementById("ageErr").innerHTML = "";
	
	let name = frm.fname.value;
	let age = frm.fage.value;
	
	if(name==""){
		document.getElementById("nameErr").innerHTML = "<i>name is required</i>";
		frm.fname.focus();
		return false;
	}
	if(age==""){
		document.getElementById("ageErr").innerHTML = "<i>age is required</i>";
		frm.fage.focus();
		return false;
	}
	else if(isNaN(age)){
		document.getElementById("ageErr").innerHTML = "<i>age must be numeric value</i>";
		frm.fage.focus();
		return false;
	}
	else {
		if(age <= 0 || age>125){
			document.getElementById("ageErr").innerHTML = "<i>age must be in the range of 1-125</i>";
			frm.fage.focus();
			return false;
		}
	}
	
	return true;
}