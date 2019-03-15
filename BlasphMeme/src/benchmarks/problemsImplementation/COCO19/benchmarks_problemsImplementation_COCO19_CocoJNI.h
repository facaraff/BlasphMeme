/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class benchmarks_problemsImplementation_COCO19_CocoJNI */

#ifndef _Included_benchmarks_problemsImplementation_COCO19_CocoJNI
#define _Included_benchmarks_problemsImplementation_COCO19_CocoJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoSetLogLevel
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoSetLogLevel
  (JNIEnv *, jclass, jstring);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoGetObserver
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoGetObserver
  (JNIEnv *, jclass, jstring, jstring);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoFinalizeObserver
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoFinalizeObserver
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemAddObserver
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemAddObserver
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemRemoveObserver
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemRemoveObserver
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoGetSuite
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoGetSuite
  (JNIEnv *, jclass, jstring, jstring, jstring);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoFinalizeSuite
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoFinalizeSuite
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoSuiteGetNextProblem
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoSuiteGetNextProblem
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoSuiteGetProblem
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoSuiteGetProblem
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoEvaluateFunction
 * Signature: (J[D)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoEvaluateFunction
  (JNIEnv *, jclass, jlong, jdoubleArray);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoEvaluateConstraint
 * Signature: (J[D)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoEvaluateConstraint
  (JNIEnv *, jclass, jlong, jdoubleArray);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetDimension
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetDimension
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetNumberOfObjectives
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetNumberOfObjectives
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetNumberOfConstraints
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetNumberOfConstraints
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetSmallestValuesOfInterest
 * Signature: (J)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetSmallestValuesOfInterest
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetLargestValuesOfInterest
 * Signature: (J)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetLargestValuesOfInterest
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetLargestFValuesOfInterest
 * Signature: (J)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetLargestFValuesOfInterest
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetId
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetId
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetName
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetEvaluations
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetEvaluations
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetEvaluationsConstraints
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetEvaluationsConstraints
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemGetIndex
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemGetIndex
  (JNIEnv *, jclass, jlong);

/*
 * Class:     benchmarks_problemsImplementation_COCO19_CocoJNI
 * Method:    cocoProblemIsFinalTargetHit
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_benchmarks_problemsImplementation_COCO19_CocoJNI_cocoProblemIsFinalTargetHit
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
