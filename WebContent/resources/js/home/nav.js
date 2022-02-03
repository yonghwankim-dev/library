
const srchTab = document.querySelector("#srchTab");
const srchDtlTab = document.querySelector("#srchDtlTab");
const detailSrh = document.querySelector("#detailSrh");
const srch = document.querySelector("#srch");

const openSrchTab = function(){
	srchTab.classList.add("active");
	srchDtlTab.classList.remove("active");
	detailSrh.style.display = "none";
	srch.style.display = "block";	
}

const openSrchDtlTab = function(){
	srchTab.classList.remove("active");
	srchDtlTab.classList.add("active");
	detailSrh.style.display = "block";
	srch.style.display = "none";
};

const init = function(){
	srchTab.addEventListener("click",openSrchTab);	
	srchDtlTab.addEventListener("click",openSrchDtlTab);	
};

export default {init};