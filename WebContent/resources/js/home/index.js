import nav from './nav.js';

/* 도서관 소장 도서 필터링의 콤보박스 기본값 설정*/
const indexInit = function(){
	const opt = document.querySelectorAll("#libraryFilter option");

	for(let i=0; i<opt.length; i++)
	{		
		if(opt[i].value===library)
		{
			opt[i].setAttribute("selected","selected");
			break;
		}
	}	
};

indexInit();
nav.init();



