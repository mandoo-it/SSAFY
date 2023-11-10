//ajax요청 작업 내용
var xhr = null;

	function getXHR() {
		return new XMLHttpRequest();
	}

	function startMethod() {

		var word = document.getElementById("word"); //body에서 name을 찾아온 다음 변수에 넣음
		
		if(word.value.length > 0) {
			var param = "?word=" + word.value; //paramTest.jsp의 값 처리를 위한 변수처리, 너무 길어질 경우를 대비함
			xhr = getXHR();
			xhr.open("get", "searchWordDB.jsp" + param, true);
			xhr.onreadystatechange = callback;
			xhr.send(null);
		} else {
			document.getElementById("popupPart").style.display = "none";
		}
		//word.value = "";//값을 지워주는 것 입력칸에서
	}
	
	function callback() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var popupPart = document.getElementById("popupPart");
			var result = eval(xhr.responseText);
			
			//나머지 입력칸들은 value로 값 넣음
			if(result != null) {//데이터가 있으면
				var msg =" ";
				for(var i=0;i<result.length;i++) {
					msg += result[i] + "<br>";
				}
				popupPart.innerHTML = msg;//div에 내용을 넣음
				popupPart.style.display = "block";//눈에 보이게함
				
			}
		}
	}