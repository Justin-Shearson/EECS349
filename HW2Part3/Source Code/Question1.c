#include <stdio.h>
#include <stdlib.h>

int main(void) 
{
	int x = 3;
	int y = 5;
	int z = 0;

	z = (x * y) - (x / 2);
	printf("%d", z);
	
	return 0;
}