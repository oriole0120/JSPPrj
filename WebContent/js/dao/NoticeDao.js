/*var noticeDao = {};//new Object();
noticeDao.getNotices = function(page){
	
}*/

/*function f1(){	
	alert(this);
}

f1();
//new f1();
*/

function NoticeDao(){
	
}

NoticeDao.prototype = {
	getNotices : function(page, aa){
		var oReq = new XMLHttpRequest();
		if (oReq) {
			
			oReq.onreadystatechange = function(){
				if(oReq.readyState == 4)
				{
					//console.log(oReq.readyState);
					var data = eval(oReq.responseText);
		   			aa(data);
				}
			}
			
			oReq.open("GET", "data.jsp?p="+page, true);
		   	oReq.send();
		}
	}	
};

var noticeDao = new NoticeDao();
/*var list = noticeDao.getNotices(1);
alert(list[0].title);*/

noticeDao.getNotices(1, function(data){
	alert(data[0].title);
	alert(data[1].title);
});

/*function Exam(){
	this.kor = 0;
	this.eng = 0;
	this.math = 0;
}

Exam.prototype = {
		
	total : function(){
		this.cnt++;
		return this.kor + this.eng + this.math;
	},
	
	avg : function(){
		return this.total() / 3;
	}
}*/

// Array, Objct, Function, .... <-- Object

/*var ex1 = new Exam();
alert(ex1.constructor);*/
//ex1.constructor.prototype
/*ex1.kor = 30;
ex1.eng = 40;
ex1.math = 50;
ex1.total();

alert(ex1.constructor);

var ex2 = new Exam();
ex2.kor = 10;
ex2.total();

var ex3 = new Exam();
ex3.kor = 20;
ex3.total();*/

















