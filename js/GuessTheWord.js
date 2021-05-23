const match = (w1, w2) => {
  let c = 0;                                                  
  for(let i=0; i < w1.length; i++){
      if(w1[i] == w2[i]){ c++ ;}
  }
  return c;
}

const findSecretWord = (wordlist, master) => {
  for(let i=0;i<10;i++){
    let word  = wordlist[Math.floor(Math.random() * wordlist.length)];
    let n = master.guess(word);
    if(n==6){
      return;
    }
    wordlist = n==-1 ? wordlist.filter(x=>match(x,word)==0) :wordlist.filter(x=> match(x,word)==N )
  }
}