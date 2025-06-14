#include <iostream>

int main()
{
    int nums[] = {0,1,2,2,3,0,4,2};
    int val = 2;

    int arr_size = sizeof(nums) / sizeof(nums[0]);
    int count = 0;

    int ap = 0;
    for(int i = 0 ; i < arr_size ; i++){
        if(nums[i] != val){
            count++;
            continue;
        }

        for(int j = ap+i ; j < arr_size ; j++){
            printf("i = %d    j = %d\n", i,j);
            if(nums[j] != val){
                nums[i] = nums[j];
                nums[j] = val;
                count++;
                ap = j-i;
                break;
            }
        }
    }

    for(int i = 0 ; i < arr_size ; i++){
        printf("%d ", nums[i]);
    }
    printf("\n%d ", count);
}
