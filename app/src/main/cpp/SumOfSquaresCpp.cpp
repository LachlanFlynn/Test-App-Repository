//
// Academic License - for use in teaching, academic research, and meeting
// course requirements at degree granting institutions only.  Not for
// government, commercial, or other organizational use.
//
// SumOfSquaresCpp.cpp
//
// Code generation for function 'SumOfSquaresCpp'
//

// Include files
#include "jni.h"
#include "SumOfSquaresCpp.h"

// Function Definitions
SumOfSquaresCpp::SumOfSquaresCpp() = default;

SumOfSquaresCpp::~SumOfSquaresCpp() = default;

double SumOfSquaresCpp::sum_of_squares(double a, double b)
{
  return a * a + b * b;
}

// JNI Function
extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_ctestapp_SecondActivity_calculateSumOfSquares(JNIEnv *env, \
jobject thiz, jdouble a, jdouble b) {
    auto *classInstance = new SumOfSquaresCpp;
    jdouble result = SumOfSquaresCpp::sum_of_squares(a, b);
    delete classInstance;
    return result;
}

// End of code generation (SumOfSquaresCpp.cpp)
