/*
    싱글쓰레드인 자바스크립트에서 비동기 처리를 위해서 콜백(callback)을 사용해왔다.
    덕분에 비동기 처리를 온전히 해낼 수 있었지만 이런 콜백이 사용되는 경우가 많아지면서 단점이 드러났다.
    그 단점은 비동기 처리를 순차적으로 실행할 필요가 있는 경우에 비동기 처리를 중첩시켜서 표현하므로 에러, 예외처리가 어렵다는 것과 중첩으로 인한 복잡도가 증가하는 것이 이다.
    크게 이 두 가지의 단점을 해결하기위해 프로미스를 지원한다. 
    생성방식] new Promise((resolve, reject){...})
    성공했을 때 resolve()를 실행하고 실패 또는 에러가 났을 때 reject()를 실행한다.
    */
//프로미스 생성
const promise1 = function(param){
return new Promise(function(resolve,reject){
    if(param==1){
        resolve("성공");
    }else if(param==2){
        reject("실패");
    }else{
        throw 'error!!';
    }
});
}
//프로미스 실행
promise1(3)
.then(function(result){
    console.log('정상실행')
	alert('정상실행');
    console.log(result);
	alert(result);
})
.catch(function(err){
    console.log('error발생!!!!!')
	alert('error발생!!!!!');
    console.log(err);
	alert(err);
});
