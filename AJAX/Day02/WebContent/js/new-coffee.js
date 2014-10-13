function getSize() {
	var sizeGroup = document.forms[0].size;
	for (var i = 0; i < sizeGroup.length; i++) {
		if (sizeGroup[i].checked == true) {
			return sizeGroup[i].value;
		}
	}
}

function getBeverage() {
	var beverageGroup = document.forms[0].beverage;
	for (var i = 0; i < beverageGroup.length; i++) {
		if (beverageGroup[i].checked == true) {
			return beverageGroup[i].value;
		}
	}
}

function serveDrink() {
	if (request1.readyState == 4) {
		// request1의 응답을 처리
		if (request1.status == 200) {
			var resMessage = request1.responseText;
			// 맨 첫 문자 1개를 읽어서 어느 커피메이커에 대한 응답인지 판단
			var whichCoffeeMaker = resMessage.substring(0, 1);
			// 2번째 문자부터 끝까지 읽어서 커피를 주문한 사람의 이름을 추출
			var name = resMessage.substring(1);
			// alert 누구누구의 커피가 완성되었다.
			alert(name + "의 커피가 나왔습니다.")
			// 커피메이커의 status 문구를 "Idle" 변경
			if (whichCoffeeMaker == "1") {
				replaceText(document.getElementById("coffeemaker1-status"), "Idle");
			} else {
				replaceText(document.getElementById("coffeemaker2-status"), "Idle");
			}
		} else {
			alert("에러가 발생했습니다. " + request1.status);
		}
		request1 = createRequest();
	} else if (request2.readyState == 4) {
		// request2의 응답을 처리
		if (request2.status == 200) {
			var resMessage = request2.responseText;
			// 맨 첫 문자 1개를 읽어서 어느 커피메이커에 대한 응답인지 판단
			var whichCoffeeMaker = resMessage.substring(0, 1);
			// 2번째 문자부터 끝까지 읽어서 커피를 주문한 사람의 이름을 추출
			var name = resMessage.substring(1);
			// alert 누구누구의 커피가 완성되었다.
			alert(name + "의 커피가 나왔습니다.")
			// 커피메이커의 status 문구를 "Idle" 변경
			if (whichCoffeeMaker == "1") {
				replaceText(document.getElementById("coffeemaker1-status"), "Idle");
			} else {
				replaceText(document.getElementById("coffeemaker2-status"), "Idle");
			}
		} else {
			alert("에러가 발생했습니다. " + request2.status);
		}
		request2 = createRequest();
	}
}

function sendRequest(request, url) {
	request.open("GET", url, true);
	request.onreadystatechange = serveDrink;
	request.send(null);
}

function orderCoffee() {
	var name = document.getElementById("name").value;
	var size = getSize();
	var beverage = getBeverage();
	
	var url = "coffeemaker.jsp?name=" + encodeURI(name)
		+ "&size=" + encodeURI(size)
		+ "&beverage=" + encodeURI(beverage)
		+ "&coffeemaker=";
	
	// 커피메이커#1의 상태값을 갖고 있는 <div> 엘리먼트
	var divCoffeeMaker1Status
		= document.getElementById("coffeemaker1-status");
	// 위 <div> 엘리먼트의 텍스트 추출
	var status = getText(divCoffeeMaker1Status);
	// status가 "Idle"인지 여부
	if (status == "Idle") {	// 커피메이커#1이 유휴상태임
		replaceText(divCoffeeMaker1Status,
				"Brewing " + name + "'s " + size + " " + beverage);
		sendRequest(request1, url + 1);
	} else {	// 커피메이커#1이 동작중
		// 커피메이커#2의 상태값을 갖고 있는 <div> element
		var divCoffeeMaker2Status
			= document.getElementById("coffeemaker2-status");
		status = getText(divCoffeeMaker2Status);
		if (status == "Idle") {	// 커피메이커#2가 유휴상태
			replaceText(divCoffeeMaker2Status,
					"Brewing " + name + "'s " + size + " " + beverage);
			sendRequest(request2, url + 2);
		} else {
			// 커피메이커#1과 커피메이커#2가 모두 사용중인 상태
			alert("모두 사용중. 잠시후 다시 시도!");
		}
	}
	
	document.forms[0].reset();
}























