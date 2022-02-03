function selectAll(selectAll)  {
	const checkboxes = document.getElementsByName('extension_chk');
    	  
	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
	})
}