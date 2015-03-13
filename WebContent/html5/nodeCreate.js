window.onload = init;

function init() {
	var txtbtn = document.getElementById("text-btn");
	var elebtn = document.getElementById("element-btn");
	var delLastbtn = document.getElementById("dellast-btn");
	var changeBtn = document.getElementById("change-btn");
	
	txtbtn.onclick = addTxtNode;
	elebtn.onclick = addEleNode;
	delLastbtn.onclick = delLastNode;
	changeBtn.onclick = changeBtnClick;
}
function addTxtNode() {
	var textNode = document.createTextNode("안녕하세요");
	var div1 = document.getElementById("div1");
	div1.appendChild(textNode);
}

function addEleNode() {
	var eleNode = document.createElement("img");
	eleNode.src = "test.jpg"
	var div1 = document.getElementById("div1");
	div1.appendChild(eleNode);
}
function delLastNode() {
	var div1 = document.getElementById("div1");
	var last = div1.lastChild;
	div1.removeChild(last);
	delete last;
}

function changeBtnClick(){
	var node1 = document.body.firstChild;
	var node2 = document.body.lastChild;
	
	document.body.replaceChild(node1, node2);
	document.body.replaceChild(node2, node1);
}




