//Justin Shearson (jrs330)
#include <stdio.h>
#include <stdlib.h>
#include <io.h>
#include <stdbool.h>
#include <string.h>

bool isEmpty(FILE* inputFile)
{
	fseek(inputFile, 0, SEEK_END);
	return ftell(inputFile) == 0 ? 1 : 0;
}

int main(void)
{
	FILE* file;
	char* peString = "I want to learn PE file format!";
	//If the file exists
	if (access("PE-1.txt", 0) == 0) {
		file = fopen("PE-1.txt", "a+");
	}
	else {
		file = fopen("PE-1.txt", "w+");
	}

	//If the file is empty
	if (isEmpty(file)) {
		fprintf(file, "%s", peString);
	}
	else {
		bool stringFound = false;
		char* testString;
		fseek(file, 0, SEEK_SET);
		fseek(file, 0, SEEK_END);
		long length = ftell(file);
		testString = malloc(length);
		fseek(file, 0, SEEK_SET);

		//Checks every line of the file and searches for the specified string
		//And prints contents to standard output if the string is found.
		while (fgets(testString, length + 1, file) != NULL && !stringFound) {
			if (strstr(testString, peString) != NULL) {
				char c;
				fseek(file, 0, SEEK_SET);
				while ((c = fgetc(file)) != EOF) {
					printf("%c", c);
				}
				stringFound = true;
			}
		}
		//Adds the string into the file if it cannot be located
		if (!stringFound) {
			fprintf(file, "%s", peString);
		}

	}

	fclose(file);
	return 0;
}