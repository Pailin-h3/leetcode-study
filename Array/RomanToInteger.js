var romanToInt = function(s) {
    var sum = 0;
    for(let i = s.length ; i-- ; i >= 0){
        if(i == 0){
            if(i == s.length){
                sum += symbolValue[s[i]];
            }else{
                if(symbolValue[s[i]] < symbolValue[s[i+1]]){
                    sum -= symbolValue[s[i]];
                }else{
                    sum += symbolValue[s[i]];
                }
            }
        }else if(i == s.length){
            sum += symbolValue[s[i]];
        }else{
            if(symbolValue[s[i]] < symbolValue[s[i+1]]){
                sum -= symbolValue[s[i]];
            }else{
                sum += symbolValue[s[i]];
            }
        }
    }

    return sum;
};

const symbolValue = {
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000
}

console.log(romanToInt("MCMXCIV"));