#include <iostream>

int main()
{
    int nums[] = {-1,0,0,0,0,3,3};

    int count = 0;
    int pos = 0;
    for (int i = 0 ; i < (sizeof(nums)/sizeof(nums[0])) ; i++){
        bool stop = true;
        for (int j = pos ; j < (sizeof(nums)/sizeof(nums[0])) ; j++){
            if(nums[i] < nums[j]){
                printf("i: %d      j: %d\n", i, j);
                nums[i+1] = nums[j];
                pos = j;
                count++;
                stop = false;
                break;
            }
        }
        
        for (int x = 0 ; x < (sizeof(nums)/sizeof(nums[0])) ; x++){
            printf("%d ", nums[x]);
        }
        printf("\n");

        if(stop){
            break;
        }
    }

    printf("\n\n\n");
    for (int x = 0 ; x < (sizeof(nums)/sizeof(nums[0])) ; x++){
        printf("%d ", nums[x]);
    }
    printf("\n");
    printf("count: %d", count+1);
}