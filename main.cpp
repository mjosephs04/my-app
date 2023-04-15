#include <iostream>
#include <fstream>

using namespace std;


class assignment{

public:

    int day, year;

    string name, month;

};

int main() {

    ifstream iFile;

    assignment listOfAssignments[50];

    string subject, days, time, location, prof, fileName;

    string input, trash;

    cout << "input a file name: ";
    cin >> fileName;
    iFile.open(fileName);



    iFile.ignore();

    getline(iFile, subject);
    iFile.ignore();
    getline(iFile, days);
    iFile.ignore();
    getline(iFile, location);
    iFile.ignore();
    getline(iFile, prof);



    iFile >> trash;

    while(trash != "Schedule"){
        iFile >> trash;
    }

    int i = 0;

    while(!iFile.eof()){
        iFile >> listOfAssignments[i].month;
        iFile >> listOfAssignments[i].day;
        getline(iFile, listOfAssignments[i].name);
        i++;
    }

    //prints out the

    cout << "Subject: " << subject << endl;
    cout << "Dates: " << days << endl;
    cout << "Location: " << location << endl;
    cout << "Professor: " << prof << endl;

    cout << "--------------------------" << endl << endl;

    for(int x = 0; x < i; x++){
        cout << "Month: " << listOfAssignments[x].month << endl;
        cout << "Day: " << listOfAssignments[x].day << endl;
        cout << "Name: " << listOfAssignments[x].name << endl;
        cout << "-------------------------------" << endl << endl;
    }


    cout << input;

    return 0;
}
