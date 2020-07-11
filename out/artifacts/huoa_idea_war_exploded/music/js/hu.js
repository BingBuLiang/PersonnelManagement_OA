	
				window.onload=function(){
					if (sessionStorage.getItem("User")){
						var user=JSON.parse(sessionStorage.getItem("User"));
						
						$("#personal").html(user.uname);
					}
				}