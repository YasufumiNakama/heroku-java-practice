const MethodURI =  "https://heroku-java-practice.herokuapp.com/webapi/webmethods/";

function gebi(id) {
    return document.getElementById(id);
}

window.onload = function(){
	var uri = MethodURI+'ramen';
	$.getJSON(uri,
	    function(data){
            for(var i=0; i<data.length; i++){
	            var table = gebi("ramen");
	            $(table).append("<tr></tr>").find("tr:last").append("<td>"+"・"+data[i]+"</td>")
	        }
        }
	);
}