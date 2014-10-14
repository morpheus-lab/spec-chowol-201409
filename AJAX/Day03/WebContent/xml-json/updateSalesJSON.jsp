<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int getRandomNumber(int min, int max) {
		int r = (int) (Math.random() * (max - min + 1)) + min;
		return r;
	}
%>
{
	"totals": [
		{
			"location": "Vali",
			"boardsSold": <%= getRandomNumber(0, 800) %>,
			"bootsSold": <%= getRandomNumber(0, 100) %>,
			"bindingsSold": <%= getRandomNumber(0, 50) %>
		},
		{
			"location": "Santa fe",
			"boardsSold": <%= getRandomNumber(0, 800) %>,
			"bootsSold": <%= getRandomNumber(0, 100) %>,
			"bindingsSold": <%= getRandomNumber(0, 50) %>
		},
		{
			"location": "Boulder",
			"boardsSold": <%= getRandomNumber(0, 800) %>,
			"bootsSold": <%= getRandomNumber(0, 100) %>,
			"bindingsSold": <%= getRandomNumber(0, 50) %>
		},
		{
			"location": "Denver",
			"boardsSold": <%= getRandomNumber(0, 800) %>,
			"bootsSold": <%= getRandomNumber(0, 100) %>,
			"bindingsSold": <%= getRandomNumber(0, 50) %>
		}
	]
}