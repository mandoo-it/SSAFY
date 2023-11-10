let msg = "GLOBAL";
function outer(a) {
    let msg = "OUTER";
    console.log(msg);
	alert(msg);
    if (true) {
        let msg = "BLOCK";
        console.log(msg);
		alert(msg);
    }
}
