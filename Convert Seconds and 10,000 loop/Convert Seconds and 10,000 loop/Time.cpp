#include<iostream>

using namespace std;
/*
year = 1
days = 365
hours = 8760
minutes = 525600
seconds = 31,536,000*/
int main() {

	int time = 1;
	for (int h = 0; h < 6; h++) {
		if (h == 0) {
			cout << time << " year" << endl;
			time = time *= 12;
		}
		if (h == 1) {
			cout << time << " months" << endl;
			time = time *= 30.4167;
		}
		if (h == 2) {
			cout << time << " days" << endl;
			time = time *= 24;
		}
		if (h == 3) {
			cout << time << " hours" << endl;
			time = time *= 60;
		}
		if (h == 4) {
			cout << time << " minutes" << endl;
			time = time *= 60;
		}
		if (h == 5) {
			cout << time << " seconds" << endl;
		}
	}

	int ptr = 1;
	for (int n = 0; n < 10000; n++) {

		if (ptr == 100) {
			cout << "." << flush;
			ptr = 0;
		}
		ptr++;
	}
	return 0;
}