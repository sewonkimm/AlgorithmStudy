function solution(cacheSize, cities) {
    var answer = 0;
    
    const cache = [];
    
    cities.forEach(city => {
        city = city.toLowerCase();
        
        const index = cache.indexOf(city);
        if(index !== -1){
            answer += 1;
            cache.splice(index, 1);
            cache.push(city);
        } 
        else{
            answer += 5;
            if(cacheSize !== 0){
                if(cache.length >= cacheSize){
                    cache.shift();
                }
                cache.push(city);
            } 
        } 
    })
    return answer;
}