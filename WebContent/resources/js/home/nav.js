<<<<<<< HEAD
const srchTab = document.querySelector("#srchTab");
const srchDtlTab = document.querySelector("#srchDtlTab");
=======

>>>>>>> 757369ee4e8fdc983e19e9435cf784a32436f0bf
const detailSrh = document.querySelector("#detailSrh");
const srch = document.querySelector("#srch");

const openSrchTab = function(){
<<<<<<< HEAD
	srchTab.classList.add("active");
	srchDtlTab.classList.remove("active");
=======
>>>>>>> 757369ee4e8fdc983e19e9435cf784a32436f0bf
	detailSrh.style.display = "none";
	srch.style.display = "block";	
}

<<<<<<< HEAD
const openSrchDtlTab = function(){
	srchTab.classList.remove("active");
	srchDtlTab.classList.add("active");	
=======
const openSrchDtlTab = function(){	
>>>>>>> 757369ee4e8fdc983e19e9435cf784a32436f0bf
	detailSrh.style.display = "block";
	srch.style.display = "none";
};

const init = function(){
<<<<<<< HEAD

=======
	const srchTab = document.querySelector("#srchTab");
	const srchDtlTab = document.querySelector("#srchDtlTab");
>>>>>>> 757369ee4e8fdc983e19e9435cf784a32436f0bf
	
	srchTab.addEventListener("click",openSrchTab);	
	srchDtlTab.addEventListener("click",openSrchDtlTab);	
	
};

export default {init};