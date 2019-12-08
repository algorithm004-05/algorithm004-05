/*
 * @lc app=leetcode.cn id=11 lang=c
 *
 * [11] 盛最多水的容器
 */

// @lc code=start


// int maxArea(int* height, int heightSize){
//     int area=0,tempArea=0,minHeight=0;
//     for(int i=0;i<heightSize-1;i++){
//         for(int j=1 ;j<heightSize;j++){
//             minHeight=height[i]>height[j]?height[j]:height[i];
//             tempArea=minHeight*(j-i);
//                 if(tempArea>area)area=tempArea;
//         }
//     }
//     return area;
    
// }

////solution 2
// int min(int a,int b);

// int maxArea(int* height, int heightSize){
//     int area=0,tempArea=0, i=0,j=heightSize-1;
//     // minHeight=height[i]>height[heightSize-1]?height[heightSize-1]:height[i];
//         area=(j-i)*min(height[i],height[j]);
//     while(j>i){
//         if(height[j]>height[i]){
//                  if(height[++i]>height[i-1])
//             tempArea=(j-i)*min(height[i],height[j]);
            
        
//         }else{
//                    if(height[--j]>height[j+1])
//             tempArea=(j-i)*min(height[i],height[j]);

//         }
//         if(tempArea>area)area=tempArea;
   
 
        
        
//     }
//     return area;
// }
// int min(int a,int b){
//     return a>b?b:a;
// }

////solution 3
// int maxArea(int* height, int heightSize){
//     int right=heightSize-1,left=0,area=0,tempArea=0,minHeight=0;
//     while(right>left){
//         minHeight=height[left]>height[right]?height[right]:height[left];
//         tempArea=(right-left)*minHeight;
//         area=area>tempArea?area:tempArea;
//         if(height[left]>height[right]) while(height[right]>height[--right]);
//         else while(height[left]>height[left++]);
//     }
//     return area;
// }

///solution 4
int maxArea(int* height, int heightSize){
    int right=heightSize-1,left=0,area=0,tempArea=0,minHeight=0;
    while(right>left){
        minHeight=height[left]>height[right]?height[right]:height[left];
        tempArea=(right-left)*minHeight;
        area=area>tempArea?area:tempArea;
        if(height[left]>height[right]) while(minHeight>height[--right]);
        else while(minHeight>height[left++]);
    }
    return area;
}


// @lc code=end

