#include <stdio.h>
#include <stdlib.h>

int proc1(int* inputArray, int y, int x) {
	int a = 0; //var_8
	int b = 0; //var_c
	int c = 0; //var_10
	int d = 0; //var_4

	while (d < y) {
		a = 1;
		while(a < x){
			while(inputArray[b] == 0){
				b = (b+1)%y;
			}
			a++;
			b = (b+1)%y;
		}
		while(inputArray[b] == 0){
			b = (b+1)%y;
		}
		
		c = inputArray[b];
		inputArray[b] = 0;
		d++;
	}

	return b;
}

int main(void)
{
	int x = 7;
	int y = 100;
	int z = 0;
	int array[101];
	while (z < y) {
		array[z] = ++z;
	}

	printf("%d", proc1(array, y, x));
	
	return 0;
}

