#include <stdio.h>
#include <stdlib.h>

int main(void) {

	int array[8] = { 12, 15, 221, 3, 432, 54, 16, 67 };
	int x = 0;
	int y = 0;
	while (y < 8)
	{
		if (x <= array[y]) {
			x = array[y];
		}
		y++;
	}
	printf("%d", x);

	return 0;
}