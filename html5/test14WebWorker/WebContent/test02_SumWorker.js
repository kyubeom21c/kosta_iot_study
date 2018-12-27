onmessage = function( event ){
	postMessage( sum( event.data ) );
};
self.onerror=function( event ){
	self.postMessage( "에러발생...." );
};
function sum( su ){
	var result = 0;
	for(var i = 0; i < su+1; i++ ){
		result += i;
	}
	return result;
}


