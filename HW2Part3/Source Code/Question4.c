#include <stdio.h>
#include <stdlib.h>

int proc1(int* inputArray, int y, int x) {
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;

	while (d < y) {

		d++;
	}
	return d;
}

int main(void)
{
	int x = 7;
	int y = 100;
	int z = 0;
	int array[101];
	while (z < y) {
		array[z] = z;
		z++;
	}

	printf("%d", proc1(array, y, x));

}