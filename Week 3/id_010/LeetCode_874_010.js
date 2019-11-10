/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    let directions = [[0,1],[1,0],[0,-1],[-1,0]]
    
    
    let x = 0,
        y = 0,
        direction = 0,
        distance = 0,
        obstacle = {}
    
    for(let i = 0; i < obstacles.length; i++) {
        obstacle[obstacles[i]] = true;
    }

    for(let i = 0; i<commands.length;++i){
        if(commands[i] === -2){
            --direction
            if(direction<0) direction+=4
        }else if(commands[i] === -1){
            ++direction
            if(direction>=4) direction%=4
        }else{
            step = 0
            while(step < commands[i]){
                ++step
                let preX = x,
                    preY = y
                x+=directions[direction][0]
                y+=directions[direction][1]
                if(obstacle[x+','+y]){
                    [x,y] = [preX,preY]
                    break
                }
            }
        }
        distance = Math.max(distance, x**2 + y**2)
    }
    return distance
};