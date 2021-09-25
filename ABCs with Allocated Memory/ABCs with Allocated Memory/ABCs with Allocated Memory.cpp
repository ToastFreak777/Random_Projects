#include<iostream>
using namespace std;

class ABCs {
private:
	string name;
public:
	ABCs() { /*cout << "Alphabet Created." << endl;*/ }
	ABCs(const ABCs& other) :name(other.name) { cout << "Alphabet created by copying." << endl; } //Copier
	~ABCs() { cout << "Destructor called." << endl; }

	void setName(string name) { this->name = name; }
	void speak() const { cout << "Letter: " << name << endl; }
};

int main() {

	ABCs* Alphabet(new ABCs[26]);

	char a = 'A';
	string name(1, a);

	for (int i = 0; i < 26; i++) {
		Alphabet[i].setName(name);
		Alphabet[i].speak();
		a++;
		name = a;
	}

	return 0;
}