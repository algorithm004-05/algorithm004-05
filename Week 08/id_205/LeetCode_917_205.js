var reverseOnlyLetters = function(S) {
  let arr=S.match(/[a-zA-Z]/g);
  if(arr){
    arr.reverse();
    for(let i=0;i<S.length;i++){
      if(!(/[a-zA-Z]/.test(S[i]))){
        arr.splice(i,0,S[i])
      }
    }
  }else{
    arr=S.split('');
  }
  return arr.join('');
};
