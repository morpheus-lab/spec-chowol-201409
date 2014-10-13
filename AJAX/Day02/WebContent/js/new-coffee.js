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
			sendRequest(request1, url + 2);
		} else {
			// 커피메이커#1과 커피메이커#2가 모두 사용중인 상태
			alert("모두 사용중. 잠시후 다시 시도!");
		}
	}
}























