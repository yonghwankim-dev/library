function change_library(obj)
{
	obj.submit();
}

function openSearchInput(event, searchName){
	const searchInput = document.getElementsByClassName("nav__row__searchInput");
	
	// 도서 검색 입력창을 전부 안보이게 한다.
	for(let i=0; i<searchInput.length; i++)
	{
		searchInput[i].style.display = "none";
	}
	
	// 검색 버튼의 active 클래스를 전부 제거한다.
	const searchTab = document.getElementsByClassName("searchTab");
	for(let i=0; i<searchTab.length; i++)
	{
		searchTab[i].className = searchTab[i].className.replace(" active", "");
	}
	
	document.getElementById(searchName).style.display = "block";
	event.currentTarget.className += " active";
}

const condition = "<select class='condition__select' name='condition__category'>\n" +
					"<option value='도서관'>도서관</option>\n" +
					"<option value='서명'>서명</option>\n" +	 									
					"</select>\n" +
					"<select class='condition__select' name='condition__logical'>\n" + 
					"<option value='AND'>AND</option>\n" +
					"<option value='OR'>OR</option>\n" +  
					"<option value='AND NOT'>NOT</option>\n" + 														
					"</select>\n" +
					"<input type='text' class='condition__input' name='condition__input'>\n" + 
					"<input type='button' value='삭제' onclick='remove(this)'>\n";


const add_conditionBox = () => {
    const conditionBox = document.getElementById("searchInput__form__conditionList");
    const newLi = document.createElement('li');
    
    console.dir(conditionBox);
	newLi.className += "searchInput__form__condition";
	newLi.innerHTML = condition;

    conditionBox.appendChild(newLi);
}
const remove = (obj) => {
    document.getElementById('searchInput__form__conditionList').removeChild(obj.parentNode);
}


