#include <jni.h>
#include <string>


#include "chem.h"
#include <unistd.h>
using namespace std;

string chesult;

void solveChem(const char ga[])
{
    setChem(ga);
    toMatrixBaby();
    initMatrix(baby, myRow, myColume);
    coefficientArray();
    chesult="";
    for(int k = 0; k < myColume; k++)
    {
        chesult+=to_string(coefficientNum[k]);
        chesult+="  ";
    }
    freeMatrix();
    freeChem();

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_vaca_chem_MainActivity_chemBalan(JNIEnv *env, jobject thiz, jbyteArray chem) {
    signed char *arrayChem = env->GetByteArrayElements(chem, NULL);
    solveChem((const char*)arrayChem);
    env->ReleaseByteArrayElements(chem, arrayChem, 0);
    return env->NewStringUTF(chesult.c_str());
}