let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.save();
			});
			$("#btn-update").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.update();
			});
  },

  save: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
	
	$.ajax({
		//회원가입 수행 요청 
		type : "POST",
		url: "/auth/joinProc",
		data:JSON.stringify(data), //http body 데이터 
		contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지 (mime) 
		dataType : "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴게 json이라면 => javascript )
		
	}).done(function(resp){
		alert("회원가입이 완료되었습니다.");
		console.log(resp);
		location.href="/";
	}).fail(function(error){
					alert(JSON.stringify(error));
				}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청 
	
  },
  
  update: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					id: $("#id").val(),
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
	

	$.ajax({
		//회원가입 수행 요청 
		type : "PUT",
		url: "/user",
		data:JSON.stringify(data), //http body 데이터 
		contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지 (mime) 
		dataType : "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴게 json이라면 => javascript )
		
	}).done(function(resp){
		alert("회원수정이 완료되었습니다.");
		console.log(resp);
		location.href="/";
	}).fail(function(error){
					alert(JSON.stringify(error));
				}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청 
	
  },
  
}

index.init();
