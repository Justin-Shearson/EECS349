#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	for (int x = 100; x < 999; x++)
	{
		int y = x / 100;
		int z = (y * -100 + x) / 10;
		int a = x - (2 * (x / 2));
		int b = (y * y * y + z * z * z + a * a * a);

		if (x == b) {
			printf("%d\n", x);
		}

	}
	return 0;
}
