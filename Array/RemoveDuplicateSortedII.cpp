#include <iostream>

int main()
{
    int nums[] = {0,0,1,1,1,2,3,3};

    if(sizeof(nums)/sizeof(nums[0]) <=2){
        return 0;
    }

    int i = 2;
    bool is_repls = false;
    int pos = 0;
    while(i < sizeof(nums)/sizeof(nums[0])){
        bool stop = true;
        if(nums[i-2] == nums[i]){
            printf("index %d equals %d\n", i-2, i);
            for(int j = i+pos ; j < (sizeof(nums)/sizeof(nums[0])) ; j++){
                if(nums[j] > nums[i]){
                    printf("replace %d with %d\n", i, j);
                    nums[i] = nums[j];
                    pos = j-i;
                    stop = false;
                    break;
                }
            }
            is_repls = true;
        }else {
            stop = false;
        }

        for (int x = 0 ; x < (sizeof(nums)/sizeof(nums[0])) ; x++){
            printf("%d ", nums[x]);
        }
        printf("\n");

        i++;
        if(stop){
            break;
        }
    }
    if(is_repls){
        i--;
    }

    printf("\n\n\n");
    for (int x = 0 ; x < (sizeof(nums)/sizeof(nums[0])) ; x++){
        printf("%d ", nums[x]);
    }
    printf("\n");
    printf("count: %d", i);
}