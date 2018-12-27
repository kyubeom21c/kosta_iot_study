self.onmessage = function( event ){
	self.postMessage( addMsg( event.data ) );
};

self.onerror=function( event ){
	self.postMessage( "에러발생...." );
};


function addMsg( msg ){	
	return "3.WebWorker처리결과 : "+  msg;
}